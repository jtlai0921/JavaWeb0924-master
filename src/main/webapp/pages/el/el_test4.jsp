<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://my.el.func/" prefix="myel" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL Page 4</title>
    </head>
    <body>
        
        <h1>${ myel:pi() }</h1>
        <h1>${ myel:bmi(170, 60) }</h1>
        
    </body>
</html>