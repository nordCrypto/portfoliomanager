package com.nordcrypto.portfoliomanager.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.nordcrypto.portfoliomanager.configuration.View;
import com.nordcrypto.portfoliomanager.model.UserModel;
import com.nordcrypto.portfoliomanager.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@RequestMapping("/user")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserModel> registerUser(@RequestBody UserModel user) {
        return ResponseEntity.ok().body(userService.addEntity(user));
    }

    @JsonView(View.Summary.class)
    @GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserModel>> findUsers() {
        return ResponseEntity.ok().body(userService.findUsers());
    }

}
