package com.example.dynamodb.controller;

import com.example.dynamodb.model.Article;
import com.example.dynamodb.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @GetMapping("/{url}")
    public Optional<Article> getArticle(@PathVariable String url) {
        return articleService.getArticle(url);
    }

    @GetMapping("/")
    public List<Article> getAll() {
        return articleService.getAllArticles();
    }

    @DeleteMapping("/{url}")
    public void deleteArticle(@PathVariable String url) {
        articleService.deleteArticle(url);
    }
}
