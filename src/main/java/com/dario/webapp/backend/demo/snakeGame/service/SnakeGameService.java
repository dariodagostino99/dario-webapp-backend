package com.dario.webapp.backend.demo.snakeGame.service;

import com.dario.webapp.backend.demo.snakeGame.model.SnakeGame;
import com.dario.webapp.backend.demo.snakeGame.model.SnakeGameDTO;
import com.dario.webapp.backend.demo.snakeGame.repository.SnakeGameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class SnakeGameService {

    @Autowired
    private SnakeGameRepository snakeGameRepository;


    @Transactional(readOnly = true)
    public List<SnakeGame> getAllSnakeGames() {
        return snakeGameRepository.findAllByOrderByScoreDesc();
    }

    @Transactional
    public SnakeGame createSnakeGameRecord(SnakeGameDTO snakeGameDTO) {
        SnakeGame snakeGame = snakeGameRepository.findByUser(snakeGameDTO.getUser())
                .orElse(SnakeGame.builder()
                        .user(snakeGameDTO.getUser())
                        .build());
        snakeGame.setScore(snakeGameDTO.getScore());
        return snakeGameRepository.save(snakeGame);

    }
}
