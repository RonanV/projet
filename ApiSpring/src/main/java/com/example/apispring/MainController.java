package com.example.apispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apispring.model.Article;
import com.example.apispring.repository.ArticleRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "/")
public class MainController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping(path="/articles/all")
	public @ResponseBody Iterable<Article> getAllUsers() {
		return articleRepository.findAll();
	}
	
	@GetMapping(path="/count")
	public @ResponseBody long count() {
		return articleRepository.count();
	}
}