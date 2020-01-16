package com.mycompany.web.servlet.various;

import com.mycompany.web.servlet.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

@WebServlet("/servlet/various/bmi")
public class BMIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 回應的文件格式(Client)
        resp.setContentType("text/plain;encoding=utf-8");
        // 回應的文件編碼(Server)
        resp.setCharacterEncoding("utf-8");
        // 回應給 Client
        PrintWriter out = resp.getWriter();
        String height = req.getParameter("height");
        String weight = req.getParameter("weight");
        
        out.println(String.format("height: %s weight: %s bmi: %.2f", height, weight, calcBmi(height, weight)));
        
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

