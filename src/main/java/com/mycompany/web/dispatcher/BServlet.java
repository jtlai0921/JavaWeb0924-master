package com.mycompany.web.dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher/B")
public class BServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BServlet");
        try {
            int x = Integer.parseInt(req.getAttribute("x").toString());
            x *= 2;
            resp.getWriter().println("BServlet say x = " + x);
        } catch (Exception e) {
            resp.getWriter().println("BServlet say No data !");
        }
        
    }
    
}
