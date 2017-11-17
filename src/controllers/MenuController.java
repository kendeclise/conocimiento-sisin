package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import views.MenuView;

public class MenuController {

	private MenuView menuView;
	private String servidor = "localhost";
	private int puerto = 6665;

	public MenuController() {
		// Instanciando la vista
		if (menuView == null) {
			menuView = new MenuView();
		}

		configView();
	}
	
	public MenuController(String servidor, int puerto) {
		this.servidor = servidor;
		this.puerto = puerto;
		// Instanciando la vista
		if (menuView == null) {
			menuView = new MenuView();
		}

		configView();
		menuView.getTxtServidor().setText(servidor);
		
		switch (puerto) {
		case 6101:
			menuView.getCmbPuerto().setSelectedIndex(0);
			break;
		case 6102:
			menuView.getCmbPuerto().setSelectedIndex(1);
			break;
		case 6103:
			menuView.getCmbPuerto().setSelectedIndex(2);
			break;
		case 6104:
			menuView.getCmbPuerto().setSelectedIndex(3);
			break;		
		default:
			menuView.getCmbPuerto().setSelectedIndex(4);
			break;
		}
		
	}

	private void configView() {

		menuView.setTitle("Menú de opciones");

		// Elementos del comboPuerto
		menuView.getCmbPuerto().addItem("6101");
		menuView.getCmbPuerto().addItem("6102");
		menuView.getCmbPuerto().addItem("6103");
		menuView.getCmbPuerto().addItem("6104");
		menuView.getCmbPuerto().addItem("6665");

		menuView.getTxtServidor().setText("192.168.1.33");
		menuView.getCmbPuerto().setSelectedIndex(0);
		
		// Asignando actionListener a los botones
		menuView.getBtnEjecutarRuta().addActionListener(accionBtnEjecutarRuta());
		menuView.getBtnPlanificarRuta().addActionListener(accionBtnPlanificarRuta());

		menuView.setLocationRelativeTo(null);
		menuView.setVisible(true);
	}

	// ActionListeners

	private ActionListener accionBtnPlanificarRuta() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				servidor = menuView.getTxtServidor().getText();
				puerto = Integer.parseInt(menuView.getCmbPuerto().getSelectedItem().toString());
				if (servidor.isEmpty()) {
					JOptionPane.showMessageDialog(menuView, "El campo dirección del servidor no puede estar vacío.",
							"Error de validación", JOptionPane.ERROR_MESSAGE);
				} else {					
					menuView.setVisible(false);
					menuView = null;
					//Instanciando el controlador Main
					new MainController(servidor, puerto);
				}
			}
		};
	}

	private ActionListener accionBtnEjecutarRuta() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				servidor = menuView.getTxtServidor().getText();
				puerto = Integer.parseInt(menuView.getCmbPuerto().getSelectedItem().toString());

				if (servidor.isEmpty()) {
					JOptionPane.showMessageDialog(menuView, "El campo dirección del servidor no puede estar vacío.",
							"Error de validación", JOptionPane.ERROR_MESSAGE);
				} else {
					menuView.setVisible(false);
					menuView = null;
					//Instanciando el controlador Generator
					new GeneratorController(servidor, puerto);
				}

			}
		};
	}

}
