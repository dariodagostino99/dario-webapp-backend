package com.dario.webapp.backend.demo.authorization.rest;


import com.dario.webapp.backend.demo.authorization.model.Authorization;
import com.dario.webapp.backend.demo.authorization.AuthorizationService;
import com.dario.webapp.backend.demo.user.model.User;
import com.dario.webapp.backend.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/authorization")
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Authorization getAuthorization(@PathVariable("userId") Long userId){
        User currentUser = userService.findById(userId);
        return authorizationService.findAuthorizationByUser(currentUser);
    }
}
