package com.hellojee.Hello_JavaEE.dao;

public final class OtherDaoFactory {

    private OtherDaoFactory() {
    }

    public static CrudDao getMyJpaEntityDao() {
        return new JpaEntityDao(PersistenceManager.getConnection());
    }

}
