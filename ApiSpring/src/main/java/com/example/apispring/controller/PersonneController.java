package com.example.apispring.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apispring.exceptions.InvalidDataException;
import com.example.apispring.jointure.tache_personne;
import com.example.apispring.model.Personne;
import com.example.apispring.model.Tache;
import com.example.apispring.repository.ArticleRepository;
import com.example.apispring.repository.PersonneRepository;
import com.example.apispring.repository.TacheRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "/personnes")
public class PersonneController extends MainController{

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping(path="")
	public Iterable<Personne> getAllUsers() {
		return super.getPersonneRepository().findAll();
	}
	
	@GetMapping(path="/{id}")
	public  Optional<Personne> getByid(@PathVariable Integer id) {
		return super.getPersonneRepository().findById(id);
	}
	@GetMapping(path="/search")
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
		List<Personne> resultats =  super.getPersonneRepository().findByNomPersonneContainingOrPrenomPersonneContainingOrEmailPersonneContaining(nom, prenom, email);
		if(resultats == null)
		{
			nom = tab[1];
			prenom = tab[0];
			resultats =  super.getPersonneRepository().findByNomPersonneContainingOrPrenomPersonneContainingOrEmailPersonneContaining(nom, prenom, email);
		}
		return resultats;
		
		
	}
	@GetMapping(path="/verif")
	public Personne verfiNumMdp(@RequestParam String numero, @RequestParam String pass) {
		Personne p = new Personne();
		p = super.getPersonneRepository().findByNumlicence(numero);
		if(p != null)
		{
			String num = p.getNumlicence();
			String mdp = p.getPassword();
			logger.error(mdp + "num : " + num);
			if(! num.isEmpty() && ! mdp.isEmpty()) {
				if (num.equals(numero) && mdp.equals(pass)) {
					return p;
				}
				else if (!num.equals(numero)) {
					throw new InvalidDataException("Le numero de licence ne correspond pas");
				}
				else if (!mdp.equals(pass)) {
					throw new InvalidDataException("Le mot de passe est incorrect ");
				}
				else {
					throw new InvalidDataException("L'utilisateur avec le numero de licence \" + numero + \" n'existe pas");
				}
			}
		}
		throw new InvalidDataException("Erreur lors de la recuperation des informations utilisateurs");		
	}
	
	@GetMapping(path="/add")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String addNewPersonne () {
			Tache t = new Tache();
			t.setLibelletache("bonjour");
			Personne n = new Personne();
			n.setNomPersonne("Vallee");
			n.setPrenomPersonne("Ronan");
			n.setPassword(BCryptPasswordEncoder("ronan"));
			n.setLoginPersonne("ValleeRonan78");
			tache_personne tp = new tache_personne();
			tp.setTache(t);
			tp.setPersonne(n);
			tp.setDetail("detail");
			n.getTache().add(tp);
			super.getTacheRepository().save(t);
			super.getPersonneRepository().save(n);
			
			
						
			return "Saved";
		}
	private String BCryptPasswordEncoder(String string) {
		PasswordEncoder crypt = new BCryptPasswordEncoder();
		String encodepassword = crypt.encode(string);
		return encodepassword;
	}

	@GetMapping(path="/add2")
	public String addnewmembre(@RequestParam String nom_Personne, @RequestParam String prenom_Personne, 
			@RequestParam String email_Personne, @RequestParam String telephone,
			@RequestParam String rue_Personne, @RequestParam String codepostal_Personne, @RequestParam String ville_Personne,
			@RequestParam String telephonepere_Personne, @RequestParam String telephonemere_Personne, @RequestParam String numlicence) {
		
		Personne p = new Personne();
		p.setNomPersonne(nom_Personne);
		p.setPrenomPersonne(prenom_Personne);
		p.setEmailPersonne(email_Personne);
		p.setTelephone(telephone);
		p.setRue_Personne(rue_Personne);
		p.setCodepostal_Personne(codepostal_Personne);
		p.setVille_Personne(ville_Personne);
		p.setTelephonemere(telephonemere_Personne);
		p.setTelephonepere(telephonepere_Personne);
		p.setNumlicence(numlicence);
		
		super.getPersonneRepository().save(p);
		return "Saved";
	}
}
