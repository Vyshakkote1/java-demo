package com.xing.demosecurity.service;

import com.xing.demosecurity.domain.RandomCity;
import com.xing.demosecurity.domain.User;

import java.util.List;

public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
}
