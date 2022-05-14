package model;

public class Curso {

	private int codigo, cantH;
	private String titulo, categoria, modalidad;
	private Docente docente;

	public Curso() {

	}

	public Curso(int codigo, int cantH, String titulo, String categoria, String modalidad, Docente docente) {
		super();
		this.codigo = codigo;
		this.cantH = cantH;
		this.titulo = titulo;
		this.categoria = categoria;
		this.modalidad = modalidad;
		this.docente = docente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantH() {
		return cantH;
	}

	public void setCantH(int cantH) {
		this.cantH = cantH;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}
