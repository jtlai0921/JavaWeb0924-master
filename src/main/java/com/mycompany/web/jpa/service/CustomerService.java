package com.mycompany.web.jpa.service;

import com.mycompany.web.jpa.dao.CustomerDAO;
import com.mycompany.web.jpa.entity.Customer;
import com.mycompany.web.jpa.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class CustomerService {
    
    private EntityManager em;
    private CustomerDAO dao;
    
    public CustomerService() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        dao = new CustomerDAO(em);
    }
    
    public List<Customer> query() {
        return dao.queryAll();
    }
    
}
