package com.microservicios.usuario.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public interface IAuthoritiesPopulatorService {
	
	public List<? extends GrantedAuthority> getGrantedAuthorities(String userName);

}
