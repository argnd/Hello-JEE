package com.hellojee.Hello_JavaEE.dao;

public final class OtherDaoFactory {

    private OtherDaoFactory() {
    }

    public static CrudDao getMyProductDao() {

        return new JpaEntityDao(PersistenceManager.getConnection());

    }

}
