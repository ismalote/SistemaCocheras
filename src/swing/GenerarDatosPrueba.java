package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.SistemaCocheras;
import utils.NumeroUtils;

public class GenerarDatosPrueba extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JTextField cantidad;
	private JButton generar;
	
	private SistemaCocheras sistemaCocheras;
	
	public GenerarDatosPrueba(SistemaCocheras s) {
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
				titulo.setText("GENERAR DATOS DE PRUEBA");
				titulo.setBounds(60, 20, 258, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Cantidad de datos a generar:");
				jLabel1.setBounds(21, 69, 180, 28);
			}
			{
				cantidad = new JTextField();
				getContentPane().add(cantidad);
				cantidad.setBounds(200, 69, 50, 28);
			}
			{
				generar = new JButton();
				getContentPane().add(generar);
				generar.setText("GENERAR");
				generar.setBounds(90, 120, 113, 28);
				generar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{		
						String mensaje = "";
						if(NumeroUtils.isInteger(cantidad.getText()) && Integer.parseInt(cantidad.getText()) > 0){
							sistemaCocheras.generarDatosPrueba(Integer.parseInt(cantidad.getText()));
							mensaje = "Los datos se han generado con exito.";							
						} else {
							mensaje = "Ingrese un numero entero positivo.";						
						}
						cantidad.setText("");
						JOptionPane.showMessageDialog(null, mensaje);						
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/sistema.png");
			setIconImage(img.getImage());
			pack();
			setSize(300, 200);
			setTitle("Generar datos de prueba");
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
