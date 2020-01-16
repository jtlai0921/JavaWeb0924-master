package com.mycompany.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = getServletConfig().getInitParameter("x");
        String y = getServletConfig().getInitParameter("y");
        int z = Integer.parseInt(x) + Integer.parseInt(y);
        resp.getWriter().println(x + " + " + y + " = " + z);
    }
    
}
