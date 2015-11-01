package swing;

import controlador.SistemaCocheras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import enums.ExitCodes;
import utils.*;

public class AltaAbono extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton alta;
	private JTextField nombre;
	private JTextField dias;
	private JTextField precio;
	private JTextField descuento;
	private JComboBox<String> cochera;	
	
	private SistemaCocheras sistemaCocheras;
	
	public AltaAbono(SistemaCocheras s) {
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
				titulo.setText("ALTA ABONO");
				titulo.setBounds(150, 20, 88, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Nombre:");
				jLabel1.setBounds(21, 69, 113, 28);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Cantidad de Dias:");
				jLabel2.setBounds(21, 118, 113, 28);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Precio Base:");
				jLabel3.setBounds(21, 167, 113, 28);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Descuento:");
				jLabel4.setBounds(21, 216, 113, 28);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Cochera:");
				jLabel5.setBounds(21, 265, 113, 28);
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(169, 69, 210, 28);
			}
			{
				dias = new JTextField();
				getContentPane().add(dias);
				dias.setBounds(169, 118, 210, 28);
			}
			{
				precio = new JTextField();
				getContentPane().add(precio);
				precio.setBounds(169, 167, 210, 28);
			}
			{
				descuento = new JTextField();
				getContentPane().add(descuento);
				descuento.setBounds(169, 216, 210, 28);
			}
			{
				String[] tamanios = { "", "Pequena", "Mediana", "Grande" };
				cochera = new JComboBox<String>(tamanios);
				getContentPane().add(cochera);
				cochera.setBounds(169, 265, 210, 28);
			}
			{
				alta = new JButton();
				getContentPane().add(alta);
				alta.setText("CONFIRMAR");
				alta.setBounds(169, 335, 113, 28);
				alta.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{	
						int rdo = -1;
						if(!NumeroUtils.isInteger(dias.getText()) || !NumeroUtils.isFloat(precio.getText()) || !NumeroUtils.isFloat(descuento.getText())){
							rdo = ExitCodes.ARGUMENTOS_INVALIDOS;
						}
						if(rdo == -1){
							rdo = sistemaCocheras.crearAbono(nombre.getText(), Integer.parseInt(dias.getText()), Float.parseFloat(precio.getText()), Float.parseFloat(descuento.getText()), cochera.getSelectedIndex());
						}
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El abono se ha creado con exito.";	
								break;
							}
							case ExitCodes.YA_EXISTE_ENTIDAD: {
								mensaje = "El abono ya existe.";	
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
							nombre.setText("");
							dias.setText("");
							precio.setText("");
							descuento.setText("");
							cochera.setSelectedIndex(0);
						}
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/abono.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 415);
			setTitle("Agregar Abono");
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
