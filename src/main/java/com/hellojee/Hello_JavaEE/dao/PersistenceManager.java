package com.hellojee.Hello_JavaEE.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    private static final String EMF_KEY = "PU";

    // SINGLETON INSTANCE
    private static EntityManagerFactory emf;

    private PersistenceManager() {
        // Avoid instantiate
    }

    public static EntityManagerFactory getConnection() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(EMF_KEY);
        }
        return emf;
    }

    public static void closeConnection() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}