package modelo;

import java.util.Date;

public class ContratoEfectivo extends Contrato {

	public ContratoEfectivo(Cliente cliente, Auto auto, Cochera cochera,
			Abono abono, boolean estado, Date fecha) {
		super(cliente, auto, cochera, abono, estado, fecha);
	}

}
