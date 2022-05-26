package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.util.ListaCursos;
import model.Curso;
import model.Docente;



@Controller
public class CursosController {
	Curso nuevcurso = new Curso();
	ListaCursos listCursos = new ListaCursos();
	//usado a modo de ejemplo para la seleccion de un docente en el formulario
	public List<Docente> getDocentes(){
		List<Docente> listaPersona = new ArrayList<Docente>();
		listaPersona.add(new Docente(1222,388512812,"Gabriel", "Cas","gris@mail"));
		listaPersona.add(new Docente(1212,388511212, "Carlos", "Caes","azul@mail"));
		return listaPersona;
	}
	//devolucion de la pagina que contiene el formulario
	@GetMapping("/curso")
	public String getCursosForm(Model model) {
		model.addAttribute("curso",nuevcurso);
		model.addAttribute("docentes",this.getDocentes());
		return("nuevo_cursos");
	}
	
	
	//devolucion a la solicitud de mostrar las listas de cursos en una tabla
	@GetMapping("/curso/lista")
	public String getListaCurso(Model model){
		model.addAttribute("cursos",listCursos.getListaCursos());
		return ("lista_cursos");
	}
	
	//devolucion de la aplicacion al cargar un nuevo curso
	@PostMapping("/curso/guardar")
	public String guardarCurso(@ModelAttribute("curso")Curso nuevoCurso,Model model) {
		Docente unDocte = new Docente();
		//asignamos los atributos del docente al atributo decente  del objeto curso
		for(Docente t: this.getDocentes())
		{ if(t.getLegajo()==nuevoCurso.getDocente().getLegajo()) {
			unDocte = t;}
		}
		//añadimos el objeto recibido a la lista de cursos
		nuevoCurso.setDocente(unDocte);
		listCursos.agregarCurso(nuevoCurso);
		model.addAttribute("cursos",listCursos.getListaCursos());
		//mostramos la lista con todos los cursos
		return ("lista_cursos");		
	}
	@GetMapping("/ListaCursos")
	public String getIndexPage(Model model) {
		return "lista_cursos";
	}
}
