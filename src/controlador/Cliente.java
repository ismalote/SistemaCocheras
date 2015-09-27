package controlador;

import java.util.Vector;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String domicilio;
	private String mail;
	private String telefono;
	private Vector<Auto> autos;
	private int estado;
	
	public Cliente(String dni, String nombre, String domicilio, String mail,
			String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.mail = mail;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Vector<Auto> getAutos() {
		return autos;
	}

	public void setAutos(Vector<Auto> autos) {
		this.autos = autos;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getDni() {
		return dni;
	}
	
}
