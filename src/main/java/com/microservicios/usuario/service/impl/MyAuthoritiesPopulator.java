package com.microservicios.usuario.service.impl;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicios.usuario.service.IAuthoritiesPopulatorService;

@Service("myAuthPopulator")
public class MyAuthoritiesPopulator implements IAuthoritiesPopulatorService {
	
//	private static final String ANONYMOUS_ROLE = "ANONYMOUS";
//	
//	private static final String ROLE_PREFIX = "ROLE_";
//
//	@Override
//	@Transactional(readOnly = true)
//	public List<? extends GrantedAuthority> getGrantedAuthorities(String userName) {
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		
//		// TODO DAO access
//		
//		authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX.concat(ANONYMOUS_ROLE)));
//		
//		return null;
//	}

}
