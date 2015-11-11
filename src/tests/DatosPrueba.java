package tests;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import enums.*;
import modelo.*;

public class DatosPrueba {
			
	private int cantidadDatosAGenerar;

	public DatosPrueba(int cantidadDatosAGenerar) throws IllegalArgumentException {
		if (cantidadDatosAGenerar > 0) {
			this.cantidadDatosAGenerar = cantidadDatosAGenerar;
		} else {
			throw new IllegalArgumentException("La cantidad de datos a generar es inválida.");
		}
		
	}
	
	public Vector<Abono> generarAbonos() {
		Vector<Abono> abonos = new Vector<Abono>();
		int i = 1, cont = 1;
		while(i <= this.cantidadDatosAGenerar) {
			String tipo = "Diaria";
			int cantDias = 1;
			float descuento = (float) 0.0;
			if(i%2 == 0){
				tipo = "Semestral";
				cantDias = 180;
				descuento = (float) 0.05;
			}
			if(i%3 == 0){
				tipo = "Anual";
				cantDias = 365;
				descuento = (float) 0.1;
			}
			Abono abonoPequenio = new Abono(
					descuento,
					String.format("(%d) " + tipo + " - " + Tamanios.getDescripcion(Tamanios.PEQUENIA), cont),
					Tamanios.PEQUENIA,
					cantDias,
					2.5f,
					true);
			cont++;
			Abono abonoMediano = new Abono(
					descuento,
					String.format("(%d) " + tipo + " - " + Tamanios.getDescripcion(Tamanios.MEDIANA), cont),
					Tamanios.MEDIANA,
					cantDias,
					3.0f,
					true);
			cont++;
			Abono abonoGrande = new Abono(
					descuento,
					String.format("(%d) " + tipo + " - " + Tamanios.getDescripcion(Tamanios.GRANDE), cont),
					Tamanios.GRANDE,
					cantDias,
					3.5f,
					true);
			cont++;
			i++;
			abonos.add(abonoPequenio);
			abonos.add(abonoMediano);
			abonos.add(abonoGrande);
		}
		
		return abonos;
	}
	
	public Vector<Cliente> generarClientes() {
		Vector<Cliente> clientes = new Vector<Cliente>();
		//Calendar fecha = Calendar.getInstance();
		//fecha.setTime(FechaUtils.getFechaActual());
		//fecha.add(Calendar.DAY_OF_YEAR, -4);
		for (int i = 1; i <= this.cantidadDatosAGenerar; i++) {
			
			Auto auto1 = new Auto(
					String.format("ABC 12%d", i),
					String.format("Chevrolet"),
					Calendar.getInstance().getTime(),
					String.format("Corsa")
					);
			
			Auto auto2 = new Auto(
					String.format("JKL 34%d", i),
					String.format("Ford", i),
					Calendar.getInstance().getTime(),
					String.format("Fiesta", i)
					);
			
			Auto auto3 = new Auto(
					String.format("XYZ 56%d", i),
					String.format("Volkswagen"),
					Calendar.getInstance().getTime(),
					String.format("Fox")
					);
			
			Auto auto4 = new Auto(
					String.format("WKI 99%d", i),
					String.format("Fiat"),
					Calendar.getInstance().getTime(),
					String.format("600")
					);
			
			
			Cliente cliente = new Cliente(
					Integer.toString(i),
					String.format("Juan Perez %d", i),
					String.format("Av. Rivadavia 341%d", i),
					String.format("mail%d@mail.com", i),
					String.format("%d567-%d114", i, i)
					);		
			
			Vector<Auto> autos = new Vector<Auto>();
			autos.add(auto1);
			autos.add(auto2);
			autos.add(auto3);
			autos.add(auto4);
			cliente.setAutos(autos);
			clientes.add(cliente);
		}
		
		return clientes;
	}
	
