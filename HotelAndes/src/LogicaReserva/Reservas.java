package LogicaReserva;

public class Reservas {

	public String fechaLlegada;
	private String getFechaLlegada() {
		return fechaLlegada;
	}

	private void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	private String getFechaSalida() {
		return fechaSalida;
	}

	private void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	private float getPrecio() {
		return precio;
	}

	public String fechaSalida;
	public float precio;
		
	public Reservas() {
		// TODO Auto-generated constructor stub
	}

}
