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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controlador.SistemaCocheras;
import vista.AutoView;

public class ListarAuto extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JTable autos;
	private TableModel jTable1Model;
		
	private SistemaCocheras sistemaCocheras;
	private String dniCliente;
	
	public ListarAuto(SistemaCocheras s, String d) {
		super();
		sistemaCocheras = s;
		dniCliente = d;
		initGUI(dniCliente);		
	}
	
	private void initGUI(final String dniCliente) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{				
				Vector<AutoView> autosView = sistemaCocheras.listarAutos(dniCliente);
				Vector<Object> vectorOfVectors = new Vector<Object>();
				for (int i= 0; i < autosView.size(); i++)
				{
					vectorOfVectors.add((autosView.elementAt(i)).toVector());
				}				
				Vector<String> columnas = new Vector<String>();
				columnas.add("Patente");
				columnas.add("Marca");				
				columnas.add("Modelo");
				columnas.add("Fecha");					
				columnas.add("Estado");
				
				jTable1Model = new DefaultTableModel(vectorOfVectors, columnas);
				autos = new JTable();				
				autos.setModel(jTable1Model);				
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(JLabel.CENTER);
				autos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				autos.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
				
				//Tamaño de las columnas
				resizeColumnWidth(autos);
				
				//Borde Negro
				autos.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				
				JScrollPane scrollPane = new JScrollPane(autos);
				
				getContentPane().add(scrollPane);
			}			
			ImageIcon img = new ImageIcon("src/swing/auto.png");
			setIconImage(img.getImage());
			pack();
			setSize(750, 450);
			setTitle("Autos del Cliente: " + dniCliente);
			setLocationRelativeTo(null);
			setResizable(false);
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
