package com.dario.webapp.backend.demo.user.model;

import com.dario.webapp.backend.demo.socialMedia.model.SocialMedia;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileDTO {

    private String description;

    private String username;

    private List<SocialMedia> socialMediaList;

}
