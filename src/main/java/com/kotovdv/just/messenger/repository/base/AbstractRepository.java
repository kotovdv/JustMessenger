package com.kotovdv.just.messenger.repository.base;

import com.kotovdv.just.messenger.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;

/**
 * @author Dmitriy Kotov
 */
public class AbstractRepository<T, K extends Serializable> {

    private final EntityManager entityManager;
    private final Class<T> dataType;

    public AbstractRepository(EntityManager entityManager, Class<T> dataType) {
        this.entityManager = entityManager;
        this.dataType = dataType;
    }

    public void add(User user) {
        entityManager.persist(user);
    }

    public T get(K key) {
        return entityManager.find(dataType, key);
    }

    public long size() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);

        query.select(criteriaBuilder.count(query.from(dataType)));

        return entityManager.createQuery(query).getSingleResult();
    }
}
