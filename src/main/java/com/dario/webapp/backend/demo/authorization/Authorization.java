package com.dario.webapp.backend.demo.authorization;

import com.dario.webapp.backend.demo.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "authorizations")
@Entity
@Builder
public class Authorization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "auth_token")
    private String authToken;

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
