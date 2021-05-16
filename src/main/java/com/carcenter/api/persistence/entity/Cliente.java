package com.carcenter.api.persistence.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@EmbeddedId
	private ClientePK clientePK;
	
	@Column
	private String primer_nombre;
	
	@Column
	private String segundo_nombre;
	
	@Column
	private String primer_apellido;
	
	@Column
	private String segundo_apellido;
	
	@Column
	private String celular;
	
	@Column
	private String direccion;
	
	@Column
	private String email;
	
	@Column
	private String estado;
	
	public ClientePK getClientePK() {
		return clientePK;
	}
	
	public void setClientePK(ClientePK clientePK) {
		this.clientePK = clientePK;
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
	
	
}
