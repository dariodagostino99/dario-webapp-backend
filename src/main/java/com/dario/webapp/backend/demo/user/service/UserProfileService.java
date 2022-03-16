package com.dario.webapp.backend.demo.user.service;

import com.dario.webapp.backend.demo.user.model.User;
import com.dario.webapp.backend.demo.user.model.UserProfileDTO;
import com.dario.webapp.backend.demo.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserProfileService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User updateProfile(UserProfileDTO userProfileDTO, User currentUser) {
        currentUser.getUserProfile().setDescription(userProfileDTO.getDescription());
        userProfileDTO.getSocialMediaList().forEach(m -> m.setUserProfile(currentUser.getUserProfile()));
        currentUser.getUserProfile().setSocialMediaList(userProfileDTO.getSocialMediaList());
        currentUser.setUsername(userProfileDTO.getUsername());
        return userRepository.save(currentUser);
    }
}
