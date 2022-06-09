package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import model.Docente;

@Controller
public class DocenteController {
	Logger logger = LoggerFactory.getLogger(CursosController.class);
	List<Docente> listaDocente = new ArrayList<>();
	Docente unDocente = new Docente();
	@GetMapping("/ListaD")
	public String getIndexPage(Model model) {
		logger.info("REQUEST: /ListaD - METHOD: getListaDocentes() - INFO: Se solicita mostrar en contenido de la lista de docentes");
		return "lista_docentes";
	}
	
	
	@GetMapping("/docente")
	public String getFormDocente(Model model) {
		model.addAttribute("docente", unDocente);
		logger.info("REQUEST: /curso - METHOD: getFormDocente() - INFO: Se solicita cargar un nuevo objeto docente, se devuelve el formulario");
		return ("nuevo_docente");
	}

	@PostMapping("/docente/guardar")
	public ModelAndView guardarDocente(@Validated @ModelAttribute("docente")Docente unDocente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav=new ModelAndView("nuevo_docente");
			mav.addObject("docente", unDocente);
			return mav;
		}
		ModelAndView mav = new ModelAndView("lista_docentes");
		if (listaDocente.add(unDocente)==true) {
			logger.info("REQUEST: /alumno/guardar - METHOD: guardarAlumno() - INFO: Se agrego un nuevo objeto docente a la lista de docentes, se devuelve el la tabla actualizada");
		}
		mav.addObject("docentes", listaDocente);
		return mav;
	}
	
}
