package com.dario.webapp.backend.demo.user.rest;

import com.dario.webapp.backend.demo.authorization.AuthorizationService;
import com.dario.webapp.backend.demo.user.model.User;
import com.dario.webapp.backend.demo.user.model.UserDTO;
import com.dario.webapp.backend.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("")
    public User signUp(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/{email}/{password}")
    public User logIn(@PathVariable("email")String email, @PathVariable("password")String password) {
        return userService.getUser(email, password);
    }

//    @PutMapping()
//    public User updateUser(@RequestHeader(value = "Authorization") String authToken){
//
//    }
}
