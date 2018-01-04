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
		Proyecto p1= new Proyecto("Armov", "12/02/2017", "02/03/2018", "/presentation/Icons/proyecto04.png","arrrrrrrrrrrrrrrr", u1, listaUsuarios, listaTareas, 0);
		Proyecto p2= new Proyecto("That thing", "11/03/2017", "05/05/2018", "/presentation/Icons/proyecto06.png","oorrrrrrrrrrrrrrr", u2, listaUsuarios, listaTareas, 2);
		Proyecto p3= new Proyecto("Wow", "06/07/2017", "24/06/2018", "/presentation/Icons/proyecto10.png","urrrrrrrrrrrrrrr", u2, listaUsuarios, listaTareas, 1);
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
		listaProyectos.add(p1);
		listaProyectos.add(p2);
		listaProyectos.add(p3);
		ArrayList <Subtarea> subtareas1 = new ArrayList<Subtarea>();
		Subtarea subtarea11= new Subtarea("Primer Hito", "Descripción general");
		Subtarea subtarea12= new Subtarea("Segundo Hito", "Realización");
		Subtarea subtarea13= new Subtarea("Tercer Hito", "Finalización");
		subtareas1.add(subtarea11);
		subtareas1.add(subtarea12);
		subtareas1.add(subtarea13);
		Tarea t1= new Tarea("Hacer trabajo", "23/07/2017", "17/08/2018", 2, "Tarea a realizar", subtareas1);
		ArrayList <Subtarea> subtareas2 = new ArrayList<Subtarea>();
		Subtarea subtarea21= new Subtarea("Cted", "Hacer videos Julie");
		Subtarea subtarea22= new Subtarea("Hollolens", "Realizado");
		subtareas2.add(subtarea21);
		subtareas2.add(subtarea22);
		Tarea t2= new Tarea("Trabajar", "26/07/2017", "17/09/2018", 3, "Tareas", subtareas1);
		listaTareas.add(t1);
		listaTareas.add(t2);
		
		
		
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
