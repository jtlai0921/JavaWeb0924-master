<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List Page MVC</title>
        <style>
            body {font-family: monospace;} 
        </style>
    </head>
    <body>
        <table class="pure-table pure-table-bordered" width="100%">
            <thead>
                <tr style="cursor: pointer" >
                    <th>product_id</th>
                    <th>description</th>
                    <th>purchase_cost</th>
                    <th>quantity_on_hand</th>
                    <th>subtotal</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="total" value="0"/>
                <c:forEach var="p" items="${requestScope.products}">
                    <c:set var="subtotal" value="${p.subtotal}"/>
                    <c:set var="total" value="${total + subtotal}"/>
                    <tr onmouseover="this.style.background = '#CCCCCC'" onmouseout="this.style.background = 'white'">
                        <td align="center" style="cursor: pointer" title="請點我" >${p.product_id}</td>
                        <td>${p.description}</td>
                        <td><fmt:formatNumber value="${p.purchase_cost}" type="currency"/></td>
                        <td align="right"><fmt:formatNumber value="${p.quantity_on_hand}" type="number"/></td>
                        <td><fmt:formatNumber value="${subtotal}" type="currency"/></td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr bgcolor='#DDDDDD'>
                    <td align="center">
                        <button type="button" class="pure-button pure-button-primary" onclick="window.history.back()">Back</button>
                    </td>
                    <td align="right" colspan="3">Total</td>
                    <td><fmt:formatNumber value="${total}" type="currency"/></td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>
