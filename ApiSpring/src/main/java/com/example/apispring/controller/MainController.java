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
import com.example.apispring.repository.AlbumRepository;
import com.example.apispring.repository.ArticleRepository;
import com.example.apispring.repository.DroitRepository;
import com.example.apispring.repository.GroupeRepository;
import com.example.apispring.repository.PersonneRepository;
import com.example.apispring.repository.TacheRepository;


@RestController
@CrossOrigin(origins = "https://localhost:4200")
@RequestMapping(path= "/")
public class MainController {
	
	
	public MainController() {
		super();
	}

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@Autowired
	private TacheRepository tacheRepository;
	
	@Autowired 
	private DroitRepository droitRepository;
	
	@Autowired
	private GroupeRepository groupeRepository;
	
	@Autowired 
	private AlbumRepository albumRepository;


	public ArticleRepository getArticleRepository() {
		return articleRepository;
	}

	public void setArticleRepository(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public PersonneRepository getPersonneRepository() {
		return personneRepository;
	}

	public void setPersonneRepository(PersonneRepository personneRepository) {
		this.personneRepository = personneRepository;
	}

	public TacheRepository getTacheRepository() {
		return tacheRepository;
	}

	public void setTacheRepository(TacheRepository tacheRepository) {
		this.tacheRepository = tacheRepository;
	}

	public DroitRepository getDroitRepository() {
		return droitRepository;
	}

	public void setDroitRepository(DroitRepository droitRepository) {
		this.droitRepository = droitRepository;
	}

	public static Logger getLogger() {
		return logger;
	}
	public GroupeRepository getGroupeRepository() {
		return groupeRepository;
	}

	public void setGroupeRepository(GroupeRepository groupeRepository) {
		this.groupeRepository = groupeRepository;
	}

	public AlbumRepository getAlbumRepository() {
		return albumRepository;
	}

	public void setAlbumRepository(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}
	

	
}