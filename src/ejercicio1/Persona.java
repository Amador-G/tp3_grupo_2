package ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.TreeSet;

public class Persona implements Comparable<Persona>{
	private String Nombre;
	private String Apellido;
	private String Dni;
	
	public Persona() {}
	public Persona(String Nombre, String Apellido,String Dni) 
	{
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.Dni = Dni;
	}
	
	
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(Apellido, Dni, Nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(Apellido, other.Apellido) && Objects.equals(Dni, other.Dni)
				&& Objects.equals(Nombre, other.Nombre);
	}
	@Override
	public String toString() {
		return "---Persona----  \nNombre : " + Nombre + "\nApellido : " + Apellido + "\nDni : " + Dni;
	}
	@Override
	public int compareTo(Persona o) {
		int salida;
		
		if(o.getApellido().compareToIgnoreCase(this.Apellido) > 0)
		{
		salida = -1;
		}
		else 
		{
			if(o.getApellido().compareToIgnoreCase(this.Apellido) < 0)
			{
				salida = 1;
			}
			else
			{
				salida = 0;
				}
		}
		return salida;					
	}
	
	public static TreeSet<Persona> CargarLIsta(String ruta) {
		FileReader entrada;
		TreeSet<Persona> Lista = new TreeSet<Persona>();
		try {
			entrada = new FileReader(ruta);
			BufferedReader br = new BufferedReader(entrada);
			String linea =br.readLine();;
			
			while(linea != null)
			{												
				String [] cortarString = linea.split("-");
				Persona p = new Persona();
				
				if(cortarString.length == 3 ) {			
						p.setNombre(cortarString[0]);
						p.setApellido(cortarString[1]);
						p.setDni(cortarString[2]);
						Lista.add(p);							
				}
				linea =br.readLine();
			}		
							
			br.close();
			entrada.close();
			
		}catch(IOException e)
		{
			System.out.println("edu me enseño mal");
		}
		return Lista;		
	}
	
	public boolean VerificarDniInvalido(String dni) throws DniInvalido
	{	
		
		boolean SoloNumeros = true;        
		for (int i = 0; i < dni.length(); i++) 
		{
            if (!Character.isDigit(dni.charAt(i)))
            {
                SoloNumeros = false;
            }
        }
		
		if(SoloNumeros == false) 
		{
			throw new  DniInvalido();
			
		}
	
		if(SoloNumeros)
		{
			return true;
		}
		return false;
	}	
		
		
}
