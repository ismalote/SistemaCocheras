package swing;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controlador.SistemaCocheras;
import vista.ClienteView;

public class ListarCliente extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JTable clientes;
	private TableModel jTable1Model;
	
	private SistemaCocheras sistemaCocheras;
	
	public static void main(String[] args) {
		ListarCliente inst = new ListarCliente();
		inst.setVisible(true);
	}	
	
	public ListarCliente()
	{
		
	}
	
	public ListarCliente(SistemaCocheras s) {
		super();
		sistemaCocheras = s;
		initGUI();		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			//getContentPane().setLayout(null);
			{				
				Vector<ClienteView> clientesView = sistemaCocheras.listarClientes();
				Vector<Object> vectorOfVectors = new Vector<Object>();
				for (int i= 0; i < clientesView.size(); i++)
				{
					vectorOfVectors.add((clientesView.elementAt(i)).toVector());
				}				
				Vector<String> columnas = new Vector<String>();
				columnas.add("DNI");
				columnas.add("Nombre");				
				columnas.add("Domicilio");
				columnas.add("Telefono");
				columnas.add("Mail");
				columnas.add("Estado");
				
				jTable1Model = new DefaultTableModel(vectorOfVectors, columnas);
				clientes = new JTable();				
				clientes.setModel(jTable1Model);				
				
				//Centrar la fila del DNI y el ESTADO
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(JLabel.CENTER);
				clientes.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				clientes.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
				
				//Tamaño de las columnas
				resizeColumnWidth(clientes);
				
				//Borde Negro
				clientes.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				
				JScrollPane scrollPane = new JScrollPane(clientes);
				
				getContentPane().add(scrollPane);

			}
			pack();
			setSize(600, 600);
			setTitle("Sistema de Cocheras - Listar Clientes");
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
