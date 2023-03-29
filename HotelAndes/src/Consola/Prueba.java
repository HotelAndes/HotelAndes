package Consola;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Logica.Cama;
import Logica.CargardorArchivo;
import Logica.Habitacion;



public class Prueba {
	static CargardorArchivo probar= new CargardorArchivo(); 

	public static void main(String[] args) throws IOException {
		
		
		
		File archivoCamas= new File ("./data/camas.txt");
		HashMap<String,Cama> camas= probar.cargarCamas ( archivoCamas);
		for(String i: camas.keySet() ) {
			Cama c = camas.get(i);
		
        	System.out.println("Tamaño: " + c.tamaño +  ", uso: "+c.getUso()+", numNiños: "+ c.getNumeroNiños());
        }
        System.out.println("\n");
		
		File archivoHabitaciones= new File ("./data/habitacion.txt");
		HashMap<String, Habitacion> cuartos= probar.cargarHabitacion ( archivoHabitaciones);
		System.out.println("Cuartos: \n");
		for(String i : cuartos.keySet()) 
		{
			
			Habitacion hab = cuartos.get(i);
            System.out.println("iD: " + i+ "capacidad: "+hab.getCapacidad() + "ubicacion : " + hab.getUbicacion() + "Precio: "+hab.getPrecioFijo()+ "Camas: ");
            ArrayList<Cama> camasHab= hab.getCama();
            for(Cama c:camasHab ) {
            	System.out.println(c.tamaño +  ",");
            }
            System.out.println("\n");
            
            
            
        }
		
		//Date fecha= probar.formatearFecha("02/07/2022", "dd/MM/yy");
		//System.out.println(fechaString(fecha));
	}
	
	
	public static String fechaString(Date date)
	{
		 
	        
            SimpleDateFormat dateFormatter=null;
	             
	        dateFormatter = new SimpleDateFormat("dd/MM/yy");
	       
	        return dateFormatter.format(date);
	        
	}
}
