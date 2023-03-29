package Logica;

import java.util.Date;

public class Tarifa {
	
	private String tipoHabitacion;
	private float precio; 
	private Date fechaInicial; 
	private Date fechaFinal;
	
	
	public Tarifa(String tipoHabitacion, float precio, Date fechaInicial, Date fechaFinal) {
		this.tipoHabitacion = tipoHabitacion;
		this.precio = precio;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}


	public String getTipoHabitacion() {
		return tipoHabitacion;
	}


	public float getPrecio() {
		return precio;
	}


	public Date getFechaInicial() {
		return fechaInicial;
	}


	public Date getFechaFinal() {
		return fechaFinal;
	}
	
	
	
	
	
}


	

	
	
	
	
	
	
	
	