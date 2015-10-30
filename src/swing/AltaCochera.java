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

public class AltaCochera extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton alta;
	private JTextField tamanio;
	
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
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("1 pequena - 2 mediana - 3 grande");
				jLabel2.setBounds(21, 94, 200, 28);
			}
			{
				tamanio = new JTextField();
				getContentPane().add(tamanio);
				tamanio.setBounds(169, 69, 210, 28);
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
						int rdo = -1;
						if(!isInteger(tamanio.getText())){
							rdo = ExitCodes.ARGUMENTOS_INVALIDOS;
						}
						if(rdo == -1){
							rdo = sistemaCocheras.crearCochera(Integer.parseInt(tamanio.getText()));
						}																		
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
							tamanio.setText("");														
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
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}

}
