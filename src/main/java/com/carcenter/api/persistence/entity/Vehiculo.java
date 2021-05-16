package com.carcenter.api.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
	
	@Id
	private String placa;
	
	@Column
	private String color;
	
	@OneToOne
	@JoinColumn(name = "cod_marca")
	private Marca marca;
	
	@OneToOne
	@JoinColumns( {
	    @JoinColumn(name="cli_tipo_documento", referencedColumnName="tipo_documento"),
	    @JoinColumn(name="cli_documento", referencedColumnName="documento")
	} )
	private Cliente cliente;
	

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
