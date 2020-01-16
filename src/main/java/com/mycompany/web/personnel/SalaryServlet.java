package com.mycompany.web.personnel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/personnel/salary")
public class SalaryServlet extends HttpServlet {
    private static Map salaryMap = new LinkedHashMap();
    static {
        salaryMap.put("John", 100000);
        salaryMap.put("Mary", 50000);
        salaryMap.put("Jean", 120000);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        int bonus = Integer.parseInt(req.getAttribute("bonus").toString());
        out.println(salaryMap);
        out.println("bonus = " + bonus);
    }
    
}
