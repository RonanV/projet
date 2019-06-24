package com.example.apispring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apispring.model.Personne;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "/membres")
public class MembreController {

	
}
