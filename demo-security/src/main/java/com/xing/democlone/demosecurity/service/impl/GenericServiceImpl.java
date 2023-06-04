package com.xing.democlone.demosecurity.service.impl;

import com.xing.democlone.demosecurity.domain.RandomCity;
import com.xing.democlone.demosecurity.domain.User;
import com.xing.democlone.demosecurity.repository.RandomCityRepository;
import com.xing.democlone.demosecurity.repository.UserRepository;
import com.xing.democlone.demosecurity.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericServiceImpl implements GenericService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RandomCityRepository randomCityRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public List<RandomCity> findAllRandomCities() {
        return (List<RandomCity>)randomCityRepository.findAll();
    }
}
