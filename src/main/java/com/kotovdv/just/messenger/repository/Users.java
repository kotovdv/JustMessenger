package com.kotovdv.just.messenger.repository;

import com.kotovdv.just.messenger.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitriy Kotov
 */
@Repository
public interface Users extends CrudRepository<User, Long> {
}
