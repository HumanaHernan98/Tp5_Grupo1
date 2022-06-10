package model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class Docente {
	@Min(value=1,message = "El legajo debe ser mayor a 0")
	private int legajo;
	@Min(value=100000,message = "El telefono debe ser mayor a 100.000")
	private int telefono;
	@NotEmpty(message = "El nombre del alumno no puede estar en blanco")
	private String nombre;
	@NotBlank(message = "El apellido no puede estar en blanco")
	private String apellido;
	@NotEmpty@Email
	private String email;
	
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
