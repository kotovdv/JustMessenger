package com.kotovdv.just.messenger.repository;

import com.kotovdv.just.messenger.entity.User;
import com.kotovdv.just.messenger.repository.base.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * @author Dmitriy Kotov
 */
@Repository
public class Users extends AbstractRepository<User, Long> {

    @Autowired
    public Users(EntityManager entityManager) {
        super(entityManager, User.class);
    }
}
