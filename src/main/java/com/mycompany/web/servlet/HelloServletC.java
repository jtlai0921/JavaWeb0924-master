package com.mycompany.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/helloc/*") // 簡易配置
public class HelloServletC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("ContextPath: " + req.getContextPath());
        out.println("ServletPath: " + req.getServletPath());
        out.println("PathInfo: " + req.getPathInfo());
    }
    
}
