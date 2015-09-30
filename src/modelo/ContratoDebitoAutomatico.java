package modelo;

public class ContratoDebitoAutomatico extends Contrato {

	private String cbu;
	private String entidadBancaria;
	
	public ContratoDebitoAutomatico(Cliente cliente, Auto auto, Cochera cochera, Abono abono, 
			String cbu, String entidadBancaria) {
		super(cliente, auto, cochera, abono);
		this.setCbu(cbu);
		this.setEntidadBancaria(entidadBancaria);
	}

	public String getCbu() {
		return this.cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public String getEntidadBancaria() {
		return this.entidadBancaria;
	}

	public void setEntidadBancaria(String entidadBancaria) {
		this.entidadBancaria = entidadBancaria;
	}
}
