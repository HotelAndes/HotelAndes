package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;



public class CargardorArchivo {
	public HashMap<String,Cama> camas= new HashMap<String,Cama>();
	public HashMap<String, Habitacion> habitacionies= new  HashMap<String, Habitacion>();
	public ArrayList <HashMap<String, ArrayList<Habitacion>>> habitacionesPorId= new ArrayList <HashMap<String, ArrayList<Habitacion>>>();
	public HashMap<Date, ArrayList<Tarifa>> tarifas= new  HashMap<Date, ArrayList<Tarifa>>();
	public HashMap<Date, String> diasAño= new HashMap<Date, String>();
	public HashMap<Date, Float> tarifaEstandar= new HashMap<Date, Float>();
	public HashMap<Date, Float> tarifaSuite= new HashMap<Date, Float>();
	public HashMap<Date, Float> tarifaSuiteDoble= new HashMap<Date, Float>();
	
	
	
	
	/*
	 +habitaciones: ArrayList <HashMap<String(ID) , List<Habitaciones>>>
	+precioSpa: int
	+precioGuia: int
	+tarifas: ArrayList<HasMap<String(dia del año), float (tarifa)>>
	+menuRestaurante: ArrayList<HashMap>
 */
	
	
	
	public HashMap<Date, String> cargarDiasAño () throws IOException
	{
		File archivodiasAño= new File ("./data/diasAño.txt");
		FileReader archivo= new FileReader(archivodiasAño);
		BufferedReader br = new BufferedReader(archivo);
		String linea = br.readLine();
	
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			//fechaInical;fechaFinal;dia;tipo de habitacion;extra  01-01-23;07-01-23
			String[] partes = linea.split(";");
			Date fecha = formatearFecha(partes[0], "dd/MM/yy");
			String  dia=partes[1];
			
			diasAño.put(fecha, dia);
			
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		
		return diasAño;
	}
	
	
	
	public HashMap<String, Habitacion> getHabitacionies() {
		return habitacionies;
	}



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
	
	public ArrayList<Object> cargarTarifas () throws IOException
	{
		diasAño=cargarDiasAño();
		File archivoTarifas= new File ("./data/tarifas.txt");
		FileReader archivo= new FileReader(archivoTarifas);
		BufferedReader br = new BufferedReader(archivo);
		String linea = br.readLine();
		String[] titulos = linea.split(";");
		linea = br.readLine();
		
		
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			
			//HashMap<String, HashMap<Date,>>
			//fechaInicial;dia;tipo de habitacion;extra
			String[] partes = linea.split(";");
			Date fecha = formatearFecha(partes[0], "dd/MM/yy");
			String[] dias = partes[1].split(",");
			String tipoHabitación= partes[2];
			float extra= Integer.parseInt(partes[3]);
			String diasemanaTarifa= diasAño.get(fecha);
			
				if(tipoHabitación.equals("estandar"))
				{
					
					if(Arrays.asList(dias).contains(diasemanaTarifa)) {
						tarifaEstandar.put(fecha, extra);}
					else {tarifaEstandar.put(fecha, 0f);}
					
					
				}
				else if (tipoHabitación.equals("suite"))
				{
					
					if(Arrays.asList(dias).contains(diasemanaTarifa)) {
							tarifaSuite.put(fecha, extra);}
					else{tarifaSuite.put(fecha, 0f);}
					
				}
				else if (tipoHabitación.equals("suite doble"))
				{
					
					if(Arrays.asList(dias).contains(diasemanaTarifa)) {
							tarifaSuiteDoble.put(fecha, extra);}
					else{tarifaSuiteDoble.put(fecha, 0f);}
					
				}
			
			Tarifa laTarifa= new Tarifa (tipoHabitación,extra,fecha,dias);
		
			if ((tarifas.keySet()).contains(fecha))
			{
				ArrayList<Tarifa> listaTarifas = tarifas.get(fecha);
				listaTarifas.add(laTarifa);
				
			}
			else {
				ArrayList<Tarifa> listaTarifas= new ArrayList<Tarifa>();
				listaTarifas.add(laTarifa);
				tarifas.put(fecha, listaTarifas);
			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		
		ArrayList<Object> listaFinal = new ArrayList<Object>();
		//0 estandar, 1 suite, 2 doble, 3 tarifapor fecha
		listaFinal.add(tarifaEstandar);
		listaFinal.add(tarifaSuite);
		listaFinal.add(tarifaSuiteDoble);
		listaFinal.add(tarifas);
		
		
		return listaFinal;
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
	public Date formatearHora(String date_time, String formato) {
		 
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
