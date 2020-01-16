<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    pageContext.setAttribute("x", 10, PageContext.PAGE_SCOPE); // pageContext.setAttribute("x", 10)
    pageContext.setAttribute("y", 20, PageContext.REQUEST_SCOPE);
    pageContext.setAttribute("z", 50, PageContext.SESSION_SCOPE);
    pageContext.setAttribute("a", 100, PageContext.APPLICATION_SCOPE);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL Page 2</title>
    </head>
    <body>
        <h1>${pageScope.x}</h1>
        <h1>${requestScope.y}</h1>
        <h1>${pageScope.x + requestScope.y}</h1>
    </body>
</html>