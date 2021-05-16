package com.carcenter.api.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carcenter.api.persistence.crud.VehiculoCrudRepository;
import com.carcenter.api.domain.repository.VehiculoRepository;
import com.carcenter.api.persistence.entity.Vehiculo;

@Service
public class VehiculoRepositoryImlp implements VehiculoRepository {

	@Autowired
	VehiculoCrudRepository vehiculoCrud;
	
	@Override
	public List<Vehiculo> getAll() {
		// TODO Auto-generated method stub
		return (List<Vehiculo>)this.vehiculoCrud.findAll();
	}

}
