<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<sql:setDataSource var="mydb"
                   driver="org.apache.derby.jdbc.ClientDriver"
                   url="jdbc:derby://localhost:1527/MyDB"
                   user="app"
                   password="app"/>
<sql:query dataSource="${mydb}" var="products">
    SELECT product_id, purchase_cost, quantity_on_hand, description, (purchase_cost*quantity_on_hand) as subtotal
    FROM product
</sql:query>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL SQLPage</title>
    </head>
    <body>
        ${mydb.getConnection().getCatalog()}
        <table class="pure-table pure-table-bordered" width="100%">
            <thead>
                <tr>
                    <th>no</th>
                    <th>product_id</th>
                    <th>description</th>
                    <th>purchase_cost</th>
                    <th>quantity_on_hand</th>
                    <th>subtotal</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${products.rows}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${p.product_id}</td>
                    <td><c:out value="${p.description}" /></td>
                    <td>${p.purchase_cost}</td>
                    <td>${p.quantity_on_hand}</td>
                    <td>${p.subtotal}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
