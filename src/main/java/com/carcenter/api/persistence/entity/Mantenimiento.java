package com.carcenter.api.persistence.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mantenimientos")
public class Mantenimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column
	private String estado;
	
	@OneToOne
	@JoinColumn(name = "cod_placa")
	@NotNull
	private Vehiculo vehiculo;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@OneToOne
	@JoinColumns( {
	    @JoinColumn(name="mec_tipo_documento", referencedColumnName="tipo_documento"),
	    @JoinColumn(name="mec_documento", referencedColumnName="documento")
	} )
	private Mecanico mecanico;
	
	@OneToMany(mappedBy = "mantenimiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Foto> listaFotos;
	
	@OneToMany(mappedBy = "mantenimiento")
    private List<ServicioMantenimiento> listaServicios;
	
	@OneToMany(mappedBy = "mantenimiento")
    private List<RepuestosMantenimiento> listaRepuestos;
	
	@ManyToOne
    @JoinColumn(name = "cod_factura")
    private Factura factura;
	
	@Column
	private BigDecimal precio_total;
	
	@Column
	private BigDecimal precio_tope;
	
	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public List<Foto> getListaFotos() {
		return listaFotos;
	}

	public void setListaFotos(List<Foto> listaFotos) {
		this.listaFotos = listaFotos;
	}

	public List<ServicioMantenimiento> getListaServicios() {
		return listaServicios;
	}

	public void setListaServicios(List<ServicioMantenimiento> listaServicios) {
		this.listaServicios = listaServicios;
	}

	public List<RepuestosMantenimiento> getListaRepuestos() {
		return listaRepuestos;
	}

	public void setListaRepuestos(List<RepuestosMantenimiento> listaRepuestos) {
		this.listaRepuestos = listaRepuestos;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public BigDecimal getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(BigDecimal precio_total) {
		this.precio_total = precio_total;
	}

	public BigDecimal getPrecio_tope() {
		return precio_tope;
	}

	public void setPrecio_tope(BigDecimal precio_tope) {
		this.precio_tope = precio_tope;
	}

	@Override
	public String toString() {
		return "Mantenimiento [codigo=" + codigo + ", mecanico=" + mecanico + "]";
	}
	
	public BigDecimal getPrecioTotalServicios() {
		
		BigDecimal precio = new BigDecimal(0);
		
		for (ServicioMantenimiento servicioM : this.listaServicios) {
			precio = precio.add(servicioM.getPrecio());
		}
		
		return precio;
	}
	
public BigDecimal getPrecioTotalRepuestos() {
		
		BigDecimal precio = new BigDecimal(0);
		
		for (RepuestosMantenimiento repuestoM : this.listaRepuestos) {
			BigDecimal precioAux = BigDecimal.valueOf(repuestoM.getUnidades(), 0).multiply(repuestoM.getRepuesto().getPrecio_unitario());
			precio = precio.add(precioAux);
		}
		
		return precio;
	}
	
}
