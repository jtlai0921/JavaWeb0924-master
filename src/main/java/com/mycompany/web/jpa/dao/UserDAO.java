package com.mycompany.web.jpa.dao;

import com.mycompany.web.jpa.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class UserDAO {

    private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public boolean insert(User user) {
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.persist(user);
        etx.commit();
        return true;
    }
    
    public List<User> query() {
        Query query = em.createQuery("SELECT u FROM User u", User.class);
        return  query.getResultList();
    }
    
    public User findById(Integer id) {
        return em.find(User.class, id);
    }
    
    public boolean update(User user) {
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.persist(user); //em.merge(user);
        etx.commit();
        return true;
    }
    
    public boolean delete(User user) {
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.remove(em.merge(user)); //看Entity 的狀態為何
        etx.commit();
        return true;
    }

}
