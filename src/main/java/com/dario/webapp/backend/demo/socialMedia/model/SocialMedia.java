package com.dario.webapp.backend.demo.socialMedia.model;

import com.dario.webapp.backend.demo.socialMedia.type.SocialMediaType;
import com.dario.webapp.backend.demo.user.model.UserProfile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "social_media")
@Entity
@Builder
public class SocialMedia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_media_type")
    private SocialMediaType socialMediaType;

    @Column(name = "profile_url")
    private String profileUrl;
}
