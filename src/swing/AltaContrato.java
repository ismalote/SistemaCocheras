package swing;

import controlador.SistemaCocheras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import enums.ExitCodes;
import enums.MediosPagoCliente;
import enums.Tamanios;
import utils.*;
import vista.AbonoView;
import vista.AutoView;
import vista.ClienteView;
import vista.CocheraView;

public class AltaContrato extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JButton alta;
	private JButton reconfirmarEfectivo;
	private JButton reconfirmarCheque;
	private JButton reconfirmarTarjeta;
	private JButton reconfirmarCBU;
	private JButton volverEfectivo;
	private JButton volverCheque;
	private JButton volverTarjeta;
	private JButton volverCBU;
	private JTextField dni;
	private JComboBox<String> patente;
	private JComboBox<String> cochera;
	private JComboBox<ComboItemAbonos> abono;
	private JTextField fecha;
	
	private JLabel jLabel7;
	private JTextField cuentaCorriente;
	private JLabel jLabel8;
	private JTextField entidadBancaria;
	private JLabel jLabel9;
	private JTextField numeroTarjeta;
	private JLabel jLabel10;
	private JTextField vencimientoTarjeta;
	private JLabel jLabel11;
	private JTextField entidadEmisora;
	private JLabel jLabel12;
	private JTextField cbu;
	private JLabel jLabel13;
	private JTextField entidadBancariaCBU;
	
	private JComboBox<String> medioPago;
	
	private SistemaCocheras sistemaCocheras;
	private String dniCliente;
	
	public AltaContrato(SistemaCocheras s, String d) {
		super();
		sistemaCocheras = s;
		dniCliente = d;
		initGUI(dniCliente);

	}
	
	private void initGUI(final String dniCliente) {
		try {
			ClienteView cliente = sistemaCocheras.buscarDatosCliente(dniCliente);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				titulo = new JLabel();
				getContentPane().add(titulo);
				titulo.setText("AGREGAR CONTRATO");
				titulo.setBounds(130, 20, 133, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("DNI:");
				jLabel1.setBounds(21, 69, 113, 28);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Patente:");
				jLabel2.setBounds(21, 118, 113, 28);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Cochera:");
				jLabel3.setBounds(21, 167, 113, 28);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Abono:");
				jLabel4.setBounds(21, 216, 113, 28);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Fecha:");
				jLabel5.setBounds(21, 265, 113, 28);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Medio de Pago:");
				jLabel6.setBounds(21, 314, 113, 28);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Cuenta Corriente:");
				jLabel7.setBounds(21, 363, 113, 28);
				jLabel7.setVisible(false);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("Entidad Bancaria:");
				jLabel8.setBounds(21, 412, 113, 28);
				jLabel8.setVisible(false);
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setText("Numero Tarjeta:");
				jLabel9.setBounds(21, 363, 113, 28);
				jLabel9.setVisible(false);
			}
			{
				jLabel10 = new JLabel();
				getContentPane().add(jLabel10);
				jLabel10.setText("Vencimiento:");
				jLabel10.setBounds(21, 412, 113, 28);
				jLabel10.setVisible(false);
			}
			{
				jLabel11 = new JLabel();
				getContentPane().add(jLabel11);
				jLabel11.setText("Entidad Emisora:");
				jLabel11.setBounds(21, 461, 113, 28);
				jLabel11.setVisible(false);
			}
			{
				jLabel12 = new JLabel();
				getContentPane().add(jLabel12);
				jLabel12.setText("CBU:");
				jLabel12.setBounds(21, 363, 113, 28);
				jLabel12.setVisible(false);
			}
			{
				jLabel13 = new JLabel();
				getContentPane().add(jLabel13);
				jLabel13.setText("Entidad Bancaria:");
				jLabel13.setBounds(21, 412, 113, 28);
				jLabel13.setVisible(false);
			}
			{
				dni = new JTextField();
				dni.setText(dniCliente);
				dni.setEnabled(false);
				getContentPane().add(dni);
				dni.setBounds(169, 69, 210, 28);
			}
			{				
				Vector<AutoView> autosView = cliente.getAutos();
				String[] autosCombo;
				if(autosView != null && autosView.size() > 0){
					autosCombo = new String[autosView.size() + 1];
					autosCombo[0] = "";
					for(int i = 0, j = 1; i < autosView.size(); i++, j++){
						autosCombo[j] = autosView.elementAt(i).getPatente();
					}
					patente = new JComboBox<String>(autosCombo);
				}else{
					patente = new JComboBox<String>();
				}
				getContentPane().add(patente);
				patente.setBounds(169, 118, 210, 28);
			}
			{
				Vector<CocheraView> cocherasView = sistemaCocheras.listarCocheras();
				String[] cocherasCombo;
				if(cocherasView != null && cocherasView.size() > 0){
					cocherasCombo = new String[cocherasView.size() + 1];
					cocherasCombo[0] = "";
					for(int i = 0, j = 1; i < cocherasView.size(); i++, j++){
						cocherasCombo[j] = Integer.toString(cocherasView.elementAt(i).getNumero());
					}
					cochera = new JComboBox<String>(cocherasCombo);
				}else{
					cochera = new JComboBox<String>();
				}
				getContentPane().add(cochera);
				cochera.setBounds(169, 167, 210, 28);
			}
			{
				Vector<AbonoView> abonosView = sistemaCocheras.listarAbonos();
				ComboItemAbonos[] itemsAbonos;
				abono = new JComboBox<ComboItemAbonos>();
				if (abonosView != null && abonosView.size() > 0) {
					itemsAbonos =  new ComboItemAbonos[abonosView.size() + 1];
					itemsAbonos[0] = new ComboItemAbonos("", ""); 
					for(int i = 0, j = 1; i < abonosView.size(); i++, j++) {
						itemsAbonos[j] = new ComboItemAbonos(abonosView.elementAt(i).getNombre(), abonosView.elementAt(i).getNombre() + " - "  + Tamanios.getDescripcion(abonosView.elementAt(i).getTamanioCochera()));
					}
					
					abono = new JComboBox<ComboItemAbonos>(itemsAbonos);
				} else {
					abono = new JComboBox<ComboItemAbonos>();
				}
				getContentPane().add(abono);
				abono.setBounds(169, 216, 210, 28);
			}
			{
				fecha = new JTextField();
				fecha.setText(FechaUtils.formatearFecha(Calendar.getInstance().getTime()));
				getContentPane().add(fecha);
				fecha.setBounds(169, 265, 210, 28);
			}
			{				
				String[] mediosPago = { "", "E - Efectivo", "C - Cheque", "T - Debito Tarjeta Credito", "D - Debito CBU" };
				medioPago = new JComboBox<String>(mediosPago);
				getContentPane().add(medioPago);
				medioPago.setBounds(169, 314, 210, 28);
			}
			{
				reconfirmarEfectivo = new JButton();
				getContentPane().add(reconfirmarEfectivo);
				reconfirmarEfectivo.setText("RECONFIRMAR");
				reconfirmarEfectivo.setBounds(59, 510, 133, 28);
				reconfirmarEfectivo.setVisible(false);
				reconfirmarEfectivo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = sistemaCocheras.crearContratoEfectivo(dni.getText(), patente.getSelectedItem().toString(), Integer.parseInt(cochera.getSelectedItem().toString()), ((ComboItemAbonos)abono.getSelectedItem()).getValue(), FechaUtils.parsearFecha(fecha.getText()));					
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El contrato se ha creado con exito.";
								break;
							}
							case ExitCodes.ARGUMENTOS_INVALIDOS: {
								mensaje = "Alguno de los argumentos es invalido.";
								break;
							}
							case ExitCodes.COCHERA_NO_DISPONIBLE: {
								mensaje = "La cochera no esta disponible.";
								break;
							}
							default: {
								break;
							}
						}
						JOptionPane.showMessageDialog(null, mensaje);
						if(rdo == ExitCodes.OK){
							patente.setSelectedIndex(0);
							cochera.setSelectedIndex(0);
							abono.setSelectedIndex(0);
							fecha.setText("");
							medioPago.setSelectedIndex(0);
							patente.setEnabled(true);
							cochera.setEnabled(true);
							abono.setEnabled(true);
							fecha.setEnabled(true);
							fecha.setText(FechaUtils.formatearFecha(Calendar.getInstance().getTime()));
							medioPago.setEnabled(true);							
							reconfirmarEfectivo.setVisible(false);
							volverEfectivo.setVisible(false);
							alta.setVisible(true);
						}
					}
				});
			}
			{
				volverEfectivo = new JButton();
				getContentPane().add(volverEfectivo);
				volverEfectivo.setText("VOLVER");
				volverEfectivo.setBounds(199, 510, 133, 28);
				volverEfectivo.setVisible(false);
				volverEfectivo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						patente.setEnabled(true);
						cochera.setEnabled(true);
						abono.setEnabled(true);
						fecha.setEnabled(true);
						medioPago.setEnabled(true);
						reconfirmarEfectivo.setVisible(false);
						volverEfectivo.setVisible(false);
						alta.setVisible(true);						
					}
				});
			}			
			{
				cuentaCorriente = new JTextField();
				getContentPane().add(cuentaCorriente);				
				cuentaCorriente.setBounds(169, 363, 113, 28);
				cuentaCorriente.setVisible(false);
			}
			{
				entidadBancaria = new JTextField();
				getContentPane().add(entidadBancaria);				
				entidadBancaria.setBounds(169, 412, 113, 28);
				entidadBancaria.setVisible(false);
			}
			{
				reconfirmarCheque = new JButton();
				getContentPane().add(reconfirmarCheque);
				reconfirmarCheque.setText("RECONFIRMAR");
				reconfirmarCheque.setBounds(59, 510, 133, 28);
				reconfirmarCheque.setVisible(false);
				reconfirmarCheque.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{	
						int rdo = 0;
						if(cuentaCorriente.getText().length() == 0 || entidadBancaria.getText().length() == 0){
							rdo = ExitCodes.ARGUMENTOS_INVALIDOS;
						}
						if(rdo == 0){
							rdo = sistemaCocheras.crearContratoCheque(dni.getText(), patente.getSelectedItem().toString(), Integer.parseInt(cochera.getSelectedItem().toString()), ((ComboItemAbonos)abono.getSelectedItem()).getValue(), FechaUtils.parsearFecha(fecha.getText()), cuentaCorriente.getText(), entidadBancaria.getText());
						}
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El contrato se ha creado con exito.";
								break;
							}
							case ExitCodes.ARGUMENTOS_INVALIDOS: {
								mensaje = "Alguno de los argumentos es invalido.";
								break;
							}
							case ExitCodes.COCHERA_NO_DISPONIBLE: {
								mensaje = "La cochera no esta disponible.";
								break;
							}
							default: {
								break;
							}
						}
						JOptionPane.showMessageDialog(null, mensaje);
						if(rdo == ExitCodes.OK){
							patente.setSelectedIndex(0);
							cochera.setSelectedIndex(0);
							abono.setSelectedIndex(0);
							fecha.setText("");
							fecha.setText(FechaUtils.formatearFecha(Calendar.getInstance().getTime()));
							cuentaCorriente.setText("");
							entidadBancaria.setText("");
							patente.setEnabled(true);
							cochera.setEnabled(true);
							abono.setEnabled(true);
							fecha.setEnabled(true);
							medioPago.setEnabled(true);							
							jLabel7.setVisible(false);
							jLabel8.setVisible(false);
							cuentaCorriente.setVisible(false);
							entidadBancaria.setVisible(false);							
							reconfirmarCheque.setVisible(false);
							volverCheque.setVisible(false);
							alta.setVisible(true);
						}
					}
				});
			}
			{
				volverCheque = new JButton();
				getContentPane().add(volverCheque);
				volverCheque.setText("VOLVER");
				volverCheque.setBounds(199, 510, 133, 28);
				volverCheque.setVisible(false);
				volverCheque.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{					
						patente.setEnabled(true);
						cochera.setEnabled(true);
						abono.setEnabled(true);
						fecha.setEnabled(true);
						medioPago.setEnabled(true);
						cuentaCorriente.setText("");
						entidadBancaria.setText("");
						jLabel7.setVisible(false);
						jLabel8.setVisible(false);
						cuentaCorriente.setVisible(false);
						entidadBancaria.setVisible(false);	
						reconfirmarCheque.setVisible(false);
						volverCheque.setVisible(false);
						alta.setVisible(true);						
					}
				});
			}
			{
				numeroTarjeta = new JTextField();
				getContentPane().add(numeroTarjeta);
				numeroTarjeta.setBounds(169, 363, 113, 28);
				numeroTarjeta.setVisible(false);
			}
			{
				vencimientoTarjeta = new JTextField();
				getContentPane().add(vencimientoTarjeta);
				vencimientoTarjeta.setBounds(169, 412, 113, 28);
				vencimientoTarjeta.setVisible(false);
			}
			{
				entidadEmisora = new JTextField();
				getContentPane().add(entidadEmisora);				
				entidadEmisora.setBounds(169, 461, 113, 28);
				entidadEmisora.setVisible(false);
			}
			{
				reconfirmarTarjeta = new JButton();
				getContentPane().add(reconfirmarTarjeta);
				reconfirmarTarjeta.setText("RECONFIRMAR");
				reconfirmarTarjeta.setBounds(59, 510, 133, 28);
				reconfirmarTarjeta.setVisible(false);
				reconfirmarTarjeta.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = 0;
						if(numeroTarjeta.getText().length() == 0 || entidadEmisora.getText().length() == 0 || vencimientoTarjeta.getText().length() == 0){
							rdo = ExitCodes.ARGUMENTOS_INVALIDOS;
						}
						if(rdo == 0){
							rdo = sistemaCocheras.crearContratoTarjetaCredito(dni.getText(), patente.getSelectedItem().toString(), Integer.parseInt(cochera.getSelectedItem().toString()), ((ComboItemAbonos)abono.getSelectedItem()).getValue(), FechaUtils.parsearFecha(fecha.getText()), numeroTarjeta.getText(), FechaUtils.parsearFecha(vencimientoTarjeta.getText()), entidadEmisora.getText());
						}
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El contrato se ha creado con exito.";
								break;
							}
							case ExitCodes.ARGUMENTOS_INVALIDOS: {
								mensaje = "Alguno de los argumentos es invalido.";
								break;
							}
							case ExitCodes.COCHERA_NO_DISPONIBLE: {
								mensaje = "La cochera no esta disponible.";
								break;
							}
							default: {
								break;
							}
						}
						JOptionPane.showMessageDialog(null, mensaje);
						if(rdo == ExitCodes.OK){
							patente.setSelectedIndex(0);
							cochera.setSelectedIndex(0);
							abono.setSelectedIndex(0);
							fecha.setText("");
							fecha.setText(FechaUtils.formatearFecha(Calendar.getInstance().getTime()));
							numeroTarjeta.setText("");
							vencimientoTarjeta.setText("");
							entidadEmisora.setText("");
							patente.setEnabled(true);
							cochera.setEnabled(true);
							abono.setEnabled(true);
							fecha.setEnabled(true);
							medioPago.setEnabled(true);
							numeroTarjeta.setVisible(false);
							vencimientoTarjeta.setVisible(false);
							entidadEmisora.setVisible(false);							
							reconfirmarCheque.setVisible(false);
							volverCheque.setVisible(false);
							alta.setVisible(true);
						}
					}
				});
			}
			{
				volverTarjeta = new JButton();
				getContentPane().add(volverTarjeta);
				volverTarjeta.setText("VOLVER");
				volverTarjeta.setBounds(199, 510, 133, 28);
				volverTarjeta.setVisible(false);
				volverTarjeta.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						patente.setEnabled(true);
						cochera.setEnabled(true);
						abono.setEnabled(true);
						fecha.setEnabled(true);
						medioPago.setEnabled(true);
						numeroTarjeta.setText("");
						vencimientoTarjeta.setText("");
						entidadEmisora.setText("");
						jLabel9.setVisible(false);
						jLabel10.setVisible(false);
						jLabel11.setVisible(false);
						numeroTarjeta.setVisible(false);
						vencimientoTarjeta.setVisible(false);
						entidadEmisora.setVisible(false);	
						reconfirmarTarjeta.setVisible(false);
						volverTarjeta.setVisible(false);
						alta.setVisible(true);						
					}
				});
			}
			{
				cbu = new JTextField();
				getContentPane().add(cbu);
				cbu.setBounds(169, 363, 113, 28);
				cbu.setVisible(false);
			}
			{
				entidadBancariaCBU = new JTextField();
				getContentPane().add(entidadBancariaCBU);				
				entidadBancariaCBU.setBounds(169, 412, 113, 28);
				entidadBancariaCBU.setVisible(false);
			}
			{
				reconfirmarCBU = new JButton();
				getContentPane().add(reconfirmarCBU);
				reconfirmarCBU.setText("RECONFIRMAR");
				reconfirmarCBU.setBounds(59, 510, 133, 28);
				reconfirmarCBU.setVisible(false);
				reconfirmarCBU.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = 0;
						if(cbu.getText().length() == 0 || entidadBancariaCBU.getText().length() == 0){
							rdo = ExitCodes.ARGUMENTOS_INVALIDOS;
						}
						if(rdo == 0){
							sistemaCocheras.crearContratoDebitoAutomatico(dni.getText(), patente.getSelectedItem().toString(), Integer.parseInt(cochera.getSelectedItem().toString()), ((ComboItemAbonos)abono.getSelectedItem()).getValue(), FechaUtils.parsearFecha(fecha.getText()), cbu.getText(), entidadBancariaCBU.getText());
						}																						
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El contrato se ha creado con exito.";
								break;
							}
							case ExitCodes.ARGUMENTOS_INVALIDOS: {
								mensaje = "Alguno de los argumentos es invalido.";
								break;
							}
							case ExitCodes.COCHERA_NO_DISPONIBLE: {
								mensaje = "La cochera no esta disponible.";
								break;
							}
							default: {
								break;
							}
						}
						JOptionPane.showMessageDialog(null, mensaje);
						if(rdo == ExitCodes.OK){
							patente.setSelectedIndex(0);
							cochera.setSelectedIndex(0);
							abono.setSelectedIndex(0);
							fecha.setText("");
							cbu.setText("");
							fecha.setText(FechaUtils.formatearFecha(Calendar.getInstance().getTime()));
							entidadBancariaCBU.setText("");
							patente.setEnabled(true);
							cochera.setEnabled(true);
							abono.setEnabled(true);
							fecha.setEnabled(true);
							medioPago.setEnabled(true);
							cbu.setVisible(false);
							entidadBancariaCBU.setVisible(false);							
							reconfirmarCBU.setVisible(false);
							volverCBU.setVisible(false);
							alta.setVisible(true);
						}
					}
				});
			}
			{
				volverCBU = new JButton();
				getContentPane().add(volverCBU);
				volverCBU.setText("VOLVER");
				volverCBU.setBounds(199, 510, 133, 28);
				volverCBU.setVisible(false);
				volverCBU.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						patente.setEnabled(true);
						cochera.setEnabled(true);
						abono.setEnabled(true);
						fecha.setEnabled(true);
						medioPago.setEnabled(true);
						cbu.setText("");
						entidadBancariaCBU.setText("");
						jLabel12.setVisible(false);
						jLabel13.setVisible(false);
						cbu.setVisible(false);
						entidadBancariaCBU.setVisible(false);	
						reconfirmarCBU.setVisible(false);
						volverCBU.setVisible(false);
						alta.setVisible(true);						
					}
				});
			}
			{
				alta = new JButton();
				getContentPane().add(alta);
				alta.setText("CONFIRMAR");
				alta.setBounds(169, 363, 113, 28);
				alta.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = validarCampos(patente.getSelectedItem().toString(), cochera.getSelectedItem().toString(), ((ComboItemAbonos)abono.getSelectedItem()).getValue(), medioPago.getSelectedIndex(), fecha.getText());
						if(rdo == -1){
							JOptionPane.showMessageDialog(null, "Verifique los datos ingresados.");
						} else {
							patente.setEnabled(false);
							cochera.setEnabled(false);
							abono.setEnabled(false);
							fecha.setEnabled(false);
							medioPago.setEnabled(false);
							alta.setVisible(false);
							String letra = "X";
							if(medioPago.getSelectedIndex() > 0){
								String inicial = (String) medioPago.getSelectedItem();
								letra = inicial.substring(0, 1).toUpperCase();
							}
							switch(letra){
								case MediosPagoCliente.EFECTIVO:
									reconfirmarEfectivo.setVisible(true);																
									volverEfectivo.setVisible(true);								
									break;
								case MediosPagoCliente.CHEQUE:								
									jLabel7.setVisible(true);
									cuentaCorriente.setVisible(true);
									jLabel8.setVisible(true);
									entidadBancaria.setVisible(true);
									reconfirmarCheque.setVisible(true);																
									volverCheque.setVisible(true);								
									break;
								case MediosPagoCliente.DEBITO_TARJETA_CREDITO:
									jLabel9.setVisible(true);
									numeroTarjeta.setVisible(true);
									jLabel10.setVisible(true);
									vencimientoTarjeta.setVisible(true);
									jLabel11.setVisible(true);
									entidadEmisora.setVisible(true);
									reconfirmarTarjeta.setVisible(true);
									volverTarjeta.setVisible(true);
									break;
								case MediosPagoCliente.DEBITO_CBU:
									jLabel12.setVisible(true);
									cbu.setVisible(true);
									jLabel13.setVisible(true);
									entidadBancariaCBU.setVisible(true);								
									reconfirmarCBU.setVisible(true);
									volverCBU.setVisible(true);
									break;
								case "X":
									patente.setEnabled(true);
									cochera.setEnabled(true);
									abono.setEnabled(true);
									fecha.setEnabled(true);
									medioPago.setEnabled(true);
									alta.setVisible(true);
									break;
							}					
						}
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/contract.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 600);
			setTitle("Agregar Contrato");
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int validarCampos(String patente, String cochera, String abono, int medioPago, String fecha){
		return (patente.length() > 0 && NumeroUtils.isInteger(cochera) && abono.length() > 0 && medioPago > 0 && FechaUtils.parsearFecha(fecha) != null) ? 0 : -1;
	}	
	
}
