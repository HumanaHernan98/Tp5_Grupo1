package ar.edu.unju.fi.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.service.IAlumnoService;
import model.Alumno;

@Controller
public class AlumnoController {
	@Autowired
	@Qualifier("AlumnoServiceImpList")
	IAlumnoService alumnoService;
	Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	 

	@GetMapping("/ListaA")
	public ModelAndView getTablaAlumnos() {
		ModelAndView mav=new ModelAndView("lista_alumno");
		mav.addObject("alumnos",alumnoService.getListaAlumno().getListaAlumno());
		logger.info("REQUEST: /ListaA - METHOD: getTablaAlumnos() - INFO: Se solicita mostrar en contenido de la lista de alumnos");
		return mav;
	}

	@GetMapping("/alumno")
	public String getFormAlumno(Model model) {
		model.addAttribute("alumno", alumnoService.getAlumno());
		logger.info("REQUEST: /alumno - METHOD: getFormAlumno() - INFO: Se solicita cargar un nuevo objeto alumno, se devuelve el formulario");
		return ("nuevo_alumnos");
	}

	@PostMapping("/alumno/guardar")
	public ModelAndView guardarAlumno(@Validated @ModelAttribute("alumno") Alumno unnAlumno,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_alumnos");
			mav.addObject("alumno", unnAlumno);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ListaA");
		if (alumnoService.guardarAlumno(unnAlumno)) {
			logger.info("REQUEST: /alumno/guardar - METHOD: guardarAlumno() - INFO: Se agrego un nuevo objeto alumno a la lista de alumnos, se devuelve el la tabla actualizada");
		}
		
		
		return mav;
	}
	///
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarAlumnoPage(@PathVariable(value="dni")int dni) {
		ModelAndView mav = new ModelAndView("edicion_alumno");
		Alumno alumno = alumnoService.BuscarAlumno(dni);
		mav.addObject("alumno", alumno);
		return mav;
		
	}
	@PostMapping("/modificar")
	public ModelAndView editarDatosAlumno(@Validated @ModelAttribute("alumno") Alumno alumno, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			logger.info("ocurrió un error "+alumno);
			ModelAndView mav = new ModelAndView("edicion_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/ListaA");
		
		alumnoService.ModificarAlumnos(alumno);
		
		return mav;
		
	}
	
	@GetMapping("/eliminar/{dni}")
	public ModelAndView eliminarAlumno(@PathVariable("dni")int dni) {
		ModelAndView mav = new ModelAndView("redirect:/ListaA");
		alumnoService.eliminarAlumno(dni);
		return mav;
		
	}
	
	
}
