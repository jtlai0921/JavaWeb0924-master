package com.mycompany.web.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

@WebServlet("/servlet/upload")
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15, // 15 MB
        location            = "/Users/vincenttuan/NetBeansProjects/JavaWeb0924/src/main/webapp/forms/upload")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // 回應的文件格式(Client)
        resp.setContentType("text/plain;encoding=utf-8");
        
        // 回應的文件編碼(Server)
        resp.setCharacterEncoding("utf-8");
        
        // 分析 Parts
        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("uploadfile"))
                .forEach(part -> {
                    try {
                        part.write(part.getSubmittedFileName());
                        resp.getWriter().println("Upload OK. ");
                    } catch (IOException ex) {
                    }
                });
        
        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("desc"))
                .forEach(part -> {
                    try {
                        resp.getWriter().print(
                                IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8.name())
                        );
                    } catch (IOException ex) {
                    }
                });
        
    }
 

}
