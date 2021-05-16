package com.carcenter.api.controllers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.carcenter.api.domain.dto.MecanicoStatistics;
import com.carcenter.api.domain.repository.MantenimientoRepository;
import com.carcenter.api.domain.repository.MecanicoRepository;
import com.carcenter.api.domain.repository.ReferenciaRepository;
import com.carcenter.api.persistence.entity.Mantenimiento;
import com.carcenter.api.persistence.entity.Mecanico;
import com.carcenter.api.persistence.entity.MecanicoPK;
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
		model.addAttribute("nav_active_grid_mec", "nav-link"); 
		model.addAttribute("nav_active_grid_man", "nav-link active");
		
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
	
	@GetMapping("/saveAsignacionMecanico/{id}/{tipoId}/{idM}")
	public String saveAsignacionMecanico(@PathVariable Long id, @PathVariable String tipoId, @PathVariable Long idM, Model model) {
		
		MecanicoPK mecanicoPK = new MecanicoPK();
		mecanicoPK.setDocumento(id);
		mecanicoPK.setTipo_documento(tipoId);
		
		Optional<Mecanico> mecO = this.mecanicoRepository.getByMecanicoPK(mecanicoPK);
		Mecanico mec = mecO.get();
		
		if(!Objects.isNull(mec)) {
		
			Optional<Mantenimiento> mantO = this.mantenimientoRepository.getByCodigo(idM);
			Mantenimiento mant = mantO.get();
			
			if(!Objects.isNull(mant)) {
				mant.setMecanico(mec);
				this.mantenimientoRepository.save(mant);
			}
		}
		
		return 	"redirect:/gridMantenimiento";
	}
	
}
