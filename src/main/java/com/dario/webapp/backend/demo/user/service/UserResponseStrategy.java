package com.dario.webapp.backend.demo.user.service;

import com.dario.webapp.backend.demo.user.model.User;
import com.dario.webapp.backend.demo.user.model.UserResponseDTO;
import com.dario.webapp.backend.demo.user.type.StatusResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserResponseStrategy {


    public UserResponseDTO generateResponse(User user){
        UserResponseDTO userResponseDTO = UserResponseDTO.builder().user(user).build();
        userResponseDTO.setStatus(user == null ? StatusResponse.ERROR : StatusResponse.SUCCESS);
        return userResponseDTO;
    }

}
