package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class EscondidasView extends JFrame {

	private JPanel contentPane;
	private JButton btnEjecutar;
	private JButton btnRetroceder;
	private JComboBox cboHabitacion;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EscondidasView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 11, 323, 41);
		contentPane.add(panel);
		
		JLabel lblJuegoDeLas = new JLabel("JUEGO DE LAS ESCONDIDAS");
		lblJuegoDeLas.setForeground(Color.WHITE);
		lblJuegoDeLas.setFont(new Font("Verdana", Font.BOLD, 14));
		lblJuegoDeLas.setBounds(56, 11, 223, 14);
		panel.add(lblJuegoDeLas);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(21, 63, 292, 205);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblHabitacin = new JLabel("Habitación:");
		lblHabitacin.setBounds(30, 33, 76, 14);
		panel_1.add(lblHabitacin);
		
		btnEjecutar = new JButton("Iniciar Programa");
		btnEjecutar.setBounds(27, 83, 241, 41);
		panel_1.add(btnEjecutar);
		
		btnRetroceder = new JButton("Retroceder");
		btnRetroceder.setBounds(27, 135, 241, 41);
		panel_1.add(btnRetroceder);
		
		cboHabitacion = new JComboBox();
		cboHabitacion.setBounds(116, 30, 152, 20);
		panel_1.add(cboHabitacion);
	}

	public JButton getBtnEjecutar() {
		return btnEjecutar;
	}

	public JButton getBtnRetroceder() {
		return btnRetroceder;
	}

	public JComboBox getCboHabitacion() {
		return cboHabitacion;
	}
	
	
}
