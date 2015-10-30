package swing;

import controlador.SistemaCocheras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import enums.ExitCodes;

public class AltaMedioPago extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;	
	private JButton alta;
	private JTextField entidad;
	private JTextField archivoEntrada;
	private JTextField archivoSalida;
	private JTextField ftp;	
	
	private SistemaCocheras sistemaCocheras;
	
	public AltaMedioPago(SistemaCocheras s) {
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
				titulo.setText("AGREGAR MEDIO DE PAGO");
				titulo.setBounds(120, 20, 258, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Entidad:");
				jLabel1.setBounds(21, 69, 113, 28);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Archivo Entrada:");
				jLabel2.setBounds(21, 118, 113, 28);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Archivo Salida:");
				jLabel3.setBounds(21, 167, 113, 28);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Direccion FTP:");
				jLabel4.setBounds(21, 216, 113, 28);
			}
			{
				entidad = new JTextField();
				getContentPane().add(entidad);
				entidad.setBounds(169, 69, 210, 28);
			}
			{
				archivoEntrada = new JTextField();
				getContentPane().add(archivoEntrada);
				archivoEntrada.setBounds(169, 118, 210, 28);
			}
			{
				archivoSalida = new JTextField();
				getContentPane().add(archivoSalida);
				archivoSalida.setBounds(169, 167, 210, 28);
			}
			{
				ftp = new JTextField();
				getContentPane().add(ftp);
				ftp.setBounds(169, 216, 210, 28);
			}
			{
				alta = new JButton();
				getContentPane().add(alta);
				alta.setText("CONFIRMAR");
				alta.setBounds(119, 265, 113, 28);
				alta.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = sistemaCocheras.crearMedioPago(entidad.getText(), archivoEntrada.getText(), archivoSalida.getText(), ftp.getText());												
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El medio de pago se ha creado con exito.";
								break;
							}
							case ExitCodes.YA_EXISTE_ENTIDAD: {
								mensaje = "El medio de pago ya existe.";	
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
							entidad.setText("");
							archivoEntrada.setText("");
							archivoSalida.setText("");
							ftp.setText("");							
						}
						
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/pago.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 350);
			setTitle("Agregar Medio de Pago");
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
