package com.mycompany.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/image_car")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("c:/car.jpg");
        System.out.println(file.length());
        
        resp.setContentType("image/jpeg");
        resp.setContentLength((int)file.length());
        
        ServletOutputStream out = resp.getOutputStream();
        Files.copy(file.toPath(), out);
        out.close();
    }
    
}
