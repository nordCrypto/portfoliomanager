package com.nordcrypto.portfoliomanager.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.nordcrypto.portfoliomanager.configuration.View;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@Entity
public class PortfolioModel {

    public PortfolioModel() {
    }

    public PortfolioModel(String name, UserModel userModel) {
        this.userModel = userModel;
        this.name = name;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserModel userModel;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Summary.class)
    private Long portfolioId;

    @JsonView(View.Summary.class)
    private String name;

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
