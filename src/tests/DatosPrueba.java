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
		
		for (int i = 0; i < this.cantidadDatosAGenerar; i++) {
			Abono abonoPequenio = new Abono(
					0.1f,
					String.format("Abono %d", i),
					Tamanios.PEQUENIA,
					i + 10,
					(i + 10) * 2.0f,
					true);
			
			Abono abonoMediano = new Abono(
					0.2f,
					String.format("Abono %d", i),
					Tamanios.MEDIANA,
					i + 20,
					(i + 20) * 4.0f,
					true);
			
			Abono abonoGrande = new Abono(
					0.3f,
					String.format("Abono %d", i),
					Tamanios.GRANDE,
					i + 30,
					(i + 30) * 6.0f,
					true);
			
			abonos.add(abonoPequenio);
			abonos.add(abonoMediano);
			abonos.add(abonoGrande);
		}
		
		return abonos;
	}
	
	public Vector<Cliente> generarClientes() {
		Vector<Cliente> clientes = new Vector<Cliente>();
		
		for (int i = 0; i < this.cantidadDatosAGenerar; i++) {
			
			Auto auto = new Auto(
					String.format("ABC %d", i),
					String.format("Marca %d", i),
					Calendar.getInstance().getTime(),
					String.format("Modelo %d", i)
					);
			
			Cliente cliente = new Cliente(
					Integer.toString(i),
					String.format("Nombre %d", i),
					String.format("Domicilio %d", i),
					String.format("mail%d@mail.com", i),
					String.format("%d-%d", i, i)
					);

			Vector<Auto> autos = new Vector<Auto>();
			autos.add(auto);
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
		
		for (int i = 0; i < this.cantidadDatosAGenerar; i++) {
			
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
