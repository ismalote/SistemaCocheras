package controlador;

import java.util.Vector;

import modelo.*;
import enums.*;
import vista.*;

public class SistemaCocheras {
	
	/*********** Región: INICIALIZACIÓN ***********/ 
	
	private Vector<Contrato> contratos;
	private Vector<Cliente> clientes;
	private Vector<MedioPago> mediosPagos;
	private Vector<Cochera> cocheras;
	private Vector<Abono> abonos;
	
	public SistemaCocheras() {
		this.contratos = new Vector<Contrato>();
		this.clientes = new Vector<Cliente>();
		this.mediosPagos = new Vector<MedioPago>();
		this.cocheras = new Vector<Cochera>();
		this.abonos = new Vector<Abono>();
	}
	
	/*********** Fin Región: INICIALIZACIÓN ***********/ 
	

	/*********** Región: CLIENTES ***********/ 
	
	public int crearCliente(String dni, String nombre, String domicilio, String mail, String telefono){
		
		if(this.validarCliente(dni, nombre, domicilio, mail, telefono)) {
			Cliente cliente = buscarCliente(dni);
			
			if(cliente == null){
				cliente = new Cliente(dni, nombre, domicilio, mail, telefono);
				this.clientes.add(cliente);
				return ExitCodes.OK;
			} else {
				return ExitCodes.YA_EXISTE_ENTIDAD;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	private boolean validarCliente(String dni, String nombre, String domicilio, String mail, 
			String telefono) {
		return (dni.length() > 0 && nombre.length() > 0 && 
				domicilio.length() > 0 && mail.length() > 0); 
	}
	
	
	public int modificarCliente(String dni, String nombre, String domicilio, String mail, 
			String telefono, int estado) {

		Cliente cliente = buscarCliente(dni);

		if (cliente != null) {
			if (this.validarCliente(dni, nombre, domicilio, mail, telefono)) {
				cliente.setNombre(nombre);
				cliente.setDomicilio(domicilio);
				cliente.setMail(mail);
				cliente.setTelefono(telefono);
				cliente.setEstado(estado);
				return ExitCodes.OK;
			} else {
				return ExitCodes.ARGUMENTOS_INVALIDOS;
			}
		} else {
			return ExitCodes.NO_EXISTE_ENTIDAD;
		}
	}
	
	public int bajaCliente(String dni) {
		
		if(dni.length() > 0) {
			Cliente cliente = buscarCliente(dni);
			
			if(cliente != null){
				cliente.darDeBaja();
				return ExitCodes.OK;
			} else {
				return ExitCodes.NO_EXISTE_ENTIDAD;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	private Cliente buscarCliente(String dni){
		Cliente c = null;
		
		if(this.clientes != null && this.clientes.size() > 0) {
			for(Cliente cte: this.clientes){
				if(cte.sosCliente(dni)){
					c = cte;
				}
			}
		}
		return c;
	}
	
	public ClienteView buscarDatosCliente(String dni) {
		ClienteView clienteView = null;
		
		Cliente cliente = this.buscarCliente(dni);
		
		if (cliente != null)
		{
			clienteView = cliente.getView();
		}
		
		return clienteView;
	}
	
	public Vector<Contrato> buscarContratosVigentes(String dni){
		Vector<Contrato> contratosVigentes = new Vector<Contrato>();
		
		if (this.contratos != null && this.contratos.size() > 0) {
			for(Contrato c: this.contratos) {
					Cliente cte = c.getCliente();
					if (cte != null && cte.sosCliente(dni)) {
						if (c.getEstado()) {
							contratosVigentes.add(c);
						}
					}
				}
		}
		
		// Si encuentro contratos vigentes del cliente, retorno la colección;
		// caso contrario, retorno null.
		return (contratosVigentes.capacity() != 0 ? contratosVigentes : null);
	}
	
	/*********** Fin Región: CLIENTES ***********/ 
	
	
	/*********** Región: MEDIOS DE PAGO ***********/ 
	
	public int crearMedioPago(String nombreEntidad, String nombreArchivoEntrada,
			String nombreArchivoSalida, String direccionFTP) {
		if (this.validarMedioPago(nombreEntidad, nombreArchivoEntrada, nombreArchivoSalida, direccionFTP)) {
			
			MedioPago medioPago = buscarMedioPago(nombreEntidad);
			
			if(medioPago == null){
				medioPago = new MedioPago(nombreEntidad, nombreArchivoEntrada, nombreArchivoSalida, direccionFTP, true);
				this.mediosPagos.add(medioPago);
				return ExitCodes.OK;
			} else {
				return ExitCodes.NO_EXISTE_ENTIDAD;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	private boolean validarMedioPago(String nombreEntidad, String nombreArchivoEntrada,
			String nombreArchivoSalida, String direccionFTP) {
		return (nombreEntidad.length() > 0 && nombreArchivoEntrada.length() > 0 && 
				nombreArchivoSalida.length() > 0 && direccionFTP.length() > 0); 
	}
	
	private MedioPago buscarMedioPago(String nombreEntidad) {
		MedioPago medioPago = null;
		
		if (this.mediosPagos != null && this.mediosPagos.size() > 0) {
			for (MedioPago m: this.mediosPagos) {
				if (m.sosMedioPago(nombreEntidad)) {
					medioPago = m;
				}
			}
		}
		
		return medioPago;
	}
	
	public int eliminarMedioPago(String nombreEntidad){
		MedioPago medioPago = this.buscarMedioPago(nombreEntidad);
		
		if(medioPago != null) {
			medioPago.darDeBaja();
		
			return ExitCodes.OK;
		}
		else {
			return ExitCodes.NO_EXISTE_ENTIDAD;
		}
	}
	
	/*********** Fin Región: MEDIOS DE PAGO ***********/ 

}
