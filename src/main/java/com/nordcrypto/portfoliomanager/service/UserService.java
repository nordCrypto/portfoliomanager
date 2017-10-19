package com.nordcrypto.portfoliomanager.service;

import com.nordcrypto.portfoliomanager.model.UserModel;
import com.nordcrypto.portfoliomanager.repository.UserRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@Service
public class UserService {

    private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel addEntity(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(new UserModel(user.getUserName(), user.getEmail(), user.getPassword()));
    }

    public List<UserModel> findUsers() {
        return IterableUtils.toList(repository.findAll());
    }

}
