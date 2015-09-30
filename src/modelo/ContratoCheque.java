package modelo;

import java.util.Date;

public class ContratoCheque extends Contrato {

	public ContratoCheque(Cliente cliente, Auto auto, Cochera cochera,
			Abono abono, boolean estado, Date fecha) {
		super(cliente, auto, cochera, abono, estado, fecha);
	}

}
