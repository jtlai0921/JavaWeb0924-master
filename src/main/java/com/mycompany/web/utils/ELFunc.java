package com.mycompany.web.utils;

public class ELFunc {
    
    public static double pi() {
        return Math.PI;
    }
    
    public static double bmi(double h, double w) {
        return w / Math.pow(h/100, 2);
    }
    
}
