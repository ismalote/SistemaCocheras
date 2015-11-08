package vista;

import java.util.Vector;

import enums.EstadosCochera;

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
	
	public Vector<String> toVector()
	{
		Vector<String> v = new Vector<String>();
		v.add(Integer.toString(numero));		
		String tamanio = "";
		switch(tamanioVehiculoAdmitido){
			case 1:
				tamanio = "Pequena";
				break;
			case 2:
				tamanio = "Mediana";
				break;
			default:
				tamanio = "Grande";
				break;
		}
		v.add(tamanio);
		v.add(EstadosCochera.getEstado(estado));
		return v;
	}
	
}
