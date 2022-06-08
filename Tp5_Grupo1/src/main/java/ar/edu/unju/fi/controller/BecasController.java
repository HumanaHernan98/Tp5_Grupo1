package ar.edu.unju.fi.controller;

import java.time.LocalDate;
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

import model.Beca;
import model.Curso;
import model.Docente;

@Controller
public class BecasController {
	Logger logger = LoggerFactory.getLogger(BecasController.class);
	Beca nuevaBeca = new Beca();
	Docente undoc=new Docente(1222,388512812,"Gabriel", "Cas","gris@mail");
	List<Beca> listaBecas = new ArrayList<>();
	public List<Curso> getCursos(){
		List<Curso> listaCurso = new ArrayList<>();
		listaCurso.add(new Curso(123,"perforacio","terciario",LocalDate.now(),LocalDate.now(),155,"precencial",undoc));
		listaCurso.add(new Curso(123,"panaderia","terciario",LocalDate.now(),LocalDate.now(),155,"precencial",undoc));
		return listaCurso;
	}
	
	//devolucion de la pagina que contiene el formulario
	@GetMapping("/becas")
	public String getFormBecas(Model model) {
		model.addAttribute("beca",nuevaBeca);
		model.addAttribute("cursos",this.getCursos());
		logger.info("REQUEST: /becas - METHOD: getFormBecas() - INFO: Se solicita cargar un nuevo objeto becas, se devuelve el formulario");
		return("nuevo_becas");
	}
	
	//devolucion a la solicitud de mostrar las listas de cursos en una tabla
	@GetMapping("/becas/lista")
	public String getListaBecas(Model model){
		model.addAttribute("becas",listaBecas);
		logger.info("REQUEST: /ListaA - METHOD: getListaBecas() - INFO: Se solicita mostrar en contenido de la lista de becas");
		return ("lista_becas");
	}
	//devolucion de la aplicacion al cargar un nuevo curso
	
		@PostMapping("/becas/guardar")
		public String guardarCurso(@Validated @ModelAttribute("beca")Beca nuevoBeca,Model model,BindingResult bindingResult) {
			
			
			
			Curso unCur = new Curso();
			//asignamos los atributos del docente al atributo decente  del objeto curso
			for(Curso t: this.getCursos())
			{ if(t.getCodigo()==nuevoBeca.getCurso().getCodigo()) {
				unCur = t;}
			}
			//añadimos el objeto recibido a la lista de cursos
			nuevoBeca.setCurso(unCur);
			listaBecas.add(nuevoBeca);
			model.addAttribute("becas",listaBecas);
			logger.info("REQUEST: /becas/guardar - METHOD: guardarBecas() - INFO: Se agrego un nuevo objeto becas a la lista de becas, se devuelve el la tabla actualizada");
			//mostramos la lista con todos los cursos
			
			return ("lista_becas");	
			
		}
		@GetMapping("/ListaB")
		public String getIndexPage(Model model) {
			return "lista_becas";
		}
}
