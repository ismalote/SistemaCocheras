package main;

import java.io.*;
import java.util.*;

import controlador.*;
import enums.*;
import vista.*;
import utils.*;

public class MainSistemaCocheras {

	/*********** Regi�n: INICIALIZACI�N ***********/ 
	
	private SistemaCocheras sistemaCocheras;

	public MainSistemaCocheras() {
		this.sistemaCocheras = new SistemaCocheras();
	}
	
	/*********** Fin Regi�n: INICIALIZACI�N ***********/ 
	
	
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
		System.out.println("4.- Contratos");
		System.out.println("5.- Cocheras");
		System.out.println("6.- Generar datos de prueba");
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
			  	case '6' :  {
			  		this.mostrarMenuGenerarDatosPrueba();
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
		System.out.println("5.- Autos");
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
			  	case '5' : {
			  		this.mostrarMenuAutos();
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
	
	private void mostrarMenuAutos() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 	
		//Imprimo menu de opciones
		System.out.println();
		System.out.println("AUTOS: MENU DE OPCIONES");
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
		  			this.crearAuto();
		  			break;
		  		}
			  	case '2' : {
			  		this.modificarAuto();
			  		break;
			  	}
			  	case '3' : {
			  		this.bajaAuto();
			  		break;
			  	}
			  	case '4' : {
			  		this.listarAutos();
			  		break;
			  	}
			  	case '5' : {
			  		this.mostrarMenuAutos();
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
	
	private void salir() {
		System.exit(0);
	}
	
	/*********** Regi�n: CLIENTES ***********/ 
	
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
					System.out.println("El cliente se ha creado con �xito.");	
					break;
				}
				case ExitCodes.YA_EXISTE_ENTIDAD: {
					System.out.println("El cliente ya existe.");	
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inv�lido.");	
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
				String lineaEstado = String.format("Estado (%d: activo, %d: inactivo, %d: con deuda): ", 
						EstadosCliente.ACTIVO, EstadosCliente.INACTIVO, EstadosCliente.CON_DEUDA);
				System.out.print(lineaEstado);
				int estado = Integer.parseInt(reader.readLine());
				
				int exitCode = sistemaCocheras.modificarCliente(dni, nombre, domicilio, mail, telefono, estado);
				
				switch(exitCode) {
					case ExitCodes.OK: {
						System.out.println("El cliente se ha modificado con �xito.");
						break;
					}
					case ExitCodes.NO_EXISTE_ENTIDAD: {
						System.out.println("El cliente no existe.");
						break;
					}
					case ExitCodes.ARGUMENTOS_INVALIDOS: {
						System.out.println("Alguno de los argumentos es inv�lido.");
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
					System.out.println("El cliente se ha dado de baja con �xito.");	
					break;
				}
				case ExitCodes.NO_EXISTE_ENTIDAD: {
					System.out.println("El cliente no existe.");
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inv�lido.");
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
	
	private void listarClientes() {
		try
		{
			Vector<ClienteView> clientesView = this.sistemaCocheras.listarClientes();	
			
			if (clientesView != null && clientesView.size() > 0) {
				System.out.println("DNI\tNOMBRE\t\tDOMICILIO\t\tMAIL\t\tTELEFONO\t\tESTADO");
				
				for (ClienteView cv: clientesView) {
						
					String estado;
						
					switch(cv.getEstado()) {
						case EstadosCliente.ACTIVO:
							estado = "Activo";
							break;
						case EstadosCliente.INACTIVO:
							estado = "Inactivo";
							break;
						case EstadosCliente.CON_DEUDA:
							estado = "Deuda";
							break;
						default:
							estado = "";
							break;
					}
								
					String linea = String.format("%s\t%s\t\t%s\t\t%s\t\t%s\t\t%s", cv.getDni(), cv.getNombre(), 
							cv.getDomicilio(), cv.getMail(), cv.getTelefono(), estado);
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
	
	/*********** Fin Regi�n: CLIENTES ***********/ 
	
	
	/*********** Regi�n: MEDIOS DE PAGO ***********/ 
	
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
					System.out.println("El medio de pago se ha creado con �xito.");
					break;
				}
				case ExitCodes.YA_EXISTE_ENTIDAD: {
					System.out.println("El medio de pago ya existe.");	
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inv�lido.");
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
					System.out.println("El medio de pago se ha dado de baja con �xito.");	
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
	
	private void listarMediosPago() {
		try
		{
			Vector<MedioPagoView> mediosPagoView = this.sistemaCocheras.listarMediosPago();	
			
			if (mediosPagoView != null && mediosPagoView.size() > 0) {
				System.out.println("NOMBRE\tARCH.ENTRADA\tARCH.SALIDA\tFTP\tACTIVO");
				
				for (MedioPagoView mpv: mediosPagoView) {				
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
	
	/*********** Fin Regi�n: MEDIOS DE PAGO ***********/ 
	
	
	/*********** Regi�n: ABONOS ***********/ 
	
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
			String tamCochera = String.format("Tama�o cochera (%d: peque�a, %d: mediana, %d: grande): ", 
					Tamanios.PEQUENIA, Tamanios.MEDIANA, Tamanios.GRANDE);
			System.out.print(tamCochera);
			int tamanioCochera = Integer.parseInt(reader.readLine());
			
			int exitCode = sistemaCocheras.crearAbono(nombre, cantidadDias, precioBase, descuento, tamanioCochera);
			
			switch(exitCode) {
				case ExitCodes.OK: {
					System.out.println("El abono se ha creado con �xito.");	
					break;
				}
				case ExitCodes.YA_EXISTE_ENTIDAD: {
					System.out.println("El abono ya existe.");	
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inv�lido.");	
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
				String tamCochera = String.format("Tama�o cochera (%d: peque�a, %d: mediana, %d: grande): ", 
						Tamanios.PEQUENIA, Tamanios.MEDIANA, Tamanios.GRANDE);
				System.out.println(tamCochera);
				int tamanioCochera = Integer.parseInt(reader.readLine());
								
				int exitCode = sistemaCocheras.modificarAbono(nombre, cantidadDias, precioBase, descuento, tamanioCochera);
				
				switch(exitCode) {
					case ExitCodes.OK: {
						System.out.println("El abono se ha modificado con �xito.");
						break;
					}
					case ExitCodes.NO_EXISTE_ENTIDAD: {
						System.out.println("El abono no existe.");
						break;
					}
					case ExitCodes.ARGUMENTOS_INVALIDOS: {
						System.out.println("Alguno de los argumentos es inv�lido.");
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
					System.out.println("El abono se ha dado de baja con �xito.");	
					break;
				}
				case ExitCodes.NO_EXISTE_ENTIDAD: {
					System.out.println("El abono no existe.");
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inv�lido.");
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
	
	private void listarAbonos() {
		try
		{
			Vector<AbonoView> abonosView = this.sistemaCocheras.listarAbonos();
			
			if (abonosView != null && abonosView.size() > 0) {
				System.out.println("NOMBRE\tPRECIO BASE\tDIAS\tDESCUENTO\tTAM.COCHERA\t\tESTADO");
				
				for (AbonoView av: abonosView) {
					String tamanio;
					String estado;
					
					switch(av.getTamanioCochera()) {
						case Tamanios.PEQUENIA:
							tamanio = "Peque�o";
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
					
					String linea = String.format("%s\t%.2f\t%d\t%.2f\t%s\t\t%s", av.getNombre(), 
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
	
	/*********** Fin Regi�n: ABONOS ***********/ 
	
	
	/*********** Regi�n: CONTRATOS ***********/ 
	
	private void crearContrato() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("ALTA DE CONTRATO");
			System.out.println("------------------------");
			System.out.print("DNI: ");
			String dni = reader.readLine();
			System.out.print("Patente: ");
			String patente = reader.readLine();
			System.out.print("Numero cochera: ");
			int nroCochera = Integer.parseInt(reader.readLine());
			System.out.print("Abono: ");
			String nombreAbono = reader.readLine();
			System.out.print("Fecha: ");
			Date fecha = FechaUtils.parsearFecha(reader.readLine());
			
			String lineaMedioPagoCliente = String.format("Seleccione el medio de pago (%s: efectivo, %s: cheque, %s: debito tarjeta de credito, %s: debito CBU): ", 
					MediosPagoCliente.EFECTIVO, MediosPagoCliente.CHEQUE, MediosPagoCliente.DEBITO_TARJETA_CREDITO,
					MediosPagoCliente.DEBITO_CBU);
			System.out.print(lineaMedioPagoCliente);
			String medioPagoCliente = reader.readLine();
			
			int exitCode = -1;
			
			if(medioPagoCliente.equalsIgnoreCase(MediosPagoCliente.EFECTIVO))
			{
				exitCode = this.sistemaCocheras.crearContratoEfectivo(dni, patente, nroCochera, 
						nombreAbono, fecha);
			}
			else if(medioPagoCliente.equalsIgnoreCase(MediosPagoCliente.CHEQUE))
			{
				System.out.print("Numero cuenta corriente: ");
				String nroCuentaCorriente = reader.readLine();
				System.out.print("Entidad bancaria: ");
				String entidadBancaria = reader.readLine();
				
				exitCode = this.sistemaCocheras.crearContratoCheque(dni, patente, nroCochera, 
						nombreAbono, fecha, nroCuentaCorriente, entidadBancaria);
			}
			else if (medioPagoCliente.equalsIgnoreCase(MediosPagoCliente.DEBITO_TARJETA_CREDITO))
			{
				System.out.print("Numero tarjeta: ");
				String nroTarjeta = reader.readLine();
				System.out.print("Fecha de vencimiento de la tarjeta: ");
				Date vencimientoTarjeta = FechaUtils.parsearFecha(reader.readLine());
				System.out.print("Entidad emisora de la tarjeta: ");
				String entidadEmisoraTarjeta = reader.readLine();
				
				exitCode = this.sistemaCocheras.crearContratoTarjetaCredito(dni, patente, nroCochera, nombreAbono, fecha, nroTarjeta, vencimientoTarjeta, entidadEmisoraTarjeta);
			}
			else if (medioPagoCliente.equalsIgnoreCase(MediosPagoCliente.DEBITO_CBU))
			{
				System.out.print("CBU: ");
				String cbu = reader.readLine();
				System.out.print("Entidad bancaria: ");
				String entidadBancaria = reader.readLine();
				
				exitCode = this.sistemaCocheras.crearContratoDebitoAutomatico(dni, patente, nroCochera, nombreAbono, fecha, cbu, entidadBancaria);
			}	
			else
			{
				System.out.println("La opci�n ingresada es inv�lida.");
			}
			
			switch(exitCode) {
			case ExitCodes.OK: {
				System.out.println("El contrato se ha creado con �xito.");
				break;
			}
			case ExitCodes.ARGUMENTOS_INVALIDOS: {
				System.out.println("Alguno de los argumentos es inv�lido.");
				break;
			}
			case ExitCodes.COCHERA_NO_DISPONIBLE: {
				System.out.println("La cochera no esta disponible.");
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
	
	private void modificarContrato() {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("MODIFICACION DE CONTRATO");
			System.out.println("------------------------");
			System.out.print("DNI: ");
			String dni = reader.readLine();
			
			Vector<ContratoView> contratosVigentes = this.sistemaCocheras.listarContratos(dni, true);
			
			if(contratosVigentes != null && contratosVigentes.size() > 0) {				
				
				System.out.println("NRO.CONTRATO\tFECHA\tPATENTE\tCOCHERA\tABONO\tESTADO");
				System.out.println("--------------------------");
				
				for (ContratoView cv: contratosVigentes) {				
					String linea = String.format("%d\t%s\t%s\t%d\t%s\t%s", 
							cv.getNroContrato(),
							FechaUtils.formatearFecha(cv.getFecha()),
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
						System.out.println("El contrato se ha modificado con �xito.");
						break;
					}
					case ExitCodes.NO_EXISTE_ENTIDAD: {
						System.out.println("El contrato no existe.");
						break;
					}
					case ExitCodes.ARGUMENTOS_INVALIDOS: {
						System.out.println("Alguno de los argumentos es inv�lido.");
						break;
					}
					default: {
						break;
					}
				}
			}
			else {
				System.out.println("El cliente no posee contratos vigentes.");
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
					String linea = String.format("%d\t%s\t%s\t%d\t%s\t%s", 
							cv.getNroContrato(),
							FechaUtils.formatearFecha(cv.getFecha()),
							cv.getPatenteAuto(),
							cv.getNroCochera(),
							cv.getAbono(),
							cv.getEstado() ? "Activo" : "Inactivo");
					
					System.out.println(linea);
				}
				
				System.out.print("Ingresar numero de contrato: ");
				int numero = Integer.parseInt(reader.readLine());
				
				int exitCode = this.sistemaCocheras.bajaContrato(numero);
				
				switch(exitCode) {
					case ExitCodes.OK: {
						System.out.println("El contrato se ha eliminado con �xito.");
						break;
					}
					case ExitCodes.NO_EXISTE_ENTIDAD: {
						System.out.println("El contrato no existe.");
						break;
					}
					case ExitCodes.ARGUMENTOS_INVALIDOS: {
						System.out.println("Alguno de los argumentos es inv�lido.");
						break;
					}
					default: {
						break;
					}
				}
			}
			else {
				System.out.println("El cliente no posee contratos vigentes.");
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void listarContratos() {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("DNI: ");
			String dni = reader.readLine();
			
			Vector<ContratoView> contratosView = this.sistemaCocheras.listarContratos(dni, false);	
			
			if (contratosView != null && contratosView.size() > 0) {
				System.out.println("NRO.CONTRATO\tFECHA\tPATENTE\tCOCHERA\tABONO\tESTADO");
				
				for (ContratoView cv: contratosView) {				
					String linea = String.format("%d\t%s\t%s\t%s\t%s\t%s", 
							cv.getNroContrato(),
							FechaUtils.formatearFecha(cv.getFecha()),
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
	
	/*********** Fin Regi�n: CONTRATOS ***********/ 
	
	
	/*********** Regi�n: COCHERA ***********/ 
	
	private void crearCochera() {
		try 
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("ALTA DE COCHERA");
			System.out.println("-----------------------");
			String tamVehiculo = String.format("Tama�o veh�culo admitido (%d: peque�a, %d: mediana, %d: grande): ",
							Tamanios.PEQUENIA, Tamanios.MEDIANA, Tamanios.GRANDE);
			System.out.print(tamVehiculo);
			int tamanio = Integer.parseInt(reader.readLine());

			int exitCode = sistemaCocheras.crearCochera(tamanio);

			switch (exitCode) {
			case ExitCodes.OK: {
				System.out.println("La cochera se ha creado con �xito.");
				break;
			}
			case ExitCodes.NO_EXISTE_ENTIDAD: {
				System.out.println("La cochera no existe.");
				break;
			}
			case ExitCodes.ARGUMENTOS_INVALIDOS: {
				System.out.println("Alguno de los argumentos es inv�lido.");
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
				String tamVehiculo = String.format("Tama�o veh�culo admitido (%d: peque�a, %d: mediana, %d: grande): ", 
						Tamanios.PEQUENIA, Tamanios.MEDIANA, Tamanios.GRANDE);
				System.out.print(tamVehiculo);
				int tamanio = Integer.parseInt(reader.readLine());
				System.out.print("Estado: ");
				int estado = Integer.parseInt(reader.readLine());
				
				int exitCode = sistemaCocheras.modificarCochera(numero, tamanio, estado);
				
				switch(exitCode) {
					case ExitCodes.OK: {
						System.out.println("La cochera se ha modificado con �xito.");
						break;
					}
					case ExitCodes.NO_EXISTE_ENTIDAD: {
						System.out.println("La cochera no existe.");
						break;
					}
					case ExitCodes.ARGUMENTOS_INVALIDOS: {
						System.out.println("Alguno de los argumentos es inv�lido.");
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
					System.out.println("La cochera se ha dado de baja con �xito.");	
					break;
				}
				case ExitCodes.NO_EXISTE_ENTIDAD: {
					System.out.println("La cochera no existe.");
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inv�lido.");
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
	
	private void listarCocheras() {
		try
		{
			Vector<CocheraView> cocherasView = this.sistemaCocheras.listarCocheras();
			
			if (cocherasView != null && cocherasView.size() > 0) {
				System.out.println("NUMERO\tTAMA�O\tESTADO");
				
				for (CocheraView cv: cocherasView) {
					String tamanio;
					String estado;
					
					switch(cv.getTamanioVechiculoAdmitido()) {
						case Tamanios.PEQUENIA:
							tamanio = "Peque�o";
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
	
	/*********** Fin Regi�n: COCHERA ***********/ 
	
	
	/*********** Regi�n: AUTOS ***********/ 
	
	private void crearAuto() throws Exception {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("ALTA DE AUTO");
			System.out.println("------------");
			System.out.print("DNI");
			String dni = reader.readLine();
			System.out.print("Patente: ");
			String patente = reader.readLine();	
			System.out.print("Marca: ");
			String marca = reader.readLine();
			System.out.print("Modelo: ");
			String modelo = reader.readLine();
			System.out.print("Fecha de entrada: ");
			Date fechaEntrada = FechaUtils.parsearFecha(reader.readLine());
			
			int exitCode = sistemaCocheras.crearAuto(dni, patente, marca, fechaEntrada, modelo);
			
			switch(exitCode) {
				case ExitCodes.OK: {
					System.out.println("El auto se ha creado con �xito.");	
					break;
				}
				case ExitCodes.YA_EXISTE_ENTIDAD: {
					System.out.println("El auto ya existe.");	
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inv�lido.");	
					break;
				}
				case ExitCodes.NO_EXISTE_ENTIDAD: {
					System.out.println("El cliente no existe.");	
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
	
	private void modificarAuto() {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("MODIFICACION DE AUTO");
			System.out.println("---------------------");
			System.out.print("DNI: ");
			String dni = reader.readLine();
			
			Vector<AutoView> autosView = this.sistemaCocheras.listarAutos(dni);
			
			if(autosView != null && autosView.size() > 0) {				
				
				System.out.println("PATENTE\tMARCA\tMODELO\tF.ENTRADA\tESTADO");
				System.out.println("--------------------------");
				
				for (AutoView av: autosView) {				
					String linea = String.format("%s\t%s\t\t%s\t%s\t%s", 
							av.getPatente(),
							av.getMarca(),
							av.getModelo(),
							FechaUtils.formatearFecha(av.getFechaEntrada()),
							av.getActivo() ? "Activo" : "Inactivo");
					
					System.out.println(linea);
				}
				
				System.out.print("Ingresar patente: ");
				String patente = reader.readLine();
				
				System.out.print("Ingresar marca: ");
				String marca = reader.readLine();
				
				System.out.print("Ingresar modelo: ");
				String modelo = reader.readLine();
				
				System.out.print("Ingresar fecha de entrada: ");
				Date fechaEntrada = FechaUtils.parsearFecha(reader.readLine());
								
				int exitCode = sistemaCocheras.modificarAuto(dni, patente, marca, fechaEntrada, modelo, true);
				
				switch(exitCode) {
					case ExitCodes.OK: {
						System.out.println("El auto se ha modificado con �xito.");
						break;
					}
					case ExitCodes.NO_EXISTE_ENTIDAD: {
						System.out.println("El cliente no existe.");
						break;
					}
					case ExitCodes.ARGUMENTOS_INVALIDOS: {
						System.out.println("Alguno de los argumentos es inv�lido.");
						break;
					}
					case ExitCodes.NO_EXISTE_AUTO: {
						System.out.println("El auto no existe.");
						break;
					}
					default: {
						break;
					}
				}
			}
			else {
				System.out.println("El cliente no posee autos.");
			}
			
			this.mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void bajaAuto() {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("BAJA DE AUTO");
			System.out.println("---------------");
			System.out.print("DNI: ");
			String dni = reader.readLine();
			System.out.print("Patente: ");
			String patente = reader.readLine();
			
			int exitCode = sistemaCocheras.bajaAuto(dni, patente);
			
			switch(exitCode) {
				case ExitCodes.OK: {
					System.out.println("El auto se ha dado de baja con �xito.");	
					break;
				}
				case ExitCodes.NO_EXISTE_ENTIDAD: {
					System.out.println("El cliente no existe.");
					break;
				}
				case ExitCodes.ARGUMENTOS_INVALIDOS: {
					System.out.println("Alguno de los argumentos es inv�lido.");
					break;
				}
				case ExitCodes.AUTO_CONTRATO_VIGENTE: {
					System.out.println("El auto est� asociado a un contrato vigente.");
					break;
				}
				case ExitCodes.NO_EXISTE_AUTO: {
					System.out.println("El auto no existe.");
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
	
	private void listarAutos() {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("DNI: ");
			String dni = reader.readLine();
			
			Vector<AutoView> autosView = this.sistemaCocheras.listarAutos(dni);	
			
			if (autosView != null && autosView.size() > 0) {
				System.out.println("PATENTE\tMARCA\t\tMODELO\t\tF.ENTRADA\tESTADO");
				System.out.println("--------------------------");
				
				for (AutoView av: autosView) {				
					String linea = String.format("%s\t%s\t\t%s\t\t%s\t%s", 
							av.getPatente(),
							av.getMarca(),
							av.getModelo(),
							FechaUtils.formatearFecha(av.getFechaEntrada()),
							av.getActivo() ? "Activo" : "Inactivo");
					
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
	
	
	/*********** Fin Regi�n: AUTOS ***********/ 
	
	
	/*********** Regi�n: DATOS PRUEBA ***********/ 
	
	private void mostrarMenuGenerarDatosPrueba() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 	
			//Imprimo menu de opciones
			System.out.println();
			System.out.println("GENERAR DATOS DE PRUEBA");
			System.out.println("------------------------");
			System.out.print("Cantidad de datos a generar: ");
			int cantidad = Integer.parseInt(reader.readLine());
			
			this.sistemaCocheras.generarDatosPrueba(cantidad);
			
			this.mostrarMenu();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*********** Fin Regi�n: DATOS PRUEBA ***********/ 
}
