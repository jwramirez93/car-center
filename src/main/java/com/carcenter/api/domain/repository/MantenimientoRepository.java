package com.carcenter.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.carcenter.api.persistence.entity.Mantenimiento;

public interface MantenimientoRepository {
	
	List<Mantenimiento> getAll();

	List<Mantenimiento> getAllAvaible();
	
	Optional<Mantenimiento> getByCodigo(Long codigo);
	
	Mantenimiento save(Mantenimiento mantenimiento);
}
