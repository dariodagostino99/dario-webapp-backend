package com.dario.webapp.backend.demo.user.model;

import com.dario.webapp.backend.demo.authorization.model.Authorization;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Entity
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserProfile userProfile;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Authorization authorization;

    @Transient
    private String authToken;

    public String getAuthToken() {
        return getAuthorization() != null ? getAuthorization().getAuthToken() : null;
    }

}
