package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import vista.AbonoView;
import controlador.SistemaCocheras;
import enums.ExitCodes;

public class ModificarAbono extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JButton buscar;
	private JButton modificar;
	private JTextField nombreAbono;
	private JTextField nombre;	
	private JTextField dias;
	private JTextField precio;
	private JTextField descuento;
	private JTextField cochera;	
	
	private SistemaCocheras sistemaCocheras;
	private AbonoView abono;

	public ModificarAbono(SistemaCocheras s) {
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
				titulo.setText("MODIFICAR ABONO");
				titulo.setBounds(140, 20, 148, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Nombre:");
				jLabel1.setBounds(21, 118, 113, 28);
				jLabel1.setVisible(false);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Cantidad de Dias:");
				jLabel2.setBounds(21, 167, 113, 28);
				jLabel2.setVisible(false);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Precio Base:");
				jLabel3.setBounds(21, 216, 113, 28);
				jLabel3.setVisible(false);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Descuento:");
				jLabel4.setBounds(21, 265, 113, 28);
				jLabel4.setVisible(false);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Cochera:");
				jLabel5.setBounds(21, 314, 113, 28);
				jLabel5.setVisible(false);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("1 pequena - 2 mediana - 3 grande");
				jLabel7.setBounds(21, 335, 200, 28);
				jLabel7.setVisible(false);
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(169, 118, 210, 28);
				nombre.setVisible(false);				
			}
			{
				dias = new JTextField();
				getContentPane().add(dias);
				dias.setBounds(169, 167, 210, 28);
				dias.setVisible(false);
			}
			{
				precio = new JTextField();
				getContentPane().add(precio);
				precio.setBounds(169, 216, 210, 28);
				precio.setVisible(false);
			}
			{
				descuento = new JTextField();
				getContentPane().add(descuento);
				descuento.setBounds(169, 265, 210, 28);
				descuento.setVisible(false);
			}
			{
				cochera = new JTextField();
				getContentPane().add(cochera);
				cochera.setBounds(169, 314, 210, 28);
				cochera.setVisible(false);
			}
			{
				modificar = new JButton();
				getContentPane().add(modificar);
				modificar.setText("CONFIRMAR");
				modificar.setBounds(169, 378, 113, 28);
				modificar.setVisible(false);
				modificar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = -1;
						if(!isInteger(dias.getText()) || !isFloat(precio.getText()) || !isFloat(descuento.getText())){
							rdo = ExitCodes.ARGUMENTOS_INVALIDOS;
						}
						if(rdo == -1){
							rdo = sistemaCocheras.modificarAbono(nombre.getText(), Integer.parseInt(dias.getText()), Float.parseFloat(precio.getText()), Float.parseFloat(descuento.getText()), Integer.parseInt(cochera.getText()));
						}
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El abono se ha modificado con exito.";
								break;
							}
							case ExitCodes.NO_EXISTE_ENTIDAD: {
								mensaje = "El abono no existe.";
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
							jLabel1.setVisible(false);
							jLabel2.setVisible(false);
							jLabel3.setVisible(false);
							jLabel4.setVisible(false);
							jLabel5.setVisible(false);
							jLabel7.setVisible(false);
							nombreAbono.setText("");
							nombre.setVisible(false);
							dias.setVisible(false);
							precio.setVisible(false);
							descuento.setVisible(false);
							cochera.setVisible(false);
							modificar.setVisible(false);
						}
					}
				});
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Nombre Abono:");
				jLabel6.setBounds(21, 69, 98, 28);
			}
			{
				nombreAbono = new JTextField();
				getContentPane().add(nombreAbono);
				nombreAbono.setBounds(119, 69, 127, 28);
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("BUSCAR");
				buscar.setBounds(260, 69, 87, 28);
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						abono = sistemaCocheras.buscarDatosAbono(nombreAbono.getText());						
						if (abono != null && abono.getActivo())
						{
							jLabel1.setVisible(true);
							jLabel2.setVisible(true);
							jLabel3.setVisible(true);
							jLabel4.setVisible(true);
							jLabel5.setVisible(true);
							jLabel7.setVisible(true);
							nombre.setVisible(true);
							nombre.setEnabled(false);
							dias.setVisible(true);							
							precio.setVisible(true);
							descuento.setVisible(true);
							cochera.setVisible(true);
							modificar.setVisible(true);
							nombre.setText(abono.getNombre());
							dias.setText(Integer.toString(abono.getCantidadDias()));
							precio.setText(Float.toString(abono.getPrecioBase()));
							descuento.setText(Float.toString(abono.getDescuento()));
							cochera.setText(Integer.toString(abono.getTamanioCochera()));
						}else{
							JOptionPane.showMessageDialog(null, "El abono no existe.");
							jLabel1.setVisible(false);
							jLabel2.setVisible(false);
							jLabel3.setVisible(false);
							jLabel4.setVisible(false);
							jLabel5.setVisible(false);
							nombre.setVisible(false);
							dias.setVisible(false);							
							precio.setVisible(false);
							descuento.setVisible(false);
							cochera.setVisible(false);
							modificar.setVisible(false);
						}
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/abono.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 455);
			setTitle("Modificar Abono");
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
	
	public static boolean isFloat(String s) {
	    try {	    	
	        Float.parseFloat(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}

}
