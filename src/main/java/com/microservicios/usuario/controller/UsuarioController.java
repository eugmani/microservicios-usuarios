package com.microservicios.usuario.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eu.microservicios.commons.controllers.CommonController;
import com.eu.microservicios.commons.model.entity.Usuario;
import com.microservicios.usuario.service.UsuarioService;

@RefreshScope // para actualizar los properties sin volver a levantar
@RestController //("/user")
public class UsuarioController extends CommonController<Usuario, UsuarioService> {
	
	private static Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
	@Value("${prueba.texto}")
	private String prueba;
	
	@Autowired
	private Environment env;
	
	@Override
	@PostMapping("/findBy")
	public ResponseEntity<Page<Usuario>> findBy(@RequestBody Usuario entity, Pageable pageable) {
		if(entity == null)
			entity = new Usuario();
		// Busca solo los vigentes
		entity.setDeleted(false);
		
		if(env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")) {
			log.info("dev");
			log.info(env.getProperty("prueba.texto"));
		}
		
		log.info(this.prueba);
		
		return super.findBy(entity, pageable);
	}
	
	@Override
	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody Usuario entity, BindingResult result) {
		// FIXME
		entity.setCreateUserId(Long.valueOf(1));
		entity.setUpdateUserId(Long.valueOf(1));
		entity.setDeleted(false);
		return super.crear(entity, result);
	}
	
	@Override
	@PutMapping
	public ResponseEntity<?> editar(@Valid @RequestBody Usuario entity, BindingResult result) {
		entity.setCreateUserId(Long.valueOf(1));
		entity.setUpdateUserId(Long.valueOf(1));
		entity.setDeleted(false);
		return super.editar(entity, result);
	}
	
	@Override
	public ResponseEntity<?> validarEditar(Usuario entity) {
		Map<String, Object> errores = null;
		Optional<Usuario> usuarioDbOpt;
		
		if(entity.getId() == null) {
			errores = new HashMap<>();
			errores.put("id", "El campo id no está informado");
		} else {
			usuarioDbOpt = this.service.findById(entity.getId());
			if(usuarioDbOpt.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
		}
		
		if(errores != null && errores.size() > 0) {
			return ResponseEntity.badRequest().body(errores);
		}
		return null;
	}
	
}
