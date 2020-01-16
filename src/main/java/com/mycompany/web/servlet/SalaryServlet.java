package com.mycompany.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/salary")
public class SalaryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;encoding=utf-8");
        resp.setCharacterEncoding("utf-8");
        
        int bytes = getServletContext().getResourceAsStream("/WEB-INF/salary.txt").available();
        resp.getWriter().println("/WEB-INF/salary.txt " + bytes + " bytes");
        
        // 讀檔案
        try(InputStream is = getServletContext().getResourceAsStream("/WEB-INF/salary.txt");
            InputStreamReader isr = new InputStreamReader(is, "utf-8");    
            PrintWriter out = resp.getWriter();){
            char[] buffer = new char[1];
            while (isr.read(buffer) != -1) {                
                out.print(new String(buffer));
            }
        }
    }

}
