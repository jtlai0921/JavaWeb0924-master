package com.mycompany.web.mvc.service;

import com.mycompany.web.mvc.model.BMI;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class BMIService {
    private static List<BMI> list = new ArrayList<>();
    static {
        list.add(new BMI(1, "男", 170.0, 60.0));
        list.add(new BMI(2, "女", 162.0, 45.5));
        list.add(new BMI(3, "女", 168.5, 63.0));
        list.add(new BMI(4, "男", 177.0, 85.0));
        list.add(new BMI(5, "男", 180.5, 92.5));
        
    }
    public void save(BMI bmi) {
        bmi.setId(list.size()+1);
        bmi.setResult(bmi.getWeight()/Math.pow(bmi.getHeight()/100, 2));
        list.add(bmi);
    }
    
    public BMI get(int id) {
        return list.stream().filter(b -> b.getId() == id).findFirst().get();
    }
    
    public void update(int id, BMI bmi) {
        BMI b = list.stream().filter(m -> m.getId() == id).findFirst().get();
        b.setSex(bmi.getSex());
        b.setHeight(bmi.getHeight());
        b.setWeight(bmi.getWeight());
        b.setResult(b.getWeight()/Math.pow(b.getHeight()/100, 2));
    }
    
    public void delete(int id) {
        BMI bmi = list.stream().filter(m -> m.getId() == id).findFirst().get();
        list.remove(bmi);
    }
    
    public List<BMI> query() {
        return list;
    }
    
    public List<BMI> query(String sex) {
        return list.stream().filter(b -> b.getSex().equals(sex)).collect(toList());
    }
    
    public long[] getData() {
        return getData(list);
    }
    
    public long[] getData(List<BMI> list) {
        long[] data = {0, 0, 0, 0};
        data[3] = list.stream().filter(bmi -> bmi.getResult() < 18.5).count();
        data[2] = list.stream().filter(bmi -> bmi.getResult() >= 28).count();
        data[1] = list.stream().filter(bmi -> bmi.getResult() >= 24 && bmi.getResult() <= 27.9).count();
        data[0] = list.stream().count() - data[3] - data[2] - data[0];
        return data;
    }
}
