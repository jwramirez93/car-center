package com.carcenter.api.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.carcenter.api.persistence.entity.Servicio;

public interface ServicioCrudRepository extends CrudRepository<Servicio, Long> {

}
