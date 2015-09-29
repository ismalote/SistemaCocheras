package modelo;

import vista.MedioPagoView;

public class MedioPago {
	
	private String nombreEntidad;
	private String nombreArchivoEntrada;
	private String nombreArchivoSalida;
	private String direccionFTP;
	private boolean activo;
	
	public MedioPago(String nombreEntidad, String nombreArchivoEntrada,
			String nombreArchivoSalida, String direccionFTP, boolean activo) {
		this.nombreEntidad = nombreEntidad;
		this.nombreArchivoEntrada = nombreArchivoEntrada;
		this.nombreArchivoSalida = nombreArchivoSalida;
		this.direccionFTP = direccionFTP;
		this.activo = activo;
	}

	public MedioPagoView getView()
	{
		MedioPagoView medioPagoView = new MedioPagoView(this.nombreEntidad, this.nombreArchivoEntrada, 
				this.nombreArchivoSalida, this.direccionFTP, this.activo);
		return medioPagoView;
	}

	public String getNombreEntidad() {
		return this.nombreEntidad;
	}

	public void setNombreEntidad(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
	}


	public String getNombreArchivoEntrada() {
		return this.nombreArchivoEntrada;
	}


	public void setNombreArchivoEntrada(String nombreArchivoEntrada) {
		this.nombreArchivoEntrada = nombreArchivoEntrada;
	}


	public String getNombreArchivoSalida() {
		return this.nombreArchivoSalida;
	}


	public void setNombreArchivoSalida(String nombreArchivoSalida) {
		this.nombreArchivoSalida = nombreArchivoSalida;
	}


	public String getDireccionFTP() {
		return this.direccionFTP;
	}


	public void setDireccionFTP(String direccionFTP) {
		this.direccionFTP = direccionFTP;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public boolean sosMedioPago(String nombreEntidad) {
		return (this.nombreEntidad.equalsIgnoreCase(nombreEntidad));
	}
	
	public void darDeBaja() {
		this.activo = false;
	}
}
