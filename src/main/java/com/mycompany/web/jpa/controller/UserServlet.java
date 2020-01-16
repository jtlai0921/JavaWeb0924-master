package com.mycompany.web.jpa.controller;

import com.mycompany.web.jpa.entity.User;
import com.mycompany.web.jpa.service.UserService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// please use TomEE
@WebServlet("/jpa/*")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo.equals("/user") || pathInfo.equals("/user/")) {
            String user_name = req.getParameter("user_name");
            Integer user_age = Integer.valueOf(req.getParameter("user_age"));
            UserService service = new UserService();
            boolean check = service.insert(user_name, user_age);
            resp.getWriter().println("Insert: " + check);
        } else {
            resp.getWriter().println("Not allow !");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserService();
        String pathInfo = req.getPathInfo();
        resp.getWriter().println(pathInfo);
        // 多筆查詢
        if (pathInfo.equals("/users") || pathInfo.equals("/users/")) {
            List<User> users = service.query();
            resp.getWriter().println(users);
        } else { // 單筆查詢
            Matcher matcher = Pattern.compile("/user/[0-9]+").matcher(pathInfo);
            resp.getWriter().println(matcher.matches());
            if (matcher.matches()) {
                Integer id = Integer.valueOf(pathInfo.split("/")[2]);
                User user = service.findById(id);
                resp.getWriter().println(user);
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String pathInfo = req.getPathInfo();
        resp.getWriter().println(pathInfo);
        Matcher matcher = Pattern.compile("/user/[0-9]+").matcher(pathInfo);
        resp.getWriter().println(matcher.matches());
        
        if (matcher.matches()) {
            UserService service = new UserService();
            // 抓取串流參數 ex: user_name=Tom&user_age=15
            String args = new BufferedReader(new InputStreamReader(req.getInputStream())).readLine();
            resp.getWriter().println(args); 
            // 切割資料
            Integer id = Integer.valueOf(pathInfo.split("/")[2]);
            String user_name = args.split("&")[0].split("=")[1];
            Integer user_age = Integer.valueOf(args.split("&")[1].split("=")[1]);
            
            boolean check = service.update(id, user_name, user_age);
            resp.getWriter().println("Update: " + check);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String pathInfo = req.getPathInfo();
        resp.getWriter().println(pathInfo);
        Matcher matcher = Pattern.compile("/user/[0-9]+").matcher(pathInfo);
        resp.getWriter().println(matcher.matches());
        
        if (matcher.matches()) {
            UserService service = new UserService();
            // 切割資料
            Integer id = Integer.valueOf(pathInfo.split("/")[2]);
            
            boolean check = service.delete(id);
            resp.getWriter().println("Delete: " + check);
        }
    }

}
