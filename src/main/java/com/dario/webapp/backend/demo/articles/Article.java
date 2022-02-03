package com.dario.webapp.backend.demo.articles;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "articles")
@Entity
@Builder
public class Article {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "author")
    private String author;

    @Column(name = "picture")
    private String picture;

}
