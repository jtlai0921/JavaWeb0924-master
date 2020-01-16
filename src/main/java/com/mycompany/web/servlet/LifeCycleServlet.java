package com.mycompany.web.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns = {"/servlet/lifecycle"},
        initParams = {
            @WebInitParam(name = "platform", value = "JavaEE"),
            @WebInitParam(name = "program", value = "Java")
        },
        loadOnStartup = 1
)
public class LifeCycleServlet extends HttpServlet {
    private int version;
    
    public LifeCycleServlet() {
        System.out.println("LifeCycleServlet()");
        version = 7;
    }

    // 新手不宜
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        init();
//    }
    
    @Override
    public void init() throws ServletException {
        System.out.println("init()");
        String platform = getServletConfig().getInitParameter("platform");
        System.out.println("platform: " + platform);
        System.out.println("version: " + version);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet()");
        resp.getWriter().println("Servlet Name: " + getServletConfig().getServletName());
        resp.getWriter().println("Please see log in Tomcat 9.0's console.");
    }
    
    @Override
    public void destroy() {
        System.out.println("destroy()");
    }
    
}
