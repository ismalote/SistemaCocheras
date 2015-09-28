package main;

import java.io.*;
import java.util.Hashtable;

import controlador.*;
import enums.*;
import vista.*;

public class MainSistemaCocheras {

	/*********** Región: INICIALIZACIÓN ***********/ 
	
	private SistemaCocheras sistemaCocheras;
	private Hashtable<Integer, ContratoView> contratosVigentesCliente; 
	
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
			  		bajaCliente();
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
			System.out.print("Tamaño cochera (1: pequeña, 2: mediana, 3: grande): ");
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
				System.out.print("Tamaño cochera (1: pequeña, 2: mediana, 3: grande): ");
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
			
			if(this.listarContratosVigentesCliente(dni)) {
				System.out.print("Ingresar #: ");
				int indice = Integer.parseInt(reader.readLine());
				
				System.out.print("Ingresar abono: ");
				String abono = reader.readLine();
								
				int exitCode = sistemaCocheras.modificarContrato(this.contratosVigentesCliente.get(indice).getNroContrato(), abono);
				
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
			
			if(this.listarContratosVigentesCliente(dni)) {
				System.out.print("Ingresar #: ");
				int indice = Integer.parseInt(reader.readLine());
								
				int exitCode = sistemaCocheras.bajaContrato(this.contratosVigentesCliente.get(indice).getNroContrato());
				
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
	
	private boolean listarContratosVigentesCliente(String dni) {
		this.contratosVigentesCliente = this.sistemaCocheras.buscarDatosContratosVigentes(dni);
		
		if (this.contratosVigentesCliente != null && this.contratosVigentesCliente .size() > 0)
		{
			System.out.println("#\tCOCHERA\tFECHA\tABONO\tPATENTE");
			System.out.println("----------------------------------");
			
			// Listo los contratos activos del cliente con un índice para elegirlo.
			for(Integer key: this.contratosVigentesCliente .keySet()) {
				ContratoView cv = this.contratosVigentesCliente .get(key);
				String linea = String.format("%d\t%d\t%td/%tm/%ty\t%s\t%s", 
						key,
						cv.getNroCochera(),
						cv.getFecha(),
						cv.getAbono(),
						cv.getPatenteAuto());
				
				System.out.println(linea);
			}
			
			return true;
		}
		else {		
			return false;
		}
	}
	
	/*********** Fin Región: CONTRATOS ***********/ 
}
