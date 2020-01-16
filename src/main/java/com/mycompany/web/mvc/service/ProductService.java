package com.mycompany.web.mvc.service;

import com.mycompany.web.mvc.entity.Product;
import com.mycompany.web.mvc.model.Exchange;
import com.mycompany.web.mvc.model.ProductDAO;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductService {
    private DataSource ds;

    public ProductService() {
        try {
            // JNDI 查找連線物件
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/derby");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 查詢全部
    public List<Product> query() {
        ProductDAO dao = new ProductDAO(ds);
        double exchange = new Exchange().getExchangeBySymbol("USDTWD=x");
        return dao.queryAll(exchange);
    }
}
