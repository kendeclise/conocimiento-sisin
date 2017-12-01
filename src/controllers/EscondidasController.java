package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Archivos;
import models.Data;
import models.Movement;
import views.EscondidasView;

public class EscondidasController {

	private EscondidasView escondidasView;
	private String servidor;
	private Boolean activo = true;
	private int habitacionSeleccionada=0;
	
	List<Data> esconderCuarto1 = new ArrayList<>();
	List<Data> esconderCuarto2= new ArrayList<>();;
	List<Data> esconderCuarto3= new ArrayList<>();;
	List<Data> esconderCuarto4= new ArrayList<>();;
	List<Data> esconderCuarto5= new ArrayList<>();;
	List<Data> esconderCuarto6= new ArrayList<>();;
	List<Data> esconderCuarto7= new ArrayList<>();;
	List<Data> esconderCuarto8= new ArrayList<>();;
	List<Data> esconderCuarto9= new ArrayList<>();;
	List<Data> esconderCuarto10= new ArrayList<>();;
	List<Data> esconderCuarto11= new ArrayList<>();;
	List<Data> esconderCuarto12= new ArrayList<>();;
	
	List<Data> buscarCuarto1= new ArrayList<>();;
	List<Data> buscarCuarto2= new ArrayList<>();;
	List<Data> buscarCuarto3= new ArrayList<>();;
	List<Data> buscarCuarto4= new ArrayList<>();;
	List<Data> buscarCuarto5= new ArrayList<>();;
	List<Data> buscarCuarto6= new ArrayList<>();;
	List<Data> buscarCuarto7= new ArrayList<>();;
	List<Data> buscarCuarto8= new ArrayList<>();;
	List<Data> buscarCuarto9= new ArrayList<>();;
	List<Data> buscarCuarto10= new ArrayList<>();;
	List<Data> buscarCuarto11= new ArrayList<>();;
	List<Data> buscarCuarto12= new ArrayList<>();;
	
	public EscondidasController(String servidor) {
		this.servidor = servidor;
		
		if(escondidasView == null) {
			escondidasView = new EscondidasView();
		}
				
		configView();
	}
	
	private void configView() {
		escondidasView.setTitle("T3-Sisin");
		escondidasView.getCboHabitacion().addItem("1");
		escondidasView.getCboHabitacion().addItem("2");
		escondidasView.getCboHabitacion().addItem("3");
		escondidasView.getCboHabitacion().addItem("4");
		escondidasView.getCboHabitacion().addItem("5");
		escondidasView.getCboHabitacion().addItem("6");
		escondidasView.getCboHabitacion().addItem("7");
		escondidasView.getCboHabitacion().addItem("8");
		escondidasView.getCboHabitacion().addItem("9");
		escondidasView.getCboHabitacion().addItem("10");
		escondidasView.getCboHabitacion().addItem("11");
		escondidasView.getCboHabitacion().addItem("12");
		
		//Asignando AL al btnEjecutar
		escondidasView.getBtnEjecutar().addActionListener(accionBtnEjecutar());
		escondidasView.getBtnRetroceder().addActionListener(accionBtnRetroceder());
		

		escondidasView.setLocationRelativeTo(null);
		escondidasView.setVisible(true);
				
	}
	
