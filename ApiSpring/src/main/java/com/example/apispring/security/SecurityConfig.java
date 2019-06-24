package com.example.apispring.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import com.example.apispring.controller.MainController;
import com.example.apispring.filter.JWTAuthenticationFilter;
import com.example.apispring.filter.JWTAuthorizationFilter;
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
		http.cors().and().authorizeRequests().antMatchers("/personnes/add", "/login", "/register", "/articles").permitAll()
		/* .and()
			.formLogin() */
				//.successHandler(new SuccessHandlerRedirection())
		.and()
			.logout()
		.and()
			.authorizeRequests().anyRequest().authenticated()
		/*.and()
			.httpBasic()*/
		.and()
			.addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .addFilter(new JWTAuthorizationFilter(authenticationManager()))
            // this disables session creation on Spring Security
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
         	.csrf().disable();
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

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST","OPTIONS","DELETE","PUT"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	
}

