package ar.edu.unju.fi.service;

import ar.edu.unju.fi.util.ListaDocentes;
import model.Docente;

public interface IDocenteService {

	public Docente getDocente();
	public boolean guardarDocente(Docente nuevoDocente);
	public void ModificarDocente(Docente nuevoDocente);
	public void eliminarDocente(int legajo);
	public ListaDocentes getListaDocente();
	public Docente BuscarDocente(int legajo);
}
