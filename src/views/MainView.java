package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JSeparator;

public class MainView extends JFrame {

	private static final long serialVersionUID = -6685266735227602941L;

	private JPanel contentPane;

	private JButton btnAvanzar;
	private JButton btnRetroceder;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	private JButton btnEncender;
	private JButton btnApagar;
	private JComboBox cmbRadar;
	private JPanel panelControl;
	private JCheckBox chckbxGuardarRuta;
	private JPanel panel;
	private JLabel lblPanelDeControl;
	private JLabel lblX;
	private JLabel lblServidor;
	private JLabel lblXX;
	private JLabel lblPuerto;
	private JButton btnVolver;

	public MainView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cmbRadar = new JComboBox();
		cmbRadar.setBounds(81, 104, 74, 24);
		contentPane.add(cmbRadar);

		btnEncender = new JButton("ENCENDER");
		btnEncender.setBounds(80, 389, 50, 50);
		btnEncender.setBorderPainted(false);
		btnEncender.setContentAreaFilled(false);
		btnEncender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnEncender.setFocusable(false);
		contentPane.add(btnEncender);

		btnApagar = new JButton("APAGAR");
		btnApagar.setBounds(166, 389, 50, 50);
		btnApagar.setBorderPainted(false);
		btnApagar.setContentAreaFilled(false);
		btnApagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnApagar.setFocusable(false);
		contentPane.add(btnApagar);
		contentPane.setFocusable(true);

		panelControl = new JPanel();
		panelControl.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Panel de control",
				TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelControl.setBounds(37, 139, 223, 241);
		contentPane.add(panelControl);
		panelControl.setLayout(null);

		btnIzquierda = new JButton("IZQUIERDA");
		btnIzquierda.setBounds(32, 95, 50, 50);
		btnIzquierda.setBorderPainted(false);
		btnIzquierda.setContentAreaFilled(false);
		btnIzquierda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnIzquierda.setFocusable(false);
		panelControl.add(btnIzquierda);

		btnDerecha = new JButton("DERECHA");
		btnDerecha.setBounds(144, 95, 50, 50);
		btnDerecha.setBorderPainted(false);
		btnDerecha.setContentAreaFilled(false);
		btnDerecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnDerecha.setFocusable(false);
		panelControl.add(btnDerecha);

		btnAvanzar = new JButton("AVANZAR");
		btnAvanzar.setBounds(89, 35, 50, 50);
		btnAvanzar.setBorderPainted(false);
		btnAvanzar.setContentAreaFilled(false);
		btnAvanzar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnAvanzar.setFocusable(false);
		panelControl.add(btnAvanzar);

		btnRetroceder = new JButton("RETROCEDER");
		btnRetroceder.setBounds(89, 161, 50, 50);
		btnRetroceder.setBorderPainted(false);
		btnRetroceder.setContentAreaFilled(false);
		btnRetroceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnRetroceder.setFocusable(false);
		panelControl.add(btnRetroceder);

		JLabel lblSensor = new JLabel("Sensor:");
		lblSensor.setBounds(37, 109, 46, 14);
		contentPane.add(lblSensor);
		
		chckbxGuardarRuta = new JCheckBox("Guardar Ruta");
		chckbxGuardarRuta.setBounds(174, 105, 97, 23);
		contentPane.add(chckbxGuardarRuta);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 8, 299, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblPanelDeControl = new JLabel("PANEL DE CONTROL");
		lblPanelDeControl.setForeground(Color.WHITE);
		lblPanelDeControl.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPanelDeControl.setBounds(77, 11, 163, 14);
		panel.add(lblPanelDeControl);
		
		lblX = new JLabel("Servidor:");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblX.setBounds(10, 60, 55, 14);
		contentPane.add(lblX);
		
		lblServidor = new JLabel("192.168.1.33");
		lblServidor.setForeground(Color.RED);
		lblServidor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblServidor.setBounds(75, 60, 114, 14);
		contentPane.add(lblServidor);
		
		lblXX = new JLabel("Puerto:");
		lblXX.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblXX.setBounds(206, 60, 55, 14);
		contentPane.add(lblXX);
		
		lblPuerto = new JLabel("6101");
		lblPuerto.setForeground(Color.RED);
		lblPuerto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPuerto.setBounds(259, 60, 64, 14);
		contentPane.add(lblPuerto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 85, 299, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 450, 299, 2);
		contentPane.add(separator_1);
		
		btnVolver = new JButton("Volver al men\u00FA de opciones");
		btnVolver.setBounds(37, 463, 223, 23);
		contentPane.add(btnVolver);

	}

	// Métodos Getter

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnAvanzar() {
		return btnAvanzar;
	}

	public JButton getBtnRetroceder() {
		return btnRetroceder;
	}

	public JButton getBtnDerecha() {
		return btnDerecha;
	}

	public JButton getBtnIzquierda() {
		return btnIzquierda;
	}

	public JButton getBtnEncender() {
		return btnEncender;
	}

	public JButton getBtnApagar() {
		return btnApagar;
	}

	public JComboBox getCmbRadar() {
		return cmbRadar;
	}
	
	
	public JCheckBox getChckbxGuardarRuta() {
		return chckbxGuardarRuta;
	}

	public JLabel getLblServidor() {
		return lblServidor;
	}

	public JLabel getLblPuerto() {
		return lblPuerto;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	// Métodos
	public void activar() {
		// Activar todos los componentes dentro de PanelControl
		for (Component cp : panelControl.getComponents()) {
			cp.setEnabled(true);
		}
		
		btnEncender.setEnabled(false);
		btnApagar.setEnabled(true);
		btnVolver.setEnabled(false);
	}

	public void desactivar() {
		// Desactivar todos los componentes dentro de PanelControl
		for (Component cp : panelControl.getComponents()) {
			cp.setEnabled(false);
		}
		
		btnEncender.setEnabled(true);
		btnApagar.setEnabled(false);
		btnVolver.setEnabled(true);
	}
}
