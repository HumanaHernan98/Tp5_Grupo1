package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.accessibility.internal.resources.accessibility;

import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.util.ListaCursos;
import model.Curso;

public class CursoServiceImp implements ICursoService {
	@Autowired//permite inyectar unas dependencias con otras dentro de Spring
	private ListaCursos listaCurso;
	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso nuevoCurso) {
		boolean respuesta = listaCurso.getListaCursos().add(nuevoCurso);
		return respuesta;
	}

	@Override
	public void ModificarCurso(Curso nuevoCurso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCurso(int codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListaCursos getListaCurso() {
		// TODO Auto-generated method stub
		return listaCurso;//retorna el objeto que accede a la lista de cursos
	}

	@Override
	public void asignarCurso() {
		// TODO Auto-generated method stub

	}

	@Override
	public Curso BuscarCurso(int codigo) {
		//busca por código y retorna el objeto
		Optional<Curso> curso = listaCurso.getListaCursos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return curso.get;
	}

}
