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

import utils.NumeroUtils;
import vista.CocheraView;
import controlador.SistemaCocheras;
import enums.EstadosCochera;
import enums.ExitCodes;

public class ModificarCochera extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel6;
	private JButton buscar;
	private JButton modificar;
	private JTextField numeroCochera;
	private JTextField numero;	
	private JComboBox<String> tipo;
	private JComboBox<String> estado;	
	
	private SistemaCocheras sistemaCocheras;
	private CocheraView cochera;

	public ModificarCochera(SistemaCocheras s) {
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
				titulo.setText("MODIFICAR COCHERA");
				titulo.setBounds(140, 20, 148, 28);
			}
			{
				numero = new JTextField();
				getContentPane().add(numero);				
				numero.setBounds(119, 118, 113, 28);
				numero.setVisible(false);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Tipo:");
				jLabel1.setBounds(21, 167, 113, 28);
				jLabel1.setVisible(false);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Estado:");
				jLabel2.setBounds(21, 216, 113, 28);
				jLabel2.setVisible(false);
			}
			{
				String[] tamanios = { "", "Pequena", "Mediana", "Grande" };
				tipo = new JComboBox<String>(tamanios);
				getContentPane().add(tipo);
				tipo.setBounds(119, 167, 210, 28);
				tipo.setVisible(false);				
			}
			{
				String[] estados = { "", "Libre", "Ocupada" };
				estado = new JComboBox<String>(estados);
				getContentPane().add(estado);
				estado.setBounds(119, 216, 210, 28);
				estado.setVisible(false);
			}
			{
				modificar = new JButton();
				getContentPane().add(modificar);
				modificar.setText("CONFIRMAR");
				modificar.setBounds(119, 265, 113, 28);
				modificar.setVisible(false);
				modificar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int	rdo = sistemaCocheras.modificarCochera(Integer.parseInt(numero.getText()), tipo.getSelectedIndex(), estado.getSelectedIndex());						
						
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "La cochera se ha modificado con exito.";
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
							jLabel1.setVisible(false);
							jLabel2.setVisible(false);
							numeroCochera.setText("");
							numero.setVisible(false);							
							tipo.setVisible(false);
							estado.setVisible(false);							
							modificar.setVisible(false);
						}
					}
				});
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Cochera:");
				jLabel6.setBounds(21, 69, 98, 28);
			}
			{
				numeroCochera = new JTextField();
				getContentPane().add(numeroCochera);
				numeroCochera.setBounds(119, 69, 127, 28);
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("BUSCAR");
				buscar.setBounds(260, 69, 87, 28);
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if(NumeroUtils.isInteger(numeroCochera.getText())){
							cochera = sistemaCocheras.buscarDatosCochera(Integer.parseInt(numeroCochera.getText()));
						
							if (cochera != null && cochera.getEstado() != EstadosCochera.INACTIVA)
							{
								jLabel1.setVisible(true);
								jLabel2.setVisible(true);
								numero.setVisible(true);
								numero.setEnabled(false);
								tipo.setVisible(true);							
								estado.setVisible(true);							
								modificar.setVisible(true);
								numero.setText(Integer.toString(cochera.getNumero()));
								tipo.setSelectedIndex(cochera.getTamanioVechiculoAdmitido());
								estado.setSelectedIndex(cochera.getEstado());
							}else{
								JOptionPane.showMessageDialog(null, "La cochera no existe.");
								jLabel1.setVisible(false);
								jLabel2.setVisible(false);							
								numero.setVisible(false);
								tipo.setVisible(false);							
								estado.setVisible(false);							
								modificar.setVisible(false);
							}
						}else{
							JOptionPane.showMessageDialog(null, "Ingrese un numero de cochera valido.");
							numeroCochera.setText("");
						}
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/lot.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 355);
			setTitle("Modificar Cochera");
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
