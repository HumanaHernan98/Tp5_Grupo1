package model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Curso {

	@Size(min = 3,max = 5,message = "el código debe tener entre 3 a 5 caracteres")
	private int codigo;
	@NotEmpty(message = "El titulo no puede estar en blanco")
	private String titulo;
	@NotEmpty(message = "La categoria no puede estar en blanco")
	private String categoria;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechinicio;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechafin;
	@Min(value=0,message = "La cantidad de horas debe ser mayor a 0")
	private int cantH;
	@NotEmpty(message = "La modalidad no puede estar en blanco")
	private String modalidad;
	@NotEmpty(message = "El docente no puede estar en blanco")
	private Docente docente;
	@NotEmpty(message = "El curso no puede estar en blanco")
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
	public Curso(int codigo, String titulo, String categoria, LocalDate fechinicio, LocalDate fechafin, int cantH,
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
	public LocalDate getFechinicio() {
		return fechinicio;
	}
	/**
	 * @param fechinicio the fechinicio to set
	 */
	public void setFechinicio(LocalDate fechinicio) {
		this.fechinicio = fechinicio;
	}
	/**
	 * @return the fechafin
	 */
	public LocalDate getFechafin() {
		return fechafin;
	}
	/**
	 * @param fechafin the fechafin to set
	 */
	public void setFechafin(LocalDate fechafin) {
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
