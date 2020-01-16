package com.mycompany.web.filter;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/servlet/exchange/price")
public class ExchangeFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        MyRequest myRequest = new MyRequest(req);
        System.out.println(Locale.getDefault().getCountry()); // TW
        myRequest.setParameter("value", req.getParameter("name") + "0");
        chain.doFilter(myRequest, res);
    }
}
