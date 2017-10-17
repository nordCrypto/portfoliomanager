package com.nordcrypto.portfoliomanager.entities;


import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@Entity
@SelectBeforeUpdate
@DynamicUpdate
@Table (name = "ASSET")
public class Asset {

    @Id
    @GeneratedValue
    @Column(name = "ASSET_ID")
    private Long assetID;

    @Column(name = "NAME")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getAssetID() {
        return assetID;
    }

    public void setAssetID(Long assetID) {
        this.assetID = assetID;
    }
}