	private ActionListener accionBtnEjecutar() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int puertoBustamante = 6101;
				int puertoRamirez = 6102;
				int puertoAngulo = 6103;
				int puertoExcelmes = 6104;
				
				
				
				
				try {
					String basePath = new File("").getAbsolutePath() + "/src/archivos/";
					
					//Rutas a esconder
					esconderCuarto1 = Archivos.almacenarFichero(basePath+"sala1"+".txt");
					esconderCuarto2 = Archivos.almacenarFichero(basePath+"sala2"+".txt");
					esconderCuarto3 = Archivos.almacenarFichero(basePath+"sala3"+".txt");
					esconderCuarto4 = Archivos.almacenarFichero(basePath+"sala4"+".txt");
					esconderCuarto5 = Archivos.almacenarFichero(basePath+"sala5"+".txt");
					esconderCuarto6 = Archivos.almacenarFichero(basePath+"sala6"+".txt");
					esconderCuarto7 = Archivos.almacenarFichero(basePath+"sala7"+".txt");
					esconderCuarto8 = Archivos.almacenarFichero(basePath+"sala8"+".txt");
					esconderCuarto9 = Archivos.almacenarFichero(basePath+"sala9"+".txt");
					esconderCuarto10 = Archivos.almacenarFichero(basePath+"sala10"+".txt");
					esconderCuarto11 = Archivos.almacenarFichero(basePath+"sala11"+".txt");
					esconderCuarto12 = Archivos.almacenarFichero(basePath+"sala12"+".txt");
					
					//Rutas a buscar
					buscarCuarto1 = Archivos.almacenarFichero(basePath+"jeff_1"+".txt");
					buscarCuarto2 = Archivos.almacenarFichero(basePath+"jeff_2"+".txt");
					buscarCuarto3 = Archivos.almacenarFichero(basePath+"jeff_3"+".txt");
					buscarCuarto4 = Archivos.almacenarFichero(basePath+"jeff_4"+".txt");
					buscarCuarto5 = Archivos.almacenarFichero(basePath+"angulo_5"+".txt");
					buscarCuarto6 = Archivos.almacenarFichero(basePath+"angulo_6"+".txt");
					buscarCuarto7 = Archivos.almacenarFichero(basePath+"angulo_7"+".txt");
					buscarCuarto8 = Archivos.almacenarFichero(basePath+"angulo_8"+".txt");
					buscarCuarto9 = Archivos.almacenarFichero(basePath+"favio_9"+".txt");
					buscarCuarto10 = Archivos.almacenarFichero(basePath+"favio_10"+".txt");
					buscarCuarto11 = Archivos.almacenarFichero(basePath+"favio_11"+".txt");
					buscarCuarto12 = Archivos.almacenarFichero(basePath+"favio_12"+".txt");
					
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				habitacionSeleccionada = Integer.parseInt(escondidasView.getCboHabitacion().getSelectedItem().toString());
				
				System.out.println("Habitación Seleccionada: "+habitacionSeleccionada);
				
				
				Movement botBustamante = new Movement("172.20.10.5", puertoBustamante);
				Movement botRamirez = new Movement("172.20.10.5", puertoRamirez);
				Movement botAngulo = new Movement("172.20.10.5", puertoAngulo);
				Movement botExcelmes = new Movement("172.20.10.5", puertoExcelmes);
				
				//Ejecutando la acción de esconder el bot
				
				try {
					switch(habitacionSeleccionada) {
					case 1:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto1);
						break;
					case 2:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto2);
						break;
					case 3:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto3);
						break;
					case 4:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto4);
						break;
					case 5:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto5);
						break;
					case 6:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto6);
						break;
					case 7:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto7);
						break;
					case 8:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto8);
						break;
					case 9:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto9);
						break;
					case 10:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto10);
						break;
					case 11:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto11);
						break;
					case 12:
						botBustamante.movimientoByCoordenadasPorLista(esconderCuarto12);
						break;
					}
					
					
					
					
				}catch(Exception e) {
					System.out.println(e);
				}
				
				JOptionPane.showMessageDialog(escondidasView, "Se escondió el bot en la habitación: "+habitacionSeleccionada);
			
				
				JOptionPane.showMessageDialog(escondidasView, "Se empezó La Búsqueda");
				
				
				
				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							
							botRamirez.movimientoByCoordenadasPorLista(buscarCuarto1);
							if(habitacionSeleccionada == 1) {
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
								
							Thread.sleep(500);
							botRamirez.movimientoByCoordenadasPorLista(buscarCuarto2);
							if(habitacionSeleccionada == 2) {
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
								
							Thread.sleep(500);
							botRamirez.movimientoByCoordenadasPorLista(buscarCuarto3);
							if(habitacionSeleccionada == 3) {
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
								
							Thread.sleep(500);
							botRamirez.movimientoByCoordenadasPorLista(buscarCuarto4);
							if(habitacionSeleccionada == 4) {
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
								
						
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}).start();
				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							
							botAngulo.movimientoByCoordenadasPorLista(buscarCuarto5);
							if(habitacionSeleccionada == 5) {
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
								
							Thread.sleep(500);
							botAngulo.movimientoByCoordenadasPorLista(buscarCuarto6);
							if(habitacionSeleccionada == 6){
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
							Thread.sleep(500);
							botAngulo.movimientoByCoordenadasPorLista(buscarCuarto7);
							if(habitacionSeleccionada == 7){
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
							Thread.sleep(500);
							botAngulo.movimientoByCoordenadasPorLista(buscarCuarto8);
							if(habitacionSeleccionada == 8){
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}).start();
				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							
							botExcelmes.movimientoByCoordenadasPorLista(buscarCuarto9);
							if(habitacionSeleccionada == 9){
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
							Thread.sleep(500);
							botExcelmes.movimientoByCoordenadasPorLista(buscarCuarto10);
							if(habitacionSeleccionada == 10){
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
							Thread.sleep(500);
							botExcelmes.movimientoByCoordenadasPorLista(buscarCuarto11);
							if(habitacionSeleccionada == 11){
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
							Thread.sleep(500);
							botExcelmes.movimientoByCoordenadasPorLista(buscarCuarto12);
							if(habitacionSeleccionada == 12){
								botRamirez.apagar();
								botAngulo.apagar();
								botExcelmes.apagar();
							}
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}).start();

				
		
				
				
				
			}
		};
	}
	
	private ActionListener accionBtnRetroceder() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(escondidasView, "NO RETROCEDAS");
				
			}
		};
	}
	
	
	
}
