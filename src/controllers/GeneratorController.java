package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.Movement;
import views.GeneratorView;

public class GeneratorController {

	private GeneratorView generatorView;
	
	private String servidor = "localhost";
	private int puerto = 6665;
	private String filepath="";
	
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de tipo .txt", "txt");
	
	public GeneratorController(String servidor, int puerto) {
		this.servidor = servidor;
		this.puerto = puerto;
		
		//Instanciando la vista
		if(generatorView == null) {
			generatorView = new GeneratorView();
		}
		configView();
	}
	
	private void configView() {
		
		generatorView.setTitle("Generador de rutas");
		generatorView.getLblServidor().setText(servidor);
		generatorView.getLblPuerto().setText(""+puerto);
		generatorView.getTxtUbicacion().setText(filepath);
		
		generatorView.getScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Cabecera JTextArea
		generatorView.getTxtConsola().setText("--------------------------------------------------------------");
		generatorView.getTxtConsola().append("\n\t    Speed\t\t|\t    TurnRate");
		generatorView.getTxtConsola().append("\n--------------------------------------------------------------");
		
		
		//Asignando acciones a los botones
		generatorView.getBtnVolver().addActionListener(accionBtnVolver());
		generatorView.getBtnEditarUbicacion().addActionListener(accionBtnEditarUbicacion());
		generatorView.getBtnEjecutar().addActionListener(accionBtnEjecutar());
		
		generatorView.setLocationRelativeTo(null);
		generatorView.setVisible(true);
		
	}
	
	//ActionListener
	private ActionListener accionBtnVolver() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Destruyo la vista
				generatorView.setVisible(false);
				generatorView = null;
				//Invoco al controlador menu
				new MenuController(servidor,puerto);
			}
		};
	}
	
	private ActionListener accionBtnEditarUbicacion() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser flc = new JFileChooser();
                flc.setFileFilter(filtro);
                flc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int option = flc.showOpenDialog(generatorView);
                //Condiciones
                if (option == JFileChooser.APPROVE_OPTION) {
                    filepath = flc.getSelectedFile().getPath();
                    
                    generatorView.getTxtUbicacion().setText(filepath);
                    	
                }
				
			}
		};
	}
	
	private ActionListener accionBtnEjecutar() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(filepath.isEmpty()) {
					JOptionPane.showMessageDialog(generatorView, "Debe seleccionar cargar un archivo .txt antes de intentar ejecutar.",
							"Error con el archivo", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						//new Movement(servidor, puerto).movimientoPorFichero(filepath, generatorView);
						new Movement(servidor, puerto).movimientoByCoordenadasPorFichero(filepath, generatorView);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(NumberFormatException nfe) {
						System.err.println("El archivo ingresado no es un script");
						JOptionPane.showMessageDialog(generatorView, "Debe seleccionar un archivo de tipo Script!.",
								"Error con el archivo", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		};
	}
	
	
}
