package com.nordcrypto.portfoliomanager.models;

import javax.persistence.*;

/**
 * @author Andreas Heilig
 * Date: 27.10.2017
 */
@Entity
@Table(name = "roles")
public class RoleModel {

    public RoleModel(String name) {
        this.name = name;
    }

    RoleModel() {
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserModel userModel;


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

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
