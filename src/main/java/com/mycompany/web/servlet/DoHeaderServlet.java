package com.mycompany.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
    客戶端就可以檢查資源的標頭，而不必實際獲取資源。使用HEAD，您可以：
    1.查找資源（例如，確定其類型）而不獲取資源。
    2.通過查看響應的狀態碼來查看對像是否存在。
    3.通過查看標頭，測試資源是否已被修改。
*/
@WebServlet("/servlet/doheader")
public class DoHeaderServlet extends HttpServlet {
    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("doHeader:" + req.getParameter("x"));
        doGet(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("doGet");
        resp.getWriter().print("doHead response");
        resp.addHeader("yes", "ok");
    }
}
