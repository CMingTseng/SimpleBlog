package com.lany.blog.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_article")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "views_count")
    private String viewsCount;
    @Column(name = "star_count")
    private String starCount;
    @Column(name = "content")
    private String content;
    @Column(name = "author_id")
    private Long authorId;
}