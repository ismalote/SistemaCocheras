package controlador;

import java.util.Calendar;
import java.util.Date;
//import java.util.Random;
import java.util.Vector;

import modelo.*;
import enums.*;
import tests.DatosPrueba;
import utils.FechaUtils;
import vista.*;

public class SistemaCocheras {
	
	/*********** Region: INICIALIZACI�N ***********/ 
	
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
	
	/*********** Fin Region: INICIALIZACI�N ***********/ 
		

	/*********** Region: CLIENTES ***********/ 
	
	public int crearCliente(String dni, String nombre, String domicilio, String mail, String telefono){
		
		if(this.validarCliente(dni, nombre, domicilio, mail, telefono, EstadosCliente.ACTIVO)) {
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
			String telefono, int estado) {
		return (dni.length() > 0 && nombre.length() > 0 && 
				domicilio.length() > 0 && mail.length() > 0 && estado > 0 && estado < 4); 
	}
	
	
	public int modificarCliente(String dni, String nombre, String domicilio, String mail, 
			String telefono, int estado) {
		
		if (this.validarCliente(dni, nombre, domicilio, mail, telefono, estado)) {
				Cliente cliente = buscarCliente(dni);
		
			if (cliente != null) {
				cliente.setNombre(nombre);
				cliente.setDomicilio(domicilio);
				cliente.setMail(mail);
				cliente.setTelefono(telefono);
				cliente.setEstado(estado);
				return ExitCodes.OK;
			} else {
				return ExitCodes.NO_EXISTE_ENTIDAD;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
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
	
	private  Vector<Contrato> buscarContratos(String dni, boolean vigentes){
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
	
	/*********** Fin Region: CLIENTES ***********/ 
	
	
	/*********** Region: MEDIOS DE PAGO ***********/ 
	
	public int crearMedioPago(String nombreEntidad, String nombreArchivoEntrada,
			String nombreArchivoSalida, String direccionFTP) {
		if (this.validarMedioPago(nombreEntidad, nombreArchivoEntrada, nombreArchivoSalida, direccionFTP)) {
			
			MedioPago medioPago = buscarMedioPago(nombreEntidad);
			
			if(medioPago == null){
				medioPago = new MedioPago(nombreEntidad, nombreArchivoEntrada, nombreArchivoSalida, direccionFTP);
				this.mediosPagos.add(medioPago);
				return ExitCodes.OK;
			} else {
				return ExitCodes.YA_EXISTE_ENTIDAD;
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
	
	/*********** Fin Region: MEDIOS DE PAGO ***********/ 

	
	/*********** Region: ABONOS ***********/ 
	
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
				descuento >= 0 && (tamanioCochera > 0 && tamanioCochera < 4)); 
	}
	
	
	public int modificarAbono(String nombre, int cantidadDias, float precioBase, float descuento, int tamanioCochera) {

		if (this.validarAbono(nombre, cantidadDias, precioBase, descuento, tamanioCochera)) {
			Abono abono = buscarAbono(nombre);
	
			if (abono != null) {
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
	
	/*********** Fin Region: ABONOS ***********/ 
	
	
	/*********** Region: CONTRATOS ***********/ 
	
	public int crearContratoEfectivo(String dni, String patente, int nroCochera, String nombreAbono, Date fecha) {
		ContratoEfectivo contrato = null;
		Cliente cliente = buscarCliente(dni);
		if (cliente != null) {			
			Auto auto = cliente.buscarAuto(patente);
			Cochera cochera = this.buscarCochera(nroCochera);
			Abono abono = this.buscarAbono(nombreAbono);			
			if (auto != null && cochera != null && abono != null && verificarPatenteEnContrato(cliente, patente) && abono.getTamanioCochera() == cochera.getTamanioVehiculoAdmitido()) {
				if (cochera.getEstado() == EstadosCochera.LIBRE) {
					contrato = new ContratoEfectivo(cliente, auto, cochera, abono, fecha);
					this.contratos.add(contrato);
					cochera.setEstado(EstadosCochera.OCUPADA);
					return ExitCodes.OK;
				} else {
					return ExitCodes.COCHERA_NO_DISPONIBLE;
				}
			} else {
				return ExitCodes.ARGUMENTOS_INVALIDOS;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	public int crearContratoCheque(String dni, String patente, int nroCochera, String nombreAbono, Date fecha, String nroCuentaCorriente, String entidadBancaria) {
		ContratoCheque contrato = null;
		
		Cliente cliente = buscarCliente(dni);
		
		if (cliente != null) {
			Auto auto = cliente.buscarAuto(patente);
			Cochera cochera = this.buscarCochera(nroCochera);
			Abono abono = this.buscarAbono(nombreAbono);
			if (auto != null && cochera != null && abono != null && verificarPatenteEnContrato(cliente, patente) && abono.getTamanioCochera() == cochera.getTamanioVehiculoAdmitido()) {
				if (cochera.getEstado() == EstadosCochera.LIBRE) {
					contrato = new ContratoCheque(cliente, auto, cochera, abono, nroCuentaCorriente, entidadBancaria, fecha);
					this.contratos.add(contrato);
					cochera.setEstado(EstadosCochera.OCUPADA);
					return ExitCodes.OK;
				} else {
					return ExitCodes.COCHERA_NO_DISPONIBLE;
				}
			} else {
				return ExitCodes.ARGUMENTOS_INVALIDOS;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}  
	}
	
	public int crearContratoTarjetaCredito(String dni, String patente, int nroCochera, String nombreAbono, Date fecha, String nroTarjeta, Date vencimientoTarjeta, String entidadEmisoraTarjeta) {
		ContratoTarjetaCredito contrato = null;		
		Cliente cliente = buscarCliente(dni);		
		if (cliente != null) {
			Auto auto = cliente.buscarAuto(patente);
			Cochera cochera = this.buscarCochera(nroCochera);
			Abono abono = this.buscarAbono(nombreAbono);			
			if (auto != null && cochera != null && abono != null && verificarPatenteEnContrato(cliente, patente) && abono.getTamanioCochera() == cochera.getTamanioVehiculoAdmitido()) {
				if (cochera.getEstado() == EstadosCochera.LIBRE) {
					contrato = new ContratoTarjetaCredito(cliente, auto, cochera, abono, 
					nroTarjeta, vencimientoTarjeta, entidadEmisoraTarjeta, fecha);
					this.contratos.add(contrato);
					cochera.setEstado(EstadosCochera.OCUPADA);
					return ExitCodes.OK;
				} else {
					return ExitCodes.COCHERA_NO_DISPONIBLE; 
				}
			} else {
				return ExitCodes.ARGUMENTOS_INVALIDOS;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}  
	}
	
	public int crearContratoDebitoAutomatico(String dni, String patente, int nroCochera, String nombreAbono,
			Date fecha, String cbu, String entidadBancaria) {
		ContratoDebitoAutomatico contrato = null;		
		Cliente cliente = buscarCliente(dni);		
		if (cliente != null) {
			Auto auto = cliente.buscarAuto(patente);
			Cochera cochera = this.buscarCochera(nroCochera);
			Abono abono = this.buscarAbono(nombreAbono);			
			if (auto != null && cochera != null && abono != null && verificarPatenteEnContrato(cliente, patente) && abono.getTamanioCochera() == cochera.getTamanioVehiculoAdmitido()) {
				if (cochera.getEstado() == EstadosCochera.LIBRE) {
					contrato = new ContratoDebitoAutomatico(cliente, auto, cochera, abono, cbu, entidadBancaria, fecha);
					this.contratos.add(contrato);
					cochera.setEstado(EstadosCochera.OCUPADA);
					return ExitCodes.OK;
				} else {
					return ExitCodes.COCHERA_NO_DISPONIBLE;
				}
			} else {
				return ExitCodes.ARGUMENTOS_INVALIDOS;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}  
	}	
	
	private boolean verificarPatenteEnContrato(Cliente cliente, String patente){		
		Vector<ContratoView> contratosView = this.listarContratos(cliente.getDni(), true);
		boolean flag = true;
		for(int i = 0; i < contratosView.size() && flag; i++){
			if(contratosView.elementAt(i).getPatenteAuto().equalsIgnoreCase(patente)){
				flag = false;
			}
		}
		return flag;
	}
	
	public int modificarContrato(int nroContrato, String abono) {
		
		Contrato contrato = buscarContrato(nroContrato);

		if (contrato != null) {
			Abono abonoNuevo = this.buscarAbono(abono);
			
			if (abonoNuevo != null && abonoNuevo.getTamanioCochera() == contrato.getCochera().getTamanioVehiculoAdmitido()) {
				contrato.setAbono(abonoNuevo);
				return ExitCodes.OK;
			} else {
				return ExitCodes.ARGUMENTOS_INVALIDOS;
			}
		} else {
			return ExitCodes.NO_EXISTE_ENTIDAD;
		}
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
	
	public Vector<ContratoView> listarContratos(String dni, boolean vigentes){
		Vector<ContratoView> contratosView = new Vector<ContratoView>();
		
		Vector<Contrato> contratosCliente = this.buscarContratos(dni, vigentes);
		
		if(contratosCliente != null && contratosCliente.size() > 0) {
			for (Contrato c: contratosCliente) {
				contratosView.add(c.getView());
			}
		}
		
		return contratosView;
	}
	
	public int generarCuotas() {
		
		if (this.contratos != null && this.contratos.size() > 0) {
			for (Contrato c: this.contratos) {
				if (c.getEstado()){
					Abono abono = c.getAbono();
					Vector<Cuota> cuotas = c.getCuotas();
					Cuota cuota;
					Calendar fechaVencimiento = Calendar.getInstance();
				
					if (cuotas != null && cuotas.size() > 0) {
						// Si ya tenia cuotas generadas
						Cuota cuo = cuotas.lastElement();
					
						// Seteo la fecha de vencimiento a partir de la ultima cuota.
						fechaVencimiento.setTime(cuo.getFechaGeneracion());
					}
					else {
						// Genero la primera cuota
						fechaVencimiento.setTime(c.getFecha());
					}	
				
					fechaVencimiento.add(Calendar.DAY_OF_YEAR, abono.getCantidadDias());
					cuota = new Cuota(c.getNroContrato(), fechaVencimiento.getTime(), abono.calcularPrecio());
				
					c.agregarCuota(cuota);
				}
			}
			
			return ExitCodes.OK;
		}
		else {
			return ExitCodes.FALLA_GENERACION_CUOTAS;
		}
	}
	
	public Vector<CuotaView> listarProximasCuotas() {
		Vector<CuotaView> cuotasView = new Vector<CuotaView>();
		
		// Busca la ultima cuota de cada contrato.
		Vector<Cuota> cuotas = this.buscarCuotas();
		
		if(cuotas != null && cuotas.size() > 0) {
			for (Cuota c: cuotas) {
				cuotasView.add(c.getView());
			}
		}
		
		return cuotasView;
	}
	
	private  Vector<Cuota> buscarCuotas(){
		Vector<Cuota> cuotas = new Vector<Cuota>();
		
		if (this.contratos != null && this.contratos.size() > 0) {
			for(Contrato c: this.contratos) {
				Vector<Cuota> cuo = c.getCuotas();
				if (cuo != null && cuo.size() > 0) {
					cuotas.add(cuo.lastElement());
				}
			}
		}

		return (cuotas.size() != 0 ? cuotas : null);
	}
	
	
	/*********** Fin Region: CONTRATOS ***********/ 
	
	
	/*********** Region: COCHERAS ***********/ 
	
	public int crearCochera(int tamanioVehiculoAdmitido) {
		// Se usa Integer.MAX_VALUE como valor provisorio; se asignar� el n�mero de la cochera
		// en el constructor.
		if(this.validarCochera(Integer.MAX_VALUE, tamanioVehiculoAdmitido, EstadosCochera.LIBRE)) {
				Cochera cochera = new Cochera(tamanioVehiculoAdmitido);
				this.cocheras.add(cochera);
				return ExitCodes.OK;
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	private boolean validarCochera(int numero, int tamanioVehiculoAdmitido, int estado) {
		return ((numero > 0) && (tamanioVehiculoAdmitido > 0 && tamanioVehiculoAdmitido  < 4)
				&& (estado > 0 && estado < 4)); 
	}
	
	public int modificarCochera(int numero, int tamanioVehiculoAdmitido, int estado) {

		if (this.validarCochera(numero, tamanioVehiculoAdmitido, estado)) {
			Cochera cochera = buscarCochera(numero);

			if (cochera != null) {
				cochera.setTamanioVehiculoAdmitido(tamanioVehiculoAdmitido);
				cochera.setEstado(estado);
				return ExitCodes.OK;
			} else {
				return ExitCodes.NO_EXISTE_ENTIDAD;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
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
	
	/*********** Fin Region: COCHERAS ***********/ 
	
	
	/*********** Region: AUTOS ***********/ 
	
	public int crearAuto(String dniCliente, String patente, String marca,
			Date fechaEntrada, String modelo) {
		if (this.validarAuto(patente, marca, fechaEntrada, modelo, true)) {

			Cliente cliente = buscarCliente(dniCliente);

			if (cliente != null) {
				Auto auto = cliente.buscarAuto(patente);

				if (auto == null) {
					auto = new Auto(patente, marca, fechaEntrada, modelo);
					cliente.agregarAuto(auto);
					return ExitCodes.OK;
				} else {
					return ExitCodes.YA_EXISTE_ENTIDAD;
				}
			} else {
				return ExitCodes.NO_EXISTE_ENTIDAD;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	private boolean validarAuto(String patente, String marca, Date fechaEntrada, 
			String modelo, boolean activo) {
		return (patente.length() > 0 && marca.length() > 0 &&  fechaEntrada != null && modelo.length() > 0); 
	}
	
	public int modificarAuto(String dniCliente, String patente, String marca,
			Date fechaEntrada, String modelo, boolean activo) {
		
		if (this.validarAuto(patente, marca, fechaEntrada, modelo, activo)) {
			Cliente cliente = buscarCliente(dniCliente);
	
			if (cliente != null) {
				Auto auto = cliente.buscarAuto(patente);
	
				if (auto != null) {
					auto.setMarca(marca);
					auto.setActivo(activo);
					auto.setFechaEntrada(fechaEntrada);
					auto.setModelo(modelo);
					return ExitCodes.OK;
				} else {
					return ExitCodes.NO_EXISTE_AUTO;
				}
			}else {
				return ExitCodes.NO_EXISTE_ENTIDAD;
			} 
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	public int bajaAuto(String dniCliente, String patente){
		
		if (dniCliente.length() > 0 && patente.length() > 0) {
			
			Cliente cliente = buscarCliente(dniCliente);
	
			if (cliente != null) {
				Auto auto = cliente.buscarAuto(patente);
			
				if(auto != null) {
					
					Vector<Contrato> contratosVigentes = this.buscarContratos(dniCliente, true);
					
					if (contratosVigentes == null || contratosVigentes.size() > 0) {
						auto.darDeBaja();
						return ExitCodes.OK;
					} else {
						return ExitCodes.AUTO_CONTRATO_VIGENTE;
					}
				}
				else {
					return ExitCodes.NO_EXISTE_AUTO;
				}
			}
			else {
				return ExitCodes.NO_EXISTE_ENTIDAD;
			}
		} else {
			return ExitCodes.ARGUMENTOS_INVALIDOS;
		}
	}
	
	public Vector<AutoView> listarAutos(String dniCliente) {
		Vector<AutoView> autosView = new Vector<AutoView>();

		Cliente cliente = buscarCliente(dniCliente);

		if (cliente != null) {
			Vector<Auto> autos  = cliente.getAutos();
		
			if(autos != null && autos.size() > 0){
				for (Auto a: autos) {
					autosView.add(a.getView());
				}
			}
		}
		
		return autosView;
	}
	
	/*********** Fin Region: AUTOS ***********/ 
	
	
	/*********** Region: DATOS PRUEBA ***********/ 
	
	public void generarDatosPrueba(int cantidadDatosAGenerar) {
		DatosPrueba datosPrueba = new DatosPrueba(cantidadDatosAGenerar);
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(FechaUtils.getFechaActual());
		fecha.add(Calendar.DAY_OF_YEAR, -4);
		
		this.abonos.addAll(datosPrueba.generarAbonos());		
		this.cocheras.addAll(datosPrueba.generarCocheras());
		this.mediosPagos.addAll(datosPrueba.generarMediosPagos());
		this.clientes.addAll(datosPrueba.generarClientes());
		
		int j = 0, k = 0;
		for(int i = 0; i < cantidadDatosAGenerar; i++){
			j = 0;
			if(j< cantidadDatosAGenerar && k < this.cocheras.size()){
				ContratoEfectivo contratoE = new ContratoEfectivo(
						this.clientes.elementAt(i),
						this.clientes.elementAt(i).getAutos().elementAt(j),
						this.cocheras.elementAt(k),
						this.abonos.elementAt(k),
						fecha.getTime()
						);
				this.contratos.add(contratoE);
				j++;
				k++;
			}
			if(j< cantidadDatosAGenerar && k < this.cocheras.size()){
				ContratoCheque contratoC = new ContratoCheque(
						this.clientes.elementAt(i),
						this.clientes.elementAt(i).getAutos().elementAt(j),
						this.cocheras.elementAt(k),
						this.abonos.elementAt(k),
						Integer.toString(j),
						String.format("Entidad %d", j),
						FechaUtils.getFechaActual()
						);
				this.contratos.add(contratoC);
				j++;
				k++;
			}
			if(j< cantidadDatosAGenerar && k < this.cocheras.size()){
				ContratoTarjetaCredito contratoTC = new ContratoTarjetaCredito(
						this.clientes.elementAt(i),
						this.clientes.elementAt(i).getAutos().elementAt(j),
						this.cocheras.elementAt(k),
						this.abonos.elementAt(k),
						Integer.toString(j),
						FechaUtils.getFechaActual(),
						String.format("Entidad %d", j),
						fecha.getTime()
						);
				this.contratos.add(contratoTC);
				j++;
				k++;
			}
			if(j< cantidadDatosAGenerar && k < this.cocheras.size()){
				ContratoDebitoAutomatico contratoDA = new ContratoDebitoAutomatico(
						this.clientes.elementAt(i),
						this.clientes.elementAt(i).getAutos().elementAt(j),
						this.cocheras.elementAt(k),
						this.abonos.elementAt(k),
						Integer.toString(j),
						String.format("Entidad %d", j),
						FechaUtils.getFechaActual()
						);
				this.contratos.add(contratoDA);	
				j++;
				k++;
			}					
		}
		
		
		/*	
		int min = 0;
		int max = cantidadDatosAGenerar - 1;
		Random random = new Random();
		
		int i = random.nextInt(max - min + 1) + min;
		
		ContratoEfectivo contratoE = new ContratoEfectivo(
				this.clientes.elementAt(i),
				this.clientes.elementAt(i).getAutos().firstElement(),
				this.cocheras.elementAt(i),
				this.abonos.elementAt(i),
				fecha.getTime()
				);
		
		this.contratos.add(contratoE);
		
		i = random.nextInt(max - min + 1) + min;
		
		ContratoCheque contratoC = new ContratoCheque(
				this.clientes.elementAt(i),
				this.clientes.elementAt(i).getAutos().firstElement(),
				this.cocheras.elementAt(i),
				this.abonos.elementAt(i),
				Integer.toString(i),
				String.format("Entidad %d", i),
				FechaUtils.getFechaActual()
				);
		
		this.contratos.add(contratoC);
		
		i = random.nextInt(max - min + 1) + min;
		
		ContratoTarjetaCredito contratoTC = new ContratoTarjetaCredito(
				this.clientes.elementAt(i),
				this.clientes.elementAt(i).getAutos().firstElement(),
				this.cocheras.elementAt(i),
				this.abonos.elementAt(i),
				Integer.toString(i),
				FechaUtils.getFechaActual(),
				String.format("Entidad %d", i),
				fecha.getTime()
				);
		
		this.contratos.add(contratoTC);
		
		i = random.nextInt(max - min + 1) + min;
		
		ContratoDebitoAutomatico contratoDA = new ContratoDebitoAutomatico(
				this.clientes.elementAt(i),
				this.clientes.elementAt(i).getAutos().firstElement(),
				this.cocheras.elementAt(i),
				this.abonos.elementAt(i),
				Integer.toString(i),
				String.format("Entidad %d", i),
				FechaUtils.getFechaActual()
				);
		
		this.contratos.add(contratoDA);*/
	}
	
	/*********** Fin Region: DATOS PRUEBA ***********/ 
}

