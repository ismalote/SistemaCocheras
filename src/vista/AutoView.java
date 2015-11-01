package vista;

import java.util.Date;
import java.util.Vector;

import utils.FechaUtils;

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
	
	public Vector<String> toVector()
	{
		Vector<String> v = new Vector<String>();
		v.add(patente);		
		v.add(marca);		
		v.add(modelo);
		v.add(FechaUtils.formatearFecha(fechaEntrada));
		v.add(activo ? "Activo" : "Inactivo");
		return v;
	}
}	