package com.example.apispring.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apispring.model.Album;

@RestController
@CrossOrigin(origins = "https://localhost:4200")
@RequestMapping(path= "/album")
public class AlbumController extends MainController{

	@GetMapping(path="")
	public Page<Album> getAllAlbum() {
		Pageable page = PageRequest.of(0, 20);
		return super.getAlbumRepository().findAll(page);
	}
}
