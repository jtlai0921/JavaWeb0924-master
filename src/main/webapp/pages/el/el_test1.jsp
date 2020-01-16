<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL Page 1</title>
    </head>
    <body>
        <h1>${1+3}</h1>
        <h1>${4/2}</h1>
        <h1>${5 % 2}</h1>
        <h1>${5 mod 2}</h1>
        <h1>${5 > 2}</h1>
        <h1>${5 gt 2}</h1>
        <h1>${ 5 * 5 * Math.PI }</h1>
        <h1>${ 60 / Math.pow(170/100, 2) }</h1>
        <h1>${ String.format("%.2f", 60 / Math.pow(170/100, 2)) }</h1>
    </body>
</html>
