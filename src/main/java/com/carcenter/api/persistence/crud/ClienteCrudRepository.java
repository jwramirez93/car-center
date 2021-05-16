package com.carcenter.api.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.carcenter.api.persistence.entity.Cliente;
import com.carcenter.api.persistence.entity.ClientePK;

public interface ClienteCrudRepository extends CrudRepository<Cliente, ClientePK> {

}
