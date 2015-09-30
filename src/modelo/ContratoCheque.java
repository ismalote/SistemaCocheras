package modelo;

import java.util.Date;

public class ContratoCheque extends Contrato {

	private String nroCuentaCorriente;
	private String entidadBancaria;
	
	public ContratoCheque(Cliente cliente, Auto auto, Cochera cochera,
			Abono abono, boolean estado, Date fecha, String nroCuentaCorriente, String entidadBancaria) {
		super(cliente, auto, cochera, abono, estado, fecha);
		this.setNroCuentaCorriente(nroCuentaCorriente);
		this.setEntidadBancaria(entidadBancaria);
	}

	public String getNroCuentaCorriente() {
		return this.nroCuentaCorriente;
	}

	public void setNroCuentaCorriente(String nroCuentaCorriente) {
		this.nroCuentaCorriente = nroCuentaCorriente;
	}

	public String getEntidadBancaria() {
		return this.entidadBancaria;
	}

	public void setEntidadBancaria(String entidadBancaria) {
		this.entidadBancaria = entidadBancaria;
	}
}
