package ejercicio1;

import java.util.Objects;

public class Dni 
{
	 private int numero;
	
	public Dni() {}
	public Dni(int DniNumero) {
		this.numero = DniNumero;
	}
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
		
	
	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dni other = (Dni) obj;
		return numero == other.numero;
	}
	
	public static boolean VerificarDniInvalido(String dni) throws DniInvalido
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
	

