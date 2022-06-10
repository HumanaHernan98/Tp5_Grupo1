package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.util.ListaDocentes;
import model.Docente;
@Service ("DocenteServiceImpList")
//implement la clase deberá implementarse de forma obligatoria abstracta
public class DocenteServiceImp implements IDocenteService {
	@Autowired
	private ListaDocentes listaDocente;
	@Override
	public Docente getDocente() {
		// retorna un objeto de la clase alumno
		return new Docente();
	}

	@Override
	public boolean guardarDocente(Docente nuevoDocente) {
		// guarda un objeto docente en la lista de docentes
		boolean respuesta =listaDocente.getListaDocente().add(nuevoDocente);
		return respuesta;
	}

	@Override
	public void ModificarDocente(Docente nuevoDocente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarDocente(int legajo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListaDocentes getListaDocente() {
		// retorna el objeto que accede a la lista de docentes
		return listaDocente;

	}

	@Override
	public Docente BuscarDocente(int legajo) {
		//busca por legajo y vretorna el objeto
		Optional<Docente> docente = listaDocente.getListaDocente().stream().filter(a -> a.getLegajo() == legajo).findFirst();
		return docente.get();
	}

}
