package controllers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.Movement;
import views.MainView;

public class MainController {

	private MainView mainView;
	private Movement movement;
	private String servidor;
	private int puerto;

	private boolean controlEncendido = false;
	private boolean controlGuardado = false;
	
	//Filtro de subida de archivos txt
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de tipo .txt", "txt");

	public MainController(String servidor, int puerto) {
		// Instanciando la vista
		if (mainView == null) {
			mainView = new MainView();
		}

		// Capturando y asignando datos del servidor y puerto
		this.servidor = servidor;
		this.puerto = puerto;

		// Configurando y mostrando la vista Principal
		configView();

	}

	private void configView() {

		// Variados
		mainView.setTitle("Planificación de rutas");
		mainView.getBtnEncender().setToolTipText("Encender la aplicación");
		mainView.getBtnApagar().setToolTipText("Apagar la aplicación");
		mainView.getContentPane().setFocusable(true);

		mainView.getLblServidor().setText(servidor);
		mainView.getLblPuerto().setText(""+puerto);
		
		// Items comboSensor
		mainView.getCmbRadar().addItem("Sonar");
		mainView.getCmbRadar().addItem("Laser");
		
		
		//Asignando Iconos a los botones del panel de control (setRollOverIcon and setPressedIcon)
		mainView.getBtnAvanzar().setText("");
		ImageIcon iconoUp = new ImageIcon(getClass().getResource("/img/up.png"));
		ImageIcon iconoUpPress = new ImageIcon(getClass().getResource("/img/upPress.png"));
		mainView.getBtnAvanzar().setIcon(resizeIcon(iconoUp, 50, 50));
		mainView.getBtnAvanzar().setPressedIcon(resizeIcon(iconoUpPress, 50, 50));
		
		mainView.getBtnRetroceder().setText("");
		ImageIcon iconoDown = new ImageIcon(getClass().getResource("/img/down.png"));
		ImageIcon iconoDownPress = new ImageIcon(getClass().getResource("/img/downPress.png"));
		mainView.getBtnRetroceder().setIcon(resizeIcon(iconoDown, 50, 50));
		mainView.getBtnRetroceder().setPressedIcon(resizeIcon(iconoDownPress, 50, 50));
		
		mainView.getBtnIzquierda().setText("");
		ImageIcon iconoLeft = new ImageIcon(getClass().getResource("/img/left.png"));
		ImageIcon iconoLeftPress = new ImageIcon(getClass().getResource("/img/leftPress.png"));
		mainView.getBtnIzquierda().setIcon(resizeIcon(iconoLeft, 50, 50));
		mainView.getBtnIzquierda().setPressedIcon(resizeIcon(iconoLeftPress, 50, 50));
		
		mainView.getBtnDerecha().setText("");
		ImageIcon iconoRight = new ImageIcon(getClass().getResource("/img/right.png"));
		ImageIcon iconoRightPress = new ImageIcon(getClass().getResource("/img/rightPress.png"));
		mainView.getBtnDerecha().setIcon(resizeIcon(iconoRight, 50, 50));
		mainView.getBtnDerecha().setPressedIcon(resizeIcon(iconoRightPress, 50, 50));
		
		mainView.getBtnEncender().setText("");
		ImageIcon iconoOn = new ImageIcon(getClass().getResource("/img/turnOn.png"));
		ImageIcon iconoOnPress = new ImageIcon(getClass().getResource("/img/turnOnPress.png"));
		mainView.getBtnEncender().setIcon(resizeIcon(iconoOn, 50, 50));
		mainView.getBtnEncender().setPressedIcon(resizeIcon(iconoOnPress, 50, 50));
		
		
		mainView.getBtnApagar().setText("");
		ImageIcon iconoOff = new ImageIcon(getClass().getResource("/img/turnOff.png"));
		ImageIcon iconoOffPress = new ImageIcon(getClass().getResource("/img/turnOffPress.png"));
		mainView.getBtnApagar().setIcon(resizeIcon(iconoOff, 50, 50));
		mainView.getBtnApagar().setPressedIcon(resizeIcon(iconoOffPress, 50, 50));
		

		// Asignando los ActionListener a los botones y el checkbox
		mainView.getBtnAvanzar().addActionListener(accionBtnAvanzar());
		mainView.getBtnRetroceder().addActionListener(accionBtnRetroceder());
		mainView.getBtnIzquierda().addActionListener(accionBtnIzquierda());
		mainView.getBtnDerecha().addActionListener(accionBtnDerecha());
		mainView.getBtnEncender().addActionListener(accionBtnEncender());
		mainView.getBtnApagar().addActionListener(accionBtnApagar());
		mainView.getChckbxGuardarRuta().addActionListener(accionCheckBoxGuardado());
		mainView.getBtnVolver().addActionListener(accionBtnVolver());

		// Asignando las teclas direccionales a la vista
		mainView.getContentPane().addKeyListener(accionTeclasDireccionales());
		mainView.getCmbRadar().addKeyListener(accionTeclasDireccionales());
		mainView.getChckbxGuardarRuta().addKeyListener(accionTeclasDireccionales());
	
		
		// Desactivar al iniciar el panelControl
		mainView.desactivar();
		controlEncendido = false;
		controlGuardado = false;

		// Mostrar GUI
		mainView.setLocationRelativeTo(null);
		mainView.setVisible(true);

	}

