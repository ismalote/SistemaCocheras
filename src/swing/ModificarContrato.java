package swing;

import controlador.SistemaCocheras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import enums.ExitCodes;
import enums.Tamanios;
import vista.AbonoView;
import vista.ContratoView;

public class ModificarContrato extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton modificar;
	private JTextField nroContrato;
	private JComboBox<ComboItemAbonos> abono;
	private JButton buscar;

	private SistemaCocheras sistemaCocheras;
	private String dniCliente;
	private ComboItemAbonos[] itemsAbonos;
	private HashMap<String, Integer> posicionesItemsAbonos;

	public ModificarContrato(SistemaCocheras s, String d) {
		super();
		sistemaCocheras = s;
		dniCliente = d;
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				titulo = new JLabel();
				getContentPane().add(titulo);
				titulo.setText("MODIFICAR CONTRATO");
				titulo.setBounds(130, 20, 133, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Ingrese Nº contrato:");
				jLabel1.setBounds(21, 69, 113, 28);
			}
			{
				nroContrato = new JTextField();
				getContentPane().add(nroContrato);
				nroContrato.setBounds(150, 69, 127, 28);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Abono:");
				jLabel2.setBounds(21, 118, 113, 28);
				jLabel2.setVisible(false);
			}
			{
				Vector<AbonoView> abonosView = sistemaCocheras.listarAbonos();
				abono = new JComboBox<ComboItemAbonos>();
				posicionesItemsAbonos = new HashMap<String, Integer>();
				if (abonosView != null && abonosView.size() > 0) {
					itemsAbonos =  new ComboItemAbonos[abonosView.size() + 1];
					itemsAbonos[0] = new ComboItemAbonos("", ""); 
					for(int i = 0, j = 1; i < abonosView.size(); i++, j++) {
						itemsAbonos[j] = new ComboItemAbonos(abonosView.elementAt(i).getNombre(), abonosView.elementAt(i).getNombre() + " - "  + Tamanios.getDescripcion(abonosView.elementAt(i).getTamanioCochera()));
						posicionesItemsAbonos.put(abonosView.elementAt(i).getNombre(), j);
					}
					
					abono = new JComboBox<ComboItemAbonos>(itemsAbonos);
				} else {
					abono = new JComboBox<ComboItemAbonos>();
				}
				getContentPane().add(abono);
				abono.setBounds(150, 118, 210, 28);
				abono.setVisible(false);
			}
			{
				modificar = new JButton();
				getContentPane().add(modificar);
				modificar.setText("MODIFICAR");
				modificar.setVisible(false);
				modificar.setBounds(169, 200, 113, 28);
				modificar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = validarCampos(((ComboItemAbonos)abono.getSelectedItem()).getValue());
						if(rdo == -1){
							JOptionPane.showMessageDialog(null, "Verifique los datos ingresados.");
						} else {
	
							rdo = sistemaCocheras.modificarContrato(Integer.parseInt(nroContrato.getText()), ((ComboItemAbonos)abono.getSelectedItem()).getValue());
							
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
								jLabel2.setVisible(false);
								abono.setVisible(false);
								modificar.setVisible(false);
							}
						}
					}
				});
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("BUSCAR");
				buscar.setBounds(300, 69, 127, 28);
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						Vector<ContratoView> contratos = sistemaCocheras.listarContratos(dniCliente, true);
						ContratoView cont = null;
						for(int i = 0; i < contratos.size() && cont == null; i++){
							if(contratos.elementAt(i).getNroContrato() == Integer.parseInt(nroContrato.getText())){								
								cont = contratos.elementAt(i);
							}
						}		
						
						if (cont != null)
						{
							//abono.setSelectedItem(Arrays.binarySearch(itemsAbonos, cont.getAbono()));
							abono.setSelectedIndex(posicionesItemsAbonos.get(cont.getAbono()));
							jLabel2.setVisible(true);
							abono.setVisible(true);
							modificar.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(null, "El contrato no existe.");
							jLabel2.setVisible(false);
							abono.setVisible(false);
							modificar.setVisible(false);
						}
					}
				});
			}
			
			ImageIcon img = new ImageIcon("src/swing/contract.png");
			setIconImage(img.getImage());
			pack();
			setSize(450, 300);
			setTitle("Modificar Contrato");
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int validarCampos(String abono) {
		return (abono.length() > 0 ? 0 : -1);
	}


}
