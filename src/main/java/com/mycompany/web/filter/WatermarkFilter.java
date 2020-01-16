package com.mycompany.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/servlet/report")
public class WatermarkFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //System.out.println("WatermarkFilter");
        // 自建 response 物件
        MyResponse myResp = new MyResponse(resp);
        
        chain.doFilter(req, myResp);
        
        String html = myResp.getResult();
        //System.out.println("html = " + html);
        html = html.replaceAll("<body", "<body background=\"../images/do_not_copy.jpg\"");
        resp.getWriter().println(html);
    }

}
