package modelo;

import java.util.Vector;

import enums.EstadosCliente;
import vista.AutoView;
import vista.ClienteView;

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
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.mail = mail;
		this.telefono = telefono;
		this.estado = EstadosCliente.ACTIVO;
		this.autos = new Vector<Auto>();
	}
	
	public ClienteView getView()
	{
		Vector<AutoView> autosView = new Vector<AutoView>();
		
		if (this.autos != null && this.autos.size() > 0) {
			for(Auto a: this.autos) {
				autosView.add(a.getView());
			}
		}
		ClienteView clienteView = new ClienteView(this.dni, this.nombre, this.domicilio, this.mail, this.telefono, this.estado, autosView);
		return clienteView;
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
	
	public boolean sosCliente(String dni) {
		return (this.dni.equalsIgnoreCase(dni));
	}
	
	public void darDeBaja() {
		this.estado = EstadosCliente.INACTIVO;
	}
	
	public Auto buscarAuto(String patente) {
		Auto auto = null;
		
		if (this.autos != null && this.autos.size() > 0) {
			for (Auto a: this.autos) {
				if (a.sosAuto(patente)) {
					auto = a;
				}
			}
		}
		
		return auto;
	}
	
	public void agregarAuto(Auto auto) {
		this.autos.add(auto);
	}
}
