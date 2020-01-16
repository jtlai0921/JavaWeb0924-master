package com.mycompany.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/calc2")
public class CalcServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] arrayX = req.getParameterValues("x");
        // Server 觀察
        Arrays.stream(arrayX).forEach(System.out::println);
        
        // 邏輯處理
        int sum = Arrays.stream(arrayX).mapToInt(Integer::parseInt).sum();
        System.out.println("sum = " + sum);
        
        // 回應給 Client
        PrintWriter out = resp.getWriter();
        out.println(String.format("sum = %d", sum));
    }
    
}

