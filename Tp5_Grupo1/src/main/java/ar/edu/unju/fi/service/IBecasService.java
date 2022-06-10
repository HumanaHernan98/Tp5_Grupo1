package ar.edu.unju.fi.service;

import ar.edu.unju.fi.util.ListaBecas;
import model.Beca;

public interface IBecasService {
	public Beca getBeca();
	public boolean guardarBeca(Beca nuevobeca);
	public void ModificarBeca(Beca nuevobeca);
	public void eliminarBeca(int codigo);
	public ListaBecas getListaBecas();
	public void asignarCurso();
	public Beca BuscarBecas(int codigo);
}
