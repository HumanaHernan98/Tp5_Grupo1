package ar.edu.unju.fi.service;

import ar.edu.unju.fi.util.ListaCursos;
import model.Curso;

public interface ICursoService {

	public Curso getCurso();
	public boolean guardarCurso(Curso nuevoCurso);
	public void ModificarAlumnos(Curso nuevoCurso);
	public void eliminarCandidato(int codigo);
	public ListaCursos getListaCursos();
	public void asignarDocente();
	public Curso BuscarCurso(int codigo);
	
}
