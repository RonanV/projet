package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.articles;


public interface ArticlesRepository extends CrudRepository<articles, Integer> {

}
