package swing;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import vista.CuotaView;
import controlador.SistemaCocheras;

public class ListarProximasCuotas extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JTable cuotas;
	private TableModel jTable1Model;
	
	private SistemaCocheras sistemaCocheras;
	
	public ListarProximasCuotas(SistemaCocheras s) {
		super();
		sistemaCocheras = s;
		initGUI();		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			//getContentPane().setLayout(null);
			{				
				Vector<CuotaView> cuotasView = sistemaCocheras.listarProximasCuotas();
				Vector<Object> vectorOfVectors = new Vector<Object>();
				for (int i= 0; i < cuotasView.size(); i++)
				{
					vectorOfVectors.add((cuotasView.elementAt(i)).toVector());
				}				
				Vector<String> columnas = new Vector<String>();
				columnas.add("N� contrato");
				columnas.add("Fecha generacion");
				columnas.add("Fecha vencimiento");				
				columnas.add("Monto");
				columnas.add("Fecha pago");
				
				jTable1Model = new DefaultTableModel(vectorOfVectors, columnas){
					
					private static final long serialVersionUID = 1L;

					public boolean isCellEditable(int row, int column){
						return false;
					}
				};
				cuotas = new JTable();				
				cuotas.setModel(jTable1Model);				
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(JLabel.CENTER);				
				cuotas.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				cuotas.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				cuotas.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				//cuotas.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
				
				//Tamaño de las columnas
				resizeColumnWidth(cuotas);
				
				//Borde Negro
				cuotas.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				
				JScrollPane scrollPane = new JScrollPane(cuotas);
				
				getContentPane().add(scrollPane);

			}
			ImageIcon img = new ImageIcon("src/swing/pago.png");
			setIconImage(img.getImage());
			pack();
			setSize(750, 450);
			setTitle("Listar Proximas Cuotas");
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
