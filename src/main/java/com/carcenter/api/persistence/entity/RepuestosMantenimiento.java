package com.carcenter.api.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "repuestos_x_mantenimiento")
public class RepuestosMantenimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column
	private Long unidades;
	
	@Column
	private Long tiempo_estimado;
	
	@ManyToOne
    @JoinColumn(name = "cod_repuesto")
	private Repuesto repuesto;
	
	@ManyToOne
    @JoinColumn(name = "cod_mantenimiento")
	private Mantenimiento mantenimiento;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getUnidades() {
		return unidades;
	}

	public void setUnidades(Long unidades) {
		this.unidades = unidades;
	}

	public Long getTiempo_estimado() {
		return tiempo_estimado;
	}

	public void setTiempo_estimado(Long tiempo_estimado) {
		this.tiempo_estimado = tiempo_estimado;
	}

	public Repuesto getRepuesto() {
		return repuesto;
	}

	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}
	
}
