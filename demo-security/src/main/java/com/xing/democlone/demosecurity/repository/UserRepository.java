package com.xing.democlone.demosecurity.repository;

import com.xing.democlone.demosecurity.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
