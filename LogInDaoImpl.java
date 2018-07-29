package com.ex.dao;

import com.ex.model.Player;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class LogInDaoImpl implements BaseDao<Player> {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Player> findAll() {
        String hql = "From Player";

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
    public Player findOne(Serializable id) {

        return null;
    }

    @Override
    public Player update(Player o) {
        return null;
    }

    @Override
    public void delete(Serializable id) {

    }
}
