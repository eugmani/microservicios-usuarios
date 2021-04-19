package com.microservicios.usuario.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import com.microservicios.usuario.service.IAuthoritiesPopulatorService;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	@Qualifier("myAuthPopulator")
	private IAuthoritiesPopulatorService myAuthPopulator;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String user = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		// TODO authenticate
		
		List<? extends GrantedAuthority> authorityList = myAuthPopulator.getGrantedAuthorities(user);
		return new UsernamePasswordAuthenticationToken(user,  password, authorityList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
