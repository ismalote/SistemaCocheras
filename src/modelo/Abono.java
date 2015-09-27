package modelo;

public class Abono {
	
	private float descuento;
	private String nombre;
	private int tamanioCochera;
	private int cantidadDias;
	private float precioBase;
	
	public Abono(float descuento, String nombre, int tamanioCochera,
			int cantidadDias, float precioBase) {
		super();
		this.descuento = descuento;
		this.nombre = nombre;
		this.tamanioCochera = tamanioCochera;
		this.cantidadDias = cantidadDias;
		this.precioBase = precioBase;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTamanioCochera() {
		return tamanioCochera;
	}

	public void setTamanioCochera(int tamanioCochera) {
		this.tamanioCochera = tamanioCochera;
	}

	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}
	
	public float calcularPrecio(){
		return (precioBase-descuento);
	}
	
	
}
