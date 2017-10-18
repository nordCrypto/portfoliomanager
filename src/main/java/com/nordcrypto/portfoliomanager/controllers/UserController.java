package com.nordcrypto.portfoliomanager.controllers;

import com.nordcrypto.portfoliomanager.models.User;
import com.nordcrypto.portfoliomanager.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User registerUser(@RequestBody User user) {
        return userService.addEntity(user);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> findUsers() {
        return userService.findUsers();
    }
}
