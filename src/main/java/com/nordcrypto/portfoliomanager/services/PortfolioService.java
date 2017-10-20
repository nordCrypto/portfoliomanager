package com.nordcrypto.portfoliomanager.services;

import com.nordcrypto.portfoliomanager.models.PortfolioModel;
import com.nordcrypto.portfoliomanager.models.UserModel;
import com.nordcrypto.portfoliomanager.repository.PortfolioRepository;
import com.nordcrypto.portfoliomanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Andreas Heilig
 * Date: 19.10.2017
 */
@Service
public class PortfolioService {

    private PortfolioRepository portfolioRepository;
    private UserRepository userRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository, UserRepository userRepository) {
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    public PortfolioModel addPortfolio(Long userId, String name) {
        UserModel userModel= userRepository.findOne(userId);
        PortfolioModel portfolioModel = new PortfolioModel(userModel, name);
        return portfolioRepository.save(portfolioModel);
    }
}
