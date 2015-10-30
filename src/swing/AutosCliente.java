package swing;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.SistemaCocheras;
import enums.EstadosCliente;
import vista.ClienteView;

public class AutosCliente extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;	
	private JButton buscar;
	private JButton alta;
	private JButton modificar;
	private JButton eliminar;
	private JButton listar;
	private JLabel titulo;
	private JLabel jLabel1;
	private JTextField dniCliente;
	private JTextField dni;
	private ClienteView cliente;	
	
	private SistemaCocheras sistemaCocheras;
	
	public static void main(String[] args) {
		ListarCliente inst = new ListarCliente();
		inst.setVisible(true);
	}	
	
	public AutosCliente()
	{
		
	}
	
	public AutosCliente(SistemaCocheras s) {
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
				titulo.setText("ABM AUTOS POR CLIENTE");
				titulo.setBounds(110, 20, 148, 28);
			}
			{
				dni = new JTextField();
				getContentPane().add(dni);
				dni.setBounds(119, 118, 127, 28);
				dni.setVisible(false);
				dni.setEnabled(false);
			}
			{
				alta = new JButton();
				getContentPane().add(alta);
				alta.setVisible(false);
				alta.setText("AGREGAR AUTO");
				alta.setBounds(113, 169, 137, 28);
				alta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						AltaAuto a = new AltaAuto(sistemaCocheras, dni.getText());
						a.setVisible(true);
					}
				});				
			}
			{
				modificar = new JButton();
				getContentPane().add(modificar);
				modificar.setVisible(false);
				modificar.setText("MODIFICAR AUTO");
				modificar.setBounds(113, 218, 137, 28);
				modificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						ModificarAuto a = new ModificarAuto(sistemaCocheras, dni.getText());
						a.setVisible(true);
					}
				});				
			}
			{
				eliminar = new JButton();
				getContentPane().add(eliminar);
				eliminar.setVisible(false);
				eliminar.setText("ELIMINAR AUTO");
				eliminar.setBounds(113, 267, 137, 28);
				eliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						EliminarAuto a = new EliminarAuto(sistemaCocheras, dni.getText());
						a.setVisible(true);
					}
				});				
			}
			{
				listar = new JButton();
				getContentPane().add(listar);
				listar.setVisible(false);
				listar.setText("LISTAR AUTOS");
				listar.setBounds(113, 316, 137, 28);
				listar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						ListarAuto a = new ListarAuto(sistemaCocheras, dni.getText());
						a.setVisible(true);
					}
				});				
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Ingrese DNI:");
				jLabel1.setBounds(21, 69, 98, 28);
			}
			{
				dniCliente = new JTextField();
				getContentPane().add(dniCliente);
				dniCliente.setBounds(119, 69, 127, 28);
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("BUSCAR");
				buscar.setBounds(260, 69, 87, 28);
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cliente = sistemaCocheras.buscarDatosCliente(dniCliente.getText());
						if (cliente != null && cliente.getEstado() == EstadosCliente.ACTIVO)
						{
							dni.setText(cliente.getDni());
							dni.setVisible(true);
							alta.setVisible(true);
							modificar.setVisible(true);
							eliminar.setVisible(true);
							listar.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(null, "El cliente no existe.");
							dni.setText("");
							dni.setVisible(false);
							alta.setVisible(false);
							modificar.setVisible(false);
							eliminar.setVisible(false);
							listar.setVisible(false);
						}
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/auto.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 600);
			setTitle("Autos por Cliente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Tamaño de las columnas
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 50; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }	        
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
	
}
