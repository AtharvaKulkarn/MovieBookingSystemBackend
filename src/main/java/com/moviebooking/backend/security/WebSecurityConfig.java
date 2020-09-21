package com.moviebooking.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("owner").password(new BCryptPasswordEncoder().encode("password")).roles("ADMIN")
				.and()
				.withUser("Atharva").password(new BCryptPasswordEncoder().encode("atharva")).roles("USER")
				.and()
				.withUser("Dendi").password(new BCryptPasswordEncoder().encode("navidendi")).roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/getAllMovies").authenticated()
				.antMatchers("/getMovieById").authenticated()
				.antMatchers("/bookMovie").hasAnyRole("ADMIN", "USER")
				.antMatchers("/updateMovie").hasRole("ADMIN")
				.antMatchers("/addMovie").hasRole("ADMIN")
				.and()
				.httpBasic()
				.and()
				.csrf().disable();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}