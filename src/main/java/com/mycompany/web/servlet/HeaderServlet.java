package com.mycompany.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/header")
public class HeaderServlet extends HttpServlet {
    private String news = "下周有4天連續假期";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain;encoding=utf-8");
        
        PrintWriter out = resp.getWriter();
        if(req.getHeader("user-agent").contains("Chrome")) {
            if(req.getHeader("accept-language").contains("zh-TW")) {
                out.println(news);
            } else {
                out.println(news + "...請自行翻譯英文");
            }
        }
        
        // 查詢所有 client's header 資料
        Enumeration<String> enums = req.getHeaderNames();
        while(enums.hasMoreElements()) {
            String name = enums.nextElement();
            String value = req.getHeader(name);
            out.println(name + ":" + value);
        }
    }
    
}
