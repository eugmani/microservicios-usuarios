package com.microservicios.usuario.beans;

import com.eu.microservicios.commons.model.entity.Usuario;

public class FiltroUsuario extends Usuario {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tipoDocumentoId;
	
	public FiltroUsuario() {
		
	}

	public long getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public void setTipoDocumentoId(long tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}

}
