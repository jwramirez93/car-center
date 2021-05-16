package com.carcenter.api.persistence.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servicios_x_mantenimiento")
public class ServicioMantenimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column
	private Long tiempo_estimado;
	
	@Column
	private BigDecimal precio;
	
	@ManyToOne
    @JoinColumn(name = "cod_servicio")
	private Servicio servicio;
	
	@ManyToOne
    @JoinColumn(name = "cod_mantenimiento")
	private Mantenimiento mantenimiento;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getTiempo_estimado() {
		return tiempo_estimado;
	}

	public void setTiempo_estimado(Long tiempo_estimado) {
		this.tiempo_estimado = tiempo_estimado;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
}
