package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import model.Docente;

@Component
public class ListaDocentes {
	private ArrayList<Docente> listaDocente;
	
	public ListaDocentes() {
		// TODO Auto-generated constructor stub
		listaDocente=new ArrayList<>();
		
	}

	/**
	 * @return the listaDocente
	 */
	public ArrayList<Docente> getListaDocente() {
		return listaDocente;
	}

	/**
	 * @param listaDocente the listaDocente to set
	 */
	public void setListaDocente(ArrayList<Docente> listaDocente) {
		this.listaDocente = listaDocente;
	}
	
	

}
