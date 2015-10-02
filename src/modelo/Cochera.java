package modelo;

import vista.CocheraView;
import enums.EstadosCochera;

public class Cochera {
	
	private int numero;
	private int tamanioVehiculoAdmitido;
	private int estado;
	
	private static int proxNumeroCochera;
	
	private static int getProxNumeroCochera(){
		return ++proxNumeroCochera;
	}

	public Cochera(int tamanioVehiculoAdmitido) {
		this.numero = getProxNumeroCochera();
		this.tamanioVehiculoAdmitido = tamanioVehiculoAdmitido;
		this.estado = EstadosCochera.LIBRE;
	}
	
	public CocheraView getView()
	{
		CocheraView cocheraView = new CocheraView(this.numero, this.tamanioVehiculoAdmitido,
				this.estado);
		return cocheraView;
	}

	public int getTamanioVehiculoAdmitido() {
		return tamanioVehiculoAdmitido;
	}

	public void setTamanioVehiculoAdmitido(int tamanioVehiculoAdmitido) {
		this.tamanioVehiculoAdmitido = tamanioVehiculoAdmitido;
	}

	public boolean estaOcupada() {
		return (this.estado == EstadosCochera.OCUPADA);
	}
	
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}
	
	public boolean sosCochera(int numero) {
		return (this.numero == numero);
	}
	
	public void darDeBaja() {
		this.estado = EstadosCochera.INACTIVA;
	}
}
