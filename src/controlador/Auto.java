package controlador;

import java.util.Date;

public class Auto {
	
	private String patente;
	private String marca;
	private Date fechaEntrada;
	public Auto(String patente, String marca, Date fechaEntrada) {
		super();
		this.patente = patente;
		this.marca = marca;
		this.fechaEntrada = fechaEntrada;
	}
	
	public String getPatente() {
		return patente;
	}
	
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	
	
}
