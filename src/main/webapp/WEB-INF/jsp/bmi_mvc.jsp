<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>BMI MVC</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);
            google.charts.setOnLoadCallback(drawChart1);
            google.charts.setOnLoadCallback(drawChart2);

            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Level', 'BMI'],
                    ['標準', ${data[0]}],
                    ['超重', ${data[1]}],
                    ['肥胖', ${data[2]}],
                    ['過低', ${data[3]}]
                ]);

                var options = {
                    title: 'BMI 資料統計'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                chart.draw(data, options);
            }
            
            function drawChart1() {
                var data = google.visualization.arrayToDataTable([
                    ['Level', 'BMI'],
                    ['標準', ${data1[0]}],
                    ['超重', ${data1[1]}],
                    ['肥胖', ${data1[2]}],
                    ['過低', ${data1[3]}]
                ]);

                var options = {
                    title: 'BMI 資料統計（男）'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart1'));

                chart.draw(data, options);
            }
            
            function drawChart2() {
                var data = google.visualization.arrayToDataTable([
                    ['Level', 'BMI'],
                    ['標準', ${data2[0]}],
                    ['超重', ${data2[1]}],
                    ['肥胖', ${data2[2]}],
                    ['過低', ${data2[3]}]
                ]);

                var options = {
                    title: 'BMI 資料統計（女）'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart2'));

                chart.draw(data, options);
            }
        </script>
    </head>
    <body style="padding: 10px">
        <table>
            <td valign="top" style="padding: 5px">
                <form class="pure-form" method="post" action="${bmi_path}/${action}">
                    <fieldset>
                        <legend>BMI MVC</legend>
                        <input type="number" name="id" value="${bmi.id}" readonly="true"><p/>
                        性別：
                        <input type="radio" name="sex" value="男" ${ bmi.sex=="男" ? "checked" : "" } >男
                        <input type="radio" name="sex" value="女" ${ bmi.sex=="女" ? "checked" : "" }>女<p />
                        <input type="number" placeholder="請輸入身高" name="height" value="${bmi.height}"><p/>
                        <input type="number" placeholder="請輸入體重" name="weight" value="${bmi.weight}"><p/>
                        <button type="submit" class="pure-button pure-button-primary">${action}</button>
                        <button type="button" class="pure-button pure-button-primary" onclick="location.href = '${bmi_path}/input';">reset</button>
                    </fieldset>
                </form>
                <table class="pure-table pure-table-bordered">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>sex</th>
                            <th>height</th>
                            <th>weight</th>
                            <th>bmi</th>
                            <th>delete</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="bmi" items="${list}">
                            <tr>
                                <td><a href="${bmi_path}/get?id=${bmi.id}">${bmi.id}</a></td>
                                <td>${bmi.sex}</td>
                                <td>${bmi.height}</td>
                                <td>${bmi.weight}</td>
                                <td><fmt:formatNumber value="${bmi.result}" type="number" maxFractionDigits="2"/></td>
                                <td><a href="${bmi_path}/delete?id=${bmi.id}">刪除</a></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </td>
            <td valign="top" style="padding: 5px">
                <table>
                    <tr>
                        <td colspan="2">
                            <div id="piechart" style="width: 700px; height: 300px;"></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div id="piechart1" style="width: 350px; height: 200px;"></div>
                        </td>
                        <td>
                            <div id="piechart2" style="width: 350px; height: 200px;"></div>
                        </td>
                    </tr>
                </table>
                
            </td>
        </table>
    </body>
</html>

