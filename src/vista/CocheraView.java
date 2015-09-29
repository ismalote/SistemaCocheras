package vista;

public class CocheraView {
	private int numero;
	private int tamanioVehiculoAdmitido;
	private int estado;
	
	public CocheraView(int numero, int tamanioVehiculoAdmitido, int estado) {
		this.numero = numero;
		this.tamanioVehiculoAdmitido = tamanioVehiculoAdmitido;
		this.estado = estado;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public int getTamanioVechiculoAdmitido() {
		return this.tamanioVehiculoAdmitido;
	}
	
	public int getEstado() {
		return this.estado;
	}
}
