package controlador;

import java.util.Hashtable;
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
			
			if(cliente != null) {
				Vector<Contrato> contratosVigentes = this.buscarContratos(dni, true);
				
				if (contratosVigentes == null)
				{
					cliente.darDeBaja();
					return ExitCodes.OK;
				}
				else {
					return ExitCodes.CLIENTE_CONTRATOS_VIGENTES;
				}
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
	
	public Vector<ClienteView> listarClientes(){
		Vector<ClienteView> clientesView = new Vector<ClienteView>();

		if(this.clientes != null && this.clientes.size() > 0){
			for (Cliente c: this.clientes) {
				clientesView.add(c.getView());
			}
		}
		
		return clientesView;
	}
	
	public Vector<Contrato> buscarContratos(String dni, boolean vigentes){
		Vector<Contrato> contratosCliente = new Vector<Contrato>();
		
		if (this.contratos != null && this.contratos.size() > 0) {
			for(Contrato c: this.contratos) {
					Cliente cte = c.getCliente();
					if (cte != null && cte.sosCliente(dni)) {
						if (vigentes) {
							if (c.getEstado()) {
								contratosCliente.add(c);
							}
						}
						else {
							contratosCliente.add(c);
						}
					}
				}
		}

		return (contratosCliente.size() != 0 ? contratosCliente : null);
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
	
	public Vector<MedioPagoView> listarMediosPagos(){
		Vector<MedioPagoView> mediosPagoView = new Vector<MedioPagoView>();

		if(this.mediosPagos != null && this.mediosPagos.size() > 0){
			for (MedioPago mp: this.mediosPagos) {
				mediosPagoView.add(mp.getView());
			}
		}
		
		return mediosPagoView;
	}
	
	/*********** Fin Región: MEDIOS DE PAGO ***********/ 

	
	/*********** Región: ABONOS ***********/ 
	
	public int crearAbono(String nombre, int cantidadDias, float precioBase, float descuento, int tamanioCochera){
		
		if(this.validarAbono(nombre, cantidadDias, precioBase, descuento, tamanioCochera)) {
			Abono abono = buscarAbono(nombre);
			
			if(abono == null){
				abono = new Abono(descuento, nombre, tamanioCochera, cantidadDias, precioBase, true);
				this.abonos.add(abono);
				return ExitCodes.OK;
			} else {
				return ExitCodes.YA_EXISTE_ENTIDAD;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	private boolean validarAbono(String nombre, int cantidadDias, float precioBase, 
			float descuento, int tamanioCochera) {
		return (nombre.length() > 0 && cantidadDias > 0 && precioBase > 0 &&
				descuento > 0 && (tamanioCochera > 0 && tamanioCochera < 4)); 
	}
	
	
	public int modificarAbono(String nombre, int cantidadDias, float precioBase, float descuento, int tamanioCochera) {

		Abono abono = buscarAbono(nombre);

		if (abono != null) {
			if (this.validarAbono(nombre, cantidadDias, precioBase, descuento, tamanioCochera)) {
				abono.setCantidadDias(cantidadDias);
				abono.setPrecioBase(precioBase);
				abono.setTamanioCochera(tamanioCochera);
				abono.setDescuento(descuento);
				return ExitCodes.OK;
			} else {
				return ExitCodes.ARGUMENTOS_INVALIDOS;
			}
		} else {
			return ExitCodes.NO_EXISTE_ENTIDAD;
		}
	}
	
	public int bajaAbono(String nombre) {

		if (nombre.length() > 0) {
			Abono abono = buscarAbono(nombre);

			if (abono != null) {
				abono.darDeBaja();
				return ExitCodes.OK;
			} else {
				return ExitCodes.NO_EXISTE_ENTIDAD;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}

	private Abono buscarAbono(String nombre){
		Abono a = null;
		
		if(this.abonos != null && this.abonos.size() > 0) {
			for(Abono abono: this.abonos){
				if(abono.sosAbono(nombre)){
					a = abono;
				}
			}
		}
		return a;
	}
	
	public AbonoView buscarDatosAbono(String nombre) {
		AbonoView abonoView = null;
		
		Abono abono = this.buscarAbono(nombre);
		
		if (abono != null)
		{
			abonoView = abono.getView();
		}
		
		return abonoView;
	}
	
	public Vector<AbonoView> listarAbonos(){
		Vector<AbonoView> abonosView = new Vector<AbonoView>();

		if(this.abonos != null && this.abonos.size() > 0){
			for (Abono a: this.abonos) {
				abonosView.add(a.getView());
			}
		}
		
		return abonosView;
	}
	
	/*********** Fin Región: ABONOS ***********/ 
	
	
	/*********** Región: CONTRATOS ***********/ 
	
	public int crearContrato() {
		
		return -1;
	}
	
	public int modificarContrato(int nroContrato, String abono) {
		
		Contrato contrato = buscarContrato(nroContrato);

		if (contrato != null) {
			Abono abonoNuevo = this.buscarAbono(abono);
			
			if (abonoNuevo != null) {
				contrato.setAbono(abonoNuevo);
				return ExitCodes.OK;
			} else {
				return ExitCodes.ARGUMENTOS_INVALIDOS;
			}
		} else {
			return ExitCodes.NO_EXISTE_ENTIDAD;
		}
	}
	
	public Hashtable<Integer, ContratoView> buscarDatosContratosVigentes(String dni) {
		Hashtable<Integer, ContratoView> contratosCliente = new Hashtable<Integer, ContratoView>();
		Integer indice = 0;
			
		Vector<Contrato> contratosVigentes = this.buscarContratos(dni, true);
		
		if(contratosVigentes != null && contratosVigentes.size() > 0) {
			for(Contrato contrato: contratosVigentes){
				contratosCliente.put(++indice, contrato.getView());
			}
		}
		
		return (contratosCliente.size() != 0 ? contratosCliente : null);
	}
	
	public int bajaContrato(int nroContrato) {
		if (nroContrato > 0) {
			Contrato contrato = buscarContrato(nroContrato);

			if (contrato != null) {
				contrato.darDeBaja();
				return ExitCodes.OK;
			} else {
				return ExitCodes.NO_EXISTE_ENTIDAD;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	private Contrato buscarContrato(int nroContrato){
		Contrato c = null;
		
		if(this.contratos != null && this.contratos.size() > 0) {
			for(Contrato contrato: this.contratos){
				if(contrato.getNroContrato() == nroContrato){
					c = contrato;
				}
			}
		}
		return c;
	}
	
	public Vector<ContratoView> listarContratos(String dni){
		Vector<ContratoView> contratosView = new Vector<ContratoView>();
		
		Vector<Contrato> contratosCliente = this.buscarContratos(dni, false);
		
		if(contratosCliente != null && contratosCliente.size() > 0) {
			for (Contrato c: contratosCliente) {
				contratosView.add(c.getView());
			}
		}
		
		return contratosView;
	}
	
	/*********** Fin Región: CONTRATOS ***********/ 
	
	
	/*********** Región: COCHERAS ***********/ 
	
	public int crearCochera(int tamanioVehiculoAdmitido) {
		
		if(this.validarCochera(tamanioVehiculoAdmitido, EstadosCochera.LIBRE)) {
				Cochera cochera = new Cochera(tamanioVehiculoAdmitido, EstadosCochera.LIBRE);
				this.cocheras.add(cochera);
				return ExitCodes.OK;
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	private boolean validarCochera(int tamanioVehiculoAdmitido, int estado) {
		return ((tamanioVehiculoAdmitido > 0 && tamanioVehiculoAdmitido  < 4)
				&& (estado > 0 && estado < 4)); 
	}
	
	public int modificarCochera(int numero, int tamanioVehiculoAdmitido, int estado) {

		Cochera cochera = buscarCochera(numero);

		if (cochera != null) {
			if (this.validarCochera(tamanioVehiculoAdmitido, estado)) {
				cochera.setTamanioVehiculoAdmitido(tamanioVehiculoAdmitido);
				cochera.setEstado(estado);
				return ExitCodes.OK;
			} else {
				return ExitCodes.ARGUMENTOS_INVALIDOS;
			}
		} else {
			return ExitCodes.NO_EXISTE_ENTIDAD;
		}
	}
	
	public int bajaCochera(int numero) {
		
		if(numero > 0) {
			Cochera cochera = buscarCochera(numero);
			
			if(cochera != null) {
					cochera.darDeBaja();
					return ExitCodes.OK;
			} else {
				return ExitCodes.NO_EXISTE_ENTIDAD;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	public Vector<CocheraView> listarCocheras(){
		Vector<CocheraView> cocherasView = new Vector<CocheraView>();

		if(this.cocheras != null && this.cocheras.size() > 0){
			for (Cochera c: this.cocheras) {
				cocherasView.add(c.getView());
			}
		}
		
		return cocherasView;
	}
	
	private Cochera buscarCochera(int numero){
		Cochera c = null;
		
		if(this.cocheras != null && this.cocheras.size() > 0) {
			for(Cochera cochera: this.cocheras){
				if(cochera.sosCochera(numero)){
					c = cochera;
				}
			}
		}
		return c;
	}
	
	public CocheraView buscarDatosCochera(int numero) {
		CocheraView cocheraView = null;
		
		Cochera cochera = this.buscarCochera(numero);
		
		if (cochera != null)
		{
			cocheraView = cochera.getView();
		}
		
		return cocheraView;
	}
	
	/*********** Fin Región: COCHERAS ***********/ 
}
