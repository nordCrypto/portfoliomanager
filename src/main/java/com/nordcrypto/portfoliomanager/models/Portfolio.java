package com.nordcrypto.portfoliomanager.models;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@Entity
@SelectBeforeUpdate
@DynamicUpdate
@Table(name = "PORTFOLIO")
public class Portfolio {

    Portfolio() {
    }

    public Portfolio(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "portfolio")
    @Column(name = "ASSETS")
    private List<Asset> assets;

    @Id
    @GeneratedValue
    @Column(name = "PORTFOLIO_ID")
    private Long portfolioId;

    @Column(name = "NAME")
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

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
}
