package Consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Logica.Cama;

public class Hotel {
	public String nombre="Hotel Andes";
	public String tiposDeHabitación=  "Estandar, Suite, Suite Doble";
	public String servicios="Alojamiento, spa, guia turistico, Restaurante, servicio a la habitación y muchas diversiones más :)";
	public String restaurante;
	HashMap<String, String> usuariosYPass = new HashMap<String, String>();
	HashMap<String, String> tipoDePersona = new HashMap<String, String>();
	ArrayList<String> usuarios= new ArrayList<String>(usuariosYPass.keySet());
	AplicacionCliente clientes =new  AplicacionCliente();
	MenuAdmin admins= new MenuAdmin();
	
	public void cargarUsuarios() throws IOException
	{
		File archivoUsers= new File ("./data/usuarios.txt");
		FileReader archivo= new FileReader(archivoUsers);
		BufferedReader br = new BufferedReader(archivo);
		String linea = br.readLine();
		
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			//fechaInical;fechaFinal;dia;tipo de habitacion;extra  01-01-23;07-01-23
			System.out.println(linea);
			String[] partes = linea.split(";");
			
			String elUser = partes[0];
			String  elPassw=partes[1];
			String  persona=partes[2];
			String User= usuariosYPass.get(elUser);
			if (User == null)
			{
				usuariosYPass.put(elUser,elPassw);
				tipoDePersona.put(User, persona);
			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		}
	
	public String iniciarSesion(String user, String password) throws IOException {
		System.out.println(usuariosYPass);
		String retorno="";
		Boolean cond1=usuarios.contains(user);
		String contraseña=usuariosYPass.get(user);
		Boolean cond2= contraseña.equals(password);
		String persona=tipoDePersona.get(user);
		if(cond1 & cond2) {
			retorno="Inició sesión con exito";
			if(persona=="empleado") {retorno="dhdd";}//TODO
			if(persona=="admin") {clientes.ejecutarAplicacion();}
			if(persona=="usuario") {admins.ejecutarAplicacion();}
			
		}
		else {retorno="Usuario o contraseña incorrecta";}
		
	
		return retorno;
	}
	
	public String crearUsuario(String user, String password) {
		String retorno="";
		Boolean cond= usuarios.contains(user);
		
		if(cond) {retorno="El usuario ya existe";}
		else {
		File archivo= new File ("./data/usuarios.txt");
		PrintWriter pw = null;
		try {
			pw= new PrintWriter(archivo);
			//escribir
			pw.println(user +";");
			pw.println(password+";");
			pw.println("usuario");
		}catch(FileNotFoundException ex ) {
			ex.printStackTrace();
			
		}finally {
			if(pw !=null) {
				pw.close();
			}
		
		
	}
		}
		return retorno;
	}
	
	
	

}
