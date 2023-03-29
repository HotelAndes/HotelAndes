package LogicaReserva;

public class HuespedReserva {
	

	public String nombre;
	public String documento;
	public String correo;
	public String celular;
	private String getNombre() {
		return nombre;
	}

	private String getDocumento() {
		return documento;
	}

	private String getCorreo() {
		return correo;
	}

	private String getCelular() {
		return celular;
	}

	private int getCantidadAcmopañantes() {
		return cantidadAcmopañantes;
	}

	private int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	private float getMontoTotal() {
		return montoTotal;
	}

	private boolean isEstado() {
		return estado;
	}

	public int cantidadAcmopañantes;
	public int numeroHabitaciones;
	public float montoTotal;
	public boolean estado;

	public HuespedReserva() {
		// TODO Auto-generated constructor stub
	}

}
