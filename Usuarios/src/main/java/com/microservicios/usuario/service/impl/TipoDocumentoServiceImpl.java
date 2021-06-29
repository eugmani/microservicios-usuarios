package com.microservicios.usuario.service.impl;

import org.springframework.stereotype.Service;

import com.eu.microservicios.commons.model.entity.TipoDocumento;
import com.eu.microservicios.commons.services.impl.EntityServiceImpl;
import com.microservicios.usuario.model.dao.TipoDocumentoDAO;
import com.microservicios.usuario.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl extends EntityServiceImpl<TipoDocumento, TipoDocumentoDAO> implements TipoDocumentoService {

}
