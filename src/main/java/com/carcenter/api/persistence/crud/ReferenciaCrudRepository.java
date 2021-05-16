package com.carcenter.api.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.carcenter.api.persistence.entity.Referencia;

public interface ReferenciaCrudRepository extends CrudRepository<Referencia, Long>{

	List<Referencia> findRefsByIdentificador(String identificador);
	Referencia findByIdentificador(String identificador);
	
}
