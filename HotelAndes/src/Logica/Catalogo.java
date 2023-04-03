package Logica;

import java.util.Date;

public class Catalogo {
	
	private String producto;
	private float precio;
	private String ubicacion;
	private Date dias;
	private String HorDisponibilidad;
	
	
	public Catalogo(String producto, float precio, String ubicacion, Date dias, String horDisponibilidad) {
		this.producto = producto;
		this.precio = precio;
		this.ubicacion = ubicacion;
		this.dias = dias;
		HorDisponibilidad = horDisponibilidad;
	}


	public String getProducto() {
		return producto;
	}


	public float getPrecio() {
		return precio;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public Date getDias() {
		return dias;
	}


	public String getHorDisponibilidad() {
		return HorDisponibilidad;
	}


	
	
	

	 
	}
