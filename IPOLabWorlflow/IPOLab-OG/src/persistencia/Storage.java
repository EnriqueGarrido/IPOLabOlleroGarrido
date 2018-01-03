package persistencia;

import java.util.ArrayList;

import dominio.*;

public class Storage {
	
	private ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();
	private ArrayList<Usuario> listaUsuarios =  new ArrayList<Usuario>();
	
	private Storage storagement;
	
	private Storage() {
		initialize();
	}
	
	// Patron Singleton
	public Storage getInstance() {
		if(this ==  null)
			storagement = new Storage();
		return storagement;
	}
	
	private void initialize() {
		Usuario u1= new Usuario("12345678p", "Adrián", "Diseñador", "UML", "email@mail.me", null, "1234");
		Usuario u2= new Usuario("98765432o", "Enrique", "Programador", "Java", "mi@contacto.es", null, "9876");
		
		//Inicializar varios proyectos
			//Inicializar varias tareas para cada proyecto
		
		//Inicializar varios usuarios
		
	
	}
	
}
