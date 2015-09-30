package modelo;

import vista.AbonoView;

public class Abono {
	
	private float descuento;
	private String nombre;
	private int tamanioCochera;
	private int cantidadDias;
	private float precioBase;
	private boolean activo;
	
	public Abono(float descuento, String nombre, int tamanioCochera,
			int cantidadDias, float precioBase, boolean activo) {
		super();
		this.descuento = descuento;
		this.nombre = nombre;
		this.tamanioCochera = tamanioCochera;
		this.cantidadDias = cantidadDias;
		this.precioBase = precioBase;
		this.activo = activo;
	}
	
	public AbonoView getView()
	{
		AbonoView abonoView = new AbonoView(this.descuento, this.nombre, this.tamanioCochera,
				this.cantidadDias, this.precioBase, this.activo);
		return abonoView;
	}

	public float getDescuento() {
		return this.descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTamanioCochera() {
		return this.tamanioCochera;
	}

	public void setTamanioCochera(int tamanioCochera) {
		this.tamanioCochera = tamanioCochera;
	}

	public int getCantidadDias() {
		return this.cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public float getPrecioBase() {
		return this.precioBase;
	}

	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}
	
	public float calcularPrecio(){
		// Precio base es por hora
		// 24 son las horas de 1 día
		// cantidadDias es la cantidad de días que dura el abono
		float precio = this.precioBase * 24 * this.cantidadDias;
		// Menos el descuento
		return precio - (precio * this.descuento);
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public boolean sosAbono(String nombre) {
		return (this.nombre.equalsIgnoreCase(nombre));
	}
	
	public void darDeBaja() {
		this.activo = false;
	}
}
