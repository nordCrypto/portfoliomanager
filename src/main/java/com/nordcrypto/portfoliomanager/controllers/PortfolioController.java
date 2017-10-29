package com.nordcrypto.portfoliomanager.controllers;

import com.nordcrypto.portfoliomanager.models.PortfolioModel;
import com.nordcrypto.portfoliomanager.models.UserModel;
import com.nordcrypto.portfoliomanager.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@RequestMapping("/portfolios")
@RestController
public class PortfolioController {

    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping(value = "/add/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PortfolioModel> createPortfolio(@AuthenticationPrincipal UserModel user, @PathVariable("name") String name) {
        return ResponseEntity.ok().body(portfolioService.addPortfolio(user, name));
    }

    @GetMapping
    public ResponseEntity<List<PortfolioModel>> getPortfoliosForUser(@AuthenticationPrincipal UserModel user) {
        return ResponseEntity.ok().body(portfolioService.findAllByUser(user));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PortfolioModel> getPortfolioById(@AuthenticationPrincipal UserModel userModel, @PathVariable("id") Long id) {
        PortfolioModel portfolioModel = portfolioService.findPortfolioById(id);
        if (userModel.getPortfolios().contains(portfolioModel)) {
            return ResponseEntity.ok().body(portfolioModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
