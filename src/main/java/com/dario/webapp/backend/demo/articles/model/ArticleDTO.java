package com.dario.webapp.backend.demo.articles.model;

import lombok.*;

@Getter
@Setter
public class ArticleDTO {

    private String title;

    private String body;

    private String author;

    private String picture;

    public Article toArticle() {
        return Article.builder()
                .author(getAuthor())
                .body(getBody())
                .picture(getPicture())
                .title(getTitle())
                .build();
    }
}
