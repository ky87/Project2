package com.ex.dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface BaseDao<T> {
    public List<T> findAll();
    public T findOne(Serializable id);
    public T update(T o);
    public void insert(T o);
    public void delete(Serializable id);
}
