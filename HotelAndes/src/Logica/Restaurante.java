package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Restaurante  extends Catalogo{
	    private ArrayList<Bebida> bebidas;
	    private ArrayList<Plato> platos;
	    
	    // Constructor
	    public Restaurante(String nombre) {
	        this.bebidas = new ArrayList<Bebida>();
	        this.platos = new ArrayList<Plato>();
	    
	    
	    
	    
	    

	// Clase Plato
	public class Plato {
	    // Declaración de variables
	    private String nombre;
	    private double precio;
	    private boolean llevable;
	    
	    // Constructor
	    public Plato(String nombre, double precio, boolean llevable) {
	        this.nombre = nombre;
	        this.precio = precio;
	        this.llevable = llevable;
	    }
	    
	    // Métodos getters y setters
	    public String getNombre() {
	        return nombre;
	    }
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    public double getPrecio() {
	        return precio;
	    }
	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }
	    public boolean isLlevable() {
	        return llevable;
	    }
	    public void setLlevable(boolean llevable) {
	        this.llevable = llevable;
	    }
	
		
	
	
	
	
	
	
	
	}}}}

	

