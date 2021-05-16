package com.carcenter.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.carcenter.api.domain.repository.MecanicoRepository;
import com.carcenter.api.domain.repository.ReferenciaRepository;
import com.carcenter.api.persistence.entity.Mecanico;
import com.carcenter.api.persistence.entity.Referencia;
import com.carcenter.api.utils.Constants;
import com.carcenter.api.persistence.entity.MecanicoPK;


@Controller
public class MecanicoController {
	
	@Autowired
	MecanicoRepository mecanicoRepository;

	@Autowired
	ReferenciaRepository referenciaRepository;
	
	@GetMapping("/formMecanico")
	public String formMecanico(Model model) {
		
		List<Referencia> tiposIdentificacion = this.referenciaRepository.
				getReferenciasByIdentificador(Constants.TIPOS_IDENTIFICACION);
		
		Mecanico mecanico = new Mecanico();
		model.addAttribute("mecanico", mecanico);
		model.addAttribute("tiposIdentificacion", tiposIdentificacion);
		model.addAttribute("title_formMecanico", "Formulario Mecanicos");
		
		return "formMecanico";
	}
	
	@PostMapping("/formMecanico")
	public String saveMecanico(@Valid Mecanico mecanico, BindingResult validations, Model model) {
		
		List<Referencia> tiposIdentificacion = this.referenciaRepository.
				getReferenciasByIdentificador(Constants.TIPOS_IDENTIFICACION);
		
		model.addAttribute("tiposIdentificacion", tiposIdentificacion);
		
		if(validations.hasErrors()) {
			
			Map<String, String> errores = new HashMap<>();
			validations.getFieldErrors().forEach(errorV -> {
				errores.put(errorV.getField(), "El campo "+errorV.getField()+" "+errorV.getDefaultMessage());
				System.out.println("**"+"El campo "+errorV.getField()+" "+errorV.getDefaultMessage());
			});
			
			model.addAttribute("operationAlert", true);
		}else {
			System.out.println(mecanico.toString());
			this.mecanicoRepository.save(mecanico);
			model.addAttribute("operationSuccess", true);
		}
		
		
		return "formMecanico";
	}
	
	@GetMapping("/formMecanico/{id}/{tipoId}")
	public String editMecanico(@PathVariable Long id, @PathVariable String tipoId, Model model) {
		
		MecanicoPK mecanicoPK = new MecanicoPK();
		mecanicoPK.setDocumento(id);
		mecanicoPK.setTipo_documento(tipoId);
		Optional<Mecanico> mecBD = this.mecanicoRepository.getByMecanicoPK(mecanicoPK);
		
		if(Objects.isNull(mecBD.get())) {
			model.addAttribute("operationWarning", true);
		}else {
			//this.mecanicoRepository.save(null);
			model.addAttribute("mecanico", mecBD.get());
			
			List<Referencia> tiposIdentificacion = this.referenciaRepository.
					getReferenciasByIdentificador(Constants.TIPOS_IDENTIFICACION);
			
			model.addAttribute("tiposIdentificacion", tiposIdentificacion);
			
		}
		
		model.addAttribute("title_formMecanico", "Formulario Mecanicos");
		
		return "formMecanico";
	}
	
	@GetMapping("/gridMecanico")
	public String gridMecanico(Model model) {
		
		List<Mecanico> listaMecanicos = this.mecanicoRepository.getAll();
		
		model.addAttribute("listaMecanicos", listaMecanicos);
		model.addAttribute("title_gridMecanico", "Listado de Mecanicos");
		
		return "gridMecanico";
	}
	
	@GetMapping("/deleteMecanico/{id}/{tipoId}")
	public String deleteMecanico(@PathVariable Long id, @PathVariable String tipoId) {
		
		MecanicoPK mecanicoPK = new MecanicoPK();
		mecanicoPK.setDocumento(id);
		mecanicoPK.setTipo_documento(tipoId);
		Optional<Mecanico> mecBD = this.mecanicoRepository.getByMecanicoPK(mecanicoPK);
		
		if(Objects.isNull(mecBD.get())) {
			//model.addAttribute("operationWarning", true);
		}else {
			mecBD.get().setEstado(Constants.ESTADO_INACTIVO);
			this.mecanicoRepository.save(mecBD.get());
		}
		
		return 	"redirect:/gridMecanico";
	}
	
}
