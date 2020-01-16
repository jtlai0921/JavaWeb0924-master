<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/my_library" %>
<!DOCTYPE html>
<%
    pageContext.setAttribute("money", 10);
    request.setAttribute("money", 5000);
    session.setAttribute("money", 10000);
    application.setAttribute("money", 99999);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Tag Page</title>
    </head>
    <body>
        <h1>
            <my:add x="10" y="20" />
        </h1>
        <h1>
            <my:bmi h="170.2" w="60.5">
                身高體重指數（又稱身體質量指數，英文為Body Mass Index，簡稱BMI）是一個計算值，主要用於統計用途。<p/>
                <%=new Date() %><p/>
            </my:bmi>
            <p />
            Good Boy !    
        </h1>
        <h1>
            <my:loop count="3">
                Java
            </my:loop>
        </h1>
        <h1>
            <my:search marker="e">
                she sell sea shell on the sea shore
            </my:search>
        </h1>
    </body>
</html>
