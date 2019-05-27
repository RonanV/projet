package com.example.apispring.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.apispring.model.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Integer>{

}
