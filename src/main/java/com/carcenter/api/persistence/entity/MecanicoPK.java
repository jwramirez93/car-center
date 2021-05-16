package com.carcenter.api.persistence.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
public class MecanicoPK implements Serializable{

private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String tipo_documento;
	
	@NotNull
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

	@Override
	public String toString() {
		return "MecanicoPK [tipo_documento=" + tipo_documento + ", documento=" + documento + "]";
	}
}
