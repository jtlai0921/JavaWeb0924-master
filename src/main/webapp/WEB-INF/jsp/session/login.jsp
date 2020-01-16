<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
    </head>
    <body style="padding: 15px">
        <form class="pure-form" method="post">
            <fieldset>
                <legend>Login Page</legend>

                <input type="text" placeholder="username" name="username" value="${cookie.username.getValue()}"><p/>
                <input type="password" placeholder="Password" name="password" value="${cookie.password.getValue()}"><p/>

                <label for="remember">
                    <input id="remember" type="checkbox" name="remember" ${cookie.remember.getValue()}> Remember me
                </label><p/>

                <button type="submit" class="pure-button pure-button-primary">Sign in</button>
                <font color="red">${message}</font>
            </fieldset>
        </form>
    </body>
</html>
