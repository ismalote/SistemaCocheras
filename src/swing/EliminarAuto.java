package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import vista.AutoView;
import controlador.SistemaCocheras;
import enums.ExitCodes;

public class EliminarAuto extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel6;
	private JButton buscar;
	private JButton baja;
	private JTextField patenteAuto;	
	private JTextField patente;	
	private JTextField marca;
	private JTextField modelo;
	private JTextField fecha;		
	
	private SistemaCocheras sistemaCocheras;
	private String dniCliente;

	public static void main(String[] args) {
		EliminarAuto inst = new EliminarAuto();
		inst.setVisible(true);
	}
	
	public EliminarAuto ()
	{
		
	}
	public EliminarAuto(SistemaCocheras s, String d) {
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
				titulo.setText("ELIMINAR AUTO DEL CLIENTE: " + dniCliente);
				titulo.setBounds(90, 20, 258, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Patente:");
				jLabel1.setBounds(21, 118, 63, 28);
				jLabel1.setVisible(false);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Marca:");
				jLabel2.setBounds(21, 167, 63, 28);
				jLabel2.setVisible(false);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Modelo:");
				jLabel3.setBounds(21, 216, 63, 28);
				jLabel3.setVisible(false);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("fecha:");
				jLabel4.setBounds(21, 265, 63, 28);
				jLabel4.setVisible(false);
			}
			{
				patente = new JTextField();
				getContentPane().add(patente);
				patente.setBounds(119, 118, 210, 28);
				patente.setVisible(false);				
			}
			{
				marca = new JTextField();
				getContentPane().add(marca);
				marca.setBounds(119, 167, 210, 28);
				marca.setVisible(false);
			}
			{
				modelo = new JTextField();
				getContentPane().add(modelo);
				modelo.setBounds(119, 216, 210, 28);
				modelo.setVisible(false);
			}
			{
				fecha = new JTextField();
				getContentPane().add(fecha);
				fecha.setBounds(119, 265, 210, 28);
				fecha.setVisible(false);
			}
			{
				baja = new JButton();
				getContentPane().add(baja);
				baja.setText("CONFIRMAR");
				baja.setBounds(119, 363, 113, 28);
				baja.setVisible(false);
				baja.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = sistemaCocheras.bajaAuto(dniCliente, patenteAuto.getText());						
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El auto se ha dado de baja con exito.";	
								break;
							}
							case ExitCodes.NO_EXISTE_ENTIDAD: {
								mensaje = "El cliente no existe.";
								break;
							}
							case ExitCodes.ARGUMENTOS_INVALIDOS: {
								mensaje = "Alguno de los argumentos es invalido.";
								break;
							}
							case ExitCodes.AUTO_CONTRATO_VIGENTE: {
								mensaje = "El auto esta asociado a un contrato vigente.";
								break;
							}
							case ExitCodes.NO_EXISTE_AUTO: {
								mensaje = "El auto no existe.";
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
							patenteAuto.setText("");
							patente.setVisible(false);
							marca.setVisible(false);
							modelo.setVisible(false);
							fecha.setVisible(false);							
							baja.setVisible(false);
						}
					}
				});
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Ingrese Patente:");
				jLabel6.setBounds(21, 69, 98, 28);
			}
			{
				patenteAuto = new JTextField();
				getContentPane().add(patenteAuto);
				patenteAuto.setBounds(119, 69, 127, 28);
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("BUSCAR");
				buscar.setBounds(260, 69, 87, 28);
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						Vector<AutoView> autos = sistemaCocheras.listarAutos(dniCliente);						
						AutoView auto = null;
						for(int i = 0; i < autos.size() && auto == null; i++){
							if(autos.elementAt(i).getPatente().equalsIgnoreCase(patenteAuto.getText())){								
								auto = autos.elementAt(i);
							}
						}						
						if (auto != null && auto.getActivo())
						{
							jLabel1.setVisible(true);
							jLabel2.setVisible(true);
							jLabel3.setVisible(true);
							jLabel4.setVisible(true);
							patente.setVisible(true);
							patente.setEnabled(false);
							marca.setVisible(true);
							marca.setEnabled(false);
							modelo.setVisible(true);
							modelo.setEnabled(false);
							fecha.setVisible(true);
							fecha.setEnabled(false);							
							baja.setVisible(true);
							patente.setText(auto.getPatente());
							marca.setText(auto.getMarca());
							modelo.setText(auto.getModelo());							
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							fecha.setText(df.format(auto.getFechaEntrada()));
						}else{
							JOptionPane.showMessageDialog(null, "El cliente no posee ese auto o el auto no existe.");
							jLabel1.setVisible(false);
							jLabel2.setVisible(false);
							jLabel3.setVisible(false);
							jLabel4.setVisible(false);							
							patente.setVisible(false);
							marca.setVisible(false);							
							modelo.setVisible(false);
							fecha.setVisible(false);							
							baja.setVisible(false);
						}
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/auto.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 600);
			setTitle("Eliminar Auto");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
