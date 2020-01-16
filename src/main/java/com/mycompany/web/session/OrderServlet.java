package com.mycompany.web.session;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/order")
public class OrderServlet extends HttpServlet {
    
    protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        
        if(session.getAttribute("carts") == null) {
            session.setAttribute("carts", new LinkedHashMap<Date, Integer>()); 
        }
        
        LinkedHashMap<Date, Integer> carts = (LinkedHashMap)session.getAttribute("carts");
        int amount = 0;
        String message = "";
        int instock = 0;
        synchronized(OrderServlet.class) {
            try {
                TimeUnit.MICROSECONDS.sleep(100);
                instock = getStockAmount();
                amount = Integer.parseInt(req.getParameter("amount"));
                if(instock >= amount) {
                    instock -= amount;
                    carts.put(new Date(), amount);
                    updateStockAmount(instock);
                } else {
                    message = "庫存不足";
                }
            } catch (Exception e) {
            }
        }
        
        req.setAttribute("instock", instock);
        req.setAttribute("amount", amount);
        req.setAttribute("message", message);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/session/order.jsp");
        rd.forward(req, resp);
    }
    
    private int getStockAmount() throws Exception {
        // 取得庫存
        String path = getServletContext().getRealPath("/WEB-INF/jsp/session/stock.txt");
        String data = Files.newBufferedReader(Paths.get(path)).readLine();
        int instock = Integer.parseInt(data);
        return instock;
    }
    
    private void updateStockAmount(int instock) {
        // 取得庫存
        String path = getServletContext().getRealPath("/WEB-INF/jsp/session/stock.txt");
        try(FileWriter fw = new FileWriter(path);) {
            fw.write(instock+"");
            fw.flush();
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

}
