<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <title>JSTL Page 1</title>
    </head>
    <body style="padding: 20px">
        <!-- ?score=100&score=40&score=30&score=70 -->
        <h1>
            第一個分數 : ${param.score}
            <c:if test="${param.score >= 60}">
                Pass
            </c:if>
            <c:if test="${param.score < 60}">
                Fail
            </c:if>
        </h1>
        <h2>
            <table class="pure-table pure-table-bordered">
                <thead>
                    <tr>
                        <th>score</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="score" items="${paramValues.score}">
                        <tr>
                            <td>${score}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>    
        </h2>
        <h2>
            <table class="pure-table pure-table-bordered">
                <thead>
                    <tr>
                        <th>score</th>
                        <th>Pass|Fail</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="score" items="${paramValues.score}">
                        <tr>
                            <td>${score}</td>
                            <td>
                                <c:if test="${score >= 60}">
                                    Pass
                                </c:if>
                                <c:if test="${score < 60}">
                                    Fail
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>    
        </h2>
    </body>
</html>
