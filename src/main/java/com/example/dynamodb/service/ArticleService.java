package com.example.dynamodb.service;

import com.example.dynamodb.repository.ArticleRepository;
import com.example.dynamodb.model.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article saveArticle(Article article) {
        article.setCreationDate(LocalDateTime.now());
        article.setUpdateDate(LocalDateTime.now());
        return articleRepository.save(article);
    }

    public Optional<Article> getArticle(String url) {
        return articleRepository.findByUrl(url);
    }

    public void deleteArticle(String url) {
        articleRepository.deleteByUrl(url);
    }

    public List<Article> getAllArticles() {
        return StreamSupport.stream(articleRepository.findAll().spliterator(), false).toList();
    }
}
