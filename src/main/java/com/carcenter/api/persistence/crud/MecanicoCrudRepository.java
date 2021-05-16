package com.carcenter.api.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.carcenter.api.domain.dto.MecanicoStatistics;
import com.carcenter.api.persistence.entity.Mecanico;
import com.carcenter.api.persistence.entity.MecanicoPK;
import com.carcenter.api.utils.Constants;

public interface MecanicoCrudRepository extends CrudRepository<Mecanico, MecanicoPK> {
	
	
	@Query(value = Constants.CONS_MEC_DISP, nativeQuery = true)
	List<MecanicoStatistics> findMecanicoAvailable(int limitRows);

	List<Mecanico> findByEstadoEquals(String estado);
}
