package controlador;

public class Cochera {
	
	private int tamanioVehiculoAdmitido;
	private Abono abono;
	private boolean ocupada;
	private int numero;
	
	private static int proxNumeroCochera;
	
	private static int getProxNumeroCochera(){
		return ++proxNumeroCochera;
	}

	public Cochera(int tamanioVehiculoAdmitido, Abono abono, boolean ocupada) {
		super();
		this.tamanioVehiculoAdmitido = tamanioVehiculoAdmitido;
		this.abono = abono;
		this.ocupada = ocupada;
		this.numero = getProxNumeroCochera();
	}

	public int getTamanioVehiculoAdmitido() {
		return tamanioVehiculoAdmitido;
	}

	public void setTamanioVehiculoAdmitido(int tamanioVehiculoAdmitido) {
		this.tamanioVehiculoAdmitido = tamanioVehiculoAdmitido;
	}

	public Abono getAbono() {
		return abono;
	}

	public void setAbono(Abono abono) {
		this.abono = abono;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public int getNumero() {
		return numero;
	}
	
}
