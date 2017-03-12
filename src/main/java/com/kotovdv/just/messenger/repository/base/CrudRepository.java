package com.kotovdv.just.messenger.repository.base;

import com.kotovdv.just.messenger.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;

/**
 * @author Dmitriy Kotov
 */
public abstract class CrudRepository<T, ID extends Serializable> {

    private final EntityManager entityManager;
    private final Class<T> dataType;

    public CrudRepository(EntityManager entityManager, Class<T> dataType) {
        this.entityManager = entityManager;
        this.dataType = dataType;
    }

    public void add(User user) {
        entityManager.persist(user);
    }

    public T get(ID id) {
        return entityManager.find(dataType, id);
    }

    public long size() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);

        query.select(builder.count(query.from(dataType)));

        return entityManager.createQuery(query).getSingleResult();
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }
}
