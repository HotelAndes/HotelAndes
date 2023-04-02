package Logica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class FuncionesEmpleado {
	Inventario inventarioInstancia =new Inventario();
	HashMap<String, ArrayList<Date>> inventario= inventarioInstancia.getInventario();
		
	

	
	public String reserva(HuespedReserva huesped1, Date Fecha_llegada,Date  Fecha_salida,int cantidadDeAcompañantes)
	{
		 ArrayList<Date> fechasEntreEntradaYSalida = new ArrayList<Date>();
	     Calendar calendar = Calendar.getInstance();
	     calendar.setTime(Fecha_llegada);
	     Boolean Sepuede=true;

	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     while (calendar.getTime().before(Fecha_salida) || calendar.getTime().equals(Fecha_salida)) {
	         Date fechaActual = calendar.getTime();
	         String x =sdf.format(fechaActual);
	         fechasEntreEntradaYSalida.add(formatearHora(x, "dd/MM/yy"));
	         calendar.add(Calendar.DATE, 1);
	     }
	     //ArrayList<Date> diasOcupados= inventario.get(IDcuarto);
	     
	     for( Date fecha: fechasEntreEntradaYSalida) 
	     {
	    	
	     }
	     if (Sepuede==false) {
	    	 return "No es posible realizar la reserva";
	     }
	     else {
	    	 
	     }
		
		
		return "a";
	}
	
	public static String fechaString(Date date)
	{
		 
	        
            SimpleDateFormat dateFormatter=null;
	             
	        dateFormatter = new SimpleDateFormat("dd/MM");
	       
	        return dateFormatter.format(date);
	        
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
        return date;}
	
	
	
	
	public void cargarConsumo() {}


}
