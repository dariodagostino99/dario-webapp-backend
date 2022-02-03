package com.dario.webapp.backend.demo.articles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping()
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable("id") Long id){
        return articleService.getArticleById(id);
    }

    @PostMapping()
    public Article createArticle(@RequestBody ArticleDTO articleDTO){
        return articleService.createArticle(articleDTO);
    }
}
