package com.carcenter.api.persistence.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ClientePK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String tipo_documento;
	private Long documento;
	
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public Long getDocumento() {
		return documento;
	}
	public void setDocumento(Long documento) {
		this.documento = documento;
	}
	
}
