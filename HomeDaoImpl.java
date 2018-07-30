package com.ex.dao;


import com.ex.model.Court;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class HomeDaoImpl implements BaseDao<Court> {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Court> findAll() {
        String hql = "From Court";

        // Session session = sessionFactory.openSession();
        //session.beginTransaction();
        //String sql = "select * from profile";
        // int result =  session.createSQLQuery(sql).getFirstResult();
        //session.getTransaction().commit();
        //session.close();

        Query query = sessionFactory.openSession().createQuery(hql);
        return  query.list();
    }

    @Override
    public Court findOne(Serializable id) {


        return null;
    }

    @Override
    public Court update(Court o) {
        return null;
    }

    @Override
    public void insert(Court o) {
    }

    @Override
    public void delete(Serializable id) {

    }
}
