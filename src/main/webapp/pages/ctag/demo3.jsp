<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/my_library" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Tag Page</title>
    </head>
    <body>
        <h1>
            <my:simple />
        </h1>
        <h1>
            <my:simple_search_image keyword="car" />
        </h1>
        <h1>
            <my:simple_dyn_add x="10" a="20" age="30" />
        </h1>
    </body>
</html>