	public Vector<Cochera> generarCocheras() {
		Vector<Cochera> cocheras = new Vector<Cochera>();
		
		for (int i = 0; i < this.cantidadDatosAGenerar; i++) {
			Cochera cocheraPequenia = new Cochera(Tamanios.PEQUENIA);
			
			Cochera cocheraMediana = new Cochera(Tamanios.MEDIANA);
			
			Cochera cocheraGrande = new Cochera(Tamanios.GRANDE);
			
			cocheras.add(cocheraPequenia);
			cocheras.add(cocheraMediana);
			cocheras.add(cocheraGrande);
		}
		
		return cocheras;
	}
	
	public Vector<MedioPago> generarMediosPagos() {
		Vector<MedioPago> mediosPagos = new Vector<MedioPago>();
		
		for (int i = 1; i <= this.cantidadDatosAGenerar; i++) {
			
			MedioPago medioPago = new MedioPago(
					String.format("Entidad %d", i),
					String.format("Archivo entrada %d", i),
					String.format("Archivo salida %d", i),
					String.format("FTP %d", i)
					);
		
			mediosPagos.add(medioPago);
		}
		
		return mediosPagos;
	}
	
	public ContratoEfectivo generarContratoEfectivo(Cliente cliente, Auto auto, Cochera cochera, Abono abono, Date fecha) 
			throws IllegalArgumentException {

		ContratoEfectivo contrato = null;
		
		if (cliente != null && auto != null && cochera != null && abono != null) {
		
			contrato = new ContratoEfectivo(
					cliente,
					auto,
					cochera,
					abono,
					fecha
					);
		} else {
			throw new IllegalArgumentException("Algún argumento es nulo, vacío o inválido.");
		}
		
		return contrato;
	}
	
	public ContratoDebitoAutomatico generarContratoDebitoAutomatico(Cliente cliente, Auto auto, Cochera cochera, Abono abono,
			String cbu, String entidadBancaria, Date fecha) 
			throws IllegalArgumentException {

		ContratoDebitoAutomatico contrato = null;
		
		if (cliente != null && auto != null && cochera != null && abono != null
				&& cbu.length() > 0 && entidadBancaria.length() > 0) {
		
			contrato = new ContratoDebitoAutomatico(
					cliente,
					auto,
					cochera,
					abono,
					cbu,
					entidadBancaria,
					fecha
					);
		} else {
			throw new IllegalArgumentException("Algún argumento es nulo, vacío o inválido.");
		}
		
		return contrato;
	}
	
	public ContratoTarjetaCredito generarContratoTarjetaCredito(Cliente cliente, Auto auto, Cochera cochera, Abono abono,
			String nroTarjeta, Date vencimientoTarjeta, String entidadTarjeta, Date fecha) 
			throws IllegalArgumentException {

		ContratoTarjetaCredito contrato = null;
		
		if (cliente != null && auto != null && cochera != null && abono != null
				&& nroTarjeta.length() > 0 && vencimientoTarjeta != null && entidadTarjeta.length() > 0) {
		
			contrato = new ContratoTarjetaCredito(
					cliente,
					auto,
					cochera,
					abono,
					nroTarjeta,
					vencimientoTarjeta,
					entidadTarjeta,
					fecha
					);
		} else {
			throw new IllegalArgumentException("Algún argumento es nulo, vacío o inválido.");
		}
		
		return contrato;
	}
	
	public ContratoCheque generarContratoCheque(Cliente cliente, Auto auto, Cochera cochera, Abono abono,
			String nroCuentaCorriente, String entidadBancaria, Date fecha) 
			throws IllegalArgumentException {

		ContratoCheque contrato = null;
		
		if (cliente != null && auto != null && cochera != null && abono != null
				&& nroCuentaCorriente.length() > 0 && entidadBancaria.length() > 0) {
		
			contrato = new ContratoCheque(
					cliente,
					auto,
					cochera,
					abono,
					nroCuentaCorriente,
					entidadBancaria,
					fecha
					);
		} else {
			throw new IllegalArgumentException("Algún argumento es nulo, vacío o inválido.");
		}
		
		return contrato;
	}
}
