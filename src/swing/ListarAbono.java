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
import vista.AbonoView;

public class ListarAbono extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JTable abonos;
	private TableModel jTable1Model;
		
	private SistemaCocheras sistemaCocheras;
	
	public ListarAbono(SistemaCocheras s) {
		super();
		sistemaCocheras = s;
		initGUI();		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{				
				Vector<AbonoView> abonosView = sistemaCocheras.listarAbonos();
				Vector<Object> vectorOfVectors = new Vector<Object>();
				for (int i= 0; i < abonosView.size(); i++)
				{
					vectorOfVectors.add((abonosView.elementAt(i)).toVector());
				}				
				Vector<String> columnas = new Vector<String>();
				columnas.add("Nombre");
				columnas.add("Cant. Dias");
				columnas.add("Precio");				
				columnas.add("Descuento");									
				columnas.add("Cochera");
				columnas.add("Estado");				
				jTable1Model = new DefaultTableModel(vectorOfVectors, columnas);
				abonos = new JTable();				
				abonos.setModel(jTable1Model);				
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(JLabel.CENTER);				
				abonos.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
				
				//Tamaño de las columnas
				resizeColumnWidth(abonos);
				
				//Borde Negro
				abonos.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				
				JScrollPane scrollPane = new JScrollPane(abonos);
				
				getContentPane().add(scrollPane);
			}			
			ImageIcon img = new ImageIcon("src/swing/abono.png");
			setIconImage(img.getImage());
			pack();
			setSize(750, 450);
			setTitle("Listar Abonos");
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
