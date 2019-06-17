package com.example.apispring.redirection;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SuccessHandlerRedirection implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectstrategy = new DefaultRedirectStrategy(); 
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String url = "http://localhost:4200";
		
		try{
			redirectstrategy.sendRedirect(request, response, url);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
