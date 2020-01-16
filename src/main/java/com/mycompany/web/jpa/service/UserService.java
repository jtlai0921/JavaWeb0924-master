package com.mycompany.web.jpa.service;

import com.mycompany.web.jpa.entity.User;
import com.mycompany.web.jpa.dao.UserDAO;
import com.mycompany.web.jpa.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class UserService {
    private EntityManager em;
    private UserDAO dao;
    
    public UserService() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        dao = new UserDAO(em);
    }
    
    // 新增
    public boolean insert(String user_name, Integer user_age) {
        User user = new User();
        user.setName(user_name);
        user.setAge(user_age);
        return dao.insert(user);
    }
    
    // 查詢多筆
    public List<User> query() {
        return dao.query();
    }
    
    // 查詢單筆
    public User findById(Integer id) {
        return dao.findById(id);
    }
    
    // 修改
    public boolean update(Integer id, String name, Integer age) {
        User user = findById(id);
        if(user == null) {
            return false;
        } else {
            user.setName(name);
            user.setAge(age);
            return dao.update(user);
        }
    }
    
    // 刪除
    public boolean delete(Integer id) {
        User user = findById(id);
        return (user == null) ? false : dao.delete(user);
    }
}
