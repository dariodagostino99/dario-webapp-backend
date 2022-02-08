package com.dario.webapp.backend.demo.user.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {

    private String username;
    private String password;
    private String email;
    private String profileImage;

    public User toUser() {
        return User.builder()
                .username(getUsername())
                .password(getPassword())
                .email(getEmail())
                .profileImage(getProfileImage())
                .build();
    }
}
