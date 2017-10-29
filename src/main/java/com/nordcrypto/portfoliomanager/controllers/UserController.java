package com.nordcrypto.portfoliomanager.controllers;

import com.nordcrypto.portfoliomanager.dto.RegisterUserDTO;
import com.nordcrypto.portfoliomanager.models.UserModel;
import com.nordcrypto.portfoliomanager.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.monitorjbl.json.JsonView;
import static com.monitorjbl.json.Match.match;

import java.security.Principal;

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

    @PostMapping(value = "/sign-up", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserModel> signUp(@RequestBody RegisterUserDTO user) {
        return ResponseEntity.ok().body(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<UserModel> getCurrentUser(Principal user) {
        if (user.getName().equals("anonymous")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userService.findByUsername(user.getName()));
    }

}
