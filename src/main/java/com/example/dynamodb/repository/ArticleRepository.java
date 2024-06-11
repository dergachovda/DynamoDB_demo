package com.example.dynamodb.repository;

import com.example.dynamodb.model.Article;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface ArticleRepository extends CrudRepository<Article, String> {
    Optional<Article> findByUrl(String url);
    void deleteByUrl(String url);
}
