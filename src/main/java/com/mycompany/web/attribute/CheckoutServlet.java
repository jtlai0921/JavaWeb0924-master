package com.mycompany.web.attribute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/attribute/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pen = 0;
        try {
            pen = Integer.parseInt(req.getSession().getAttribute("pen").toString());
            req.getSession().setAttribute("pen", 0);
        } catch (Exception e) {
            pen = 0;
        }
        if(pen > 0) {
            int summary = 0;
            if (req.getSession().getAttribute("summary") != null) {
                summary = Integer.parseInt(req.getSession().getAttribute("summary").toString());
            }
            summary += pen;
            req.getSession().setAttribute("summary", summary);
        }
        resp.getWriter().println("Summary : " + req.getSession().getAttribute("summary"));
    }

}
