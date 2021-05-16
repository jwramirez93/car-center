package com.carcenter.api.persistence.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "servicios")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column
	private String nombre_servicio;
	
	@Column
	private BigDecimal precio_minimo;
	
	@Column
	private BigDecimal precio_maximo;
	
	@OneToMany(mappedBy = "servicio")
    private List<ServicioMantenimiento> listaServicios;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre_servicio() {
		return nombre_servicio;
	}
	
	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}
	
	public BigDecimal getPrecio_minimo() {
		return precio_minimo;
	}
	
	public void setPrecio_minimo(BigDecimal precio_minimo) {
		this.precio_minimo = precio_minimo;
	}
	
	public BigDecimal getPrecio_maximo() {
		return precio_maximo;
	}
	
	public void setPrecio_maximo(BigDecimal precio_maximo) {
		this.precio_maximo = precio_maximo;
	}
	

}
