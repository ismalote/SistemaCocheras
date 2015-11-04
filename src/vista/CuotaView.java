package vista;

import java.util.Date;

public class CuotaView {
	private Date fechaGeneracion;
	private Date fechaVencimiento;
	private float monto;
	private Date fechaPago;
	
	public CuotaView(Date fechaGeneracion, Date fechaVencimiento, float monto, Date fechaPago) {
		this.fechaGeneracion = fechaGeneracion;
		this.fechaVencimiento = fechaVencimiento;
		this.monto = monto;
		this.fechaPago = fechaPago;
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
	
}
