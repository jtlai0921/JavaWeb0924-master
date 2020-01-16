package com.mycompany.web.jpa.controller;

import com.google.gson.Gson;
import com.mycompany.web.jpa.entity.Customer;
import com.mycompany.web.jpa.service.CustomerService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jpa/customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        CustomerService service = new CustomerService();
        List<Customer> customers = service.query();
        
        resp.getWriter().print(new Gson().toJson(customers));
        
    }
    
}
