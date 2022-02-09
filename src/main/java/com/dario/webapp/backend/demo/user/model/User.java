package com.dario.webapp.backend.demo.user.model;

import com.dario.webapp.backend.demo.authorization.Authorization;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column(name = "profile_image")
    private String profileImage;

    @Column
    private String description;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Authorization authorization;

}
