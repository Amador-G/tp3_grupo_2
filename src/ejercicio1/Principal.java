package ejercicio1;


import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {
		
	Archivo file2 = new Archivo("Resultado.txt");	
	Archivo file = new Archivo("Personas.txt");
	TreeSet<Persona> ListaDePersonas = Persona.CargarLIsta(file.getRuta());
	for (Persona p : ListaDePersonas) {
		System.out.println(p.toString());		
	}
	for (Persona p : ListaDePersonas) {
		file2.escribe_lineas(p.toString());		
	}
	}	
}
		

