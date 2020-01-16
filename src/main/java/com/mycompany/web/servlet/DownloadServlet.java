package com.mycompany.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/download")
public class DownloadServlet extends HttpServlet {
    
    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("doHeader:" + req.getParameter("x"));
        doGet(req, resp);
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 從絕對路徑讀取輸入文件
        File file = new File("/Users/vincenttuan/Pictures/bread.png");
        
        // 取得檔案的網際網路媒體類型MIME類型（MIME type）
        String mimeType = Files.probeContentType(file.toPath());
        if (mimeType == null) {        
            // 若無法判斷 mini, 則設定一個任意的二進制檔案（通常做為通知瀏覽器下載檔案）
            mimeType = "application/octet-stream"; 
        }
         
        // 設定下載檔案標頭資料
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
        resp.setHeader(headerKey, headerValue);
         
        // obtains response's output stream
        Files.copy(file.toPath(), resp.getOutputStream()); 
    }
}
