package com.carcenter.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.carcenter.api.persistence.entity.Referencia;

public interface ReferenciaRepository {
	
	List<Referencia> getAll();

	Optional<Referencia> getReferenciaByCod(Long codigo);
	
	List<Referencia> getReferenciasByIdentificador(String identificador);
	
	Referencia getReferenciaByIdentificador(String identificador);
	
	Referencia save(Referencia referencia);
	
	void delete(Long codigo);
	
}
