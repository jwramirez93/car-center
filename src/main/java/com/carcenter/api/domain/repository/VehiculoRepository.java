package com.carcenter.api.domain.repository;

import java.util.List;
import com.carcenter.api.persistence.entity.Vehiculo;

public interface VehiculoRepository {
	
	List<Vehiculo> getAll();
	
}
