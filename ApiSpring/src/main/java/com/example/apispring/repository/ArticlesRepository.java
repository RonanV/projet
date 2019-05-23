package com.example.apispring.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.apispring.model.Articles;

public interface ArticlesRepository extends CrudRepository<Articles, Integer>{

}
