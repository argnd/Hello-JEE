package com.hellojee.Hello_JavaEE.listener;

import com.hellojee.Hello_JavaEE.dao.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        PersistenceManager.getConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        PersistenceManager.closeConnection();
    }
}
