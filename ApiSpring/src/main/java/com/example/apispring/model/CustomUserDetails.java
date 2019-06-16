package com.example.apispring.model;

import java.util.Collection;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.apispring.controller.MainController;
import com.example.apispring.security.SecurityConfig;

public class CustomUserDetails extends Personne implements UserDetails{

	public CustomUserDetails(final Personne personne) {
		super(personne);
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getTache()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getTache()))
                .collect(Collectors.toList());
	}

	public String getUsername() {
		return super.getLoginPersonne();
	}
	public String getPassword() {
		return super.getPassword();
	}
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
