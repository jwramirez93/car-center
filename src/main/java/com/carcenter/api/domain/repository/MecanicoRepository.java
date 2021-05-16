package com.carcenter.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.carcenter.api.domain.dto.MecanicoStatistics;
import com.carcenter.api.persistence.entity.Mecanico;
import com.carcenter.api.persistence.entity.MecanicoPK;


public interface MecanicoRepository {
	
	List<Mecanico> getAll();
	
	List<Mecanico> getAllActive();

	Optional<Mecanico> getByMecanicoPK(MecanicoPK mecanicoPK);
	
	Mecanico save(Mecanico mecanico);
	
	void delete(MecanicoPK mecanicoPK);
	
	List<MecanicoStatistics> getMecanicoAvailable(int limitRows);
}
