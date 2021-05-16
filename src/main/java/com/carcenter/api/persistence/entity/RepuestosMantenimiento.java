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
@Table(name = "repuestos_x_mantenimientos")
public class RepuestosMantenimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column
	private int unidades;
	
	@Column
	private Long tiempo_estimado;
	
	@ManyToOne
    @JoinColumn(name = "cod_mantenimiento", referencedColumnName = "codigo")
	private Mantenimiento mantenimiento;
	
	@ManyToOne
    @JoinColumn(name = "cod_repuesto", referencedColumnName = "codigo")
	private Repuesto repuesto;
	
}
