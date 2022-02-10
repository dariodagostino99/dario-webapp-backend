package com.dario.webapp.backend.demo.user.decorator;


import com.dario.webapp.backend.demo.user.model.User;
import liquibase.repackaged.org.apache.commons.lang3.Validate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthTokenDecorator {

    public void decorateUserWithAuthToken(User user){
        Validate.notNull(user);
        //
        String authToken = user.getAuthToken();
        if (authToken != null){
            user.setAuthToken(authToken);
        }
    }
}
