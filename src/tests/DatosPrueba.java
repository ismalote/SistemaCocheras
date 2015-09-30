package tests;

import java.util.Calendar;
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
					i * 0.1f,
					String.format("Abono %d", i),
					Tamanios.PEQUENIA,
					i,
					i * 2.0f,
					true);
			
			Abono abonoMediano = new Abono(
					i * 0.2f,
					String.format("Abono %d", i),
					Tamanios.MEDIANA,
					i,
					i * 4.0f,
					true);
			
			Abono abonoGrande = new Abono(
					i * 0.3f,
					String.format("Abono %d", i),
					Tamanios.GRANDE,
					i,
					i * 6.0f,
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
					String.format("%d-%d", i)
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
	
	public ContratoEfectivo generarContratoEfectivo(Cliente cliente, Auto auto, Cochera cochera, Abono abono) 
			throws IllegalArgumentException {

		ContratoEfectivo contrato = null;
		
		if (cliente != null && auto != null && cochera != null && abono != null) {
		
			contrato = new ContratoEfectivo(
					cliente,
					auto,
					cochera,
					abono
					);
		} else {
			throw new IllegalArgumentException("Algún argumento es nulo, vacío o inválido.");
		}
		
		return contrato;
	}
	
	public ContratoDebitoAutomatico generarContratoDebitoAutomatico(Cliente cliente, Auto auto, Cochera cochera, Abono abono,
			String cbu, String entidadBancaria) 
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
					entidadBancaria
					);
		} else {
			throw new IllegalArgumentException("Algún argumento es nulo, vacío o inválido.");
		}
		
		return contrato;
	}
	
	public ContratoTarjetaCredito generarContratoTarjetaCredito(Cliente cliente, Auto auto, Cochera cochera, Abono abono,
			String nroCuentaCorriente, String entidadBancaria) 
			throws IllegalArgumentException {

		ContratoTarjetaCredito contrato = null;
		
		if (cliente != null && auto != null && cochera != null && abono != null
				&& nroCuentaCorriente.length() > 0 && entidadBancaria.length() > 0) {
		
			contrato = new ContratoTarjetaCredito(
					cliente,
					auto,
					cochera,
					abono,
					nroCuentaCorriente,
					Calendar.getInstance().getTime(),
					entidadBancaria
					);
		} else {
			throw new IllegalArgumentException("Algún argumento es nulo, vacío o inválido.");
		}
		
		return contrato;
	}
	
	public ContratoCheque generarContratoCheque(Cliente cliente, Auto auto, Cochera cochera, Abono abono,
			String nroCuentaCorriente, String entidadBancaria) 
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
					entidadBancaria
					);
		} else {
			throw new IllegalArgumentException("Algún argumento es nulo, vacío o inválido.");
		}
		
		return contrato;
	}
}
