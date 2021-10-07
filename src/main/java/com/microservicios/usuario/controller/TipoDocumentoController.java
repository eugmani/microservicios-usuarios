package com.microservicios.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eu.microservicios.commons.model.entity.TipoDocumento;
import com.microservicios.usuario.service.TipoDocumentoService;

@RestController
public class TipoDocumentoController {
	
	@Autowired
	private TipoDocumentoService service;
	
	@GetMapping("/tipo-documento")
	public ResponseEntity<Iterable<TipoDocumento>> findAll() {
		
		return ResponseEntity.ok().body(this.service.findAll());
	}

}
