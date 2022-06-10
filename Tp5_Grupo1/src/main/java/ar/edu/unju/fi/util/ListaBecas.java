package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import model.Beca;

@Component
public class ListaBecas {
	
	ArrayList<Beca> listaBecas;
	
	public ListaBecas() {
		// TODO Auto-generated constructor stub
		listaBecas = new ArrayList<Beca>();
	}


	/**
	 * @return the listaBecas
	 */
	public ArrayList<Beca> getListaBecas() {
		return listaBecas;
	}

	/**
	 * @param listaBecas the listaBecas to set
	 */
	public void setListaBecas(ArrayList<Beca> listaBecas) {
		this.listaBecas = listaBecas;
	}
	
	
	
	
}
