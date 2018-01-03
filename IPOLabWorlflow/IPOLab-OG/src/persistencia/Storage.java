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
		//Inicializar varios proyectos
			//Inicializar varias tareas para cada proyecto
		
		//Inicializar varios usuarios
		
	
	}
	
}
