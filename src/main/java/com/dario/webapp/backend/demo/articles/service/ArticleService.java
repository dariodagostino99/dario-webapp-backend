package com.dario.webapp.backend.demo.articles.service;


import com.dario.webapp.backend.demo.articles.model.Article;
import com.dario.webapp.backend.demo.articles.model.ArticleDTO;
import com.dario.webapp.backend.demo.articles.repository.ArticleRepository;
import liquibase.repackaged.org.apache.commons.lang3.Validate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Article findById(Long articleId){
        Validate.notNull(articleId);
        //
        Article article = articleRepository.findById(articleId).orElse(null);
        if (article == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article with id: " + articleId + " not found.");
        }
        return article;
    }

    @Transactional(readOnly = true)
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Transactional
    public Article createArticle(ArticleDTO articleDTO) {
        Validate.notNull(articleDTO);
        //
        return articleRepository.save(articleDTO.toArticle());
    }

    @Transactional(readOnly = true)
    public Article getArticleById(Long id) {
        Validate.notNull(id);
        //
        return findById(id);
    }
}
