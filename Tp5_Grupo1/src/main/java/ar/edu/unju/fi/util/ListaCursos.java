package ar.edu.unju.fi.util;


import java.util.ArrayList;

import org.springframework.stereotype.Component;

import model.Curso;
@Component
public class ListaCursos {
	private ArrayList<Curso> listaCursos;
	
	public ListaCursos() {
		// TODO Auto-generated constructor stub
		listaCursos = new ArrayList<>();
	}

	/**
	 * @return the listaCursos
	 */
	public ArrayList<Curso> getListaCursos() {
		return listaCursos;
	}

	/**
	 * @param listaCursos the listaCursos to set
	 */
	public void setListaCursos(ArrayList<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}


	
}
