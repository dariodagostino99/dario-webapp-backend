package com.dario.webapp.backend.demo.articles.repository;


import com.dario.webapp.backend.demo.articles.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
