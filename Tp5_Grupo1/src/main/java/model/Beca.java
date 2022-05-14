package model;

public class Beca {
	private int codigo;
	private String curso, fechI, fechC;
	private boolean estado;

	public Beca() {

	}

	public Beca(int codigo, String curso, String fechI, String fechC, boolean estado) {
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getFechI() {
		return fechI;
	}

	public void setFechI(String fechI) {
		this.fechI = fechI;
	}

	public String getFechC() {
		return fechC;
	}

	public void setFechC(String fechC) {
		this.fechC = fechC;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
