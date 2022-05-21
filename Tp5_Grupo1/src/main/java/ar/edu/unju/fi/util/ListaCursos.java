package ar.edu.unju.fi.util;

import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class ListaCursos {
	private List<Curso> listaCursos = new ArrayList<>();
	
	public ListaCursos() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the listaCursos
	 */
	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	/**
	 * @param listaCursos the listaCursos to set
	 */
	public void agregarCurso(Curso curso) {
		listaCursos.add(curso);
	}
	
	
}
