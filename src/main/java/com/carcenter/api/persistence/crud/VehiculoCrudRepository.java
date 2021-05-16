package com.carcenter.api.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.carcenter.api.persistence.entity.Vehiculo;

public interface VehiculoCrudRepository extends CrudRepository<Vehiculo, String> {

}
