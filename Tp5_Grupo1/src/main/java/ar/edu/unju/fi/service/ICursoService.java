package ar.edu.unju.fi.service;

import ar.edu.unju.fi.util.ListaCursos;
import model.Curso;

public interface ICursoService {

	public Curso getCurso();
	public boolean guardarCurso(Curso nuevoCurso);
	public void ModificarCurso(Curso nuevoCurso);
	public void eliminarCurso(int codigo);
	public ListaCursos getListaCurso();
	public void asignarCurso();
	public Curso BuscarCurso(int codigo);
	
}
