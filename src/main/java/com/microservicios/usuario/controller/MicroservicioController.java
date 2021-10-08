package com.microservicios.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eu.microservicios.commons.model.entity.Microservicio;
import com.microservicios.usuario.service.MicroservicioService;

@RestController
public class MicroservicioController {
	
	@Autowired
	private MicroservicioService service;
	
	/**
	 * Devuelve la lista de todos los microservicios
	 * @return
	 */
	@GetMapping("/microservicio")
	public ResponseEntity<Iterable<Microservicio>> findAll() {
		
		return ResponseEntity.ok().body(this.service.findAll());
	}

}
