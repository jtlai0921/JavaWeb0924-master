package com.mycompany.web.attribute;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/attribute/A")
public class AServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int x = 10;
        int y = 20;
        int z = 30;
        
        // 設定
        req.setAttribute("x", x); // Request scope
        req.getSession().setAttribute("y", y); // Session scope
        getServletContext().setAttribute("z", z); // Context(Application) scope
        
        // 分派
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/attribute/B");
        rd.forward(req, resp);
        
        // 取得
        PrintWriter out = resp.getWriter();
        out.println(getServletName() + " Set up:");
        out.println("x = " + req.getAttribute("x"));
        out.println("y = " + req.getSession().getAttribute("y"));
        out.println("z = " + getServletContext().getAttribute("z"));
        // Log
        System.out.println("x = " + req.getAttribute("x"));
        System.out.println("y = " + req.getSession().getAttribute("y"));
        System.out.println("z = " + getServletContext().getAttribute("z"));
        
    }
    
}
