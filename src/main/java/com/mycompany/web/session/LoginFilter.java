package com.mycompany.web.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/session/*")
public class LoginFilter extends HttpFilter {

    private static Map<String, String> users = new LinkedHashMap<>();

    static {
        users.put("admin", "1234");
        users.put("vin", "1111");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        boolean pass = (session.getAttribute("username") != null);

        if (!pass) { // 檢查是否有帶入 username/password
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String remember = req.getParameter("remember");
            
            pass = checkLogin(username, password);
            
            if (pass && remember != null) {
                Cookie cookie_username = new Cookie("username", username);
                Cookie cookie_password = new Cookie("password", password);
                Cookie cookie_remember = new Cookie("remember", "checked");
                cookie_username.setMaxAge(7 * 24 * 60 * 60); // 單位/秒
                cookie_password.setMaxAge(7 * 24 * 60 * 60);
                cookie_remember.setMaxAge(7 * 24 * 60 * 60);
                resp.addCookie(cookie_username);
                resp.addCookie(cookie_password);
                resp.addCookie(cookie_remember);
            }

            if (pass) {
                session.setAttribute("username", username);
            } else {
                session.invalidate();
                req.setAttribute("message", "登入失敗或請重新登入");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/session/login.jsp");
                rd.forward(req, resp);
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    private boolean checkLogin(String username, String password) {
        return users.get(username) != null && users.get(username).equals(password);
    }
}
