package com.microservicios.usuario.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eu.microservicios.commons.model.entity.Usuario;
import com.eu.microservicios.commons.services.impl.EntityServiceImpl;
import com.microservicios.usuario.model.dao.UsuarioDAO;
import com.microservicios.usuario.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends EntityServiceImpl<Usuario, UsuarioDAO> implements UsuarioService {	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> find(Pageable pageable, Usuario usuario) {
		Page<Usuario> resultPage = this.dao.findAll(new Specification<Usuario>() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if(usuario != null) {
					if (usuario.getNombre() != null && !usuario.getNombre().trim().isEmpty()) {
						predicates
								.add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.upper(root.get("nombre")),
										"%" + usuario.getNombre().trim().toUpperCase() + "%")));
					}
					if (usuario.getApellido1() != null && !usuario.getApellido1().trim().isEmpty()) {
						predicates
								.add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.upper(root.get("apellido1")),
										"%" + usuario.getApellido1().trim().toUpperCase() + "%")));
					}
					if (usuario.getApellido2() != null && !usuario.getApellido2().trim().isEmpty()) {
						predicates
								.add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.upper(root.get("apellido2")),
										"%" + usuario.getApellido2().trim().toUpperCase() + "%")));
					}
					if (usuario.getEmail() != null && !usuario.getEmail().trim().isEmpty()) {
						predicates
								.add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.upper(root.get("email")),
										"%" + usuario.getEmail().trim().toUpperCase() + "%")));
					}
					if (usuario.getTelefonoMovil() != null && !usuario.getTelefonoMovil().trim().isEmpty()) {
						predicates
								.add(criteriaBuilder.and(criteriaBuilder.like(root.get("telefonoMovil"),
										usuario.getTelefonoMovil().trim() + "%")));
					}
					if (usuario.getTipoDocumento() != null) {
						predicates
								.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("tipoDocumento").get("id"),
										usuario.getTipoDocumento().getId())));
					}
					if (usuario.getNumeroDocumento() != null && !usuario.getNumeroDocumento().trim().isEmpty()) {
						predicates
								.add(criteriaBuilder.and(criteriaBuilder.like(root.get("numeroDocumento"),
										usuario.getNumeroDocumento().trim() + "%")));
					}
					if(usuario.getDeleted() != null) {
						predicates
								 .add(criteriaBuilder.and(criteriaBuilder.equal(root.get("deleted"), usuario.getDeleted()? 1: 0)));
					}
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);
		
		return resultPage;
	}
	
	@Override
	public void deleteById(Long id) {
		Optional<Usuario> usuarioOpt = this.findById(id);
		Usuario usuario;
		
		if(usuarioOpt.isPresent()) {
			usuario = usuarioOpt.get();
			usuario.setDeleted(true);
			this.save(usuario);
		}
	}
	
}
