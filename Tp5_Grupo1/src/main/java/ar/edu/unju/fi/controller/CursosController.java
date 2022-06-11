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

import ar.edu.unju.fi.util.ListaCursos;
import model.Curso;
import model.Docente;



@Controller
public class CursosController {
	@Autowired
	Logger logger = LoggerFactory.getLogger(CursosController.class);
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
	public String getFormCursos(Model model) {
		model.addAttribute("curso",nuevcurso);
		model.addAttribute("docentes",this.getDocentes());
		logger.info("REQUEST: /curso - METHOD: getFormCursos() - INFO: Se solicita cargar un nuevo objeto cursos, se devuelve el formulario");
		return("nuevo_cursos");
	}
	//entre llaves es una variable que viene en la url
		@GetMapping("/editar/{codigo}")
		public ModelAndView getEditarC(@PathVariable(value="codigo")int codigo) {
			ModelAndView mav = new ModelAndView("edicion_cursos");
			// mostramos la lista con todos los cursos.
			return mav;
		}
		@PostMapping("/modificar")
		public ModelAndView editarDatosCursos(@ModelAttribute("docente") Docente docente, BindingResult bindingResult) {
			//busco el objeto seleccionado para modificar en la lista de candidato
			ModelAndView mav = new ModelAndView("edicion_docente");
			mav.addObject("docente", docente);
			return mav;
		}
	//devolucion a la solicitud de mostrar las listas de cursos en una tabla
	@GetMapping("/ListaCursos")
	public String getListaCurso(Model model){
		model.addAttribute("cursos",listCursos.getListaCursos());
		logger.info("REQUEST: /ListaA - METHOD: getListaCursos() - INFO: Se solicita mostrar en contenido de la lista de cursos");
		return ("lista_cursos");
	}
	
	//devolucion de la aplicacion al cargar un nuevo curso
	@PostMapping("/curso/guardar")
	public ModelAndView guardarCurso(@Validated @ModelAttribute("curso")Curso nuevoCurso,BindingResult bindingResult) {
		Docente unDocte = new Docente();
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_cursos");
			mav.addObject("curso",nuevoCurso);
			mav.addObject("docentes", this.getDocentes());
			return mav;
		}
		//asignamos los atributos del docente al atributo decente  del objeto curso
		for(Docente t: this.getDocentes())
		{ if(t.getLegajo()==nuevoCurso.getDocente().getLegajo()) {
			unDocte = t;}
		}
		//añadimos el objeto recibido a la lista de cursos
		ModelAndView mav = new ModelAndView("lista_cursos");
		nuevoCurso.setDocente(unDocte);
		listCursos.agregarCurso(nuevoCurso);
		mav.addObject("cursos",listCursos.getListaCursos());
		logger.info("REQUEST: /curso/guardar - METHOD: guardarCurso() - INFO: Se agrego un nuevo objeto curso a la lista de cursos, se devuelve el la tabla actualizada");
		//mostramos la lista con todos los cursos
		return mav;		
	}
}
/*@Controller
public class CursosController {
	@Autowired
	Logger logger = LoggerFactory.getLogger(CursosController.class);
	Curso nuevcurso = new Curso();
	ListaCursos listCursos = new ListaCursos();
	//usado a modo de ejemplo para la seleccion de un docente en el formulario
	public List<Curso> getDocentes(){
		List<Curso> listaPersona = new ArrayList<Curso>();
		listaPersona.add(new Curso(1222,388512812,"Gabriel", "Cas","gris@mail"));
		listaPersona.add(new Curso(1212,388511212, "Carlos", "Caes","azul@mail"));
		return listaPersona;
	}
	//devolucion de la pagina que contiene el formulario
	@GetMapping("/curso")
	public String getFormCursos(Model model) {
		model.addAttribute("curso",nuevcurso);
		model.addAttribute("docentes",this.getDocentes());
		logger.info("REQUEST: /curso - METHOD: getFormCursos() - INFO: Se solicita cargar un nuevo objeto cursos, se devuelve el formulario");
		return("nuevo_cursos");
	}
	//entre llaves es una variable que viene en la url
		@GetMapping("/editar/{codigo}")
		public ModelAndView getEditarC(@PathVariable(value="codigo")int codigo) {
			ModelAndView mav = new ModelAndView("edicion_cursos");
			// mostramos la lista con todos los cursos.
			return mav;
		}
		@PostMapping("/modificar")
		public ModelAndView editarDatosCursos(@ModelAttribute("curso") Curso curso, BindingResult bindingResult) {
			//busco el objeto seleccionado para modificar en la lista de candidato
			ModelAndView mav = new ModelAndView("edicion_curso");
			mav.addObject("curso", curso);
			return mav;
		}
	//devolucion a la solicitud de mostrar las listas de cursos en una tabla
	@GetMapping("/ListaCursos")
	public String getListaCurso(Model model){
		model.addAttribute("cursos",listCursos.getListaCursos());
		logger.info("REQUEST: /ListaA - METHOD: getListaCursos() - INFO: Se solicita mostrar en contenido de la lista de cursos");
		return ("lista_cursos");
	}
	
	//devolucion de la aplicacion al cargar un nuevo curso
	@PostMapping("/curso/guardar")
	public ModelAndView guardarCurso(@Validated @ModelAttribute("curso")Curso nuevoCurso,BindingResult bindingResult) {
		Curso unDocte = new Curso();
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_cursos");
			mav.addObject("curso",nuevoCurso);
			mav.addObject("docentes", this.getDocentes());
			return mav;
		}
		//asignamos los atributos del docente al atributo decente  del objeto curso
		for(Curso t: this.getDocentes())
		{ if(t.getCodigo()==nuevoCurso.getCurso().getCodigo()) {
			unDocte = t;}
		}
		//añadimos el objeto recibido a la lista de cursos
		ModelAndView mav = new ModelAndView("lista_cursos");
		nuevoCurso.setCurso(unDocte);
		listCursos.agregarCurso(nuevoCurso);
		mav.addObject("cursos",listCursos.getListaCursos());
		logger.info("REQUEST: /curso/guardar - METHOD: guardarCurso() - INFO: Se agrego un nuevo objeto curso a la lista de cursos, se devuelve el la tabla actualizada");
		//mostramos la lista con todos los cursos
		return mav;		
	}
}*/
