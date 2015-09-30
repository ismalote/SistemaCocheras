package modelo;

import java.util.Date;
import vista.AutoView;

public class Auto {
	
	private String patente;
	private String marca;
	private Date fechaEntrada;
	private String modelo;
	private boolean activo;
	
	public Auto(String patente, String marca, Date fechaEntrada, String modelo) {
		this.patente = patente;
		this.marca = marca;
		this.fechaEntrada = fechaEntrada;
		this.modelo = modelo;
		this.activo = true;
	}
	
	public AutoView getView() {
		AutoView autoView = new AutoView(this.patente, this.marca, this.fechaEntrada, 
				this.modelo, this.activo);
		return autoView;
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
		return this.fechaEntrada;
	}
	
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public boolean sosAuto(String patente) {
		return (this.patente.equalsIgnoreCase(patente));
	}
	
	public void darDeBaja() {
		this.activo = false;
	}
}
