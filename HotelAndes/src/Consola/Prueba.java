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
import Logica.Tarifa;



public class Prueba {
	static CargardorArchivo probar= new CargardorArchivo(); 

	public static void main(String[] args) throws IOException {
		
		
		/*
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
 		
		System.out.println("TARIFAS");
        File archivoTarifa= new File ("./data/tarifas.txt");
        ArrayList<Object> tarifas= probar.cargarTarifas();
    	//0 estandar, 1 suite, 2 doble, 3 tarifapor fecha
        
        HashMap<Date, String> diasAño= probar.cargarDiasAño();
       
         
         Object principal= tarifas.get(0);
         Object tarifaEstandar= tarifas.get(1);
         Object tarifaSuite= tarifas.get(2);
         Object tarifaSuiteDoble= tarifas.get(3);
         //System.out.println(tarifaEstandar);
         for(Date j : ((HashMap<Date, Float>) tarifaEstandar).keySet()) 
 		{
 			String fecha=fechaString(j);
 			System.out.println(fecha + ": "+ (((HashMap<String, Cama>) tarifaEstandar).get(j))); 
 		}
         
		
		*/
		//Date hora= probar.formatearHora("12:04", "HH:mm");
		//System.out.println(horaString(hora));
	}
	
	
	public static String fechaString(Date date)
	{
		 
	        
            SimpleDateFormat dateFormatter=null;
	             
	        dateFormatter = new SimpleDateFormat("dd/MM");
	       
	        return dateFormatter.format(date);
	        
	}
	public static String horaString(Date date)
	{
		 
	        
            SimpleDateFormat dateFormatter=null;
	             
	        dateFormatter = new SimpleDateFormat("HH:mm");
	       
	        return dateFormatter.format(date);
	        
	}
}
