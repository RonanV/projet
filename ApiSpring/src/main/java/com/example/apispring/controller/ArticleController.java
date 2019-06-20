package com.example.apispring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@PostMapping(path="/add")
	public String addNewArticle (@RequestParam String texte_article, @RequestParam String titre_article, @RequestParam String nomPersonne, @RequestParam String prenomPersonne) {
		
		Personne pers = super.getPersonneRepository().findByNomPersonneAndPrenomPersonne(nomPersonne, prenomPersonne);
		
		Article n = new Article();
		n.setTexte_article(texte_article);
		n.setTitre_article(titre_article);
		n.setIdpersonne(pers);
		super.getArticleRepository().save(n);
		
		return "Saved";
	}
	
	@GetMapping(path="")
	public Page<Article> getAllArticles(@RequestParam(required=false) Integer size, @RequestParam(required = false) String sort) {
		Pageable page = PageRequest.of(0, 20, Sort.by("idpersonne").descending());
		return super.getArticleRepository().findAll(page);
	}
	@PutMapping(path="/{id}")
	public String ModifArticle(@PathVariable Integer id,@RequestParam String texte_article, @RequestParam String titre_article, @RequestParam String nomPersonne, @RequestParam String prenomPersonne) {
		Personne pers = super.getPersonneRepository().findByNomPersonneAndPrenomPersonne(nomPersonne, prenomPersonne);
		Optional<Article> art = super.getArticleRepository().findById(id);
		
		art.get().setTexte_article(texte_article);
		art.get().setTitre_article(titre_article);
		art.get().setIdpersonne(pers);
		
		super.getArticleRepository().save(art.get());
		return "Saved";
		
	}
	@DeleteMapping(path="/{id}")
	public String deleteArticle(@PathVariable Integer id) {
		Optional<Article> art = super.getArticleRepository().findById(id);
		
		super.getArticleRepository().delete(art.get());
		return "Saved";
		
	}
}
