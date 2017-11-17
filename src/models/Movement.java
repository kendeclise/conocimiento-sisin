package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javaclient3.PlayerClient;
import javaclient3.PlayerException;
import javaclient3.Position2DInterface;
import javaclient3.RangerInterface;
import javaclient3.structures.PlayerConstants;
import javaclient3.structures.PlayerPose2d;
import javaclient3.structures.position1d.PlayerPosition1dCmdPos;
import javaclient3.structures.position2d.PlayerPosition2dCmdPos;
import views.GeneratorView;

public class Movement {
	private PlayerClient robot = null;
	private Position2DInterface posi = null;
	private RangerInterface ranger = null;

	private int indexRadar = 0, puerto = 6665;
	private String servidor = "localhost";
	private int[] lados = new int[3];
	
	private List<String> database = new ArrayList<>();
	

	/*
	 * laser = 360 puntos (divisiones 1-120, 121-240, 241-360) 
	 * sonar = 15 puntos (divisiones 1-5, 6-10, 11-15)
	 */

	public Movement(String servidor, int puerto) {
		this.servidor = servidor;
		this.puerto = puerto;
		database.add("Speed;TurnRate");
		
	}

	public void setIndexRadar(int indexRadar) {
		this.indexRadar = indexRadar;
	}
	
	public List<String> getDatabase() {
		return database;
	}

	public void encender() {

		try {

			robot = new PlayerClient(servidor, puerto);
			posi = robot.requestInterfacePosition2D(0, PlayerConstants.PLAYER_OPEN_MODE);
			ranger = robot.requestInterfaceRanger(indexRadar, PlayerConstants.PLAYER_OPEN_MODE);
			
			PlayerPose2d position = new PlayerPose2d(6, 6, 5000);		
			PlayerPosition2dCmdPos pst = new PlayerPosition2dCmdPos();
			pst.setPos(position);
			pst.setVel(position);
			posi.setPosition(pst);
			
			
			
			ranger.setRangerPower(1);
			posi.setMotorPower(1);
			
			
			
			

			switch (ranger.getDeviceAddress().getIndex()) {
			case 0:
				lados[0] = 5;
				lados[1] = 10;
				lados[2] = 15;
				break;
			case 1:
				lados[0] = 120;
				lados[1] = 240;
				lados[2] = 360;
				break;
			}

			robot.runThreaded(-1, -1);

		} catch (PlayerException e) {
			e.printStackTrace();
			//System.err.println(e.toString());
			System.exit(1);
		}
	}

	public void apagar() {
		if (ranger.isDataReady()) {
			posi.setMotorPower(0);
			ranger.setRangerPower(0);
			ranger = robot.requestInterfaceRanger(indexRadar, PlayerConstants.PLAYER_CLOSE_MODE);
			ranger = null;
			posi = null;
			robot.close();
		}
		//System.err.println("APAGADO");
	}

	public void obstaculo(int inicio, int fin) {
		boolean obstaculo = false;

		for (int i = inicio; i < fin; i++) {
			if (ranger.isDataReady()) {
				if (ranger.getData().getRanges()[i] < 1.5)
					obstaculo = true;
			}
		}

		System.out.println(", OBSTACULO: " + obstaculo);

	}

	public void movimiento(String accion) {
		double speed = 0, turnrate = 0;
		System.out.println("ACCIÓN: " + accion);

		if ("IZQUIERDA".equals(accion)) {
			speed = 0f;
			turnrate = 1;
			obstaculo(lados[1] + 1, lados[2]);
		} else if ("AVANZAR".equals(accion)) {
			speed = 0.5f;
			turnrate = 0;
			obstaculo(lados[0] + 1, lados[1]);
		} else if ("RETROCEDER".equals(accion)) {
			speed = -0.5f;
			turnrate = 0;
			System.out.println();
			;
		} else if ("DERECHA".equals(accion)) {
			speed = 0f;
			turnrate = -1;
			obstaculo(0, lados[0]);
		}

		posi.setSpeed(speed, turnrate);

		try {
			Thread.sleep(300);
		} catch (Exception e) {
		}

		posi.setSpeed(0, 0);
		
		System.out.println("Velocidad= " + speed + ", Giro= " + turnrate);
		//Almacenando en una variable base de datos
		database.add(speed+";"+turnrate);

		if (ranger.isDataReady()) {
			// System.err.println(decodeLaserData(ranger));
		}
	}
	
	public void movimientoPorFichero(String urlFichero, GeneratorView vistaGenerator) throws IOException, NumberFormatException {
		File archivo = new File (urlFichero);
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		
		// Lectura del fichero
        String linea;
        int cont = 0;
        encender();
        while((linea=br.readLine())!=null) {
        	if(cont != 0) {
        		//System.out.println(linea);
        		String[] datos = linea.split(";");        		
        		double speed = Double.parseDouble(datos[0]); 
        	    double turnrate = Double.parseDouble(datos[1]);
        	    
        		//System.out.println(speed+" - "+turnrate);
        	    
        	    String speedString = (speed>=0.0) ? " "+speed : ""+speed;
        	    String turnRateString = (turnrate>=0.0) ? " "+turnrate : ""+turnrate;
        	            		
        		//Efectuando el movimiento        		
        		posi.setSpeed(speed, turnrate);
        		vistaGenerator.getTxtConsola().append("\n\t    "+  speedString+"\t\t|\t      "+turnRateString);

        		try {
        			Thread.sleep(300);
        		} catch (Exception e) {
        		}

        		posi.setSpeed(0, 0);
        		
        	}        	
        	cont++;
        }
        
        //Cerrando el archivo
        br.close();
        fr.close();
        apagar();
        
        try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
        
        JOptionPane.showMessageDialog(vistaGenerator, "Se ejecutó correctamente el script de movimiento de rutas.",
				"Éxito", JOptionPane.DEFAULT_OPTION);
		
	}

	static NumberFormat fmt = NumberFormat.getInstance();

	public String decodeLaserData(RangerInterface li) {
		String out = "\n" + (indexRadar == 0 ? "Sonar" : "Laser") + " values: \n";
		for (int i = 0; i < li.getData().getRanges_count(); i++) {
			out += " [" + align(fmt, i + 1, 2) + "] = " + align(fmt, (float) li.getData().getRanges()[i], 5);
			if (((i + 1) % 8) == 0)
				out += "\n";
		}
		return out;
	}

	static String align(NumberFormat fmt, float n, int sp) {
		StringBuffer buf = new StringBuffer();
		FieldPosition fpos = new FieldPosition(NumberFormat.INTEGER_FIELD);
		fmt.format(n, buf, fpos);
		for (int i = 0; i < sp - fpos.getEndIndex(); ++i)
			buf.insert(0, ' ');
		return buf.toString();
	}
}
