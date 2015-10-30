package vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

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
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		v.add(df.format(fechaEntrada));
		v.add(activo ? "Activo" : "Inactivo");
		return v;
	}
}	