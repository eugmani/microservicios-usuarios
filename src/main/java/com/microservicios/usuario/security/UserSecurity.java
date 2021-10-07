package com.microservicios.usuario.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//import com.microservicios.usuario.security.service.CustomAuthenticationProvider;

//@Configuration
public class UserSecurity { 
//extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private CustomAuthenticationProvider customAuthProvider; FIXME authorities login
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() { // Comment if you are using customAuthProvider
//		return new BCryptPasswordEncoder();
//	}
//	
////	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// auth.authenticationProvider(customProvider); FIXME authorities login
//		
//		http.authorizeRequests()
//		.antMatchers("/css/**").permitAll()
//		.anyRequest().authenticated()//authenticated()
//		.and()
//		.formLogin().permitAll()
//		.and()
//		.logout().permitAll()
//		.invalidateHttpSession(true)
//		.deleteCookies("JSESSIONID")
//		.and()
//		.exceptionHandling().accessDeniedPage("/error/error_404");
//	}
//	
//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
//		PasswordEncoder encoder = passwordEncoder();
//		UserBuilder userBuilder = User.builder().passwordEncoder(
//				password -> {
//					return encoder.encode(password);
//				}
//			);
//		builder.inMemoryAuthentication()
//		.withUser(userBuilder.username("admin").password("1234").roles("ADMIN"));
//	}

}
