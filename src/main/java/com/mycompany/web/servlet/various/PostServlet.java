package com.mycompany.web.servlet.various;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

@WebServlet("/servlet/various/post")
public class PostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 回應的文件格式(Client)
        resp.setContentType("text/html;encoding=utf-8");
        
        // 回應的文件編碼(Server)
        resp.setCharacterEncoding("utf-8");
        
        // 回應給 Client
        PrintWriter out = resp.getWriter();
        String id = req.getParameter("id");
        String exam = req.getParameter("exam");
        String[] slot = req.getParameterValues("slot");
        String pay = req.getParameter("exam");
        String note = req.getParameter("note");
        
        out.println(String.format("id: %s<br> exam: %s<br> slot: %s<br> pay: %s<br> note: %s<br>", 
                id, exam, Arrays.toString(slot), pay, note));
        
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

