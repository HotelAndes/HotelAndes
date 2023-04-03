package Logica;

public class Plato {
    // Declaración de variables
    private String nombre;
    private double precio;
    private boolean llevable;
    private String tiempo;
    
    
    // Constructor
    public Plato(String nombre, double precio,String tiempo, boolean llevable) {
        this.nombre = nombre;
        this.precio = precio;
        this.llevable = llevable;
        this.tiempo = tiempo;
        
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
    }}



