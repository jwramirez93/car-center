package com.carcenter.api.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.carcenter.api.persistence.entity.Marca;

public interface MarcaCrudRepository extends CrudRepository<Marca, Long> {

}
