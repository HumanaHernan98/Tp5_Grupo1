package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeneficiosController {
	@GetMapping("/beneficios")
	public String getIndexPage(Model model) {
		return "beneficios";
	}
}
