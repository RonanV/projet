package com.example.apispring.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.apispring.controller.MainController;
import com.example.apispring.redirection.SuccessHandlerRedirection;
import com.example.apispring.service.CustomUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
			auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(getPasswordEncoder());
				
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/personnes/verif").permitAll()
		.and()
			.formLogin()
				.successHandler(new SuccessHandlerRedirection())
		.and()
			.logout()
		.and()
			.authorizeRequests().anyRequest().authenticated()
		.and()
			.httpBasic();			
		
	}
	
	private PasswordEncoder getPasswordEncoder() {
		final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
		/*return new PasswordEncoder() {
			@Override
            public String encode(CharSequence charSequence) {
				logger.error("encode "+ charSequence);
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
            	logger.error(charSequence + s);
                return false;
            }
		};*/
		return new BCryptPasswordEncoder();
	}
	
}

