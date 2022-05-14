package model;

public class Docente {

	private int legajo, telefono;
	private String nombre, apellido, email;

	public Docente() {

	}

	public Docente(int legajo, int telefono, String nombre, String apellido, String email) {
		super();
		this.legajo = legajo;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
