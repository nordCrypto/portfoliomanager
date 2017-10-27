package com.nordcrypto.portfoliomanager.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.nordcrypto.portfoliomanager.configuration.View;
import com.nordcrypto.portfoliomanager.models.PortfolioModel;
import com.nordcrypto.portfoliomanager.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@RequestMapping("/portfolio")
@RestController
public class PortfolioController {

    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @JsonView(View.Summary.class)
    @PostMapping(value = "/add/{userId}/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PortfolioModel> createPortfolio(@PathVariable("userId") Long userId, @PathVariable("name") String name) {
        return ResponseEntity.ok().body(portfolioService.addPortfolio(userId, name));
    }

}