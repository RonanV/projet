package com.example.apispring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.apispring.model.Album;
import com.example.apispring.model.Article;

public interface AlbumRepository extends CrudRepository<Album, Integer>{

	Page<Album> findAll(Pageable pageable);
}
