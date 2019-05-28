package com.example.apispring;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apispring.model.Article;
import com.example.apispring.model.Droit;
import com.example.apispring.model.Personne;
import com.example.apispring.model.Tache;
import com.example.apispring.repository.ArticleRepository;
import com.example.apispring.repository.DroitRepository;
import com.example.apispring.repository.PersonneRepository;
import com.example.apispring.repository.TacheRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "/")
public class MainController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@Autowired
	private TacheRepository tacheRepository;
	
	@Autowired 
	private DroitRepository droitRepository;
	
	@GetMapping(path="/articles/add")
	public @ResponseBody String addNewArticle () {
		Article n = new Article();
		n.setTexte_article("Bonjour");
		n.setTitre_article("c'est moi");
		articleRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/articles/all")
	public @ResponseBody Iterable<Article> getAllArticles() {
		return articleRepository.findAll();
	}
	
	@GetMapping(path="/count")
	public @ResponseBody long count() {
		return articleRepository.count();
	}
	
	@GetMapping(path="/personnes/all")
	public @ResponseBody Iterable<Personne> getAllUsers() {
		return personneRepository.findAll();
	}
	
	@GetMapping(path="/personnes/add")
	public @ResponseBody String addNewPersonne () {
			Tache t = new Tache();
			Droit d = new Droit();
			t.setLibelletache("Bonjour");
			d.setLibelledroit("ta pas le droit");
			Personne n = new Personne();
			n.setNom_Personne("Vallee");
			n.setPrenom_Personne("Ronan");
			t.getPersonne().add(n);
			tacheRepository.save(t);
			d.getPersonne().add(n);
			droitRepository.save(d);
			
			return "Saved";
		}
	
}