package com.nordcrypto.portfoliomanager.models;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@Entity
@Table(name = "portfolios")
public class PortfolioModel {

    public PortfolioModel() {
    }

    public PortfolioModel(UserModel userModel, String name) {
        this.userModel = userModel;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserModel userModel;

    @OneToMany(mappedBy = "portfolioModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AssetModel> assets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<AssetModel> getAssets() {
        return assets;
    }

    public void setAssets(Set<AssetModel> assets) {
        this.assets = assets;
    }
}
