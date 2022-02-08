package com.dario.webapp.backend.demo.snakeGame.model;

import com.dario.webapp.backend.demo.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "snake_games")
@Entity
@Builder
public class SnakeGame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column
    private BigDecimal score;
}
