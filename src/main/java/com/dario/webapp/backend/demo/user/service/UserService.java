package com.dario.webapp.backend.demo.user.service;

import com.dario.webapp.backend.demo.authorization.model.Authorization;
import com.dario.webapp.backend.demo.user.decorator.AuthTokenDecorator;
import com.dario.webapp.backend.demo.user.model.User;
import com.dario.webapp.backend.demo.user.model.UserDTO;
import com.dario.webapp.backend.demo.user.repository.UserRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.security.MessageDigest;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SecureHashAlgorithmService secureHashAlgorithmService;
    @Autowired
    private AuthTokenDecorator authTokenDecorator;

    @Transactional(readOnly = true)
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + id + " not found");
        }
        return user;
    }

    @Transactional(readOnly = true)
    public User findUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password).orElse(null);
        if (user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The user does not exists");
        }
        return user;
    }

    @SneakyThrows
    @Transactional
    public User createUser(UserDTO userDTO) {
        MessageDigest digest = secureHashAlgorithmService.getSHA256Instance("SHA-256");
        String encryptedPassword = secureHashAlgorithmService.encryptPassword(digest, userDTO.getPassword());
        User user = userDTO.toUser();
        user.setPassword(encryptedPassword);
        user.getUserProfile().setUser(user);
        user.getAuthorization().setAuthToken(encryptedPassword);
        user.getAuthorization().setUser(user);
        return userRepository.save(user);
    }

    @SneakyThrows
    @Transactional(readOnly = true)
    public User getUser(String email, String password) {
        MessageDigest digest = secureHashAlgorithmService.getSHA256Instance("SHA-256");
        String encryptedPassword = secureHashAlgorithmService.encryptPassword(digest, password);
        User user = findUserByEmailAndPassword(email, encryptedPassword);
        authTokenDecorator.decorateUserWithAuthToken(user);
        return user;
    }
}
