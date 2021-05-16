package com.carcenter.api.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carcenter.api.domain.dto.MecanicoStatistics;
import com.carcenter.api.domain.repository.MecanicoRepository;
import com.carcenter.api.persistence.crud.MecanicoCrudRepository;
import com.carcenter.api.persistence.entity.Mecanico;
import com.carcenter.api.persistence.entity.MecanicoPK;
import com.carcenter.api.utils.Constants;

@Service
public class MecanicoRepositoryImpl implements MecanicoRepository {

	@Autowired
	MecanicoCrudRepository mecanicoCrud;

	@Override
	public List<Mecanico> getAll() {
		// TODO Auto-generated method stub
		return (List<Mecanico>)this.mecanicoCrud.findAll();
	}

	@Override
	public Optional<Mecanico> getByMecanicoPK(MecanicoPK mecanicoPK) {
		// TODO Auto-generated method stub
		return this.mecanicoCrud.findById(mecanicoPK);
	}

	@Override
	public Mecanico save(Mecanico mecanico) {
		// TODO Auto-generated method stub
		return this.mecanicoCrud.save(mecanico);
	}

	@Override
	public void delete(MecanicoPK mecanicoPK) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MecanicoStatistics> getMecanicoAvailable(int limitRows) {
		// TODO Auto-generated method stub
		return this.mecanicoCrud.findMecanicoAvailable(limitRows);
	}

	@Override
	public List<Mecanico> getAllActive() {
		// TODO Auto-generated method stub
		return this.mecanicoCrud.findByEstadoEquals(Constants.ESTADO_ACTIVO);
	}
	
	
	
}
