<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<fmt:setLocale value="zh_TW"/> <!-- zh_TW, en_US, ja_JP, de_DE, ko_KR, zh_CN -->
<sql:setDataSource var="mydb"
                   driver="org.apache.derby.jdbc.ClientDriver"
                   url="jdbc:derby://localhost:1527/MyDB"
                   user="app"
                   password="app"/>
<c:set var="exchange" value="${param.exchange==null?1:param.exchange}"/>
<c:set var="sortcolname" value="${param.sortcolname==null?'product_id':param.sortcolname}"/>
<c:set var="sortflag" value="${param.sortflag==null?'':param.sortflag}"/>
<sql:query dataSource="${mydb}" var="products">
    SELECT product_id, 
    (purchase_cost*${exchange}) as purchase_cost, 
    quantity_on_hand, 
    description, 
    ((purchase_cost*${exchange})*quantity_on_hand) as subtotal
    FROM product
    WHERE available = 'TRUE'
    ORDER BY ${sortcolname} ${sortflag}
</sql:query>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL SQLPage 2</title>
        <style>
            body {font-family: monospace;} 
        </style>
        <script>
            function sort(value) {
                let url = new URL(location.href);
                var search_params = new URLSearchParams(url.search); // query_string
                var sortflag = search_params.get('sortflag') == 'ASC' ? 'DESC' : 'ASC';
                var exchange = document.getElementById('exchange').value;
                
                search_params.set('sortcolname', value);
                search_params.set('sortflag', sortflag);
                search_params.set('exchange', exchange);
                
                url.search = search_params.toString();
                window.location.href = url.toString();
            }
            window.onload = function () {
                var input = document.getElementById('exchange');
                input.addEventListener("keyup", function (event) {
                    if (event.keyCode === 13) {
                        // Cancel the default action, if needed
                        event.preventDefault();
                        sort('purchase_cost');
                    }
                });
            }
        </script>
    </head>
    <body>
        ${mydb.getConnection().getCatalog()}
        <table class="pure-table pure-table-bordered" width="100%">
            <thead>
                <tr style="cursor: pointer" title="按我一下可以排序" >
                    <th onclick="sort('product_id')">product_id</th>
                    <th onclick="sort('description')">description</th>
                    <th onclick="sort('purchase_cost')">purchase_cost</th>
                    <th onclick="sort('quantity_on_hand')">quantity_on_hand</th>
                    <th onclick="sort('subtotal')">subtotal</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="total" value="0"/>
                <c:forEach var="p" items="${products.rows}">
                    <c:set var="subtotal" value="${p.subtotal}"/>
                    <c:set var="total" value="${total + subtotal}"/>
                    <tr onmouseover="this.style.background = '#CCCCCC'" onmouseout="this.style.background = 'white'">
                        <td align="center" style="cursor: pointer" title="請點我" >${p.product_id}</td>
                        <td style="cursor: help" >${p.description}</td>
                        <td><fmt:formatNumber value="${p.purchase_cost}" type="currency"/></td>
                        <td align="right"><fmt:formatNumber value="${p.quantity_on_hand}" type="number"/></td>
                        <td style="cursor: wait" ><fmt:formatNumber value="${subtotal}" type="currency"/></td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr bgcolor='#DDDDDD'>
                    <td align="center">匯率</td>
                    <td><input id="exchange" type="number" value="${exchange}"/></td>
                    <td align="right" colspan="2">Total</td>
                    <td><fmt:formatNumber value="${total}" type="currency"/></td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>
