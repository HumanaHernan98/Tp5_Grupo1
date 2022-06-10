package model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Alumno {
	@Min(value=1000000,message = "El DNI debe ser mayor a 1.000.000")
	private long dni;
	@Min(value=100000,message = "El telefono debe ser mayor a 1.00.000")
	private int telefono;
	@Size(min = 3,max = 100,message = "el nombre debe tener entre 3 a 100 caracteres")
	@NotEmpty(message = "El nombre del alumno no puede estar en blanco")
	private String nombre;
	@NotBlank(message = "El apellido no puede estar en blanco")
	private String apellido; 
	@NotEmpty@Email
	private String email;

	public Alumno() {

	}

	public Alumno(long dni, int telefono, String nombre, String apellido, String email) {
		super();
		this.dni = dni;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
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
