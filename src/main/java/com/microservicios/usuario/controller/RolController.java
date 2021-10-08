package com.microservicios.usuario.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eu.microservicios.commons.controllers.CommonController;
import com.eu.microservicios.commons.model.entity.Rol;
import com.microservicios.usuario.service.RolService;

@RestController
@RequestMapping("/roles")
public class RolController extends CommonController<Rol, RolService> {
	
	@Override
	@PostMapping("/findBy")
	public ResponseEntity<Page<Rol>> findBy(Rol entity, Pageable pageable) {
		if(entity == null)
			entity = new Rol();
		entity.setDeleted(false);
		return super.findBy(entity, pageable);
	}
	
	/**
	 * 
	 */
	@Override
	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody Rol entity, BindingResult result) {
		// FIXME
		entity.setCreateUserId(Long.valueOf(1));
		entity.setUpdateUserId(Long.valueOf(1));
		entity.setDeleted(false);
		return super.crear(entity, result);
	}
	
	@Override
	public ResponseEntity<?> editar(@Valid @RequestBody Rol entity, BindingResult result) {
		entity.setCreateUserId(Long.valueOf(1));
		entity.setUpdateUserId(Long.valueOf(1));
		entity.setDeleted(false);
		return super.editar(entity, result);
	}

}
