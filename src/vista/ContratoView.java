package vista;

import java.util.Date;
import java.util.Vector;

import utils.FechaUtils;

public class ContratoView {
	private int nroContrato;
	private String dniCliente;
	private String nombreCliente;
	private String patenteAuto;
	private int nroCochera;
	private String abono;
	private boolean estado;
	private Date fecha;
	
	public ContratoView(int nroContrato, String dniCliente, String nombreCliente, 
			String patenteAuto, int nroCochera, String abono, boolean estado, Date fecha) {
		this.nroContrato = nroContrato;
		this.dniCliente = dniCliente;
		this.nombreCliente = nombreCliente;
		this.patenteAuto = patenteAuto;
		this.nroCochera = nroCochera;
		this.abono = abono;
		this.estado = estado;
		this.fecha = fecha;
	}
	
	public int getNroContrato() {
		return this.nroContrato;
	}
	
	public String getDniCliente() {
		return this.dniCliente;
	}
	
	public String getNombreCliente() {
		return this.nombreCliente;
	}
	
	public String getPatenteAuto() {
		return this.patenteAuto;
	}
	
	public int getNroCochera() {
		return this.nroCochera;
	}
	
	public String getAbono() {
		return this.abono;
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
	
	public Vector<String> toVector()
	{
		Vector<String> v = new Vector<String>();
		v.add(Integer.toString(nroContrato));		
		v.add(FechaUtils.formatearFecha(fecha));		
		v.add(patenteAuto);
		v.add(Integer.toString(nroCochera));
		v.add(abono);
		String est = "";
		est = (estado == true) ? "Vigente" : "No vigente";
		v.add(est);
		return v;
	}
}
