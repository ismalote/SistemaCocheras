package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import vista.AbonoView;
import controlador.SistemaCocheras;
import enums.ExitCodes;

public class EliminarAbono extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;	
	private JButton buscar;
	private JButton eliminar;
	private JTextField nombreAbono;
	private JTextField nombre;	
	private JTextField dias;
	private JTextField precio;
	private JTextField descuento;
	private JComboBox<String> cochera;	
	
	private SistemaCocheras sistemaCocheras;
	private AbonoView abono;

	public EliminarAbono(SistemaCocheras s) {
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
				titulo.setText("ELIMINAR ABONO");
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
				String[] tamanios = { "", "Pequena", "Mediana", "Grande" };
				cochera = new JComboBox<String>(tamanios);
				getContentPane().add(cochera);
				cochera.setBounds(169, 314, 210, 28);
				cochera.setVisible(false);
			}
			{
				eliminar = new JButton();
				getContentPane().add(eliminar);
				eliminar.setText("CONFIRMAR");
				eliminar.setBounds(169, 378, 113, 28);
				eliminar.setVisible(false);
				eliminar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = sistemaCocheras.bajaAbono(nombre.getText());
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El abono se ha dado de baja con exito.";
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
							nombreAbono.setText("");
							nombre.setVisible(false);
							dias.setVisible(false);
							precio.setVisible(false);
							descuento.setVisible(false);
							cochera.setVisible(false);
							eliminar.setVisible(false);
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
							nombre.setVisible(true);
							nombre.setEnabled(false);
							dias.setVisible(true);
							dias.setEnabled(false);
							precio.setVisible(true);
							precio.setEnabled(false);
							descuento.setVisible(true);
							descuento.setEnabled(false);
							cochera.setVisible(true);
							cochera.setEnabled(false);
							eliminar.setVisible(true);
							nombre.setText(abono.getNombre());
							dias.setText(Integer.toString(abono.getCantidadDias()));
							precio.setText(Float.toString(abono.getPrecioBase()));
							descuento.setText(Float.toString(abono.getDescuento()));
							cochera.setSelectedIndex(abono.getTamanioCochera());
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
							eliminar.setVisible(false);
						}
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/abono.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 455);
			setTitle("Eliminar Abono");
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
