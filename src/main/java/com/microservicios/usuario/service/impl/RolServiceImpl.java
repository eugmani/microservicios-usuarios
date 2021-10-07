package com.microservicios.usuario.service.impl;

import org.springframework.stereotype.Service;

import com.eu.microservicios.commons.model.entity.Rol;
import com.eu.microservicios.commons.services.impl.EntityServiceImpl;
import com.microservicios.usuario.model.dao.RolDAO;
import com.microservicios.usuario.service.RolService;

@Service
public class RolServiceImpl extends EntityServiceImpl<Rol, RolDAO> implements RolService {

}
