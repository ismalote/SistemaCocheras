package swing;

import controlador.SistemaCocheras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import enums.ExitCodes;
import utils.*;

public class AltaAuto extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;	
	private JButton alta;
	private JTextField patente;
	private JTextField marca;
	private JTextField modelo;
	private JTextField fecha;	
	
	private SistemaCocheras sistemaCocheras;
	private String dniCliente;
	
	public AltaAuto(SistemaCocheras s, String d) {
		super();
		
		sistemaCocheras = s;
		dniCliente = d;
		initGUI(dniCliente);
	}
	
	private void initGUI(final String dniCliente) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);			
			{
				titulo = new JLabel();
				getContentPane().add(titulo);
				titulo.setText("AGREGAR AUTO PARA CLIENTE: " + dniCliente);
				titulo.setBounds(90, 20, 258, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Patente:");
				jLabel1.setBounds(21, 69, 113, 28);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Marca:");
				jLabel2.setBounds(21, 118, 113, 28);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Modelo:");
				jLabel3.setBounds(21, 167, 113, 28);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Fecha de Entrada:");
				jLabel4.setBounds(21, 216, 113, 28);
			}
			{
				patente = new JTextField();
				getContentPane().add(patente);
				patente.setBounds(145, 69, 75, 28);
			}
			{
				marca = new JTextField();
				getContentPane().add(marca);
				marca.setBounds(145, 118, 210, 28);
			}
			{
				modelo = new JTextField();
				getContentPane().add(modelo);
				modelo.setBounds(145, 167, 210, 28);
			}
			{
				fecha = new JTextField();
				fecha.setText(FechaUtils.formatearFecha(Calendar.getInstance().getTime()));
				getContentPane().add(fecha);
				fecha.setBounds(145, 216, 75, 28);
			}
			{
				alta = new JButton();
				getContentPane().add(alta);
				alta.setText("CONFIRMAR");
				alta.setBounds(145, 265, 113, 28);
				alta.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{						
						int rdo = sistemaCocheras.crearAuto(dniCliente, patente.getText(), marca.getText(), FechaUtils.parsearFecha(fecha.getText()), modelo.getText());						
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El auto se ha creado con exito.";	
								break;
							}
							case ExitCodes.YA_EXISTE_ENTIDAD: {
								mensaje = "El auto ya existe.";	
								break;
							}
							case ExitCodes.ARGUMENTOS_INVALIDOS: {
								mensaje = "Alguno de los argumentos es invalido.";	
								break;
							}
							case ExitCodes.NO_EXISTE_ENTIDAD: {
								mensaje = "El cliente no existe.";	
								break;
							}
							default: {
								break;
							}
						}
						JOptionPane.showMessageDialog(null, mensaje);						
						if(rdo == ExitCodes.OK){							
							patente.setText("");
							marca.setText("");
							modelo.setText("");
							fecha.setText(FechaUtils.formatearFecha(Calendar.getInstance().getTime()));							
						}
						
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/auto.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 350);
			setTitle("Agregar Auto");
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
