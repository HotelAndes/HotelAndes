package Logica;

import java.util.Date;

public class Tarifa {
	
	private String tipoHabitacion;
	private float precio; 
	private Date fecha; 

	private String[] diaSemana;
	
	public Tarifa(String tipoHabitacion, float precio, Date fecha, String[] diaSemana) {
		this.tipoHabitacion = tipoHabitacion;
		this.precio = precio;
		this.fecha = fecha;
		
	}


	public String getTipoHabitacion() {
		return tipoHabitacion;
	}
	public String[] getDiaSemana() {
		return diaSemana;
	}


	public float getPrecio() {
		return precio;
	}


	public Date getFecha() {
		return fecha;
	}

	
	
	
	
	
}


	

	
	
	
	
	
	
	
	