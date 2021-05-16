package com.carcenter.api.persistence.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "repuestos")
public class Repuesto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column
	private String nombre_repuesto;
	
	@Column
	private BigDecimal precio_unitario;
	
	@Column
	private int unidades_inventario;
	
	@Column
	private String proveedor;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre_repuesto() {
		return nombre_repuesto;
	}

	public void setNombre_repuesto(String nombre_repuesto) {
		this.nombre_repuesto = nombre_repuesto;
	}

	public BigDecimal getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(BigDecimal precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public int getUnidades_inventario() {
		return unidades_inventario;
	}

	public void setUnidades_inventario(int unidades_inventario) {
		this.unidades_inventario = unidades_inventario;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
}
