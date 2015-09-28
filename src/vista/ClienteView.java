package vista;

//import java.util.Vector;
//import modelo.Auto;

public class ClienteView {

	private String dni;
	private String nombre;
	private String domicilio;
	private String mail;
	private String telefono;
	//private Vector<AutoView> autos;
	//private int estado;
	
	public ClienteView(String dni, String nombre, String domicilio, String mail, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.mail = mail;
		this.telefono = telefono;
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
}
