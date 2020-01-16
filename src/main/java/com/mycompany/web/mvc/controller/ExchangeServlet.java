package com.mycompany.web.mvc.controller;

import com.mycompany.web.mvc.model.Exchange;
import com.mycompany.web.mvc.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc/controller/exchange")
public class ExchangeServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String money = req.getParameter("money");
        String symbol = req.getParameter("symbol");
        // 使用 Model
        Exchange exchange = new Exchange();
        double exchangePrice = exchange.getExchangePrice(symbol, Integer.parseInt(money));
        
        // 設定要傳給 view 的資料
        req.setAttribute("exchangePrice", exchangePrice);
        
        // 重導到 view
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/exchange_view.jsp");
        rd.forward(req, resp);
    }
    
}
