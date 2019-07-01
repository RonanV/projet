package com.example.apispring.controller;

import java.util.Optional;

import com.example.apispring.model.Article;
import com.example.apispring.model.Personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "/articles")
public class ArticleController extends MainController{
	
	@GetMapping(path="/count")
	public long count() {
		return super.getArticleRepository().count();
	}
	@PostMapping(path="/add")
	public boolean addNewArticle (@RequestParam String texte_article, @RequestParam String titre_article, @RequestParam int idpersonne) {
		Personne pers = super.getPersonneRepository().findById(idpersonne);
		
		Article n = new Article();
		n.setTexte_article(texte_article);
		n.setTitre_article(titre_article);
		n.setIdpersonne(pers);
		super.getArticleRepository().save(n);
		
		return true;
	}

	@GetMapping(path="/{id}")
	public  Optional<Article> getByid(@RequestParam Integer id) {
		return super.getArticleRepository().findById(id);
	}

	@GetMapping(path="/all")
	public Page<Article> getAllArticles(@RequestParam(required=false) Integer size, @RequestParam(required = false) String sort) {
		Pageable page = PageRequest.of(0, 20, Sort.by("idpersonne").descending());
		return super.getArticleRepository().findAll(page);
	}
}
