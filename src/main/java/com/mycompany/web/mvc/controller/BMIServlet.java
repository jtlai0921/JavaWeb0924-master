/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.web.mvc.controller;

import com.mycompany.web.mvc.model.BMI;
import com.mycompany.web.mvc.service.BMIService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc/bmi/*")
public class BMIServlet extends HttpServlet {

    private BMIService service = new BMIService();

    protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String bmi_path = getServletContext().getContextPath() + req.getServletPath();
        BMI bmi = new BMI();
        int id = 0;
        String action = "save";
        switch (req.getPathInfo()) {
            case "/input":
                break;
            case "/save":
                bmi.setSex(req.getParameter("sex"));
                bmi.setHeight(Double.parseDouble(req.getParameter("height")));
                bmi.setWeight(Double.parseDouble(req.getParameter("weight")));
                service.save(bmi);
                resp.sendRedirect(bmi_path + "/input");
                return;
            case "/get":
                id = Integer.parseInt(req.getParameter("id"));
                bmi = service.get(id);
                action = "update";
                break;
            case "/update":
                id = Integer.parseInt(req.getParameter("id"));
                bmi.setSex(req.getParameter("sex"));
                bmi.setHeight(Double.parseDouble(req.getParameter("height")));
                bmi.setWeight(Double.parseDouble(req.getParameter("weight")));
                service.update(id, bmi);
                resp.sendRedirect(bmi_path + "/input");
                return;
            case "/delete":
                id = Integer.parseInt(req.getParameter("id"));
                service.delete(id);
                resp.sendRedirect(bmi_path + "/input");
                return;
        }
        
        req.setAttribute("data", service.getData());
        req.setAttribute("data1", service.getData(service.query("男")));
        req.setAttribute("data2", service.getData(service.query("女")));
        req.setAttribute("action", action);
        req.setAttribute("bmi", bmi);
        req.setAttribute("list", service.query());
        req.setAttribute("bmi_path", bmi_path);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/bmi_mvc.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandler(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandler(req, resp);
    }

}
