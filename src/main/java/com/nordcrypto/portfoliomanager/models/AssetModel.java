package com.nordcrypto.portfoliomanager.models;


import javax.persistence.*;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@Entity
public class AssetModel {

    public AssetModel() {
    }

    public AssetModel(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "portfolio_id")
    private PortfolioModel portfolioModel;

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
