package ar.edu.unju.fi.service;

import ar.edu.unju.fi.util.ListaAlumno;
import model.Alumno;

public interface IAlumnoService {
	public Alumno getAlumno();
	public boolean guardarAlumno(Alumno alumno);
	public void ModificarAlumnos(Alumno alumno);
	public void eliminarAlumno(long dni);
	public ListaAlumno getListaAlumno();
	public Alumno BuscarAlumno(long dni);
}
