window.onload = function () {
    var webSocket;
    var url = 'ws://localhost:8080/JavaWeb0924/simple/ws/server';

    //設置登入鈕的動作，登入才可發言
    openBtn.addEventListener("click", function () {
        setWebSocket();  // 設置WebSocket連接
    });
    
    messageBtn.addEventListener("click", function () {
        var msg = message.value;
        webSocket.send(msg); // 傳送資料
    });
    
    closeBtn.addEventListener("click", function () {
        webSocket.close(); // 關閉WebSocket連接
    });

    //設置 WebSocket
    function setWebSocket() {
        console.log(url);
        // 開始 WebSocket 連線
        webSocket = new WebSocket(url);
        //以下開始偵測WebSocket的各種事件

        // onopen , 連線成功時觸發
        webSocket.onopen = function (event) {
            console.log("onopen: 連線成功");
            openBtn.disabled = true;
            messageBtn.disabled = false;
            closeBtn.disabled = false;
        };

        // onmessage , 接收到來自Server的訊息時觸發
        webSocket.onmessage = function (event) {
            var time = " <font color='gray' size='1'>" + new Date() + "</font>";
            var msg = event.data + time;
            console.log("onmessage: " + msg);
            messageDisplay.insertAdjacentHTML('beforeend', msg + '<br>');
        };
        
        // onclose , 連線關閉  
        webSocket.onclose = function (event) {
            console.log("onclose: 連線關閉");
            messageDisplay.insertAdjacentHTML('beforeend', "連線關閉" + '<br>');
            openBtn.disabled = false;
            messageBtn.disabled = true;
            closeBtn.disabled = true;
        };
        
        // onerror , 連線錯誤時觸發  
        webSocket.onerror = function (event) {
            console.log("onerror: 連線錯誤");
        };

    }
}

