package com.dario.webapp.backend.demo.user.model;

import com.dario.webapp.backend.demo.authorization.model.Authorization;
import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {

    private String username;
    private String password;
    private String email;

    public User toUser() {
        return User.builder()
                .username(getUsername())
                .email(getEmail())
                .userProfile(UserProfile.builder()
                        .description(String.format("Hi! I am %s and I am using Dario webb app!", getUsername()))
                        .profileImageUrl("https://remax-center.com.mx/images/profile1.png")
                        .socialMediaList(new ArrayList<>())
                        .build())
                .authorization(Authorization.builder().build())
                .build();
    }
}
