package vista;

import java.util.Vector;

public class ClienteView {

	private String dni;
	private String nombre;
	private String domicilio;
	private String mail;
	private String telefono;
	//private Vector<AutoView> autos;
	private int estado;
	
	public ClienteView(String dni, String nombre, String domicilio, String mail, String telefono, int estado) {
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.mail = mail;
		this.telefono = telefono;
		this.estado = estado;
	}
	
	public String getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public String getMail() {
		return this.mail;
	}
	
	public String getTelefono() {
		return this.telefono;
	}

	public int getEstado() {
		return this.estado;
	}
	
	public Vector<String> toVector()
	{
		Vector<String> v = new Vector<String>();
		v.add(dni);		
		v.add(nombre);		
		v.add(domicilio);
		v.add(telefono);
		v.add(mail);
		String est = "";
		switch(estado){
			case 1:
				est = "Activo";
				break;
			case 2:
				est = "Inactivo";
				break;
			default:
				est = "Con deuda";
				break;
		}
		v.add(est);
		return v;
	}
}
