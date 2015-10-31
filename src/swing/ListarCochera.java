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
import vista.CocheraView;

public class ListarCochera extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JTable cocheras;
	private TableModel jTable1Model;
	
	private SistemaCocheras sistemaCocheras;
	
	public ListarCochera(SistemaCocheras s) {
		super();
		sistemaCocheras = s;
		initGUI();		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			//getContentPane().setLayout(null);
			{				
				Vector<CocheraView> cocherasView = sistemaCocheras.listarCocheras();
				Vector<Object> vectorOfVectors = new Vector<Object>();
				for (int i= 0; i < cocherasView.size(); i++)
				{
					vectorOfVectors.add((cocherasView.elementAt(i)).toVector());
				}				
				Vector<String> columnas = new Vector<String>();
				columnas.add("Numero");
				columnas.add("Tamano Vehiculo");				
				columnas.add("Estado");		
				
				jTable1Model = new DefaultTableModel(vectorOfVectors, columnas);
				cocheras = new JTable();				
				cocheras.setModel(jTable1Model);				
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(JLabel.CENTER);
				cocheras.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				cocheras.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				
				//Tamaño de las columnas
				resizeColumnWidth(cocheras);
				
				//Borde Negro
				cocheras.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				
				JScrollPane scrollPane = new JScrollPane(cocheras);
				
				getContentPane().add(scrollPane);

			}
			ImageIcon img = new ImageIcon("src/swing/lot.png");
			setIconImage(img.getImage());
			pack();
			setSize(750, 450);
			setTitle("Listar Cocheras");
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
