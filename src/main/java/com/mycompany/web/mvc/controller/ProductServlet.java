package com.mycompany.web.mvc.controller;

import com.mycompany.web.mvc.entity.Product;
import com.mycompany.web.mvc.service.ProductService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc/controller/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ProductService service = new ProductService();
        List<Product> products = service.query();
        
        req.setAttribute("products", products);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/product_view.jsp");
        rd.forward(req, resp);
        
    }
    
}
