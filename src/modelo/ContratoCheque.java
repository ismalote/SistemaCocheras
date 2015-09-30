package modelo;

public class ContratoCheque extends Contrato {

	private String nroCuentaCorriente;
	private String entidadBancaria;
	
	public ContratoCheque(Cliente cliente, Auto auto, Cochera cochera, Abono abono, 
			String nroCuentaCorriente, String entidadBancaria) {
		super(cliente, auto, cochera, abono);
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
