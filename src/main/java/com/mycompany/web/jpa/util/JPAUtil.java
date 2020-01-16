package com.mycompany.web.jpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf;
    static {
        emf = Persistence.createEntityManagerFactory("p1");
    }
    
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
    
    public static void shutdown() {
        emf.close();
    }
    
}
