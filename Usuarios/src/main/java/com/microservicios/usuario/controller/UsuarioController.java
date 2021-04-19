package com.microservicios.usuario.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.usuario.model.Usuario;
import com.microservicios.usuario.service.UsuarioService;

@RestController("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/find")
	public ResponseEntity<Page<Usuario>> find(@RequestBody(required = false) Usuario usuario) {
		
		int page = 1; // TODO front page
		Pageable pageable = PageRequest.of(page - 1, 25, Sort.by("id"));
		
		Page<Usuario> resultList = this.service.find(pageable, usuario);
		
		if(resultList.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(resultList);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
		if(usuario.getId() != null) {
			usuario.setId(null);
		}
		Usuario result = service.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping("/editar")
	public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario) {
		
		Usuario usuarioDb;
		
		if(usuario.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		usuarioDb = this.service.save(usuario);
		
		if(usuarioDb != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDb);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<Usuario> eliminar(@RequestBody long userId) {
		return ResponseEntity.noContent().build();
		
	}
}
