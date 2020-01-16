<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! 
    public String now() {
        return new Date().toString();
    }
    public int add(int x, int y) {
        return x + y;
    }

    class BMI {
        private double bmi;
        BMI(double h, double w) {
            bmi = w / Math.pow(h/100, 2);
        }
        public double getBmi() {
            return bmi;
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><% out.print(new Date()); %></h1>
        <h1><% out.print(now()); %></h1>
        <h1><%=now() %></h1>
        <h1><%=1+5 %></h1>
        <h1><%=add(1, 5) %></h1>
        <%
            BMI bmi = new BMI(170, 60);
            out.print(String.format("%.2f", bmi.getBmi()));
        %>
    </body>
</html>
