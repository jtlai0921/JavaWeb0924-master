package com.mycompany.web.jpa.dao;

import com.mycompany.web.jpa.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CustomerDAO {
    private EntityManager em;

    public CustomerDAO(EntityManager em) {
        this.em = em;
    }
    
    public List<Customer> queryAll() {
        Query query = em.createQuery("select c from Customer c");
        return query.getResultList();
    }
    
}
