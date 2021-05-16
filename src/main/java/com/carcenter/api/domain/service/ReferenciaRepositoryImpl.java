package com.carcenter.api.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carcenter.api.domain.repository.ReferenciaRepository;
import com.carcenter.api.persistence.crud.ReferenciaCrudRepository;
import com.carcenter.api.persistence.entity.Referencia;

@Service
public class ReferenciaRepositoryImpl implements ReferenciaRepository {

	@Autowired
	ReferenciaCrudRepository referenciaCrud;

	@Override
	public List<Referencia> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Referencia> getReferenciaByCod(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Referencia> getReferenciasByIdentificador(String identificador) {
		// TODO Auto-generated method stub
		return this.referenciaCrud.findRefsByIdentificador(identificador);
	}

	@Override
	public Referencia save(Referencia referencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long codigo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Referencia getReferenciaByIdentificador(String identificador) {
		// TODO Auto-generated method stub
		return this.referenciaCrud.findByIdentificador(identificador);
	}
}
