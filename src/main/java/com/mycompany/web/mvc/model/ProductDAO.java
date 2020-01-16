package com.mycompany.web.mvc.model;

import com.mycompany.web.mvc.entity.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ProductDAO {
    private DataSource ds;

    public ProductDAO(DataSource ds) {
        this.ds = ds;
    }
    
    public List<Product> queryAll(double exchange) {
        List<Product> list = new ArrayList<>();
        try {
            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select product_id, (purchase_cost*%f) as purchase_cost, quantity_on_hand, description, ((purchase_cost*%f)*quantity_on_hand) as subtotal FROM product";
            sql = sql.format(sql, exchange, exchange);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setPurchase_cost(rs.getDouble("purchase_cost"));
                product.setQuantity_on_hand(rs.getInt("quantity_on_hand"));
                product.setDescription(rs.getString("description"));
                product.setSubtotal(rs.getDouble("subtotal"));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
}
