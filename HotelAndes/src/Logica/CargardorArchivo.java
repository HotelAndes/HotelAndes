package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;



public class CargardorArchivo {
	public HashMap<String,Cama> camas= new HashMap<String,Cama>();
	public HashMap<String, Habitacion> habitacionies= new  HashMap<String, Habitacion>();
	public ArrayList <HashMap<String, ArrayList<Habitacion>>> habitacionesPorId= new ArrayList <HashMap<String, ArrayList<Habitacion>>>();
	public HashMap<Habitacion, Tarifa> tarifas= new  HashMap<Habitacion, Tarifa>();
	public ArrayList<HasMap<String(dia del año), float (tarifa)>>
	
	
	/*
	 +habitaciones: ArrayList <HashMap<String(ID) , List<Habitaciones>>>
	+precioSpa: int
	+precioGuia: int
	+tarifas: ArrayList<HasMap<String(dia del año), float (tarifa)>>
	+menuRestaurante: ArrayList<HashMap>
 */
	
	
	public HashMap<String,Cama> cargarCamas (File archivoCamas) throws IOException
	{
		
		FileReader archivo= new FileReader(archivoCamas);
		BufferedReader br = new BufferedReader(archivo);
		String linea = br.readLine();
		String[] titulos = linea.split(";");
		linea = br.readLine();
		
		
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			
			String[] partes = linea.split(";");
			String tamaño = partes[0];
			String uso=partes[1];
			int numeroNiños=Integer.parseInt(partes[2]);
			int numeroAdultos=Integer.parseInt(partes[3]);
			Cama laCama= camas.get(tamaño);
			if (laCama == null)
			{
				laCama= new Cama (tamaño,uso, numeroNiños,numeroAdultos);
				camas.put(tamaño,laCama);
			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		return camas;
	}
	public HashMap<String, Habitacion> cargarHabitacion (File archivoHabitaciones) throws IOException
	{
		
		FileReader archivo= new FileReader(archivoHabitaciones);
		BufferedReader br = new BufferedReader(archivo);
		String linea = br.readLine();
		String[] titulos = linea.split(";");
		linea = br.readLine();
		
		
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			//id;ubicacion;capacidad;camas;precioFijo;vista;balcon;cocina;tipo
			
			
			String[] partes = linea.split(";");
			
			String id = partes[0];
			String ubicacion=partes[1];
			int capacidad=Integer.parseInt(partes[2]);
			String[] lasCamas = partes[3].split(",");
			ArrayList<Cama> camasCuarto= new ArrayList<Cama>();
			for(String i: lasCamas)
			{
				Cama laCama= camas.get(i);
				if(laCama !=null) {
				camasCuarto.add(laCama);
				}
			}
					
			float precioFijo = Float.parseFloat(partes[4]);
			boolean vista = toBool(partes[5]);
			boolean balcon= toBool(partes[6]);
			boolean cocina= toBool(partes[7]);
			String tipo=partes[8];

			Habitacion laHabitacion= habitacionies.get(id);
			if (laHabitacion == null)
			{
				laHabitacion= new Habitacion( id,  capacidad, camasCuarto,  ubicacion,  tipo,  precioFijo, vista,  balcon,  cocina);
				habitacionies.put(id, laHabitacion);
				//ArrayList <HashMap<String, ArrayList<Habitacion>>> Mirar si organizar eso por esta estructura
				

			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		return habitacionies;
			
		}
	
	public HashMap<String,Cama> cargarTarifas (File archivoTarifas) throws IOException
	{
		
		FileReader archivo= new FileReader(archivoTarifas);
		BufferedReader br = new BufferedReader(archivo);
		String linea = br.readLine();
		String[] titulos = linea.split(";");
		linea = br.readLine();
		
		
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			//fechaInical;fechaFinal;dia;tipo de habitacion;extra  01-01-23;07-01-23
			String[] partes = linea.split(";");
			Date fechaInicial = formatearFecha(partes[0], "dd-MM-yy");
			Date fechaFinal=formatearFecha(partes[1], "dd-MM-yy");
			String dia=partes[2];
			Habitacion tipoHabitación= habitacionies.get(partes[3]);
			float extra= Integer.parseInt(partes[4]);
			Tarifa laTarifa= tarifas.get();
			if (laCama == null)
			{
				laCama= new Cama (tamaño,uso, numeroNiños,numeroAdultos);
				camas.put(tamaño,laCama);
			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		return camas;
	}
	
	
	
	
	
	public boolean toBool ( String variable )
	{
		boolean bool=false;
		if (variable.equals("true"))
				{
			bool= true;
				}
		else if(variable.equals("false"))
				{
			bool= false;
				}
		return bool;
	}
	
	public Date formatearFecha(String date_time, String formato) {
		 
	        SimpleDateFormat dateParser = new SimpleDateFormat(formato);
	        Date date= null ;
           
	        {
	            try {
	                 date = dateParser.parse(date_time);
	                
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	        }
	        return date;
	}
	

}
