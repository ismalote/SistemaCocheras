package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import vista.ClienteView;
import controlador.SistemaCocheras;
import enums.EstadosCliente;
import enums.ExitCodes;


public class EliminarCliente extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JButton buscar;
	private JButton baja;
	private JTextField dniCliente;
	private JTextField dni;	
	private JTextField telefono;
	private JTextField domicilio;
	private JTextField nombre;
	private JTextField mail;	
	
	private SistemaCocheras sistemaCocheras;
	private ClienteView cliente;

	public static void main(String[] args) {
		ModificarCliente inst = new ModificarCliente();
		inst.setVisible(true);
	}
	
	public EliminarCliente ()
	{
		
	}
	public EliminarCliente(SistemaCocheras s) {
		super();
		sistemaCocheras = s;
		initGUI();		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				titulo = new JLabel();
				getContentPane().add(titulo);
				titulo.setText("ELIMINAR CLIENTE");
				titulo.setBounds(150, 20, 148, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("DNI:");
				jLabel1.setBounds(21, 118, 63, 28);
				jLabel1.setVisible(false);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre:");
				jLabel2.setBounds(21, 167, 63, 28);
				jLabel2.setVisible(false);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Domicilio:");
				jLabel3.setBounds(21, 216, 63, 28);
				jLabel3.setVisible(false);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Mail:");
				jLabel4.setBounds(21, 265, 63, 28);
				jLabel4.setVisible(false);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Telefono:");
				jLabel5.setBounds(21, 314, 63, 28);
				jLabel5.setVisible(false);
			}
			{
				dni = new JTextField();
				getContentPane().add(dni);
				dni.setBounds(119, 118, 210, 28);
				dni.setVisible(false);				
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(119, 167, 210, 28);
				nombre.setVisible(false);
			}
			{
				domicilio = new JTextField();
				getContentPane().add(domicilio);
				domicilio.setBounds(119, 216, 210, 28);
				domicilio.setVisible(false);
			}
			{
				mail = new JTextField();
				getContentPane().add(mail);
				mail.setBounds(119, 265, 210, 28);
				mail.setVisible(false);
			}
			{
				telefono = new JTextField();
				getContentPane().add(telefono);
				telefono.setBounds(119, 314, 210, 28);
				telefono.setVisible(false);
			}
			{
				baja = new JButton();
				getContentPane().add(baja);
				baja.setText("CONFIRMAR");
				baja.setBounds(119, 363, 113, 28);
				baja.setVisible(false);
				baja.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = sistemaCocheras.bajaCliente(dni.getText());
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El cliente se ha dado de baja con exito.";	
								break;
							}
							case ExitCodes.NO_EXISTE_ENTIDAD: {
								mensaje = "El cliente no existe.";
								break;
							}
							case ExitCodes.ARGUMENTOS_INVALIDOS: {
								mensaje = "Alguno de los argumentos es invalido.";
								break;
							}
							case ExitCodes.CLIENTE_CONTRATOS_VIGENTES: {
								mensaje = "El cliente posee contratos vigentes.";
								break;
							}
							default: {
								break;
							}
						}
						JOptionPane.showMessageDialog(null, mensaje);
						if(rdo == ExitCodes.OK){
							jLabel1.setVisible(false);
							jLabel2.setVisible(false);
							jLabel3.setVisible(false);
							jLabel4.setVisible(false);
							jLabel5.setVisible(false);
							dniCliente.setText("");
							dni.setVisible(false);
							nombre.setVisible(false);
							domicilio.setVisible(false);
							mail.setVisible(false);
							telefono.setVisible(false);
							baja.setVisible(false);
						}
					}
				});
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Ingrese DNI:");
				jLabel6.setBounds(21, 69, 98, 28);
			}
			{
				dniCliente = new JTextField();
				getContentPane().add(dniCliente);
				dniCliente.setBounds(119, 69, 127, 28);
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("BUSCAR");
				buscar.setBounds(260, 69, 87, 28);
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cliente = sistemaCocheras.buscarDatosCliente(dniCliente.getText());
						if (cliente != null && cliente.getEstado() == EstadosCliente.ACTIVO)
						{
							jLabel1.setVisible(true);
							jLabel2.setVisible(true);
							jLabel3.setVisible(true);
							jLabel4.setVisible(true);
							jLabel5.setVisible(true);
							dni.setVisible(true);
							dni.setEnabled(false);
							nombre.setVisible(true);
							nombre.setEnabled(false);
							domicilio.setVisible(true);
							domicilio.setEnabled(false);
							telefono.setVisible(true);
							telefono.setEnabled(false);
							mail.setVisible(true);
							mail.setEnabled(false);
							baja.setVisible(true);
							dni.setText(cliente.getDni());
							nombre.setText(cliente.getNombre());
							domicilio.setText(cliente.getDomicilio());
							mail.setText(cliente.getMail());
							telefono.setText(cliente.getTelefono());
						}else{
							JOptionPane.showMessageDialog(null, "El cliente no existe.");
							jLabel1.setVisible(false);
							jLabel2.setVisible(false);
							jLabel3.setVisible(false);
							jLabel4.setVisible(false);
							jLabel5.setVisible(false);
							dni.setVisible(false);
							nombre.setVisible(false);							
							domicilio.setVisible(false);
							telefono.setVisible(false);
							mail.setVisible(false);
							baja.setVisible(false);
						}
					}
				});
			}
			pack();
			setSize(400, 600);
			setTitle("Sistema de Cocheras - Eliminar Cliente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
