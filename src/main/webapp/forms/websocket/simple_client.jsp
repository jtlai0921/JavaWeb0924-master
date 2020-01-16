<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Simple Client</title>
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="simple_client.js"></script>
    </head>
    <body style="padding: 20px">
        <div>
            <form class="pure-form" id="chatRoomForm" onsubmit="return false;">
                <fieldset>
                    <legend>Simple Client</legend>
                    <input type="text"   id="message"    value="Hello" placeholder="請輸入訊息" /><p/>
                    <input type="button" id="openBtn"    value="連線" class="pure-button pure-button-primary" /> 
                    <input type="button" id="messageBtn" value="傳送" class="pure-button pure-button-primary" disabled /> 
                    <input type="button" id="closeBtn"   value="關閉" class="pure-button pure-button-primary" disabled /> 
                </fieldset>
            </form>
        </div>
        <div id="messageDisplay"></div>
    </body>
</html>
