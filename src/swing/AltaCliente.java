package swing;

import controlador.SistemaCocheras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import enums.ExitCodes;

public class AltaCliente extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton alta;
	private JTextField dni;
	private JTextField nombre;
	private JTextField domicilio;
	private JTextField mail;
	private JTextField telefono;	
	
	private SistemaCocheras sistemaCocheras;

	public static void main(String[] args) {
		AltaCliente inst = new AltaCliente();
		inst.setVisible(true);
	}
	
	public AltaCliente ()
	{
		
	}
	
	public AltaCliente(SistemaCocheras s) {
		super();
		initGUI();
		sistemaCocheras = s;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				titulo = new JLabel();
				getContentPane().add(titulo);
				titulo.setText("ALTA CLIENTE");
				titulo.setBounds(150, 20, 88, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("DNI:");
				jLabel1.setBounds(21, 69, 63, 28);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre:");
				jLabel2.setBounds(21, 118, 63, 28);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Domicilio:");
				jLabel3.setBounds(21, 167, 63, 28);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Mail:");
				jLabel4.setBounds(21, 216, 63, 28);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Telefono:");
				jLabel5.setBounds(21, 265, 63, 28);
			}
			{
				dni = new JTextField();
				getContentPane().add(dni);
				dni.setBounds(119, 69, 210, 28);
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(119, 118, 210, 28);
			}
			{
				domicilio = new JTextField();
				getContentPane().add(domicilio);
				domicilio.setBounds(119, 167, 210, 28);
			}
			{
				mail = new JTextField();
				getContentPane().add(mail);
				mail.setBounds(119, 216, 210, 28);
			}
			{
				telefono = new JTextField();
				getContentPane().add(telefono);
				telefono.setBounds(119, 265, 210, 28);
			}
			{
				alta = new JButton();
				getContentPane().add(alta);
				alta.setText("CONFIRMAR");
				alta.setBounds(119, 314, 113, 28);
				alta.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{				
						int rdo = sistemaCocheras.crearCliente(dni.getText(), nombre.getText(), domicilio.getText(), mail.getText(), telefono.getText());
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El cliente se ha creado con exito.";	
								break;
							}
							case ExitCodes.YA_EXISTE_ENTIDAD: {
								mensaje = "El cliente ya existe.";	
								break;
							}
							case ExitCodes.ARGUMENTOS_INVALIDOS: {
								mensaje = "Alguno de los argumentos es invalido.";	
								break;
							}
							default: {
								break;
							}	
						}
						JOptionPane.showMessageDialog(null, mensaje);						
						if(rdo == ExitCodes.OK){							
							dni.setText("");
							nombre.setText("");
							domicilio.setText("");
							mail.setText("");
							telefono.setText("");
						}
						
					}
				});
			}
			pack();
			setSize(400, 400);
			setTitle("Agregar Cliente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
