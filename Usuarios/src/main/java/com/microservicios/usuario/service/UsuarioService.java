package com.microservicios.usuario.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eu.microservicios.commons.model.entity.Usuario;
import com.eu.microservicios.commons.services.EntityService;

public interface UsuarioService extends EntityService<Usuario> {
	
	public Page<Usuario> find(Pageable pageable, Usuario usuario);

}
