package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Alumno;

@Controller
public class AlumnoController {
	List<Alumno> listaAlumno= new ArrayList<>();
	Alumno unAlumno = new Alumno(); 
	@GetMapping("/alumno")
	public String getAlumno(Model model) {
		model.addAttribute("alumno",unAlumno);
		return("nuevo_alumnos");
	}
	
		@GetMapping("/ListaA")
		public String getIndexPage(Model model) {
			return "lista_alumno";
		}
	@PostMapping("/alumno/guardar")
	public String guardarAlumno(@ModelAttribute("alumno")Alumno unAlumno,Model model) {
		listaAlumno.add(unAlumno);
		model.addAttribute("alumnos", listaAlumno);
		return("lista_alumno");
	}
}
