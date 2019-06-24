package com.example.apispring.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apispring.model.Groupe;
import com.example.apispring.model.Personne;
import com.example.apispring.model.Tache;
import com.example.apispring.repository.PersonneRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "/groupes")
public class GroupeController extends MainController{

	@GetMapping(path="")
	public Iterable<Groupe> getAllGroupes() {
		return super.getGroupeRepository().findAll();
	}
	
	@GetMapping(path="/all2")
	public List<Groupe> getAllGroupe2() {
		
		return super.getGroupeRepository().findAllGroupe();
	}
	@PostMapping(path="/add")
	public String ajoutgroupe(@RequestParam String libellegrp, @RequestParam String limitemax, @RequestParam String annee_Min, @RequestParam String annee_Max, @RequestParam int identraineur ) {
		Groupe g = new Groupe();
		PersonneRepository personnerepository = super.getPersonneRepository();
		Set<Personne> entraineur = personnerepository.findByIdpersonne(identraineur);
		g.setLibellegrp(libellegrp);
		g.setPersonne(entraineur);
		g.setLimitemax(limitemax);
		g.setAnnee_Min(annee_Min);
		g.setAnne_Max(annee_Max);
		return "Saved";
	}
}
