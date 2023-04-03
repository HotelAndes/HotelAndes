package Logica;

public class Bebida {
	    
	    private float precio;
	    private String tiempo;
	    private boolean llevable;
		private String producto;
	    
	    // Constructor
	    public Bebida(String producto, float precio, String tiempo, boolean llevable) {
	        this.producto = producto;
	        this.precio = (float) precio;
	        this.tiempo = tiempo;
	        this.llevable = llevable;
	    
}

		public float getPrecio() {
			return precio;
		}

		public String getTiempo() {
			return tiempo;
		}

		public boolean isLlevable() {
			return llevable;
		}

		public String getProducto() {
			return producto;
		}}

