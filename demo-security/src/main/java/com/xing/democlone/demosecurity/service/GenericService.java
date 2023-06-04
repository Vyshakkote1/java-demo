package com.xing.democlone.demosecurity.service;

import com.xing.democlone.demosecurity.domain.RandomCity;
import com.xing.democlone.demosecurity.domain.User;

import java.util.List;

public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
}
