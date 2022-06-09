package model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


import org.springframework.format.annotation.DateTimeFormat;

public class Beca {
	@Min(value=100,message = "El codigo debe ser mayor a 100")
	private int codigo;
	
	private Curso curso;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechI;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechC;
	@NotEmpty(message = "El estado de la beca no puede estar en blanco")
	private String estado;
	public Beca() {

	}

	public Beca(int codigo, Curso curso, LocalDate fechI, LocalDate fechC, String estado) {
		super();
		this.codigo = codigo;
		this.curso = curso;
		this.fechI = fechI;
		this.fechC = fechC;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getFechI() {
		return fechI;
	}

	public void setFechI(LocalDate fechI) {
		this.fechI = fechI;
	}

	public LocalDate getFechC() {
		return fechC;
	}

	public void setFechC(LocalDate fechC) {
		this.fechC = fechC;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	

}
