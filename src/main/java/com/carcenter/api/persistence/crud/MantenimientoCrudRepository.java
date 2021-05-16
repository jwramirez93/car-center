package com.carcenter.api.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.carcenter.api.persistence.entity.Mantenimiento;

public interface MantenimientoCrudRepository extends CrudRepository<Mantenimiento, Long> {

	List<Mantenimiento> findByEstadoEquals(String estado);
	
}
