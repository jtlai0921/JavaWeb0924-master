package com.mycompany.web.dispatcher;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher/A")
public class AServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AServlet");
        int x = 10;
        // 設定 request scope 變數
        req.setAttribute("x", x);
        // 建立分派器
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/dispatcher/B");
        //rd.forward(req, resp);
        rd.include(req, resp);
        
        // end of AServlet
        resp.getWriter().println("end of AServlet");
    }
    
}
