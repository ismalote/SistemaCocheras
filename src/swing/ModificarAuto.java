package swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import vista.AutoView;
import controlador.SistemaCocheras;
import enums.ExitCodes;



public class ModificarAuto extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel titulo;	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;	
	private JLabel jLabel6;
	private JButton buscar;
	private JButton modificar;	
	private JTextField patenteAuto;
	private JTextField patente;
	private JTextField marca;
	private JTextField modelo;
	private JTextField fecha;	
	
	private SistemaCocheras sistemaCocheras;
	private String dniCliente;	

	public static void main(String[] args) {
		ModificarAuto inst = new ModificarAuto();
		inst.setVisible(true);
	}
	
	public ModificarAuto ()
	{
		
	}
	public ModificarAuto(SistemaCocheras s, String d) {
		super();
		sistemaCocheras = s;
		dniCliente = d;
		initGUI(dniCliente);		
	}
	
	private Date parsearFecha(String fecha){
		Date fechaParseada = null;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fechaParseada = formato.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaParseada;
	}
	
	private void initGUI(final String dniCliente) {
		try {						
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				titulo = new JLabel();
				getContentPane().add(titulo);
				titulo.setText("MODIFICAR AUTO DEL CLIENTE: " + dniCliente);
				titulo.setBounds(65, 20, 258, 28);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Patente:");
				jLabel1.setBounds(21, 118, 113, 28);
				jLabel1.setVisible(false);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Marca:");
				jLabel2.setBounds(21, 167, 113, 28);
				jLabel2.setVisible(false);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Modelo:");
				jLabel3.setBounds(21, 216, 113, 28);
				jLabel3.setVisible(false);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Fecha de Entrada:");
				jLabel4.setBounds(21, 265, 113, 28);
				jLabel4.setVisible(false);
			}
			{
				patente = new JTextField();
				getContentPane().add(patente);
				patente.setBounds(169, 118, 210, 28);
				patente.setVisible(false);				
			}
			{
				marca = new JTextField();
				getContentPane().add(marca);
				marca.setBounds(169, 167, 210, 28);
				marca.setVisible(false);
			}
			{
				modelo = new JTextField();
				getContentPane().add(modelo);
				modelo.setBounds(169, 216, 210, 28);
				modelo.setVisible(false);
			}
			{
				fecha = new JTextField();
				getContentPane().add(fecha);
				fecha.setBounds(169, 265, 210, 28);
				fecha.setVisible(false);
			}
			{
				modificar = new JButton();
				getContentPane().add(modificar);
				modificar.setText("CONFIRMAR");
				modificar.setBounds(169, 314, 113, 28);
				modificar.setVisible(false);
				modificar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						int rdo = sistemaCocheras.modificarAuto(dniCliente, patente.getText(), marca.getText(), parsearFecha(fecha.getText()), modelo.getText(), true);						
						String mensaje = "";
						switch(rdo) {
							case ExitCodes.OK: {
								mensaje = "El auto se ha modificado con �xito.";
								break;
							}
							case ExitCodes.NO_EXISTE_ENTIDAD: {
								mensaje = "El cliente no existe.";
								break;
							}
							case ExitCodes.ARGUMENTOS_INVALIDOS: {
								mensaje = "Alguno de los argumentos es inv�lido.";
								break;
							}
							case ExitCodes.NO_EXISTE_AUTO: {
								mensaje = "El auto no existe.";
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
							jLabel3.setVisible(false);
							jLabel4.setVisible(false);
							patenteAuto.setText("");
							patente.setVisible(false);
							marca.setVisible(false);
							modelo.setVisible(false);
							fecha.setVisible(false);							
							modificar.setVisible(false);
						}
					}
				});
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Ingrese Patente:");
				jLabel6.setBounds(21, 69, 98, 28);
			}
			{
				patenteAuto = new JTextField();
				getContentPane().add(patenteAuto);
				patenteAuto.setBounds(119, 69, 127, 28);
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("BUSCAR");
				buscar.setBounds(260, 69, 87, 28);
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						Vector<AutoView> autos = sistemaCocheras.listarAutos(dniCliente);						
						AutoView auto = null;
						for(int i = 0; i < autos.size() && auto == null; i++){
							if(autos.elementAt(i).getPatente().equalsIgnoreCase(patenteAuto.getText())){								
								auto = autos.elementAt(i);
							}
						}						
						if (auto != null && auto.getActivo())
						{							
							jLabel1.setVisible(true);
							jLabel2.setVisible(true);
							jLabel3.setVisible(true);
							jLabel4.setVisible(true);
							patente.setVisible(true);
							patente.setEnabled(false);
							marca.setVisible(true);							
							modelo.setVisible(true);
							fecha.setVisible(true);							
							modificar.setVisible(true);
							patente.setText(auto.getPatente());
							marca.setText(auto.getMarca());
							modelo.setText(auto.getModelo());
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							fecha.setText(df.format(auto.getFechaEntrada()));							
						}else{
							JOptionPane.showMessageDialog(null, "El cliente no posee ese auto o el auto no existe.");
							jLabel1.setVisible(false);
							jLabel2.setVisible(false);
							jLabel3.setVisible(false);
							jLabel4.setVisible(false);
							patente.setVisible(false);
							marca.setVisible(false);							
							modelo.setVisible(false);
							fecha.setVisible(false);							
							modificar.setVisible(false);
						}
					}
				});
			}
			ImageIcon img = new ImageIcon("src/swing/auto.png");
			setIconImage(img.getImage());
			pack();
			setSize(400, 400);
			setTitle("Modificar Auto");
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
