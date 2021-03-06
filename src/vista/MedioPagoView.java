package vista;

import java.util.Vector;

public class MedioPagoView {
	private String nombreEntidad;
	private String nombreArchivoEntrada;
	private String nombreArchivoSalida;
	private String direccionFTP;
	private boolean activo;
	
	public MedioPagoView(String nombreEntidad, String nombreArchivoEntrada, String nombreArchivoSalida,
			String direccionFTP, boolean activo) {
		this.nombreEntidad = nombreEntidad;
		this.nombreArchivoEntrada = nombreArchivoEntrada;
		this.nombreArchivoSalida = nombreArchivoSalida;
		this.direccionFTP = direccionFTP;
		this.activo = activo;
	}
	
	public String getNombreEntidad() {
		return this.nombreEntidad;
	}
	
	public String getNombreArchivoEntrada() {
		return this.nombreArchivoEntrada;
	}
	
	public String getNombreArchivoSalida() {
		return this.nombreArchivoSalida;
	}
	
	public String getDireccionFTP() {
		return this.direccionFTP;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public Vector<String> toVector()
	{
		Vector<String> v = new Vector<String>();
		v.add(nombreEntidad);		
		v.add(nombreArchivoEntrada);		
		v.add(nombreArchivoSalida);
		v.add(direccionFTP);
		v.add(activo ? "Activo" : "Inactivo");
		return v;
	}
	
}
