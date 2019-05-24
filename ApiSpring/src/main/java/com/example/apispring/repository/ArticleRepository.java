package com.example.apispring.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.apispring.model.Article;

public interface ArticleRepository extends CrudRepository<Article, Integer>{

}
