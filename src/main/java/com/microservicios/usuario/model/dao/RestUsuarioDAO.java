package com.microservicios.usuario.model.dao;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.eu.microservicios.commons.model.entity.Usuario;

@RepositoryRestResource(path="seg-usuarios")
public interface RestUsuarioDAO {
	
	@RestResource(path="buscar-usuario")
	public Usuario findByCodigoUsuario(@Param("username") String username);

}
