package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String guardarDocente(@ModelAttribute("docente")Docente unDocente,Model model) {
		listaDocente.add(unDocente);
		model.addAttribute("docentes", listaDocente);
		logger.info("REQUEST: /docente/guardar - METHOD: guardardocente() - INFO: Se agrego un nuevo objeto docente a la lista de docente, se devuelve el la tabla actualizada");		return ("lista_docentes");
	}
	
}
