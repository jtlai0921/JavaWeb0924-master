package com.mycompany.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bmi")
public class BMIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 回應的文件格式(Client)
        resp.setContentType("text/plain;encoding=utf-8");
        // 回應的文件編碼(Server)
        resp.setCharacterEncoding("utf-8");
        // 回應給 Client
        PrintWriter out = resp.getWriter();
        out.println("禁止用此方法連入");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 回應的文件格式(Client)
        resp.setContentType("text/plain;encoding=utf-8");
        // 回應的文件編碼(Server)
        resp.setCharacterEncoding("utf-8");
        
        PrintWriter out = resp.getWriter();
        
        // 取得參數
        String h = req.getParameter("h");
        String w = req.getParameter("w");
        
        // 邏輯處理
        double bmi = calcBmi(h, w);
        
        // 驗證
        switch ((int)bmi) {
            case -1:
                // 回應給 Client
                out.println("h 參數錯誤 !");
                // 程式結束
                return;
            case -2:
                // 回應給 Client
                out.println("w 參數錯誤 !");
                // 程式結束
                return;  
        }
        
        // 回應給 Client
        out.println(String.format("身高:%s, 體重:%s, BMI:%.2f", h, w, bmi));
    }
    
    // 計算 BMI
    private double calcBmi(String height, String weight) {
        double h, w = 0;
        // 轉型...
        try {
            h = Double.parseDouble(height);
        } catch (Exception e) {
            return -1;
        }
        try {
            w = Double.parseDouble(weight);
        } catch (Exception e) {
            return -2;
        }
        return w / Math.pow(h/100, 2);
    }
    
}

