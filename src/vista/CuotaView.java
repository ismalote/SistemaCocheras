package vista;

import java.util.Date;
import java.util.Vector;

import utils.FechaUtils;

public class CuotaView {
	private int nroContrato;
	private Date fechaGeneracion;
	private Date fechaVencimiento;
	private float monto;
	private Date fechaPago;
	
	public CuotaView(int nroContrato, Date fechaGeneracion, Date fechaVencimiento, float monto, Date fechaPago) {
		this.nroContrato = nroContrato;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaVencimiento = fechaVencimiento;
		this.monto = monto;
		this.fechaPago = fechaPago;
	}
	
	public int getNroContrato() {
		return this.nroContrato;
	}
	
	public Date getFechaGeneracion() {
		return this.fechaGeneracion;
	}
	
	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}	
	
	public Date getFechaPago() {
		return this.fechaPago;
	}
	
	public float getMonto() {
		return this.monto;
	}
	
	public Vector<String> toVector()
	{
		Vector<String> v = new Vector<String>();
		v.add(Integer.toString(nroContrato));
		v.add(FechaUtils.formatearFecha(fechaGeneracion));		
		v.add(FechaUtils.formatearFecha(fechaVencimiento));		
		v.add(Float.toString(monto));
		v.add(FechaUtils.formatearFecha(fechaPago));
		return v;
	}
}
