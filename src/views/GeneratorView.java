package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class GeneratorView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUbicacion;
	private JLabel lblServidor;
	private JLabel lblPuerto;
	private JButton btnVolver;
	private JTextArea txtConsola;
	private JButton btnEditarUbicacion;
	private JButton btnEjecutar;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneratorView frame = new GeneratorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GeneratorView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 8, 485, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EJECUTAR RUTA");
		lblNewLabel.setBounds(183, 11, 142, 28);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n:");
		lblUbicacin.setBounds(20, 113, 59, 14);
		contentPane.add(lblUbicacin);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setText("C:\\Users\\jbust\\Desktop\\Box Apache");
		txtUbicacion.setForeground(Color.RED);
		txtUbicacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUbicacion.setEnabled(false);
		txtUbicacion.setBounds(89, 110, 298, 20);
		contentPane.add(txtUbicacion);
		txtUbicacion.setColumns(10);
		
		btnEditarUbicacion = new JButton("Editar");
		btnEditarUbicacion.setBounds(391, 109, 68, 23);
		contentPane.add(btnEditarUbicacion);
		
		btnEjecutar = new JButton("Ejecutar Instrucciones");
		btnEjecutar.setBounds(176, 156, 139, 23);
		contentPane.add(btnEjecutar);
		
		txtConsola = new JTextArea();
		txtConsola.setEditable(false);
		txtConsola.setForeground(Color.DARK_GRAY);
		txtConsola.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtConsola.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtConsola.setText("\tSpeed \t |               Turnrate\r\n----------------------------------------------------------------------------------------------\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1\r\n  \t -0.5\t\t1");
		//txtConsola.setBounds(23, 190, 439, 133);
		//contentPane.add(txtConsola);
		
		scrollPane = new JScrollPane(txtConsola);
		scrollPane.setBounds(23, 190, 439, 133);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel("Servidor:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(108, 65, 55, 14);
		contentPane.add(label);
		
		lblServidor = new JLabel("192.168.1.33");
		lblServidor.setForeground(Color.RED);
		lblServidor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblServidor.setBounds(173, 65, 114, 14);
		contentPane.add(lblServidor);
		
		JLabel label_2 = new JLabel("Puerto:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(304, 65, 55, 14);
		contentPane.add(label_2);
		
		lblPuerto = new JLabel("6101");
		lblPuerto.setForeground(Color.RED);
		lblPuerto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPuerto.setBounds(357, 65, 64, 14);
		contentPane.add(lblPuerto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-3, 90, 488, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 344, 488, 2);
		contentPane.add(separator_1);
		
		btnVolver = new JButton("Volver al men\u00FA de opciones");
		btnVolver.setBounds(136, 357, 223, 23);
		contentPane.add(btnVolver);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-3, 143, 488, 2);
		contentPane.add(separator_2);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTxtUbicacion() {
		return txtUbicacion;
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

	public JTextArea getTxtConsola() {
		return txtConsola;
	}

	public JButton getBtnEditarUbicacion() {
		return btnEditarUbicacion;
	}

	public JButton getBtnEjecutar() {
		return btnEjecutar;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	
	
	
}
