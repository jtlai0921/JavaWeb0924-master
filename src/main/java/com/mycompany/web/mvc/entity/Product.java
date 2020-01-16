package com.mycompany.web.mvc.entity;

public class Product {
    private int product_id;
    private double purchase_cost;
    private int quantity_on_hand;
    private String description;
    private double subtotal;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getPurchase_cost() {
        return purchase_cost;
    }

    public void setPurchase_cost(double purchase_cost) {
        this.purchase_cost = purchase_cost;
    }

    public int getQuantity_on_hand() {
        return quantity_on_hand;
    }

    public void setQuantity_on_hand(int quantity_on_hand) {
        this.quantity_on_hand = quantity_on_hand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", purchase_cost=" + purchase_cost + ", quantity_on_hand=" + quantity_on_hand + ", description=" + description + ", subtotal=" + subtotal + '}';
    }
    
}
