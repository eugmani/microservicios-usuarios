package com.microservicios.usuario.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.microservicios.usuario.model.Usuario;

public interface UsuarioService {
	
	public Page<Usuario> find(Pageable pageable, Usuario usuario);

	public Usuario save(Usuario usuario);

	public Optional<Usuario> findById(Long id);

}
