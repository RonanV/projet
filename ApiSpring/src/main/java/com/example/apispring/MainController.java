package com.example.apispring;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apispring.jointure.tache_personne;
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
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
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
	Personne pers = new Personne();
		pers.setNom_Personne("Vallee");
		pers.setPrenom_Personne("Ronan");
		
		this.personneRepository.save(pers);
		Article n = new Article();
		n.setTexte_article("Bonjour");
		n.setTitre_article("c'est moi");
		n.setIdpersonne(pers);
		this.articleRepository.save(n);
		
		
				
		
		
		
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
	@GetMapping(path="/personnes/{id}")
	public @ResponseBody Optional<Personne> getByid(@RequestParam Integer id) {
		return personneRepository.findById(id);
	}
	@GetMapping(path="/personnes/verif")
	public @ResponseBody boolean verfiNumMdp(@RequestParam String numero, @RequestParam String pass, @RequestParam Integer id) {
		Personne p = new Personne();
		p = personneRepository.findById(id).get();
		String num = p.getNumlicence();
		String mdp = "mdp";
		Integer idpersonne = p.getIdpersonne();
		
		if (num.equals(numero) && mdp.equals(pass) && idpersonne.equals(id)) {
			return true;
		}
		else if (!num.equals(numero)) {
			logger.error(num+ " " + numero );
			logger.error("les numéros de licence ne correspondent pas");
			return false;
		}
		else if (!mdp.equals(pass)) {
			logger.error("les password ne correspondent pas");
			return false;
		}
		else {
			logger.error("erreur lors de la recuperation des informations de la personne");
			return false;
		}
		
		
	}
	
	@GetMapping(path="/personnes/add")
	public @ResponseBody String addNewPersonne () {
			Tache t = new Tache();
			t.setLibelletache("bonjour");
			Personne n = new Personne();
			n.setNom_Personne("Vallee");
			n.setPrenom_Personne("Ronan");
			tache_personne tp = new tache_personne();
			tp.setTache(t);
			tp.setPersonne(n);
			tp.setDetail("detail");
			n.getTache().add(tp);
			tacheRepository.save(t);
			personneRepository.save(n);
			
			
						
			return "Saved";
		}
	@GetMapping(path="/taches/all")
	public @ResponseBody Iterable<Tache> getalltache()
	{
		return tacheRepository.findAll();
	}
	@GetMapping(path="/membres/add")
	public @ResponseBody String addnewmembre(@RequestParam String nom_Personne, @RequestParam String prenom_Personne, 
			@RequestParam String email_Personne, @RequestParam String telephone,
			@RequestParam String rue_Personne, @RequestParam String codepostal_Personne, @RequestParam String ville_Personne,
			@RequestParam String telephonepere_Personne, @RequestParam String telephonemere_Personne, @RequestParam String numlicence) {
		
		Personne p = new Personne();
		p.setNom_Personne(nom_Personne);
		p.setPrenom_Personne(prenom_Personne);
		p.setEmail_Personne(email_Personne);
		p.setTelephone(telephone);
		p.setRue_Personne(rue_Personne);
		p.setCodepostal_Personne(codepostal_Personne);
		p.setVille_Personne(ville_Personne);
		p.setTelephonemere(telephonemere_Personne);
		p.setTelephonepere(telephonepere_Personne);
		p.setNumlicence(numlicence);
		
		personneRepository.save(p);
		return "Saved";
	}
	
}