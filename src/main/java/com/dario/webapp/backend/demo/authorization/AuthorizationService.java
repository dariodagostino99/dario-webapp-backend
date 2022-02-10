package com.dario.webapp.backend.demo.authorization;

import com.dario.webapp.backend.demo.authorization.model.Authorization;
import com.dario.webapp.backend.demo.authorization.repository.AuthorizationRepository;
import com.dario.webapp.backend.demo.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class AuthorizationService {

    @Autowired
    private AuthorizationRepository authorizationRepository;

    @Transactional(readOnly = true)
    public User validateToken(String authToken) {
        Authorization authorization = authorizationRepository.findByAuthToken(authToken).orElse(null);
        if (authorization == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return authorization.getUser();
    }

    @Transactional(readOnly = true)
    public Authorization findAuthorizationByUser(User user) {
        return authorizationRepository.findByUser(user);
    }
}
