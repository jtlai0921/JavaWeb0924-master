<%@page import="java.math.BigDecimal"%>
<%@page import="yahoofinance.YahooFinance"%>
<%@page import="yahoofinance.Stock"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String money = request.getParameter("money");
    String symbol = request.getParameter("symbol");
    if(symbol == null || symbol.equals("")) {
        symbol = "TWDUSD=x";
    }
    if(money == null || money.equals("")) {
        money = "1000";
    }
    Stock stock = YahooFinance.get(symbol);
    double price = stock.getQuote().getPrice().doubleValue();
    double result = price * Integer.parseInt(money);
%>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finance</title>
    </head>
    <body style="padding: 15px">
        <form class="pure-form">
            <fieldset>
                <legend>匯率轉換資料輸入</legend>
                <input type="number" placeholder="台幣" name="money" value="<%=money %>" >
                <input type="text" placeholder="請輸入商品" name="symbol" value="<%=symbol %>" >
                <input type="text" name="result" value="<%=result %>" readonly>
                <button type="submit" class="pure-button pure-button-primary">查詢</button>
                
            </fieldset>
        </form>
        
    </body>
</html>
