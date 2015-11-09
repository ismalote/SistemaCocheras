package swing;

import controlador.SistemaCocheras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import enums.ExitCodes;

public class AltaCochera extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JButton alta;
	private JComboBox<String> tamanio;
	
	private SistemaCocheras sistemaCocheras;
	
	public AltaCochera(SistemaCocheras s) {
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
				titulo.setText("AGREGAR COCHERA");
				titulo.setBounds(130, 20, 258, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Tamano:");
				jLabel1.setBounds(21, 69, 113, 28);
			}
			{
				String[] tamanios = { "", "Pequena", "Mediana", "Grande" };
				tamanio = new JComboBox<String>(tamanios);
				getContentPane().add(tamanio);
				tamanio.setBounds(169, 69, 100, 28);
			}
			{
				alta = new JButton();
				getContentPane().add(alta);
				alta.setText("CONFIRMAR");
				alta.setBounds(169, 138, 113, 28);
				alta.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int	rdo = sistemaCocheras.crearCochera(tamanio.getSelectedIndex());																
						String mensaje = "";
						switch (rdo) {
							case ExitCodes.OK: {
								mensaje = "La cochera se ha creado con exito.";
								break;
							}
							case ExitCodes.NO_EXISTE_ENTIDAD: {
								mensaje = "La cochera no existe.";
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
							tamanio.setSelectedIndex(0);														
						}						
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/lot.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 220);
			setTitle("Agregar Cochera");
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
