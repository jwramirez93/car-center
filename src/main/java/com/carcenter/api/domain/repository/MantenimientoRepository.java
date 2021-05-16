package com.carcenter.api.domain.repository;

import java.util.List;

import com.carcenter.api.persistence.entity.Mantenimiento;

public interface MantenimientoRepository {
	
	List<Mantenimiento> getAll();

	List<Mantenimiento> getAllAvaible();
}
