package model;

import java.time.LocalDate;

public class Curso {

	private int codigo;
	private String titulo;
	private String categoria;
	private String fechinicio;
	private String fechafin;
	private int cantH;
	private String modalidad;
	private Docente docente;
	public Curso() {

	}
	/**
	 * @param codigo
	 * @param titulo
	 * @param categoria
	 * @param fechinicio
	 * @param fechafin
	 * @param cantH
	 * @param modalidad
	 * @param docente
	 */
	public Curso(int codigo, String titulo, String categoria, String fechinicio, String fechafin, int cantH,
			String modalidad, Docente docente) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechinicio = fechinicio;
		this.fechafin = fechafin;
		this.cantH = cantH;
		this.modalidad = modalidad;
		this.docente = docente;
	}
	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the fechinicio
	 */
	public String getFechinicio() {
		return fechinicio;
	}
	/**
	 * @param fechinicio the fechinicio to set
	 */
	public void setFechinicio(String fechinicio) {
		this.fechinicio = fechinicio;
	}
	/**
	 * @return the fechafin
	 */
	public String getFechafin() {
		return fechafin;
	}
	/**
	 * @param fechafin the fechafin to set
	 */
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}
	/**
	 * @return the cantH
	 */
	public int getCantH() {
		return cantH;
	}
	/**
	 * @param cantH the cantH to set
	 */
	public void setCantH(int cantH) {
		this.cantH = cantH;
	}
	/**
	 * @return the modalidad
	 */
	public String getModalidad() {
		return modalidad;
	}
	/**
	 * @param modalidad the modalidad to set
	 */
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	/**
	 * @return the docente
	 */
	public Docente getDocente() {
		return docente;
	}
	/**
	 * @param docente the docente to set
	 */
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	
	
}
