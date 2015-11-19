package modelo;

import java.util.Calendar;
import java.util.Date;

import vista.CuotaView;

public class Cuota {
	private int nroContrato;
	private Date fechaGeneracion;
	private Date fechaVencimiento;
	private float monto;
	private Date fechaPago;
	
	public Cuota(int nroContrato, Date fechaVencimiento, float monto) {
		this.nroContrato = nroContrato;
		this.fechaGeneracion = Calendar.getInstance().getTime();
		this.fechaVencimiento = fechaVencimiento;
		this.monto = monto;
		this.fechaPago = null;
	}
	
	public CuotaView getView()
	{
		CuotaView cuotaView = new CuotaView(this.nroContrato, this.fechaGeneracion, this.fechaVencimiento, this.monto, this.fechaPago);
		return cuotaView;
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
	
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public Date getFechaPago() {
		return this.fechaPago;
	}
	
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	public float getMonto() {
		return this.monto;
	}
	
	public void setMonto(float monto) {
		this.monto = monto;
	}	
}
