package modelo;

import java.util.Date;

import vista.ContratoView;

public abstract class Contrato {
	
	protected int nroContrato;
	protected Cliente cliente;
	protected Auto auto;
	protected Cochera cochera;
	protected Abono abono;
	protected boolean estado;
	protected Date fecha;
	
	private static int proxNroContrato;
	
	private static int getProxNroContrato(){
		return ++proxNroContrato;
	}
	
	public Contrato(Cliente cliente, Auto auto, Cochera cochera, Abono abono,
			boolean estado, Date fecha) {
		this.nroContrato = getProxNroContrato();
		this.cliente = cliente;
		this.auto = auto;
		this.cochera = cochera;
		this.abono = abono;
		this.estado = estado;
		this.fecha = fecha;
	}
	
	public ContratoView getView()
	{
		ContratoView contratoView = new ContratoView(this.nroContrato, this.cliente.getDni(), 
				this.cliente.getNombre(), this.auto.getPatente(), this.cochera.getNumero(), 
				this.abono.getNombre(),
				this.estado, this.fecha);
		return contratoView;
	}
	
	public int getNroContrato() {
		return this.nroContrato;
	}

	public Cochera getCochera() {
		return cochera;
	}

	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
	}

	public Abono getAbono() {
		return this.abono;
	}

	public void setAbono(Abono abono) {
		this.abono = abono;
	}

	public boolean getEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Auto getAuto() {
		return this.auto;
	}
	
	public void darDeBaja() {
		this.estado = false;
	}
}
