package vista;

import java.util.Date;

public class AutoView {
	
	private String patente;
	private String marca;
	private Date fechaEntrada;
	private String modelo;
	private boolean activo;
	
	public AutoView(String patente, String marca, Date fechaEntrada, String modelo, boolean activo) {
		this.patente = patente;
		this.marca = marca;
		this.fechaEntrada = fechaEntrada;
		this.modelo = modelo;
		this.activo = activo;
	}
	
	public String getPatente() {
		return patente;
	}
	
	public String getMarca() {
		return marca;
	}
		
	public Date getFechaEntrada() {
		return this.fechaEntrada;
	}
		
	public String getModelo() {
		return this.modelo;
	}
	
	public boolean getActivo() {
		return this.activo;
	}	
}	