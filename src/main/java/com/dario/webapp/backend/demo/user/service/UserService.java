package com.dario.webapp.backend.demo.user.service;

import com.dario.webapp.backend.demo.authorization.Authorization;
import com.dario.webapp.backend.demo.user.model.User;
import com.dario.webapp.backend.demo.user.model.UserDTO;
import com.dario.webapp.backend.demo.user.model.UserResponseDTO;
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
    private UserResponseStrategy userResponseStrategy;

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
        user.setProfileImage("https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png");
        user.setAuthorization(Authorization.builder().user(user).authToken(encryptedPassword).build());
        user.setDescription(String.format("Hi I am %s and I am using Dario web app!", user.getUsername()));
        return userRepository.save(user);
    }

    @SneakyThrows
    @Transactional(readOnly = true)
    public User getUser(String email, String password) {
        MessageDigest digest = secureHashAlgorithmService.getSHA256Instance("SHA-256");
        String encryptedPassword = secureHashAlgorithmService.encryptPassword(digest, password);
        return findUserByEmailAndPassword(email, encryptedPassword);
    }
}
