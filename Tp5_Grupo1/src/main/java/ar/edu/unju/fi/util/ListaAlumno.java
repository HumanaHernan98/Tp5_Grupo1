package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import model.Alumno;

@Component
public class ListaAlumno {
	private ArrayList<Alumno> listaAlumno;
	
	public ListaAlumno() {
		// TODO Auto-generated constructor stub
		
		listaAlumno=new ArrayList<Alumno>();
	}

	/**
	 * @return the listaAlumno
	 */
	public ArrayList<Alumno> getListaAlumno() {
		return listaAlumno;
	}

	/**
	 * @param listaAlumno the listaAlumno to set
	 */
	public void setListaAlumno(ArrayList<Alumno> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}
	

}
