package com.carcenter.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.carcenter.api.domain.dto.MecanicoStatistics;
import com.carcenter.api.domain.repository.MantenimientoRepository;
import com.carcenter.api.domain.repository.MecanicoRepository;
import com.carcenter.api.domain.repository.ReferenciaRepository;
import com.carcenter.api.persistence.entity.Mantenimiento;
import com.carcenter.api.persistence.entity.Referencia;
import com.carcenter.api.utils.Constants;

@Controller
public class MantenimientoController {

	@Autowired
	MantenimientoRepository mantenimientoRepository;
	
	@Autowired
	MecanicoRepository mecanicoRepository;
	
	@Autowired
	ReferenciaRepository referenciaRepository;
	
	@GetMapping("/gridMantenimiento")
	public String gridMantenimiento(Model model) {
		
		List<Mantenimiento> listaMantenimientos = this.mantenimientoRepository.getAllAvaible();
		
		Referencia ref = this.referenciaRepository.getReferenciaByIdentificador(Constants.LIMT_MECA_DISPONIBLES);
		List<MecanicoStatistics> listaMecanicos = this.mecanicoRepository.
				getMecanicoAvailable(Integer.parseInt(ref.getValor()));
		
		model.addAttribute("listaMecanicos", listaMecanicos);
		model.addAttribute("listaMantenimientos", listaMantenimientos);
		model.addAttribute("title_gridMantenimiento", "Formulario de Mantenimientos");
		
		return "gridMantenimiento";
	}
	
	@PostMapping("/saveMantenimiento")
	public String saveMantenimiento(@Valid Mantenimiento mantenimiento, BindingResult validations, Model model) {
		
		if(validations.hasErrors()) {
			System.out.println("*** FLAG ERRORES ****");
		}
		
		return "formMantenimiento";
	}
	
	@GetMapping("/asignacionMecanico")
	public String asignacionMecanico(Model model) {
		
		Referencia ref = this.referenciaRepository.getReferenciaByIdentificador(Constants.LIMT_MECA_DISPONIBLES);
		List<MecanicoStatistics> listaMecanicos = this.mecanicoRepository.
				getMecanicoAvailable(Integer.parseInt(ref.getValor()));
		
		model.addAttribute("listaMecanicos", listaMecanicos);
		
		return "asignacionMecanico";
	}
	
}
