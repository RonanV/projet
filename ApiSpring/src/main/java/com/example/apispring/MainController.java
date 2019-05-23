package com.example.apispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apispring.model.Articles;
import com.example.apispring.repository.ArticlesRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "/")
public class MainController {
	
	@Autowired
	private ArticlesRepository articlesRepository;
	
	@GetMapping(path="/articles/all")
	public @ResponseBody Iterable<Articles> getAllUsers() {
		return articlesRepository.findAll();
	}
	
	@GetMapping(path="/count")
	public @ResponseBody long count() {
		return articlesRepository.count();
	}
}