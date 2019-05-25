package fr.villecresnes.etoile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.villecresnes.etoile.dto.Personne;
import fr.villecresnes.etoile.service.BackendService;
import io.swagger.annotations.ApiOperation;



@RestController
public class BackEndController {

	Logger logger = LoggerFactory.getLogger(BackEndController.class);
	
	 @Autowired
	 BackendService beService;
	 
	 @ApiOperation("Accepte et traite les requêtes HTTP POST pour inscrire un Adhérent")
	  @PostMapping(value="/api/addPerson", consumes = "application/json", produces={"application/json"})
	  Personne postRequest(@RequestBody Personne personne) {
		 
		 //ajouter une personne dans la BD
		 // = inscription ?
	    return personne;
	  }
}
