package com.mycompany.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/calc")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        
        // Server 觀察
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        
        // 邏輯處理
        int z = Integer.parseInt(x) + Integer.parseInt(y);
        System.out.println("z = " + z);
        
        // 回應給 Client
        PrintWriter out = resp.getWriter();
        out.println(String.format("%s + %s = %d", x, y, z));
    }
    
}

