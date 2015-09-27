package controlador;

public class Contrato {
	
	protected Cliente cliente;
	protected Auto auto;
	protected Cochera cochera;
	protected Abono abono;
	protected boolean estado;
	
	public Contrato(Cliente cliente, Auto auto, Cochera cochera, Abono abono,
			boolean estado) {
		super();
		this.cliente = cliente;
		this.auto = auto;
		this.cochera = cochera;
		this.abono = abono;
		this.estado = estado;
	}

	public Cochera getCochera() {
		return cochera;
	}

	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
	}

	public Abono getAbono() {
		return abono;
	}

	public void setAbono(Abono abono) {
		this.abono = abono;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Auto getAuto() {
		return auto;
	}
	
	
	
}
