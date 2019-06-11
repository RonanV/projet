package com.example.apispring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apispring.model.Article;
import com.example.apispring.model.Personne;
import com.example.apispring.repository.ArticleRepository;
import com.example.apispring.repository.DroitRepository;
import com.example.apispring.repository.PersonneRepository;
import com.example.apispring.repository.TacheRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "/articles")
public class ArticleController extends MainController{
	
	@GetMapping(path="/count")
	public long count() {
		return super.getArticleRepository().count();
	}
	@GetMapping(path="/add")
	public String addNewArticle () {
	Personne pers = new Personne();
		pers.setNomPersonne("Vallee");
		pers.setPrenom_Personne("Ronan");
		
		super.getPersonneRepository().save(pers);
		Article n = new Article();
		n.setTexte_article("Bonjour");
		n.setTitre_article("c'est moi");
		n.setIdpersonne(pers);
		super.getArticleRepository().save(n);
		
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public Page<Article> getAllArticles(@RequestParam(required=false) Integer size, @RequestParam(required = false) String sort) {
		Pageable page = PageRequest.of(0, 20, Sort.by("idpersonne").descending());
		return super.getArticleRepository().findAll(page);
	}
}
