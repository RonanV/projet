package com.example.apispring.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import com.auth0.jwt.JWT;
import com.example.apispring.controller.MainController;
import com.example.apispring.model.CustomUserDetails;
import com.example.apispring.model.Personne;
import static com.example.apispring.security.SecurityConstant.EXPIRATION_TIME;
import static com.example.apispring.security.SecurityConstant.TOKEN_PREFIX;
import static com.example.apispring.security.SecurityConstant.HEADER_STRING;
import static com.example.apispring.security.SecurityConstant.SECRET;


import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private AuthenticationManager authenticationManager;
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
            Personne creds = new ObjectMapper()
                    .readValue(request.getInputStream(), Personne.class);
            logger.error(creds.getNumlicence());
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getNumlicence(),
                            creds.getPassword(),
                            Collections.emptyList())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}


	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		   String token = JWT.create()
	                .withSubject(((User) authResult.getPrincipal()).getUsername())
	                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	                .sign(HMAC512(SECRET.getBytes()));
	        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
	}

	
}
