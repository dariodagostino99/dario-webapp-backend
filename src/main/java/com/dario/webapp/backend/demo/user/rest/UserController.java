package com.dario.webapp.backend.demo.user.rest;

import com.dario.webapp.backend.demo.user.model.User;
import com.dario.webapp.backend.demo.user.model.UserDTO;
import com.dario.webapp.backend.demo.user.model.UserResponseDTO;
import com.dario.webapp.backend.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public User signUp(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping()
    public UserResponseDTO logIn (@RequestBody UserDTO userDTO){
        return userService.getUser(userDTO);
    }
}
