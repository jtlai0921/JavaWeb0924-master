<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL Page 3</title>
    </head>
    <body>
        <!-- ?h=170&w=60&a-b=40&score=100&score=90&score=80 -->
        <h1>${param.h}</h1>
        <h1>${param.w}</h1>
        <h1>${param["a-b"]}</h1>
        
        <h1>${paramValues.score}</h1>
        <h1>${paramValues.score[1]}</h1>
        
        <h1>${header["User-Agent"]}</h1>
    </body>
</html>