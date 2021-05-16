package com.carcenter.api.persistence.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "facturas")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column
	private BigDecimal precio_total;
	
	@Column
	private BigDecimal precio_impuesto;
	
	@Column
	private BigDecimal precio_descuento;
	
	@Column
	private Date fecha;
	
	@Column
	private String estado;
	
	@OneToMany(mappedBy = "factura")
    private List<Mantenimiento> listaMantenimientos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(BigDecimal precio_total) {
		this.precio_total = precio_total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getPrecio_impuesto() {
		return precio_impuesto;
	}

	public void setPrecio_impuesto(BigDecimal precio_impuesto) {
		this.precio_impuesto = precio_impuesto;
	}

	public BigDecimal getPrecio_descuento() {
		return precio_descuento;
	}

	public void setPrecio_descuento(BigDecimal precio_descuento) {
		this.precio_descuento = precio_descuento;
	}
	
}
