package com.carcenter.api.persistence.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mecanicos")
public class Mecanico {
	
	@EmbeddedId
	@NotNull
	@Valid
	private MecanicoPK mecanicoPK;
	
	@Column
	@NotEmpty
	private String primer_nombre;
	
	@Column
	private String segundo_nombre;
	
	@Column
	@NotEmpty
	private String primer_apellido;
	
	@Column
	private String segundo_apellido;
	
	@Column
	@NotEmpty
	private String celular;
	
	@Column
	@NotEmpty
	private String direccion;
	
	@Column
	@NotEmpty
	@Email
	private String email;
	
	@Column
	@NotEmpty
	private String estado;

	public MecanicoPK getMecanicoPK() {
		return mecanicoPK;
	}

	public void setMecanicoPK(MecanicoPK mecanicoPK) {
		this.mecanicoPK = mecanicoPK;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getNombreCompl() {
		return primer_nombre+" "+segundo_nombre+" "+primer_apellido+" "+segundo_apellido;
	}

	@Override
	public String toString() {
		return "Mecanico [mecanicoPK=" + mecanicoPK + ", primer_nombre=" + primer_nombre + ", segundo_nombre="
				+ segundo_nombre + ", primer_apellido=" + primer_apellido + ", segundo_apellido=" + segundo_apellido
				+ ", celular=" + celular + ", direccion=" + direccion + ", email=" + email + ", estado=" + estado + "]";
	}	

}
