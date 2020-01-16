package com.mycompany.web.filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/personnel/salary")
public class LoginFilter implements Filter {
    private static Map<String, String> users = new LinkedHashMap<>();
    static {
        // username / password
        users.put("John", "1234");
        users.put("Mary", "5678");
        users.put("Jean", "0000");
        users.put("admin", "9999");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("LoginFilter");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(users.get(username) != null && users.get(username).equals(password)) {
            chain.doFilter(request, response);
        } else {
            return;
        }
        
    }

    @Override
    public void destroy() {
    }
    
}
