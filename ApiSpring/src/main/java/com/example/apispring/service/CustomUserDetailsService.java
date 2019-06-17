package com.example.apispring.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.apispring.controller.MainController;
import com.example.apispring.exceptions.InvalidDataException;
import com.example.apispring.model.CustomUserDetails;
import com.example.apispring.model.Personne;
import com.example.apispring.repository.PersonneRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private PersonneRepository personneRepository;
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Personne personne = personneRepository.findByNumlicence(username);
		if(personne == null)
		{
			throw new InvalidDataException("Cette utilisateur n'existe pas " + username);
		}
		else {
			List<GrantedAuthority> authorityList = personne.getTache().stream()
					.map(role -> new SimpleGrantedAuthority(role.getTache().getLibelletache()))
					.collect(Collectors.toList());
			logger.error(authorityList + " role");
			return new User(personne.getNumlicence(),personne.getPassword(), authorityList);
		}
	}
	

}
