/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.web.attribute;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/attribute/B")
public class BServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 取得
        PrintWriter out = resp.getWriter();
        out.println(getServletName() + " Get :");
        out.println("x = " + req.getAttribute("x"));
        out.println("y = " + req.getSession().getAttribute("y"));
        out.println("z = " + getServletContext().getAttribute("z"));
        // Log
        System.out.println("x = " + req.getAttribute("x"));
        System.out.println("y = " + req.getSession().getAttribute("y"));
        System.out.println("z = " + getServletContext().getAttribute("z"));
    }
    
}
