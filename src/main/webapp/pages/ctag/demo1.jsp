<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="http://my.scwcd" %>
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
        <h1><my:required /></h1>
        <h1><my:greet /></h1>
        <h1><my:greet user="John" /></h1>
        <h1><my:greet user="<%=String.valueOf(1+2) %>" /></h1>
        <h1><my:greet user="${1+2}" /></h1>
        
        <h1>
            <my:switch conditionValue="1">
                <my:case caseValue="1">
                    男生
                </my:case>
                <my:case caseValue="2">
                    女生
                </my:case>
                <my:default>
                    錯誤
                </my:default>
            </my:switch>
        </h1>
        
        <h1>
            <my:implicit attributeName="money" scopeName="page" />
            <my:implicit attributeName="money" scopeName="request" />
            <my:implicit attributeName="money" scopeName="session" />
            <my:implicit attributeName="money" scopeName="application" />
        </h1>
        
    </body>
</html>
