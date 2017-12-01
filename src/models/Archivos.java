package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivos {
	
	public static List<Data> almacenarFichero(String urlFichero) throws IOException, NumberFormatException {
		List<Data> almacen = new ArrayList<>();
		
		File archivo = new File (urlFichero);
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		
		// Lectura del fichero
        String linea;
        int cont = 0;
        
        while((linea=br.readLine())!=null) {
        	if(cont != 0) {
        		//System.out.println(linea);
        		String[] datos = linea.split(";");        		
        		double speed = Double.parseDouble(datos[0]); 
        	    double turnrate = Double.parseDouble(datos[1]);
        	    double x = Double.parseDouble(datos[2]);
        	    double y = Double.parseDouble(datos[3]);
        	    double yaw = Double.parseDouble(datos[4]);
        	    
        	    Data data = new Data();
        	    data.setSpeed(speed);
        	    data.setTurnspeed(turnrate);
        	    data.setX(x);
        	    data.setY(y);
        	    data.setYaw(yaw);       		        	            		
        		
        		almacen.add(data);
        	}        	
        	cont++;
        }
        
        //Cerrando el archivo
        br.close();
        fr.close();
    
        return almacen; 
		
	}
	
	public static void imprimir(List<Data> almacen) {
		System.out.println("---Lista---");
		for(Data d: almacen) {
			System.out.println(d);
		}
	}
	
}
