package com.dario.webapp.backend.demo.snakeGame.model;

import com.dario.webapp.backend.demo.user.model.User;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SnakeGameDTO {

    private User user;

    private BigDecimal score;

}
