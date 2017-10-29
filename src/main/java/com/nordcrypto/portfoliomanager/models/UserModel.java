package com.nordcrypto.portfoliomanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@Entity
@Table(name = "users")
public class UserModel implements UserDetails {

    public UserModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @RestResource
    private Set<PortfolioModel> portfolios;

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RoleModel> roles;

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<PortfolioModel> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(Set<PortfolioModel> portfolios) {
        this.portfolios = portfolios;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleModel role : getRoles()) {
            if (role.getName().startsWith("ROLE_")) {
                authorities.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
            } else {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().toUpperCase()));
            }
        }
        return authorities;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }
}
