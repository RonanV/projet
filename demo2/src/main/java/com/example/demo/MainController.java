package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;



@RestController    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired 
	private ArticlesRepository articlesRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	@GetMapping(path="/articles/all")
	public @ResponseBody Iterable<articles> getAllArticles() {
		return articlesRepository.findAll();
	}
	@GetMapping(path="/articles/count")
	public @ResponseBody long count() {
		return articlesRepository.count();
	}
	@GetMapping(path="/users/all")
	public @ResponseBody Iterable<users> getAllUsers() {
		return usersRepository.findAll();
	}
}
