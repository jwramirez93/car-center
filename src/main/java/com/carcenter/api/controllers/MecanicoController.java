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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("title_formMecanico", Constants.TIT_FORM_MECANICO);
		model.addAttribute("nav_active_grid_mec", "nav-link"); 
		model.addAttribute("nav_active_grid_man", "nav-link");
		
		return "asd";
	}
	
	@PostMapping("/formMecanico")
	public String saveMecanico(@Valid Mecanico mecanico, BindingResult validations, Model model, RedirectAttributes flashAttr) {
		
		List<Referencia> tiposIdentificacion = this.referenciaRepository.
				getReferenciasByIdentificador(Constants.TIPOS_IDENTIFICACION);
		
		model.addAttribute("tiposIdentificacion", tiposIdentificacion);
		
		if(validations.hasErrors()) {
			
			model.addAttribute("operationAlert", true);
			model.addAttribute("nav_active_grid_mec", "nav-link"); 
			model.addAttribute("nav_active_grid_man", "nav-link");
			
			return "formMecanico";
		}else {
			this.mecanicoRepository.save(mecanico);
			model.addAttribute("operationSuccess", true);
		}
		

		flashAttr.addFlashAttribute("operationSuccess", true);	
		return "redirect:/gridMecanico";
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

			model.addAttribute("mecanico", mecBD.get());
			
			List<Referencia> tiposIdentificacion = this.referenciaRepository.
					getReferenciasByIdentificador(Constants.TIPOS_IDENTIFICACION);
			
			model.addAttribute("tiposIdentificacion", tiposIdentificacion);
			
		}
		
		model.addAttribute("title_formMecanico", Constants.TIT_FORM_MECANICO);
		model.addAttribute("nav_active_grid_mec", "nav-link"); 
		model.addAttribute("nav_active_grid_man", "nav-link");
		
		return "formMecanico";
	}
	
	@GetMapping({"/gridMecanico", "/"})
	public String gridMecanico(Model model) {
		
		List<Mecanico> listaMecanicos = this.mecanicoRepository.getAll();
		
		model.addAttribute("listaMecanicos", listaMecanicos);
		model.addAttribute("title_gridMecanico", "Listado de Mecanicos");
		model.addAttribute("nav_active_grid_mec", "nav-link active"); 
		model.addAttribute("nav_active_grid_man", "nav-link");
		
		return "gridMecanico";
	}
	
	@GetMapping("/deleteMecanico/{id}/{tipoId}")
	public String deleteMecanico(@PathVariable Long id, @PathVariable String tipoId, RedirectAttributes flashAttr) {
		
		MecanicoPK mecanicoPK = new MecanicoPK();
		mecanicoPK.setDocumento(id);
		mecanicoPK.setTipo_documento(tipoId);
		Optional<Mecanico> mecBD = this.mecanicoRepository.getByMecanicoPK(mecanicoPK);
		
		if(!Objects.isNull(mecBD.get())) {
			mecBD.get().setEstado(Constants.ESTADO_INACTIVO);
			this.mecanicoRepository.save(mecBD.get());
			
			flashAttr.addFlashAttribute("operationSuccess", true);
		}else {
			flashAttr.addFlashAttribute("operationWarning", true);
		}
		
		return 	"redirect:/gridMecanico";
	}
	
	@GetMapping("/activarMecanico/{id}/{tipoId}")
	public String activarMecanico(@PathVariable Long id, @PathVariable String tipoId, RedirectAttributes flashAttr) {
		
		MecanicoPK mecanicoPK = new MecanicoPK();
		mecanicoPK.setDocumento(id);
		mecanicoPK.setTipo_documento(tipoId);
		Optional<Mecanico> mecBD = this.mecanicoRepository.getByMecanicoPK(mecanicoPK);
		
		if(!Objects.isNull(mecBD.get())) {
			mecBD.get().setEstado(Constants.ESTADO_ACTIVO);
			this.mecanicoRepository.save(mecBD.get());
			
			flashAttr.addFlashAttribute("operationSuccess", true);
		}else {
			flashAttr.addFlashAttribute("operationWarning", true);
		}
		
		return 	"redirect:/gridMecanico";
	}
	
	
}
