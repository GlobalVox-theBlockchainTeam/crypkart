/*
 * Copyright (c) 5/3/18 11:15 AM Bitwise Ventures
 * Author : Anand Panchal
 * Author Email : anand4686@gmail.com
 */

package com.gradle.dao.iface;

import com.gradle.entity.configurations.AdminConfig;
import com.gradle.entity.configurations.AdminConfigValues;
import com.gradle.entity.user.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projection;

import java.util.List;

public interface GenericDao<E,K>  /*extends PagingAndSortingRepository<E, Integer> */{
    public void save(E entity) ;
    public void saveOrUpdate(E entity) ;
    public void update(E entity) ;
    public void delete(E entity);
    public E find(K key);
    public List<E> findAll() ;
    public List<E> query(String query);
    public List<E> queryWithParameter(String queryString, Object[] params);
    public E first(String queryString, Object[] params);
    public List<E> hql(Query query);
    public Query getQuery(String query);
    public Query getNamedQuery(String query);
    public List<E> executeQuery(Query query);
    public Criteria getCriteria(E obj);
    public List<E> getByCriteria(Criteria criteria);
    public List<Object> queryAsObjectList(String query);
    public List<AdminConfigValues> getConfigValues(String tableName);
    public List<AdminConfig> getConfig(String obj);
    public List<E> findPaginated(int page, int maxCount, E obj ,String search);
    public Long count(E obj);
    public Long countQuery(String query, Object[] params);
    public Long countByUser(User user);
    public Long countByUserByProperty(User user, String userProperty);

    public Long avg(E obj, String avgPropertyName);
    public Double avgByUser(User user, String avgPropertyName, String userProperty);

    public List<E> findPaginatedByUser(int page, int maxCount, E obj, String search, User user);
    public List<AdminConfigValues> getGeneralConfig();
    public List<AdminConfigValues> getEntityConfig(E obj);
    public Double getByProjection(User user,  String userProperty, Projection projection);
    public List<E> findPaginatedByUser(int page, int maxCount, E obj, User user, String userProperty);
    public List<E> findPaginatedByUserWithOrder(int page, int maxCount, E obj, User user, String userProperty, String orderProperty, String orderDirection);
    public boolean executeQuery(String query, Object[] params);
    public void refresh(E obj);
    public E last(String orderProperty);
    public List<E> getListByProjection(String property);


}