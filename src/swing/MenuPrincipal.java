package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import controlador.SistemaCocheras;

public class MenuPrincipal extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar jMenuBar1;
	private JMenu jMenu1; //Clientes
	private JMenu jMenu2;//Medios de pago
	private JMenu jMenu3;//Abonos
	private JMenu jMenu4;//Contratos
	private JMenu jMenu5;//Cocheras
	private JMenu jMenu6;//Salir

	private JMenuItem jMenuItem1;	
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem4;	
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem6;
	private JMenuItem jMenuItem7;	
	private JMenuItem jMenuItem8;
	private JMenuItem jMenuItem9;
	private JMenuItem jMenuItem10;	
	private JMenuItem jMenuItem11;
	private JMenuItem jMenuItem12;
	private JMenuItem jMenuItem13;	
	private JMenuItem jMenuItem14;
	private JMenuItem jMenuItem15;
	private JMenuItem jMenuItem16;	
	private JMenuItem jMenuItem17;
	private JMenuItem jMenuItem18;
	private JMenuItem jMenuItem19;	
	private JMenuItem jMenuItem20;
	
	private SistemaCocheras sistemaCocheras;

	public static void main(String[] args) {
		MenuPrincipal inst = new MenuPrincipal();
		inst.setVisible(true);
	}

	public MenuPrincipal() {
		super();
		initGUI();
		sistemaCocheras = new SistemaCocheras();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				jMenuBar1.setPreferredSize(new java.awt.Dimension(392, 22));
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("Clientes");
					jMenu1.setPreferredSize(new java.awt.Dimension(56, 21));
					jMenu1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) 
						{

						}
					});
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("Agregar");
						jMenuItem1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								AltaCliente a = new AltaCliente(sistemaCocheras);								
								a.setVisible(true);
							}
						});
					}

					
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("Modificar");
						jMenuItem2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								ModificarCliente m = new ModificarCliente(sistemaCocheras);
								m.setVisible(true);
							}
						});
					}
					{
						jMenuItem3 = new JMenuItem();
						jMenu1.add(jMenuItem3);
						jMenuItem3.setText("Eliminar");
						jMenuItem3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								EliminarCliente e = new EliminarCliente(sistemaCocheras);
								e.setVisible(true);
							}
						});
					}
					{
						jMenuItem4 = new JMenuItem();
						jMenu1.add(jMenuItem4);
						jMenuItem4.setText("Listar");
						jMenuItem4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								ListarCliente l = new ListarCliente(sistemaCocheras);
								l.setVisible(true);
							}
						});
					}
					{
						jMenuItem5 = new JMenuItem();
						jMenu1.add(jMenuItem5);
						jMenuItem5.setText("Autos");
						jMenuItem5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								AutosCliente a = new AutosCliente(sistemaCocheras);
								a.setVisible(true);
							}
						});
					}
					
				}
				{
					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("Medio de Pagos");
					jMenu2.setPreferredSize(new java.awt.Dimension(100, 21));
					jMenu2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) 
						{

						}
					});
					{
						jMenuItem6 = new JMenuItem();
						jMenu2.add(jMenuItem6);
						jMenuItem6.setText("Alta");
						jMenuItem6.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//AltaMedioPago a = new AltaMedioPago(sistemaCocheras);
								System.out.println( "Apreto Alta");
								//a.setVisible(true);

							}
						});
					}
					{
						jMenuItem7 = new JMenuItem();
						jMenu2.add(jMenuItem7);
						jMenuItem7.setText("Baja");
						jMenuItem7.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//BajaMedioPago a = new BajaMedioPago(sistemaCocheras);
								System.out.println( "Apreto Baja");
								//a.setVisible(true);

							}
						});
					}
					{
						jMenuItem8 = new JMenuItem();
						jMenu2.add(jMenuItem8);
						jMenuItem8.setText("Listar");
						jMenuItem8.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//BajaMedioPago a = new BajaMedioPago(sistemaCocheras);
								System.out.println( "Apreto Baja");
								//a.setVisible(true);

							}
						});
					}
				}
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Abonos");
					jMenu3.setPreferredSize(new java.awt.Dimension(56, 21));
					jMenu3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) 
						{

						}
					});
					{
						jMenuItem9 = new JMenuItem();
						jMenu3.add(jMenuItem9);
						jMenuItem9.setText("Alta");
						jMenuItem9.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//AltaMedioPago a = new AltaMedioPago(sistemaCocheras);
								System.out.println( "Apreto Alta");
								//a.setVisible(true);

							}
						});
					}
					{
						jMenuItem10 = new JMenuItem();
						jMenu3.add(jMenuItem10);
						jMenuItem10.setText("Modificacion");
						jMenuItem10.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//ModificarAbono m = new ModificarAbono(sistemaCocheras);
								System.out.println( "Apreto Baja");
								//m.setVisible(true);

							}
						});
					}
					{
						jMenuItem11 = new JMenuItem();
						jMenu3.add(jMenuItem11);
						jMenuItem11.setText("Baja");
						jMenuItem11.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//BajaAbono b = new BajaAbono(sistemaCocheras);
								System.out.println( "Apreto Baja");
								//b.setVisible(true);

							}
						});
					}
					{
						jMenuItem12 = new JMenuItem();
						jMenu3.add(jMenuItem12);
						jMenuItem12.setText("Listar");
						jMenuItem12.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//BajaAbono b = new BajaAbono(sistemaCocheras);
								System.out.println( "Apreto Baja");
								//b.setVisible(true);

							}
						});
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Contratos");
					jMenu4.setPreferredSize(new java.awt.Dimension(70, 21));
					jMenu4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) 
						{

						}
					});
					{
						jMenuItem13 = new JMenuItem();
						jMenu4.add(jMenuItem13);
						jMenuItem13.setText("Alta");
						jMenuItem13.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//AltaMedioPago a = new AltaMedioPago(sistemaCocheras);
								System.out.println( "Apreto Alta");
								//a.setVisible(true);

							}
						});
					}
					{
						jMenuItem14 = new JMenuItem();
						jMenu4.add(jMenuItem14);
						jMenuItem14.setText("Modificaci�n");
						jMenuItem14.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//ModificarAbono m = new ModificarAbono(sistemaCocheras);
								System.out.println( "Apreto Baja");
								//m.setVisible(true);

							}
						});
					}
					{
						jMenuItem15 = new JMenuItem();
						jMenu4.add(jMenuItem15);
						jMenuItem15.setText("Baja");
						jMenuItem15.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//BajaAbono b = new BajaAbono(sistemaCocheras);
								System.out.println( "Apreto Baja");
								//b.setVisible(true);

							}
						});
					}
					{
						jMenuItem16 = new JMenuItem();
						jMenu4.add(jMenuItem16);
						jMenuItem16.setText("Listar");
						jMenuItem16.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//BajaAbono b = new BajaAbono(sistemaCocheras);
								System.out.println( "Apreto Baja");
								//b.setVisible(true);

							}
						});
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Cocheras");
					jMenu5.setPreferredSize(new java.awt.Dimension(70, 21));
					jMenu5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) 
						{

						}
					});
					{
						jMenuItem17 = new JMenuItem();
						jMenu5.add(jMenuItem17);
						jMenuItem17.setText("Alta");
						jMenuItem17.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//AltaMedioPago a = new AltaMedioPago(sistemaCocheras);
								System.out.println( "Apreto Alta");
								//a.setVisible(true);

							}
						});
					}
					{
						jMenuItem18 = new JMenuItem();
						jMenu5.add(jMenuItem18);
						jMenuItem18.setText("Modificaci�n");
						jMenuItem18.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//ModificarAbono m = new ModificarAbono(sistemaCocheras);
								System.out.println( "Apreto Baja");
								//m.setVisible(true);

							}
						});
					}
					{
						jMenuItem19 = new JMenuItem();
						jMenu5.add(jMenuItem19);
						jMenuItem19.setText("Baja");
						jMenuItem19.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//BajaAbono b = new BajaAbono(sistemaCocheras);
								System.out.println( "Apreto Baja");
								//b.setVisible(true);

							}
						});
					}
					{
						jMenuItem20 = new JMenuItem();
						jMenu5.add(jMenuItem20);
						jMenuItem20.setText("Listar");
						jMenuItem20.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								//BajaAbono b = new BajaAbono(sistemaCocheras);
								System.out.println( "Apreto Baja");
								//b.setVisible(true);

							}
						});
					}
					{
						jMenu6 = new JMenu();
						jMenuBar1.add(jMenu6);
						jMenu6.setText("Salir");
						jMenu6.addMenuListener(new MenuListener() {
							public void menuSelected(MenuEvent evt) {
								System.exit(0);
							}
							public void menuDeselected(MenuEvent evt) {
								
							}
							public void menuCanceled(MenuEvent evt) {
								
							}
						});
					}
				}
			}		
			
			pack();
			setSize(800, 600);
			setTitle("Sistema de Cocheras - Menu Principal");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

}