	// Acciones de los Botones y el checkBox (ActionListeners)

	private ActionListener accionBtnAvanzar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Btn Avanzar");
				movement.movimiento("AVANZAR");

			}
		};
	}

	private ActionListener accionBtnRetroceder() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Btn Retroceder");
				movement.movimiento("RETROCEDER");

			}
		};
	}

	private ActionListener accionBtnIzquierda() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Btn Izquierda");
				movement.movimiento("IZQUIERDA");
			}
		};
	}

	private ActionListener accionBtnDerecha() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Btn Derecha");
				movement.movimiento("DERECHA");
			}
		};
	}

	private ActionListener accionBtnEncender() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.err.println("[APLICACIÓN ENCENDIDA]");
				// Instancio el modelo
				if (movement == null) {
					movement = new Movement(servidor, puerto);
				}
				
				movement.setIndexRadar(mainView.getCmbRadar().getSelectedIndex());
				movement.encender();
				mainView.activar();
				controlEncendido = true;
			}
		};
	}

	private ActionListener accionBtnApagar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {		

				//Guardado de el archivo txt de la ruta generada
				if(controlGuardado == true) {
					JFileChooser flc = new JFileChooser();//Aplicamos el filtro de extensiones usando el metodo setFileFilter, y validamos  que solo se ingresen archivos
	                flc.setFileFilter(filtro);
	                flc.setFileSelectionMode(JFileChooser.FILES_ONLY);//Abrimos la ventana de dialogo para elegir imagenes
	                int option = flc.showSaveDialog(mainView);
	                
	                if (option == JFileChooser.APPROVE_OPTION) {
	                    try {
	                    	
	                    	String extension = "";
	                    	
	                    	if(flc.getSelectedFile().toString().length() > 4) {
	                    		String endStr = flc.getSelectedFile().toString().substring(flc.getSelectedFile().toString().length()-4,flc.getSelectedFile().toString().length());
	                    		
	                    		if(!endStr.equalsIgnoreCase(".txt")) {
	                    			extension = ".txt";
	                    		}
	                    		
	                    	}	                    	
	                    	
	                        FileWriter fw = new FileWriter(flc.getSelectedFile()+extension);
	                        PrintWriter pw = new PrintWriter(fw);
	                        //Escritura del archivo txt
	                        
	                        for(String s : movement.getDatabase()) {
	                        	pw.println(s);
	                        }

	                        //Cerrando el archivo
	                        pw.close();
	                        fw.close();
	                        
	                        //Mensaje de éxito
	                        JOptionPane.showMessageDialog(mainView, "Se guardó el script correctamente en la ubicación: \""+flc.getSelectedFile()+extension+"\"",
	                				"éxito al guardar archivo", JOptionPane.DEFAULT_OPTION);
	                        
	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                    
	                    System.err.println("[APLICACIÓN APAGADA]");
	                    movement.apagar();
	                    movement = null;
						mainView.desactivar();			
						controlEncendido = false;
		                
	                    
	                } 
	                
	                mainView.getContentPane().requestFocus();
	               
	                
				}else {
					System.err.println("[APLICACIÓN APAGADA]");
					movement.apagar();
					movement = null;
					mainView.desactivar();			
					controlEncendido = false;
				}
				
				
			}
		};
	}
	
	private ActionListener accionCheckBoxGuardado() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controlGuardado = mainView.getChckbxGuardarRuta().isSelected();			
			}
		};
	}
	
	private ActionListener accionBtnVolver() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Destruyendo la vista
				mainView.setVisible(false);
				mainView = null;
				
				//Invocando el controlador de Menú
				new MenuController(servidor,puerto);
			}
		};
	}
	

	// KeyListener

	private KeyListener accionTeclasDireccionales() {
		return new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				if (controlEncendido) {
					if (KeyEvent.VK_UP == e.getKeyCode()) {
						movement.movimiento("AVANZAR");
					}
					if (KeyEvent.VK_DOWN == e.getKeyCode()) {
						movement.movimiento("RETROCEDER");
					}
					if (KeyEvent.VK_RIGHT == e.getKeyCode()) {
						movement.movimiento("DERECHA");
					}
					if (KeyEvent.VK_LEFT == e.getKeyCode()) {
						movement.movimiento("IZQUIERDA");
					}

				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				/*
				if (controlEncendido) {
					if (KeyEvent.VK_UP == e.getKeyCode()) {
						movement.movimiento("AVANZAR");
					}
					if (KeyEvent.VK_DOWN == e.getKeyCode()) {
						movement.movimiento("RETROCEDER");
					}
					if (KeyEvent.VK_RIGHT == e.getKeyCode()) {
						movement.movimiento("DERECHA");
					}
					if (KeyEvent.VK_LEFT == e.getKeyCode()) {
						movement.movimiento("IZQUIERDA");
					}

				}*/

			}
		};
	}
	
	//Método para cambiar el tamaño de una imagen
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}

}
