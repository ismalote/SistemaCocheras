package controlador;

import java.util.Vector;

public class SistemaCocheras {
	
	private Vector<Contrato> contratos;
	private Vector<Cliente> clientes;
	private Vector<MedioPago> mediosPagos;
	private Vector<Cochera> cocheras;
	private Vector<Abono> abonos;
	
	public int crearCliente(String nombre, String domicilio, String mail, String telefono, String  dni){
		
		if(dni.length() > 0 && nombre.length() > 0 && domicilio.length() > 0 && mail.length() > 0){
			Cliente cliente = buscarCliente(dni);
			
			if(cliente == null){
				cliente = new Cliente(dni, nombre, domicilio, mail, telefono);
				clientes.add(cliente);
				return 1;
			}else{
				return -1;
			}
		}else{
			return 0;
		}
	}
	
	public int modificarCliente(String nombre, String domicilio, String mail, String telefono, String dni, int estado){
		
		if(dni.length() > 0 && nombre.length() > 0 && domicilio.length() > 0 && mail.length() > 0){
			Cliente cliente = buscarCliente(dni);
			
			if(cliente != null){
				cliente.setNombre(nombre);
				cliente.setDomicilio(domicilio);
				cliente.setMail(mail);
				cliente.setTelefono(telefono);
				cliente.setEstado(estado);
				return 1;
			}else{
				return -1;
			}
		}else{
			return 0;
		}
	}
	
	public int bajaCliente(String dni){
		
		if(dni.length() > 0){
			Cliente cliente = buscarCliente(dni);
			
			if(cliente != null){
				cliente.setEstado(0);
				return 1;
			}else{
				return -1;
			}
		}else{
			return 0;
		}
	}
	
	public int crearMedioPago(String nombreEntidad, String nombreArchivoEntrada,
			String nombreArchivoSalida, String direccionFTP){
		// TODO
		return 0;
	}
	
	public Vector<Contrato> buscarContratosVigentes(String dni){
		// TODO
		return null;
	}
	
	private Cliente buscarCliente(String dni){
		Cliente c = null;
		
		for(Cliente cte: clientes){
			if(cte.getDni().contains(dni)){
				c = cte;
			}
		}
		return c;
	}
}
