package com.nordcrypto.portfoliomanager.services;

import com.nordcrypto.portfoliomanager.models.PortfolioModel;
import com.nordcrypto.portfoliomanager.models.UserModel;
import com.nordcrypto.portfoliomanager.repository.PortfolioRepository;
import com.nordcrypto.portfoliomanager.repository.UserRepository;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Andreas Heilig
 * Date: 19.10.2017
 */
@Service
public class PortfolioService {

    private PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public PortfolioModel addPortfolio(UserModel userModel, String name) {
        PortfolioModel portfolioModel = new PortfolioModel(userModel, name);
        return portfolioRepository.save(portfolioModel);
    }

    public List<PortfolioModel> findAllByUser(UserModel userModel) {
        return portfolioRepository.findAllByUserModel(userModel);
    }
}
