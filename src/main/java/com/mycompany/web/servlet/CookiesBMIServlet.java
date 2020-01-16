package com.mycompany.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/cookies_bmi")
public class CookiesBMIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;encoding=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        String h = req.getParameter("h");
        String w = req.getParameter("w");
        
        // 確認是否有 h 或 w 的參數
        if(h == null || w == null) { // 沒有參數
            out.println("抓取 cookies 內容");
            // 取得 client 所有 cookie
            Cookie[] cookies = req.getCookies();
            if(cookies == null) { // cookie 不存在
                out.print("Cookie 沒資料");
            } else {
                // 分析每一筆 cookie
                for(Cookie cookie : cookies) {
                    out.println(cookie.getName() + ":" + cookie.getValue());
                }
            }
        } else { // 有參數
            double bmi = Double.parseDouble(w) / Math.pow(Double.parseDouble(h)/100, 2);
            out.println("直接及時計算");
            out.println(String.format("身高: %s, 體重:%s, bmi:%.2f", h, w, bmi));
            // 將 bmi 存入字串
            Cookie c1 = new Cookie("bmi", bmi + "");
            c1.setMaxAge(30);
            Cookie c2 = new Cookie("height", h);
            c2.setMaxAge(30);
            // 要求 client 存入 cookie 資料
            resp.addCookie(c1);
            resp.addCookie(c2);
        }
        
    }

}

