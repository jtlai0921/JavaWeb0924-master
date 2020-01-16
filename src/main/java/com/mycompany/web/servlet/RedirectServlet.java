package com.mycompany.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;encoding=utf-8");
        resp.setCharacterEncoding("utf-8");
        
        switch(req.getParameter("x")) {
            case "1":
                resp.sendRedirect("http://tw.yahoo.com");
                break;
            default:
                resp.sendRedirect("http://google.com");
                break;    
        }
        
        
    }
    
}
