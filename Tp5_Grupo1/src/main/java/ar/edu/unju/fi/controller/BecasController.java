package ar.edu.unju.fi.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Beca;
import model.Curso;
import model.Docente;

@Controller
public class BecasController {
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
	public String getCursosForm(Model model) {
		model.addAttribute("beca",nuevaBeca);
		model.addAttribute("cursos",this.getCursos());
		return("nuevo_becas");
	}
	
	//devolucion a la solicitud de mostrar las listas de cursos en una tabla
	@GetMapping("/becas/lista")
	public String getListaCurso(Model model){
		model.addAttribute("becas",listaBecas);
		return ("lista_becas");
	}
	//devolucion de la aplicacion al cargar un nuevo curso
		@PostMapping("/becas/guardar")
		public String guardarCurso(@ModelAttribute("beca")Beca nuevoBeca,Model model) {
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
			//mostramos la lista con todos los cursos
			return ("lista_becas");		
		}
		@GetMapping("/ListaB")
		public String getIndexPage(Model model) {
			return "lista_becas";
		}
}
