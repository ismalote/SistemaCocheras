package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controlador.SistemaCocheras;
import enums.ExitCodes;

public class GenerarProximasCuotas extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JButton generar;
	
	private SistemaCocheras sistemaCocheras;
	
	public GenerarProximasCuotas(SistemaCocheras s) {
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
				titulo.setText("GENERAR PROXIMAS CUOTAS");
				titulo.setBounds(60, 20, 258, 28);
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
						int rdo = sistemaCocheras.generarCuotas();

						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "Las proximas cuotas se han generado con exito.";	
								break;
							}
							case ExitCodes.FALLA_GENERACION_CUOTAS: {
								mensaje = "La generacion de proximas cuotas ha fallado.";	
								break;
							}
							default: {
								break;
							}
						}
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
