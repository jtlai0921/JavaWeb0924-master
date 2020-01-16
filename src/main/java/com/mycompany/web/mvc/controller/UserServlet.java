package com.mycompany.web.mvc.controller;

import com.mycompany.web.mvc.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc/controller/user")
public class UserServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String username = req.getParameter("username");
        // 使用 Model
        User user = new User();
        boolean check = user.isMember(username);
        
        // 設定要傳給 view 的資料
        req.setAttribute("username", username);
        req.setAttribute("check", check);
        
        // 重導到 view
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/user_view.jsp");
        rd.forward(req, resp);
    }
    
}
