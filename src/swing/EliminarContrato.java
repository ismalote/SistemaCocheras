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

import utils.FechaUtils;
import vista.ContratoView;
import controlador.SistemaCocheras;
import enums.ExitCodes;

public class EliminarContrato extends javax.swing.JFrame {

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
	private JButton baja;
	private JTextField nroContrato;
	private JTextField contrato;	
	private JTextField fecha;
	private JTextField patente;
	private JTextField nroCochera;
	private JTextField abono;
	private JTextField estado;

	private SistemaCocheras sistemaCocheras;
	private Vector<ContratoView> contratos;
	private String dniCliente;

	public EliminarContrato(SistemaCocheras s, String dni) {
		super();
		sistemaCocheras = s;
		dniCliente = dni;
		initGUI(dniCliente);
	}

	private void initGUI(final String dniCliente) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				titulo = new JLabel();
				getContentPane().add(titulo);
				titulo.setText("ELIMINAR CONTRATO DEL CLIENTE: " + dniCliente);
				titulo.setBounds(90, 20, 243, 28);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Nro. Contrato:");
				jLabel7.setBounds(21, 118, 80, 28);
				jLabel7.setVisible(false);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Fecha:");
				jLabel1.setBounds(21, 167, 80, 28);
				jLabel1.setVisible(false);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Patente:");
				jLabel2.setBounds(21, 216, 80, 28);
				jLabel2.setVisible(false);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Nº cochera:");
				jLabel3.setBounds(21, 265, 80, 28);
				jLabel3.setVisible(false);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Abono:");
				jLabel4.setBounds(21, 314, 80, 28);
				jLabel4.setVisible(false);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Estado:");
				jLabel5.setBounds(21, 363, 80, 28);
				jLabel5.setVisible(false);
			}
			{
				contrato = new JTextField();
				getContentPane().add(contrato);
				contrato.setBounds(140, 118, 210, 28);
				contrato.setVisible(false);
				contrato.setEnabled(false);
			}
			{
				fecha = new JTextField();
				getContentPane().add(fecha);
				fecha.setBounds(140, 167, 210, 28);
				fecha.setVisible(false);
			}
			{
				patente = new JTextField();
				getContentPane().add(patente);
				patente.setBounds(140, 216, 210, 28);
				patente.setVisible(false);
			}
			{
				nroCochera = new JTextField();
				getContentPane().add(nroCochera);
				nroCochera.setBounds(140, 265, 210, 28);
				nroCochera.setVisible(false);
			}
			{
				abono = new JTextField();
				getContentPane().add(abono);
				abono.setBounds(140, 314, 210, 28);
				abono.setVisible(false);
			}
			{
				estado = new JTextField();
				getContentPane().add(estado);
				estado.setBounds(140, 363, 210, 28);
				estado.setVisible(false);
			}
			{
				baja = new JButton();
				getContentPane().add(baja);
				baja.setText("CONFIRMAR");
				baja.setBounds(140, 412, 113, 28);
				baja.setVisible(false);
				baja.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						int rdo = sistemaCocheras.bajaContrato(Integer
								.parseInt(nroContrato.getText()));
						String mensaje = "";
						switch (rdo) {
						case ExitCodes.OK: {
							mensaje = "El contrato se ha dado de baja con exito.";
							break;
						}
						case ExitCodes.NO_EXISTE_ENTIDAD: {
							mensaje = "El contrato no existe.";
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
						if (rdo == ExitCodes.OK) {
							jLabel1.setVisible(false);
							jLabel2.setVisible(false);
							jLabel3.setVisible(false);
							jLabel4.setVisible(false);
							jLabel5.setVisible(false);
							jLabel7.setVisible(false);
							nroContrato.setText("");
							contrato.setVisible(false);
							fecha.setVisible(false);
							patente.setVisible(false);
							nroCochera.setVisible(false);
							abono.setVisible(false);
							estado.setVisible(false);
							baja.setVisible(false);
						}
					}
				});
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Ingrese Nº contrato:");
				jLabel6.setBounds(21, 69, 130, 28);
			}
			{
				nroContrato = new JTextField();
				getContentPane().add(nroContrato);
				nroContrato.setBounds(140, 69, 127, 28);
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("BUSCAR");
				buscar.setBounds(280, 69, 87, 28);
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						contratos = sistemaCocheras.listarContratos(dniCliente,	true);
						ContratoView cont = null;
						for (int i = 0; i < contratos.size() && cont == null; i++) {
							if (contratos.elementAt(i).getNroContrato() == Integer
									.parseInt(nroContrato.getText())) {
								cont = contratos.elementAt(i);
							}
						}
						if (cont != null) {
							jLabel1.setVisible(true);
							jLabel2.setVisible(true);
							jLabel3.setVisible(true);
							jLabel4.setVisible(true);
							jLabel5.setVisible(true);
							jLabel7.setVisible(true);
							contrato.setVisible(true);
							contrato.setEnabled(false);							
							fecha.setVisible(true);
							fecha.setEnabled(false);
							patente.setVisible(true);
							patente.setEnabled(false);
							nroCochera.setVisible(true);
							nroCochera.setEnabled(false);
							abono.setVisible(true);
							abono.setEnabled(false);
							estado.setVisible(true);
							estado.setEnabled(false);
							baja.setVisible(true);
							contrato.setText(Integer.toString(cont.getNroContrato()));
							fecha.setText(FechaUtils.formatearFecha(cont
									.getFecha()));
							patente.setText(cont.getPatenteAuto());
							nroCochera.setText(Integer.toString(cont
									.getNroCochera()));
							abono.setText(cont.getAbono());
							estado.setText((cont.getEstado() == true) ? "Vigente" : "No vigente");
						} else {
							JOptionPane.showMessageDialog(null, "El contrato no existe.");
							jLabel1.setVisible(false);
							jLabel2.setVisible(false);
							jLabel3.setVisible(false);
							jLabel4.setVisible(false);
							jLabel5.setVisible(false);
							jLabel7.setVisible(false);
							contrato.setVisible(false);
							fecha.setVisible(false);
							patente.setVisible(false);
							nroCochera.setVisible(false);
							abono.setVisible(false);
							estado.setVisible(false);
							baja.setVisible(false);
						}
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/contract.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 500);
			setTitle("Eliminar Contrato");
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
