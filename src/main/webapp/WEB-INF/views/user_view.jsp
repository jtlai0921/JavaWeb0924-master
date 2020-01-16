<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>Check User</h1>
        <h1>${requestScope.username}</h1>
        <h1>${requestScope.check}</h1>
        <c:if test="${requestScope.check}">
            <h1>${requestScope.username} 是會員</h1>
        </c:if>
    </body>
</html>
