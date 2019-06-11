package com.example.apispring.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apispring.exceptions.InvalidDataException;
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
	public String addNewArticle () {
	Personne pers = new Personne();
		pers.setNomPersonne("Vallee");
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
	public Page<Article> getAllArticles(@RequestParam Integer size, @RequestParam String sort) {
		Pageable page = PageRequest.of(0, 20, Sort.by("idpersonne").descending());
		return articleRepository.findAll(page);
	}
	
	@GetMapping(path="/count")
	public long count() {
		return articleRepository.count();
	}
	
	@GetMapping(path="/personnes/all")
	public Iterable<Personne> getAllUsers() {
		return personneRepository.findAll();
	}
	@GetMapping(path="/personnes/{id}")
	public  Optional<Personne> getByid(@RequestParam Integer id) {
		return personneRepository.findById(id);
	}
	@GetMapping(path="/personnes/search")
	public List<Personne> search(@RequestParam String search){
		String tab[] = search.split(" ");
		Integer taille = tab.length;
		String nom = tab[0];
		String prenom = tab[0];
		String email = tab[0];
		if (taille > 1)
		{
			nom = tab[0];
			prenom = tab[1];
		}
		List<Personne> resultats =  personneRepository.findByNomPersonneContainingOrPrenomPersonneContainingOrEmailPersonneContaining(nom, prenom, email);
		if(resultats == null)
		{
			nom = tab[1];
			prenom = tab[0];
			resultats =  personneRepository.findByNomPersonneContainingOrPrenomPersonneContainingOrEmailPersonneContaining(nom, prenom, email);
		}
		return resultats;
		
		
	}
	@GetMapping(path="/personnes/verif")
	public Integer verfiNumMdp(@RequestParam String numero, @RequestParam String pass) {
		Personne p = new Personne();
		p = personneRepository.findByNumlicence(numero);
		if(p != null)
		{
			String num = p.getNumlicence();
			String mdp = p.getPassword();
			
			if (num.equals(numero) && mdp.equals(pass)) {
				return p.getIdpersonne();
			}
			else if (!num.equals(numero)) {
				throw new InvalidDataException("Le numero de licence ne correspond pas");
			}
			else if (!mdp.equals(pass)) {
				throw new InvalidDataException("Le mot de passe est incorrect ");
			}
			else {
				throw new InvalidDataException("Erreur lors de la recuperation des informations utilisateurs");
			}
		}
		throw new InvalidDataException("L'utilisateur avec le numero de licence " + numero + " n'existe pas");		
	}
	@GetMapping(path="/personnes/add")
	public String addNewPersonne () {
			Tache t = new Tache();
			t.setLibelletache("bonjour");
			Personne n = new Personne();
			n.setNomPersonne("Vallee");
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
	public  Iterable<Tache> getalltache()
	{
		return tacheRepository.findAll();
	}
	@GetMapping(path="/membres/add")
	public String addnewmembre(@RequestParam String nom_Personne, @RequestParam String prenom_Personne, 
			@RequestParam String email_Personne, @RequestParam String telephone,
			@RequestParam String rue_Personne, @RequestParam String codepostal_Personne, @RequestParam String ville_Personne,
			@RequestParam String telephonepere_Personne, @RequestParam String telephonemere_Personne, @RequestParam String numlicence) {
		
		Personne p = new Personne();
		p.setNomPersonne(nom_Personne);
		p.setPrenom_Personne(prenom_Personne);
		p.setEmailPersonne(email_Personne);
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