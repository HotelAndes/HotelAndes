package Consola;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
			/*
			public String id;
			public int capacidad;
			public List<Cama> cama;
			public String ubicacion;
			public String tipo;
			public float precioFijo;
			public boolean vista;
			public boolean balcon;
			public boolean cocina;
			*/
			Habitacion hab = cuartos.get(i);
            System.out.println("iD: " + i+ "capacidad: "+hab.getCapacidad() + "ubicacion : " + hab.getUbicacion() + "Precio: "+hab.getPrecioFijo()+ "Camas: ");
            ArrayList<Cama> camasHab= hab.getCama();
            for(Cama c:camasHab ) {
            	System.out.println(c.tamaño +  ",");
            }
            System.out.println("\n");
        }
		
	}
			 
			 
	

}
