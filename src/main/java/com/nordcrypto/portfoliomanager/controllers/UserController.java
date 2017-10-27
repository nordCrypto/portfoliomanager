package com.nordcrypto.portfoliomanager.controllers;

import com.nordcrypto.portfoliomanager.models.UserModel;
import com.nordcrypto.portfoliomanager.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserModel> registerUser(@RequestBody UserModel user) {
        return ResponseEntity.ok().body(userService.save(user));
    }

}
