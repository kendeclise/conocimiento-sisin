package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MenuView extends JFrame {

	private JPanel contentPane;
	private JButton btnPlanificarRuta;
	private JButton btnEjecutarRuta;
	private JPanel panel_1;
	private JLabel lblDireccin;
	private JLabel lblPuerto;
	private JTextField txtServidor;
	private JComboBox cmbPuerto;
	


	/**
	 * Create the frame.
	 */
	public MenuView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 11, 289, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("MEN\u00DA RUTAS");
		lblTitulo.setBounds(77, 11, 143, 34);
		panel.add(lblTitulo);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnPlanificarRuta = new JButton("PLANIFICACI\u00D3N DE RUTAS");
		btnPlanificarRuta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPlanificarRuta.setBounds(41, 184, 201, 33);
		contentPane.add(btnPlanificarRuta);
		
		btnEjecutarRuta = new JButton("EJECUTACI\u00D3N DE RUTAS");
		btnEjecutarRuta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEjecutarRuta.setBounds(41, 240, 201, 33);
		contentPane.add(btnEjecutarRuta);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos del servidor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(31, 74, 224, 89);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(21, 27, 68, 14);
		panel_1.add(lblDireccin);
		
		lblPuerto = new JLabel("Puerto:");
		lblPuerto.setBounds(21, 52, 68, 14);
		panel_1.add(lblPuerto);
		
		txtServidor = new JTextField();
		txtServidor.setBounds(90, 24, 107, 20);
		panel_1.add(txtServidor);
		txtServidor.setColumns(10);
		
		cmbPuerto = new JComboBox();
		cmbPuerto.setBounds(90, 49, 107, 20);
		panel_1.add(cmbPuerto);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnPlanificarRuta() {
		return btnPlanificarRuta;
	}

	public JButton getBtnEjecutarRuta() {
		return btnEjecutarRuta;
	}

	public JTextField getTxtServidor() {
		return txtServidor;
	}

	public JComboBox getCmbPuerto() {
		return cmbPuerto;
	}
	
	
	
	
}
