package com.example.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



//@Controller    // This means that this class is a Controller
@RestController
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class MainController {
	//Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired 
	private ArticlesRepository articlesRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	//@GetMapping(path="/articles/all")
	@GetMapping(value="/articles/all",produces= {"application/json"})
	public @ResponseBody Iterable<articles> getAllArticles() {
		return articlesRepository.findAll();
	}
	//@GetMapping(path="/articles/count")
	@GetMapping(value="/articles/count",produces= {"application/json"})
	public @ResponseBody long count() {
		return articlesRepository.count();
	}																	//consumes=MediaType.APPLICATION_JSON_VALUE
																	//consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE
	@PostMapping(value="/articles/add",produces= {"application/json"},consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody void addArticle(articles article) {
		articlesRepository.storeArticleInDB(article);
	}
	
	@PostMapping(value="/users/add",produces= {"application/json"},consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody void addPerson(users personne) {
		System.out.println("nom personne = "+personne.getNom());
		System.out.println("téléphone personne = "+personne.getTelephone());
		System.out.println("code postal personne = "+personne.getCodePostal());
		System.out.println("ville personne = "+personne.getVille());
		System.out.println("date naissance personne = "+personne.getDateNaissance());
		System.out.println("tel mère personne = "+personne.getTelMere());
		System.out.println("tel père personne = "+personne.getTelPere());
		usersRepository.storePersonneInDB(personne);
	}
	//@GetMapping(path="/users/all")
	@GetMapping(value="/users/all",produces= {"application/json"})
	public @ResponseBody Iterable<users> getAllUsers() {
		return usersRepository.findAll();
	}
}
