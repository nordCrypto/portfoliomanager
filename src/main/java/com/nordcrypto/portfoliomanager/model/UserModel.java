package com.nordcrypto.portfoliomanager.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.nordcrypto.portfoliomanager.configuration.View;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@Entity
public class UserModel {

    public UserModel() {
    }

    public UserModel(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Summary.class)
    private Long userId;

    @JsonView(View.Summary.class)
    private String userName;

    @JsonView(View.Summary.class)
    private String email;

    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
