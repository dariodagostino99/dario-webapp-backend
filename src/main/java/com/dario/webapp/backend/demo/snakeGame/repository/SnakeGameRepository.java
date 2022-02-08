package com.dario.webapp.backend.demo.snakeGame.repository;

import com.dario.webapp.backend.demo.snakeGame.model.SnakeGame;
import com.dario.webapp.backend.demo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SnakeGameRepository extends JpaRepository<SnakeGame, Long> {

    List<SnakeGame> findAllByOrderByScoreDesc();

    Optional<SnakeGame> findByUser(User user);
}
