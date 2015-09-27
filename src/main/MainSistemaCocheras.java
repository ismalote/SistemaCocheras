package main;

import java.io.*;

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

	public void mostrarMenu() {
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
		  			// Alta;
		  			break;
		  		}
			  	case '2' : {
			  		// Modificacion
			  		break;
			  	}
			  	case '3' : {
			  		// Baja;
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
		  			// Alta;
		  			break;
		  		}
			  	case '2' : {
			  		// Modificacion
			  		break;
			  	}
			  	case '3' : {
			  		// Baja;
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
	
	public void crearCliente() 
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
	
	public void modificarCliente() 
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
	
	public void bajaCliente() 
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
	
	public void crearMedioPago() 
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
	
	public void bajaMedioPago() 
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
	
	
	/*********** Fin Región: ABONOS ***********/ 
	
	
	/*********** Región: CONTRATOS ***********/ 
	
	
	/*********** Fin Región: CONTRATOS ***********/ 
}
