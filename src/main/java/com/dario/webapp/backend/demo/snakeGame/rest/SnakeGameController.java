package com.dario.webapp.backend.demo.snakeGame.rest;

import com.dario.webapp.backend.demo.snakeGame.model.SnakeGame;
import com.dario.webapp.backend.demo.snakeGame.model.SnakeGameDTO;
import com.dario.webapp.backend.demo.snakeGame.service.SnakeGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/snakeGame")
public class SnakeGameController {

    @Autowired
    private SnakeGameService snakeGameService;

    @GetMapping()
    public List<SnakeGame> getAllSnakeGames(){
        return snakeGameService.getAllSnakeGames();
    }

    @PostMapping()
    public SnakeGame createSnakeGameRecord(@RequestBody SnakeGameDTO snakeGameDTO){
        return snakeGameService.createSnakeGameRecord(snakeGameDTO);
    }

}
