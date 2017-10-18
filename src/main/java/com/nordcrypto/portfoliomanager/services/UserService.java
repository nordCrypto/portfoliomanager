package com.nordcrypto.portfoliomanager.services;

import com.nordcrypto.portfoliomanager.models.User;
import com.nordcrypto.portfoliomanager.repositories.UserRepository;
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

    public User addEntity(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public List<User> findUsers() {
        return repository.findAll();
    }
}
