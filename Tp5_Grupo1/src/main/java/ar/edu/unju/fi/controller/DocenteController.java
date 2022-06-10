package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.service.IDocenteService;
import model.Docente;

@Controller
public class DocenteController {
	@Autowired
	private IDocenteService docenteService;
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
	//entre llaves es una variable que viene en la url
	@GetMapping("/editar/{legajo}")
	public ModelAndView getEditarD(@PathVariable(value="legajo")int legajo) {
		ModelAndView mav = new ModelAndView("edicion_docente");
		// mostramos la lista con todos los cursos.
		return mav;
	}
	@PostMapping("/modificar")
	public ModelAndView editarDatosDocente(@ModelAttribute("docente") Docente docente, BindingResult bindingResult) {
		//busco el objeto seleccionado para modificar en la lista de candidato
		ModelAndView mav = new ModelAndView("edicion_docente");
		mav.addObject("docente", docente);
		return mav;
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
