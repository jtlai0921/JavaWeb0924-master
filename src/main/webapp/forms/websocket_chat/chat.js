window.onload = function () {
    //獲取 DOM 元件
    var userNameInput = document.getElementById("userNameInput");
    var loginBtn = document.getElementById("loginBtn");
    var exitBtn = document.getElementById("exitBtn");
    var infoWindow = document.getElementById("infoWindow");
    
    var userinput = document.getElementById("userinput");
    var chatRoomForm = document.getElementById("chatRoomForm");
    var messageDisplay = document.getElementById("messageDisplay");

    var webSocket;
    var isConnectSuccess = false;
    var url = 'ws://' + window.location.hostname + ':' + window.location.port + '/JavaWeb0924/websocket/chatserver';
    //設置登入鈕的動作，登入才可發言
    loginBtn.addEventListener("click", function () {
        //檢查有無輸入名稱
        if (userNameInput.value !== "") {
            setWebSocket();  //設置WebSocket連接
        } else {
            infoWindow.innerHTML = "請輸入名稱";
        }

    });
    
    exitBtn.addEventListener("click", function () {
        location.reload();
    });
    
    //Submit Form時送出訊息
    chatRoomForm.addEventListener("submit", function () {
        sendMessage();
        return false;
    });
    //使用webSocket擁有的function, send(), 送出訊息
    function sendMessage() {
        //檢查WebSocket連接狀態
        if (webSocket && isConnectSuccess) {
            var messageInfo = {
                userName: userNameInput.value,
                message: userinput.value
            }
            webSocket.send(JSON.stringify(messageInfo));
        } else {
            infoWindow.innerHTML = "未登入";
        }
    }

    //設置 WebSocket
    function setWebSocket() {
        console.log(url);
        // 開始 WebSocket 連線
        webSocket = new WebSocket(url);
        //以下開始偵測WebSocket的各種事件
        
        // onerror , 連線錯誤時觸發  
        webSocket.onerror = function (event) {
            loginBtn.disabled = false;
            userNameInput.disabled = false;
            infoWindow.innerHTML = "登入失敗";
        };

        // onopen , 連線成功時觸發
        webSocket.onopen = function (event) {
            isConnectSuccess = true;
            loginBtn.disabled = true;
            userNameInput.disabled = true;
            infoWindow.innerHTML = "登入成功";

            //送一個登入聊天室的訊息
            var firstLoginInfo = {
                userName: "系統",
                message: userNameInput.value + " 登入了聊天室"
            };
            webSocket.send(JSON.stringify(firstLoginInfo));
        };

        // onmessage , 接收到來自Server的訊息時觸發
        webSocket.onmessage = function (event) {
            var messageObject = JSON.parse(event.data);
            messageDisplay.innerHTML += messageObject.userName + " 說 : " + messageObject.message + "<br />";
        };
        
        
    }
}


