package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocenteController {
	@GetMapping("/ListaD")
	public String getIndexPage(Model model) {
		return "lista_docente";
	}
}
