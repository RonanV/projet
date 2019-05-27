package com.example.apispring.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.apispring.model.Album;

public interface AlbumRepository extends CrudRepository<Album, Integer>{

}
