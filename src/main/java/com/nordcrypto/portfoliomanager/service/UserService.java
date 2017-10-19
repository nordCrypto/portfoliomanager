package com.nordcrypto.portfoliomanager.service;

import com.nordcrypto.portfoliomanager.model.PortfolioModel;
import com.nordcrypto.portfoliomanager.model.UserModel;
import com.nordcrypto.portfoliomanager.repository.PortfolioRepository;
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

    private final UserRepository userRepository;
    private final PortfolioRepository portfolioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PortfolioRepository portfolioRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.portfolioRepository = portfolioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserModel addEntity(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<UserModel> findUsers() {
        return IterableUtils.toList(userRepository.findAll());
    }

    public UserModel addPortfolio(Long userId, String name) {
        UserModel user = userRepository.findOne(userId);
        PortfolioModel portfolioModel = portfolioRepository.save(new PortfolioModel(name, user));
        user.getPortfolios().add(portfolioModel);
        return userRepository.save(user);
    }
}
