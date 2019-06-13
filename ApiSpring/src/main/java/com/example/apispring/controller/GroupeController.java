package com.example.apispring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apispring.model.Groupe;
import com.example.apispring.model.Tache;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "/groupes")
public class GroupeController extends MainController{

	@GetMapping(path="/all")
	public Iterable<Groupe> getAllGroupes() {
		return super.getGroupeRepository().findAll();
	}
	
	@GetMapping(path="/all2")
	public List<Groupe> getAllGroupe2() {
		
		return super.getGroupeRepository().findAllGroupe();
	}
}
