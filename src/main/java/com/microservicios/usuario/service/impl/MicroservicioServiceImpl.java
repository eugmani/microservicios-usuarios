package com.microservicios.usuario.service.impl;

import org.springframework.stereotype.Service;

import com.eu.microservicios.commons.model.entity.Microservicio;
import com.eu.microservicios.commons.services.impl.EntityServiceImpl;
import com.microservicios.usuario.model.dao.MicroservicioDAO;
import com.microservicios.usuario.service.MicroservicioService;

@Service
public class MicroservicioServiceImpl extends EntityServiceImpl<Microservicio, MicroservicioDAO> implements MicroservicioService {

}
