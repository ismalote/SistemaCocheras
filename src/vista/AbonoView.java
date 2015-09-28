package vista;

public class AbonoView {
	private float descuento;
	private String nombre;
	private int tamanioCochera;
	private int cantidadDias;
	private float precioBase;
	private boolean activo;
	
	public AbonoView(float descuento, String nombre, int tamanioCochera,
			int cantidadDias, float precioBase, boolean activo) {
		this.descuento = descuento;
		this.nombre = nombre;
		this.tamanioCochera = tamanioCochera;
		this.cantidadDias = cantidadDias;
		this.precioBase = precioBase;
		this.activo = activo;
	}
	
	public float getDescuento() {
		return this.descuento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getTamanioCochera() {
		return this.tamanioCochera;
	}

	public int getCantidadDias() {
		return this.cantidadDias;
	}
	
	public float getPrecioBase() {
		return this.precioBase;
	}

	public boolean getActivo() {
		return this.activo;
	}
}
