<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int work = 0;
    try {
        work = Integer.parseInt(request.getParameter("work"));
    } catch (Exception e) {
        work = 11;
    }
    int eat = new Random().nextInt(10);
    int commute = new Random().nextInt(10);
    int tv = new Random().nextInt(10);
    int sleep = new Random().nextInt(10);
%>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">  
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {

                var data = google.visualization.arrayToDataTable([
                    ['Task', 'Hours per Day'],
                    ['Work', <%=work%>],
                    ['Eat', <%=eat%>],
                    ['Commute', <%=commute%>],
                    ['Watch TV', <%=tv%>],
                    ['Sleep', <%=sleep%>]
                ]);

                var options = {
                    title: 'My Daily Activities'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                chart.draw(data, options);
            }
        </script>
    </head>
    <body style="padding: 15px">
        <form class="pure-form">
            <fieldset>
                <legend>請輸入參數</legend>
                <input type="number" name="work" placeholder="請輸入 Work" value="<%=work %>">
                <button type="submit" class="pure-button pure-button-primary">繪圖</button>
            </fieldset>
        </form>
        <div id="piechart" style="width: 900px; height: 500px;"></div>
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Work</th>
                    <th>Eat</th>
                    <th>Commute</th>
                    <th>Watch TV</th>
                    <th>Sleep</th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td>1</td>
                    <td><%=work%></td>
                    <td><%=eat%></td>
                    <td><%=commute%></td>
                    <td><%=tv%></td>
                    <td><%=sleep%></td>
                </tr>

            </tbody>
        </table>
    </body>
</html>

