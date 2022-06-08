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


import model.Alumno;

@Controller
public class AlumnoController {

	Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	List<Alumno> listaAlumno = new ArrayList<>();
	Alumno unAlumno = new Alumno();

	@GetMapping("/ListaA")
	public String getTablaAlumnos(Model model) {
		logger.info("REQUEST: /ListaA - METHOD: getTablaAlumnos() - INFO: Se solicita mostrar en contenido de la lista de alumnos");
		return "lista_alumno";
	}

	@GetMapping("/alumno")
	public String getFormAlumno(Model model) {
		model.addAttribute("alumno", unAlumno);
		logger.info("REQUEST: /alumno - METHOD: getFormAlumno() - INFO: Se solicita cargar un nuevo objeto alumno, se devuelve el formulario");
		return ("nuevo_alumnos");
	}

	@PostMapping("/alumno/guardar")
	public String guardarAlumno(@ModelAttribute("alumno") Alumno unAlumno, Model model) {
		listaAlumno.add(unAlumno);
		model.addAttribute("alumnos", listaAlumno);
		logger.info("REQUEST: /alumno/guardar - METHOD: guardarAlumno() - INFO: Se agrego un nuevo objeto alumno a la lista de alumnos, se devuelve el la tabla actualizada");
		return ("lista_alumno");
	}
}
