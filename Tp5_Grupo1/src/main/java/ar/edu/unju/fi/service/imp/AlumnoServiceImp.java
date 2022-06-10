package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.util.ListaAlumno;
import model.Alumno;

@Service("AlumnoServiceImpList")
public class AlumnoServiceImp implements IAlumnoService {
	@Autowired
	ListaAlumno listaAlumno;
	
	
	@Override
	public Alumno getAlumno() {
		// TODO Auto-generated method stub
		return new Alumno();
	}

	@Override
	public boolean guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return listaAlumno.getListaAlumno().add(alumno);
	}

	@Override
	public void ModificarAlumnos(Alumno alumno) {
		// TODO Auto-generated method stub
		//se busca el objeto a modificar y al encontrarlo se le asigna los nuevos valores
		for(Alumno t : listaAlumno.getListaAlumno()) {
			 if(t.getDni() == alumno.getDni()) {
				t.setNombre(alumno.getNombre());
				t.setApellido(alumno.getApellido());
				t.setEmail(alumno.getEmail());
				t.setTelefono(alumno.getTelefono());
			}	 
		}
	}

	@Override
	public void eliminarAlumno(long dni) {
		// TODO Auto-generated method stub
		
		int k=0;
		int i=0;
		for(Alumno t : listaAlumno.getListaAlumno()) {
			if (t.getDni()==dni) {
				i=k;
			}
			k++;
		}
		listaAlumno.getListaAlumno().remove(i);
	}

	@Override
	public ListaAlumno getListaAlumno() {
		// TODO Auto-generated method stub
		return listaAlumno;
	}

	@Override
	public Alumno BuscarAlumno(long dni) {
		Optional<Alumno> alumno=listaAlumno.getListaAlumno().stream().filter(a -> a.getDni()==dni).findFirst();
		
		return alumno.get();
	}

}
