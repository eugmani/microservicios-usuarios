package com.microservicios.usuario.model.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.microservicios.usuario.model.Usuario;

public interface UsuarioDAO extends PagingAndSortingRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

}
