package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import vista.MedioPagoView;
import controlador.SistemaCocheras;
import enums.ExitCodes;

public class EliminarMedioPago extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel6;
	private JButton buscar;
	private JButton baja;
	private JTextField nombreEntidad;	
	private JTextField entidad;	
	private JTextField archivoEntrada;
	private JTextField archivoSalida;
	private JTextField ftp;		
	
	private SistemaCocheras sistemaCocheras;

	public EliminarMedioPago(SistemaCocheras s) {
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
				titulo.setText("ELIMINAR MEDIO DE PAGO");
				titulo.setBounds(100, 20, 258, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Entidad:");
				jLabel1.setBounds(21, 118, 63, 28);
				jLabel1.setVisible(false);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Archivo Entrada:");
				jLabel2.setBounds(21, 167, 63, 28);
				jLabel2.setVisible(false);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Archivo Salida:");
				jLabel3.setBounds(21, 216, 63, 28);
				jLabel3.setVisible(false);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Direccion FTP:");
				jLabel4.setBounds(21, 265, 63, 28);
				jLabel4.setVisible(false);
			}
			{
				entidad = new JTextField();
				getContentPane().add(entidad);
				entidad.setBounds(119, 118, 210, 28);
				entidad.setVisible(false);				
			}
			{
				archivoEntrada = new JTextField();
				getContentPane().add(archivoEntrada);
				archivoEntrada.setBounds(119, 167, 210, 28);
				archivoEntrada.setVisible(false);
			}
			{
				archivoSalida = new JTextField();
				getContentPane().add(archivoSalida);
				archivoSalida.setBounds(119, 216, 210, 28);
				archivoSalida.setVisible(false);
			}
			{
				ftp = new JTextField();
				getContentPane().add(ftp);
				ftp.setBounds(119, 265, 210, 28);
				ftp.setVisible(false);
			}
			{
				baja = new JButton();
				getContentPane().add(baja);
				baja.setText("CONFIRMAR");
				baja.setBounds(119, 314, 113, 28);
				baja.setVisible(false);
				baja.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = sistemaCocheras.eliminarMedioPago(nombreEntidad.getText());												
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
							nombreEntidad.setText("");
							entidad.setVisible(false);
							archivoEntrada.setVisible(false);
							archivoSalida.setVisible(false);
							ftp.setVisible(false);							
							baja.setVisible(false);
						}
					}
				});
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Medio de Pago:");
				jLabel6.setBounds(21, 69, 118, 28);
			}
			{
				nombreEntidad = new JTextField();
				getContentPane().add(nombreEntidad);
				nombreEntidad.setBounds(119, 69, 127, 28);
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("BUSCAR");
				buscar.setBounds(260, 69, 87, 28);
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						Vector<MedioPagoView> mediosPago = sistemaCocheras.listarMediosPago();										
						MedioPagoView medioPago = null;
						for(int i = 0; i < mediosPago.size() && medioPago == null; i++){
							if(mediosPago.elementAt(i).getNombreEntidad().equalsIgnoreCase(nombreEntidad.getText())){								
								medioPago = mediosPago.elementAt(i);
							}
						}						
						if (medioPago != null && medioPago.getActivo())
						{
							jLabel1.setVisible(true);
							jLabel2.setVisible(true);
							jLabel3.setVisible(true);
							jLabel4.setVisible(true);
							entidad.setVisible(true);
							entidad.setEnabled(false);
							archivoEntrada.setVisible(true);
							archivoEntrada.setEnabled(false);
							archivoSalida.setVisible(true);
							archivoSalida.setEnabled(false);
							ftp.setVisible(true);
							ftp.setEnabled(false);							
							baja.setVisible(true);
							entidad.setText(medioPago.getNombreEntidad());
							archivoEntrada.setText(medioPago.getNombreArchivoEntrada());
							archivoSalida.setText(medioPago.getNombreArchivoSalida());
							ftp.setText(medioPago.getDireccionFTP());							
						}else{
							JOptionPane.showMessageDialog(null, "El medio de pago no existe.");
							jLabel1.setVisible(false);
							jLabel2.setVisible(false);
							jLabel3.setVisible(false);
							jLabel4.setVisible(false);							
							entidad.setVisible(false);
							archivoEntrada.setVisible(false);							
							archivoSalida.setVisible(false);
							ftp.setVisible(false);							
							baja.setVisible(false);
						}
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/pago.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 400);
			setTitle("Eliminar Medio de Pago");
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
