package modelo;

import java.util.Date;

public class ContratoTarjetaCredito extends Contrato {

	private String nroTarjeta;
	private Date vencimientoTarjeta;
	private String entidadEmisoraTarjeta;
	
	public ContratoTarjetaCredito(Cliente cliente, Auto auto, Cochera cochera, Abono abono, 
			String nroTarjeta, Date vencimientoTarjeta, String entidadEmisoraTarjeta, Date fecha) {
		super(cliente, auto, cochera, abono, fecha);
		this.setNroTarjeta(nroTarjeta);
		this.setVencimientoTarjeta(vencimientoTarjeta);
		this.setEntidadEmisoraTarjeta(entidadEmisoraTarjeta);
	}

	public String getNroTarjeta() {
		return this.nroTarjeta;
	}

	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public Date getVencimientoTarjeta() {
		return this.vencimientoTarjeta;
	}

	public void setVencimientoTarjeta(Date vencimientoTarjeta) {
		this.vencimientoTarjeta = vencimientoTarjeta;
	}

	public String getEntidadEmisoraTarjeta() {
		return this.entidadEmisoraTarjeta;
	}

	public void setEntidadEmisoraTarjeta(String entidadEmisoraTarjeta) {
		this.entidadEmisoraTarjeta = entidadEmisoraTarjeta;
	}

}
