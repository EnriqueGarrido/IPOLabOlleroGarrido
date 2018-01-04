package persistencia;

import java.util.ArrayList;

import dominio.*;

public class Storage {
	
	private ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();
	private ArrayList<Usuario> listaUsuarios =  new ArrayList<Usuario>();
	private ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();

	private static Storage storagement;
	
	private Storage() {
		initialize();
	}
	
	// Patron Singleton
	public static Storage getInstance() {
		if(storagement ==  null)
			storagement = new Storage();
		return storagement;
	}
	
	private void initialize() {
		Usuario u1= new Usuario("12345678p", "Adrián", "Diseñador", "UML", "email@mail.me", null, "1234");
		Usuario u2= new Usuario("98765432o", "Enrique", "Programador", "Java", "mi@contacto.es", null, "9876");
		Proyecto p1= new Proyecto("Armov", "12/02/2017", "02/03/2018", "/presentation/Icons/proyecto04.png","arrrrrrrrrrrrrrrr", u1, listaUsuarios, listaTareas);
		Proyecto p2= new Proyecto("That thing", "11/03/2017", "05/05/2018", "/presentation/Icons/proyecto06.png","oorrrrrrrrrrrrrrr", u2, listaUsuarios, listaTareas);
		Proyecto p3= new Proyecto("Wow", "06/07/2017", "24/06/2018", "/presentation/Icons/proyecto10.png","urrrrrrrrrrrrrrr", u2, listaUsuarios, listaTareas);
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
		listaProyectos.add(p1);
		listaProyectos.add(p2);
		listaProyectos.add(p3);
		//Inicializar varios proyectos
			//Inicializar varias tareas para cada proyecto
		
		//Inicializar varios usuarios
		
	
	}

	public ArrayList<Proyecto> getListaProyectos() {
		return listaProyectos;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
	public ArrayList<Tarea> getListaTareas() {
		return listaTareas;
	}

	
}
