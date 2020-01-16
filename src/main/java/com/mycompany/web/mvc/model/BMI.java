package com.mycompany.web.mvc.model;

public class BMI {
    private Integer id;
    private String sex;
    private Double height;
    private Double weight;
    private Double result;

    public BMI() {
    }

    public BMI(Integer id, String sex, Double height, Double weight) {
        this.id = id;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        result = weight / Math.pow(height/100, 2);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
    
    
    
    
}
