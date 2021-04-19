package com.microservicios.usuario.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicios.usuario.model.Usuario;
import com.microservicios.usuario.model.dao.UsuarioDAO;
import com.microservicios.usuario.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDao;

	@Override
	public Page<Usuario> find(Pageable pageable, Usuario usuario) {
		Page<Usuario> resultPage = this.usuarioDao.findAll(new Specification<Usuario>() {
			
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
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);
		
		return resultPage;
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		
		return this.usuarioDao.findById(id);
	}

}
