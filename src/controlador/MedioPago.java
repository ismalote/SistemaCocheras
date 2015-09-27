package controlador;

public class MedioPago {
	
	private String nombreEntidad;
	private String nombreArchivoEntrada;
	private String nombreArchivoSalida;
	private String direccionFTP;
	
	
	public MedioPago(String nombreEntidad, String nombreArchivoEntrada,
			String nombreArchivoSalida, String direccionFTP) {
		super();
		this.nombreEntidad = nombreEntidad;
		this.nombreArchivoEntrada = nombreArchivoEntrada;
		this.nombreArchivoSalida = nombreArchivoSalida;
		this.direccionFTP = direccionFTP;
	}


	public String getNombreEntidad() {
		return nombreEntidad;
	}


	public void setNombreEntidad(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
	}


	public String getNombreArchivoEntrada() {
		return nombreArchivoEntrada;
	}


	public void setNombreArchivoEntrada(String nombreArchivoEntrada) {
		this.nombreArchivoEntrada = nombreArchivoEntrada;
	}


	public String getNombreArchivoSalida() {
		return nombreArchivoSalida;
	}


	public void setNombreArchivoSalida(String nombreArchivoSalida) {
		this.nombreArchivoSalida = nombreArchivoSalida;
	}


	public String getDireccionFTP() {
		return direccionFTP;
	}


	public void setDireccionFTP(String direccionFTP) {
		this.direccionFTP = direccionFTP;
	}
	
	
}
