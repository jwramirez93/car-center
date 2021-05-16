package com.carcenter.api.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carcenter.api.domain.repository.MantenimientoRepository;
import com.carcenter.api.persistence.crud.MantenimientoCrudRepository;
import com.carcenter.api.persistence.entity.Mantenimiento;
import com.carcenter.api.utils.Constants;

@Service
public class MantenimientoRepositoryImpl implements MantenimientoRepository {

	@Autowired
	MantenimientoCrudRepository mantenimientoCrud;

	@Override
	public List<Mantenimiento> getAll() {
		// TODO Auto-generated method stub
		return  (List<Mantenimiento>) this.mantenimientoCrud.findAll();
	}

	@Override
	public List<Mantenimiento> getAllAvaible() {
		return this.mantenimientoCrud.findByEstadoEquals(Constants.MANT_SIN_ASIGNAR);
	}

	@Override
	public Optional<Mantenimiento> getByCodigo(Long codigo) {
		// TODO Auto-generated method stub
		return this.mantenimientoCrud.findById(codigo);
	}

	@Override
	public Mantenimiento save(Mantenimiento mantenimiento) {
		// TODO Auto-generated method stub
		return this.mantenimientoCrud.save(mantenimiento);
	}

	
}
