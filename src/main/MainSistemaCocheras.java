package main;

import java.io.*;
import java.util.Vector;

import controlador.*;
import enums.*;
import vista.*;

public class MainSistemaCocheras {

	/*********** Región: INICIALIZACIÓN ***********/ 
	
	private SistemaCocheras sistemaCocheras;

	public MainSistemaCocheras() {
		this.sistemaCocheras = new SistemaCocheras();
	}
	
	/*********** Fin Región: INICIALIZACIÓN ***********/ 
	
	
	public static void main(String[] args) {
		MainSistemaCocheras sistema = new MainSistemaCocheras();
		sistema.mostrarMenu();
	}

	private void mostrarMenu() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 	
		//Imprimo menu de opciones
		System.out.println();
		System.out.println("SISTEMA DE COCHERAS: MENU DE OPCIONES");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Clientes");
		System.out.println("2.- Medios de pago");
		System.out.println("3.- Abonos");
		System.out.println("4.- Contratos de cochera");
		System.out.println("5.- Cocheras");
		System.out.println("Q.- Salir");
		System.out.println("-------------------------------------------------------");
		System.out.print("Opcion: ");
		try
		{
			char s = (char)reader.read();
			
		  	switch (s)
		  	{
		  		case '1' : {
		  			this.mostrarMenuClientes();
		  			break;
		  		}
			  	case '2' : {
			  		this.mostrarMenuMediosPago();
			  		break;
			  	}
			  	case '3' : {
			  		this.mostrarMenuAbonos();
			  		break;
			  	}
			  	case '4' :  {
			  		this.mostrarMenuContratos();
			  		break;
			  	}
			  	case '5' :  {
			  		this.mostrarMenuCocheras();
			  		break;
			  	}
			  	case 'Q': 
			  	case 'q': {
			  		this.salir();
			  		break;
			  	}
			  	default: {
			  		this.mostrarMenu();
			  		break;
			  	}
		  	}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void mostrarMenuClientes() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 	
		//Imprimo menu de opciones
		System.out.println();
		System.out.println("CLIENTES: MENU DE OPCIONES");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Alta");
		System.out.println("2.- Modificacion");
		System.out.println("3.- Baja");
		System.out.println("4.- Listar");
		System.out.println("Q.- Volver");
		System.out.println("-------------------------------------------------------");
		System.out.print("Opcion: ");
		try
		{
			char s = (char)reader.read();
			
		  	switch (s)
		  	{
		  		case '1' : {
		  			this.crearCliente();
		  			break;
		  		}
			  	case '2' : {
			  		this.modificarCliente();
			  		break;
			  	}
			  	case '3' : {
			  		this.bajaCliente();
			  		break;
			  	}
			  	case '4' : {
			  		this.listarClientes();
			  		break;
			  	}
			  	case 'Q': 
			  	case 'q': {
			  		this.mostrarMenu();
			  		break;
			  	}
			  	default: {
			  		this.mostrarMenu();
			  		break;
			  	}
		  	}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void mostrarMenuMediosPago() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 	
		//Imprimo menu de opciones
		System.out.println();
		System.out.println("MEDIOS DE PAGO: MENU DE OPCIONES");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Alta");
		System.out.println("2.- Baja");
		System.out.println("3.- Listar");
		System.out.println("Q.- Volver");
		System.out.println("-------------------------------------------------------");
		System.out.print("Opcion: ");
		try
		{
			char s = (char)reader.read();
			
		  	switch (s)
		  	{
		  		case '1' : {
		  			this.crearMedioPago();
		  			break;
		  		}
			  	case '2' : {
			  		this.bajaMedioPago();
			  		break;
			  	}
			  	case '3' : {
			  		this.listarMediosPago();
			  		break;
			  	}
			  	case 'Q': 
			  	case 'q': {
			  		this.mostrarMenu();
			  		break;
			  	}
			  	default: {
			  		this.mostrarMenu();
			  		break;
			  	}
		  	}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void mostrarMenuAbonos() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 	
		//Imprimo menu de opciones
		System.out.println();
		System.out.println("ABONOS: MENU DE OPCIONES");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Alta");
		System.out.println("2.- Modificacion");
		System.out.println("3.- Baja");
		System.out.println("4.- Listar");
		System.out.println("Q.- Volver");
		System.out.println("-------------------------------------------------------");
		System.out.print("Opcion: ");
		try
		{
			char s = (char)reader.read();
			
		  	switch (s)
		  	{
		  		case '1' : {
		  			this.crearAbono();
		  			break;
		  		}
			  	case '2' : {
			  		this.modificarAbono();
			  		break;
			  	}
			  	case '3' : {
			  		this.bajaAbono();
			  		break;
			  	}
			  	case '4' : {
			  		this.listarAbonos();
			  		break;
			  	}
			  	case 'Q': 
			  	case 'q': {
			  		this.mostrarMenu();
			  		break;
			  	}
			  	default: {
			  		this.mostrarMenu();
			  		break;
			  	}
		  	}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void mostrarMenuContratos() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 	
		//Imprimo menu de opciones
		System.out.println();
		System.out.println("CONTRATOS: MENU DE OPCIONES");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Alta");
		System.out.println("2.- Modificacion");
		System.out.println("3.- Baja");
		System.out.println("4.- Listar");
		System.out.println("Q.- Volver");
		System.out.println("-------------------------------------------------------");
		System.out.print("Opcion: ");
		try
		{
			char s = (char)reader.read();
			
		  	switch (s)
		  	{
		  		case '1' : {
		  			this.crearContrato();
		  			break;
		  		}
			  	case '2' : {
			  		this.modificarContrato();
			  		break;
			  	}
			  	case '3' : {
			  		this.bajaContrato();
			  		break;
			  	}
			  	case '4' : {
			  		this.listarContratos();
			  		break;
			  	}
			  	case 'Q': 
			  	case 'q': {
			  		this.mostrarMenu();
			  		break;
			  	}
			  	default: {
			  		this.mostrarMenu();
			  		break;
			  	}
		  	}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void salir() {
		System.exit(0);
	}
	
	private void mostrarMenuCocheras() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 	
		//Imprimo menu de opciones
		System.out.println();
		System.out.println("COCHERAS: MENU DE OPCIONES");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Alta");
		System.out.println("2.- Modificacion");
		System.out.println("3.- Baja");
		System.out.println("4.- Listar");
		System.out.println("Q.- Volver");
		System.out.println("-------------------------------------------------------");
		System.out.print("Opcion: ");
		try
		{
			char s = (char)reader.read();
			
		  	switch (s)
		  	{
		  		case '1' : {
		  			this.crearCochera();
		  			break;
		  		}
			  	case '2' : {
			  		this.modificarCochera();
			  		break;
			  	}
			  	case '3' : {
			  		this.bajaCochera();
			  		break;
			  	}
			  	case '4': {
			  		this.listarCocheras();
			  		break;
			  	}
			  	case 'Q': 
			  	case 'q': {
			  		this.mostrarMenu();
			  		break;
			  	}
			  	default: {
			  		this.mostrarMenu();
			  		break;
			  	}
		  	}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*********** Región: CLIENTES ***********/ 
	
	private void crearCliente() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("ALTA DE CLIENTE");
			System.out.println("---------------");
			System.out.print("DNI: ");
			String dni = reader.readLine();
			System.out.print("Nombre: ");
			String nombre = reader.readLine();
			System.out.print("Domicilio: ");
			String domicilio = reader.readLine();
			System.out.print("Mail: ");
			String mail = reader.readLine();
			System.out.print("Telefono: ");
			String telefono = reader.readLine();
			
			int exitCode = sistemaCocheras.crearCliente(dni, nombre, domicilio, mail, telefono);
			
			switch(exitCode) {
				case ExitCodes.OK: {
					System.out.println("El cliente se ha creado con éxito.");	
					break;
				}
				case ExitCodes.YA_EXISTE_ENTIDAD: {
					System.out.println("El cliente ya existe.");	
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inválido.");	
					break;
				}
				default: {
					break;
				}
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void modificarCliente() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("MODIFICACION DE CLIENTE");
			System.out.println("-----------------------");
			System.out.print("DNI: ");
			String dni = reader.readLine();
			
			ClienteView clienteView = this.sistemaCocheras.buscarDatosCliente(dni);
			
			if (clienteView != null)
			{
				System.out.print("Nombre: ");
				String nombre = reader.readLine();
				System.out.print("Domicilio: ");
				String domicilio = reader.readLine();
				System.out.print("Mail: ");
				String mail = reader.readLine();
				System.out.print("Telefono: ");
				String telefono = reader.readLine();
				System.out.print("Estado: ");
				int estado = Integer.parseInt(reader.readLine());
				
				int exitCode = sistemaCocheras.modificarCliente(dni, nombre, domicilio, mail, telefono, estado);
				
				switch(exitCode) {
					case ExitCodes.OK: {
						System.out.println("El cliente se ha modificado con éxito.");
						break;
					}
					case ExitCodes.NO_EXISTE_ENTIDAD: {
						System.out.println("El cliente no existe.");
						break;
					}
					case ExitCodes.ARGUMENTOS_INVALIDOS: {
						System.out.println("Alguno de los argumentos es inválido.");
						break;
					}
					default: {
						break;
					}
				}
			}
			else {
				System.out.println("El cliente no existe.");
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void bajaCliente() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("BAJA DE CLIENTE");
			System.out.println("---------------");
			System.out.print("DNI: ");
			String dni = reader.readLine();
			
			int exitCode = sistemaCocheras.bajaCliente(dni);
			
			switch(exitCode) {
				case ExitCodes.OK: {
					System.out.println("El cliente se ha dado de baja con éxito.");	
					break;
				}
				case ExitCodes.NO_EXISTE_ENTIDAD: {
					System.out.println("El cliente no existe.");
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inválido.");
					break;
				}
				case ExitCodes.CLIENTE_CONTRATOS_VIGENTES: {
					System.out.println("El cliente posee contratos vigentes.");
					break;
				}
				default: {
					break;
				}
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void listarClientes() {
		try
		{
			Vector<ClienteView> clientesView = this.sistemaCocheras.listarClientes();	
			
			if (clientesView != null && clientesView.size() > 0) {
				System.out.println("DNI\tNOMBRE\tDOMICILIO\tMAIL\tTELEFONO");
				System.out.println("--------------------------");
				
				for (ClienteView cv: clientesView) {				
					String linea = String.format("%s\t%s\t%s\t%s\t%s", cv.getDni(), cv.getNombre(), 
							cv.getDomicilio(), cv.getMail(), cv.getTelefono());
					System.out.println(linea);
				}
			}
			else {
				System.out.println("No hay clientes para mostrar.");
			}
			
			this.mostrarMenu();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*********** Fin Región: CLIENTES ***********/ 
	
	
	/*********** Región: MEDIOS DE PAGO ***********/ 
	
	private void crearMedioPago() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("ALTA DE MEDIO DE PAGO");
			System.out.println("---------------------");
			System.out.print("Nombre Entidad: ");
			String nombreEntidad = reader.readLine();
			System.out.print("Nombre Archivo de Entrada: ");
			String nombreArchivoEntrada = reader.readLine();
			System.out.print("Nombre Archivo Salida: ");
			String nombreArchivoSalida= reader.readLine();
			System.out.print("Direccion FTP: ");
			String direccionFTP = reader.readLine();
			
			int exitCode = sistemaCocheras.crearMedioPago(nombreEntidad, nombreArchivoEntrada, 
					nombreArchivoSalida, direccionFTP);
			
			switch(exitCode) {
				case ExitCodes.OK: {
					System.out.println("El medio de pago se ha creado con éxito.");
					break;
				}
				case ExitCodes.YA_EXISTE_ENTIDAD: {
					System.out.println("El medio de pago ya existe.");	
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inválido.");
					break;
				}
				default: {
					break;
				}
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void bajaMedioPago() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("BAJA DE MEDIO DE PAGO");
			System.out.println("---------------------");
			System.out.print("Nombre Entidad: ");
			String nombreEntidad = reader.readLine();
			
			int exitCode = sistemaCocheras.eliminarMedioPago(nombreEntidad);
			
			switch(exitCode) {
				case ExitCodes.OK: {
					System.out.println("El medio de pago se ha dado de baja con éxito.");	
					break;
				}
				case ExitCodes.NO_EXISTE_ENTIDAD: {
					System.out.println("El medio de pago no existe.");
					break;
				}
				default: {
					break;
				}
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void listarMediosPago() {
		try
		{
			Vector<MedioPagoView> mediosPagosView = this.sistemaCocheras.listarMediosPagos();	
			
			if (mediosPagosView != null && mediosPagosView.size() > 0) {
				System.out.println("NOMBRE\tARCH.ENTRADA\tARCH.SALIDA\tFTP\tACTIVO");
				System.out.println("--------------------------");
				
				for (MedioPagoView mpv: mediosPagosView) {				
					String linea = String.format("%s\t%s\t%s\t%s\t%s", mpv.getNombreEntidad(),
							mpv.getNombreArchivoEntrada(), mpv.getNombreArchivoSalida(), 
							mpv.getDireccionFTP(), mpv.getActivo() ? "Activo" : "Inactivo");
					System.out.println(linea);
				}
			}
			else {
				System.out.println("No hay medios de pago para mostrar.");
			}
			
			this.mostrarMenu();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*********** Fin Región: MEDIOS DE PAGO ***********/ 
	
	
	/*********** Región: ABONOS ***********/ 
	
	private void crearAbono() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("ALTA DE ABONO");
			System.out.println("---------------");
			System.out.print("Nombre: ");
			String nombre = reader.readLine();
			System.out.print("Cantidad de Dias: ");
			int cantidadDias = Integer.parseInt(reader.readLine());
			System.out.print("Precio Base: ");
			float precioBase = Float.parseFloat(reader.readLine());
			System.out.print("Descuento: ");
			float descuento = Float.parseFloat(reader.readLine());
			String tamCochera = String.format("Tamaño cochera (%d: pequeña, %d: mediana, %d: grande): ", 
					Tamanios.PEQUENIA, Tamanios.MEDIANA, Tamanios.GRANDE);
			System.out.print(tamCochera);
			int tamanioCochera = Integer.parseInt(reader.readLine());
			
			int exitCode = sistemaCocheras.crearAbono(nombre, cantidadDias, precioBase, descuento, tamanioCochera);
			
			switch(exitCode) {
				case ExitCodes.OK: {
					System.out.println("El abono se ha creado con éxito.");	
					break;
				}
				case ExitCodes.YA_EXISTE_ENTIDAD: {
					System.out.println("El abono ya existe.");	
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inválido.");	
					break;
				}
				default: {
					break;
				}
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void modificarAbono() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("MODIFICACION DE ABONO");
			System.out.println("-----------------------");
			System.out.print("Nombre: ");
			String nombre = reader.readLine();
			
			AbonoView abonoView = this.sistemaCocheras.buscarDatosAbono(nombre);
			
			if (abonoView != null)
			{
				System.out.print("Cantidad de Dias: ");
				int cantidadDias = Integer.parseInt(reader.readLine());
				System.out.print("Precio Base: ");
				float precioBase = Float.parseFloat(reader.readLine());
				System.out.print("Descuento: ");
				float descuento = Float.parseFloat(reader.readLine());
				String tamCochera = String.format("Tamaño cochera (%d: pequeña, %d: mediana, %d: grande): ", 
						Tamanios.PEQUENIA, Tamanios.MEDIANA, Tamanios.GRANDE);
				System.out.println(tamCochera);
				int tamanioCochera = Integer.parseInt(reader.readLine());
								
				int exitCode = sistemaCocheras.modificarAbono(nombre, cantidadDias, precioBase, descuento, tamanioCochera);
				
				switch(exitCode) {
					case ExitCodes.OK: {
						System.out.println("El abono se ha modificado con éxito.");
						break;
					}
					case ExitCodes.NO_EXISTE_ENTIDAD: {
						System.out.println("El abono no existe.");
						break;
					}
					case ExitCodes.ARGUMENTOS_INVALIDOS: {
						System.out.println("Alguno de los argumentos es inválido.");
						break;
					}
					default: {
						break;
					}
				}
			}
			else {
				System.out.println("El cliente no existe.");
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void bajaAbono() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("BAJA DE ABONO");
			System.out.println("---------------");
			System.out.print("Nombre: ");
			String nombre = reader.readLine();
			
			int exitCode = sistemaCocheras.bajaAbono(nombre);
			
			switch(exitCode) {
				case ExitCodes.OK: {
					System.out.println("El abono se ha dado de baja con éxito.");	
					break;
				}
				case ExitCodes.NO_EXISTE_ENTIDAD: {
					System.out.println("El abono no existe.");
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inválido.");
					break;
				}
				default: {
					break;
				}
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void listarAbonos() {
		try
		{
			Vector<AbonoView> abonosView = this.sistemaCocheras.listarAbonos();
			
			if (abonosView != null && abonosView.size() > 0) {
				System.out.println("NOMBRE\tPRECIO BASE\tDIAS\tDESCUENTO\tTAM.COCHERA\tESTADO");
				System.out.println("--------------------------");
				
				for (AbonoView av: abonosView) {
					String tamanio;
					String estado;
					
					switch(av.getTamanioCochera()) {
						case Tamanios.PEQUENIA:
							tamanio = "Pequeño";
							break;
						case Tamanios.MEDIANA:
							tamanio = "Mediana";
							break;
						case Tamanios.GRANDE:
							tamanio = "Grande";
							break;
						default:
							tamanio = "";
							break;
					}
					
					estado = av.getActivo() ? "Activo" : "Inactivo";
					
					System.out.println("NOMBRE\tPRECIO BASE\tDIAS\tDESCUENTO\tTAM.COCHERA\tESTADO");
					
					String linea = String.format("%f\t%f\t%d\t%s\t%s", av.getNombre(), 
							av.getPrecioBase(), av.getCantidadDias(), av.getDescuento(),
							tamanio, estado);
					System.out.println(linea);
				}
			}
			else {
				System.out.println("No hay abonos para mostrar.");
			}
			
			this.mostrarMenu();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*********** Fin Región: ABONOS ***********/ 
	
	
	/*********** Región: CONTRATOS ***********/ 
	
	private void crearContrato() throws Exception {
		throw new Exception("TO-DO: implementar");		
	}
	
	private void modificarContrato() {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("MODIFICACION DE CONTRATO");
			System.out.println("-----------------------");
			System.out.print("DNI: ");
			String dni = reader.readLine();
			
			Vector<ContratoView> contratosVigentes = this.sistemaCocheras.listarContratos(dni, true);
			
			if(contratosVigentes != null && contratosVigentes.size() > 0) {				
				
				System.out.println("NRO.CONTRATO\tFECHA\tPATENTE\tCOCHERA\tABONO\tESTADO");
				System.out.println("--------------------------");
				
				for (ContratoView cv: contratosVigentes) {				
					String linea = String.format("%d\t%td/%tm/%ty\t%s\t%d\t%s\t%s", 
							cv.getNroContrato(),
							cv.getFecha(),
							cv.getPatenteAuto(),
							cv.getNroCochera(),
							cv.getAbono(),
							cv.getEstado() ? "Activo" : "Inactivo");
					
					System.out.println(linea);
				}
				
				System.out.print("Ingresar numero de contrato: ");
				int numero = Integer.parseInt(reader.readLine());
				
				System.out.print("Ingresar abono: ");
				String abono = reader.readLine();
								
				int exitCode = sistemaCocheras.modificarContrato(numero, abono);
				
				switch(exitCode) {
					case ExitCodes.OK: {
						System.out.println("El contrato se ha modificado con éxito.");
						break;
					}
					case ExitCodes.NO_EXISTE_ENTIDAD: {
						System.out.println("El contrato no existe.");
						break;
					}
					case ExitCodes.ARGUMENTOS_INVALIDOS: {
						System.out.println("Alguno de los argumentos es inválido.");
						break;
					}
					default: {
						break;
					}
				}
			}
			else {
				System.out.println("El cliente no cuenta con contratos vigentes.");
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void bajaContrato() {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("BAJA DE CONTRATO");
			System.out.println("-----------------");
			System.out.print("DNI: ");
			String dni = reader.readLine();
			
			Vector<ContratoView> contratosVigentes = this.sistemaCocheras.listarContratos(dni, true);
			
			if(contratosVigentes != null && contratosVigentes.size() > 0) {
				
				System.out.println("NRO.CONTRATO\tFECHA\tPATENTE\tCOCHERA\tABONO\tESTADO");
				System.out.println("--------------------------");
				
				for (ContratoView cv: contratosVigentes) {				
					String linea = String.format("%d\t%td/%tm/%ty\t%s\t%d\t%s\t%s", 
							cv.getNroContrato(),
							cv.getFecha(),
							cv.getPatenteAuto(),
							cv.getNroCochera(),
							cv.getAbono(),
							cv.getEstado() ? "Activo" : "Inactivo");
					
					System.out.println(linea);
				}
				
				System.out.print("Ingresar numero de contrato: ");
				int numero = Integer.parseInt(reader.readLine());
				
				int exitCode = sistemaCocheras.bajaContrato(numero);
				
				switch(exitCode) {
					case ExitCodes.OK: {
						System.out.println("El contrato se ha eliminado con éxito.");
						break;
					}
					case ExitCodes.NO_EXISTE_ENTIDAD: {
						System.out.println("El contrato no existe.");
						break;
					}
					case ExitCodes.ARGUMENTOS_INVALIDOS: {
						System.out.println("Alguno de los argumentos es inválido.");
						break;
					}
					default: {
						break;
					}
				}
			}
			else {
				System.out.println("El cliente no cuenta con contratos vigentes.");
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void listarContratos() {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("DNI: ");
			String dni = reader.readLine();
			
			Vector<ContratoView> contratosView = this.sistemaCocheras.listarContratos(dni, false);	
			
			if (contratosView != null && contratosView.size() > 0) {
				System.out.println("NRO.CONTRATO\tFECHA\tPATENTE\tCOCHERA\tABONO\tESTADO");
				System.out.println("--------------------------");
				
				for (ContratoView cv: contratosView) {				
					String linea = String.format("%d\t%d\t%td/%tm/%ty\t%s\t%s", 
							cv.getNroContrato(),
							cv.getFecha(),
							cv.getPatenteAuto(),
							cv.getNroCochera(),
							cv.getAbono(),
							cv.getEstado() ? "Activo" : "Inactivo");
					
					System.out.println(linea);
				}
			}
			else {
				System.out.println("No hay contratos para mostrar.");
			}
			
			this.mostrarMenu();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	/*********** Fin Región: CONTRATOS ***********/ 
	
	
	/*********** Región: COCHERA ***********/ 
	
	private void crearCochera() {
		try 
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("ALTA DE COCHERA");
			System.out.println("-----------------------");
			String tamVehiculo = String.format("Tamaño vehículo admitido (%d: pequeña, %d: mediana, %d: grande): ",
							Tamanios.PEQUENIA, Tamanios.MEDIANA, Tamanios.GRANDE);
			System.out.print(tamVehiculo);
			int tamanio = Integer.parseInt(reader.readLine());

			int exitCode = sistemaCocheras.crearCochera(tamanio);

			switch (exitCode) {
			case ExitCodes.OK: {
				System.out.println("La cochera se ha creado con éxito.");
				break;
			}
			case ExitCodes.NO_EXISTE_ENTIDAD: {
				System.out.println("La cochera no existe.");
				break;
			}
			case ExitCodes.ARGUMENTOS_INVALIDOS: {
				System.out.println("Alguno de los argumentos es inválido.");
				break;
			}
			default: {
				break;
			}
			}

			this.mostrarMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void modificarCochera() {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("MODIFICACION DE COCHERA");
			System.out.println("-----------------------");
			System.out.print("DNI: ");
			int numero = Integer.parseInt(reader.readLine());
			
			CocheraView cocheraView = this.sistemaCocheras.buscarDatosCochera(numero);
			
			if (cocheraView != null)
			{
				String tamVehiculo = String.format("Tamaño vehículo admitido (%d: pequeña, %d: mediana, %d: grande): ", 
						Tamanios.PEQUENIA, Tamanios.MEDIANA, Tamanios.GRANDE);
				System.out.print(tamVehiculo);
				int tamanio = Integer.parseInt(reader.readLine());
				System.out.print("Estado: ");
				int estado = Integer.parseInt(reader.readLine());
				
				int exitCode = sistemaCocheras.modificarCochera(numero, tamanio, estado);
				
				switch(exitCode) {
					case ExitCodes.OK: {
						System.out.println("La cochera se ha modificado con éxito.");
						break;
					}
					case ExitCodes.NO_EXISTE_ENTIDAD: {
						System.out.println("La cochera no existe.");
						break;
					}
					case ExitCodes.ARGUMENTOS_INVALIDOS: {
						System.out.println("Alguno de los argumentos es inválido.");
						break;
					}
					default: {
						break;
					}
				}
			}
			else {
				System.out.println("La cochera no existe.");
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void bajaCochera() {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("BAJA DE COCHERA");
			System.out.println("---------------");
			System.out.print("Numero: ");
			int numero = Integer.parseInt(reader.readLine());
			
			int exitCode = sistemaCocheras.bajaCochera(numero);
			
			switch(exitCode) {
				case ExitCodes.OK: {
					System.out.println("La cochera se ha dado de baja con éxito.");	
					break;
				}
				case ExitCodes.NO_EXISTE_ENTIDAD: {
					System.out.println("La cochera no existe.");
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inválido.");
					break;
				}
				default: {
					break;
				}
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void listarCocheras() {
		try
		{
			Vector<CocheraView> cocherasView = this.sistemaCocheras.listarCocheras();
			
			if (cocherasView != null && cocherasView.size() > 0) {
				System.out.println("NUMERO\tTAMAÑO\tESTADO");
				System.out.println("--------------------------");
				
				for (CocheraView cv: cocherasView) {
					String tamanio;
					String estado;
					
					switch(cv.getTamanioVechiculoAdmitido()) {
						case Tamanios.PEQUENIA:
							tamanio = "Pequeño";
							break;
						case Tamanios.MEDIANA:
							tamanio = "Mediana";
							break;
						case Tamanios.GRANDE:
							tamanio = "Grande";
							break;
						default:
							tamanio = "";
							break;
					}
					
					switch(cv.getEstado()) {
					case EstadosCochera.LIBRE:
						estado = "Libre";
						break;
					case EstadosCochera.OCUPADA:
						estado = "Ocupada";
						break;
					case EstadosCochera.INACTIVA:
						estado = "Inactiva";
						break;
					default:
						estado = "";
						break;
				}
						
					String linea = String.format("%d\t%s\t%s", cv.getNumero(), tamanio, estado);
					System.out.println(linea);
				}
			}
			else {
				System.out.println("No hay cocheras para mostrar.");
			}
			
			this.mostrarMenu();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*********** Fin Región: COCHERA ***********/ 
}
