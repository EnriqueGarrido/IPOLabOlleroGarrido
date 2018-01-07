package persistencia;

import java.util.ArrayList;

import dominio.*;

public class Storage {
	
	private ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();
	private ArrayList<Usuario> listaUsuarios =  new ArrayList<Usuario>();
	

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
		
			/// Usuarios
		Usuario u1= new Usuario("12345678P", "Adrián Ollero", "Diseñador", "UML", "email@mail.me", null, "1234");
		Usuario u2= new Usuario("98765432Q", "Enrique Garrido", "Programador", "Java", "mi@contacto.es", null, "9876");
		Usuario u3=new Usuario("11223344B", "Alvaro Noli", "Analista", "C++", "alvarito@noli.es", null, "1122");
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
		listaUsuarios.add(u3);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//										PROYECTOS															//
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		{	// Proyecto 1
			ArrayList<Tarea> listaTareas1 = new ArrayList<Tarea>();
			{	//Tarea 1.1
				ArrayList <Subtarea> subtareas1 = new ArrayList<Subtarea>();
				{	//Subtareas
					Subtarea subtarea11= new Subtarea("Primer Hito", "Descripción general");
					Subtarea subtarea12= new Subtarea("Segundo Hito", "Realización");
					Subtarea subtarea13= new Subtarea("Tercer Hito", "Finalización");
					subtareas1.add(subtarea11);
					subtareas1.add(subtarea12);
					subtareas1.add(subtarea13);
				}
				Tarea t1= new Tarea("Hacer deberes", "23/07/2017", "17/08/2018", 2, "Tarea a realizar", subtareas1);
				listaTareas1.add(t1);
			}
			{	//Tarea 1.2
				ArrayList <Subtarea> subtareas2 = new ArrayList<Subtarea>();
				{	//Subtareas
					Subtarea subtarea21= new Subtarea("Comienzo", "Hacer videos Julie");
					Subtarea subtarea22= new Subtarea("Progreso", "Editarlo");
					Subtarea subtarea23= new Subtarea("Fin", "Finalizado");
					subtareas2.add(subtarea21);
					subtareas2.add(subtarea22);
					subtareas2.add(subtarea23);
				}
				Tarea t2= new Tarea("Trabajar", "26/07/2017", "17/09/2018", 3, "Tareas", subtareas2);
				listaTareas1.add(t2);
			}
			ArrayList<Usuario> miembrosp1 = new ArrayList<Usuario>();
			miembrosp1.add(u3);
			Proyecto p1= new Proyecto("Armov", "12/02/2017", "02/03/2018", 0,"Proyecto que se encarga de cosas de realidaz aumentada", u1, miembrosp1, listaTareas1, 0);
			listaProyectos.add(p1);
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		{	// Proyecto 2
			ArrayList<Tarea> listaTareas2 = new ArrayList<Tarea>();
			{	// Tarea 2.1
				ArrayList <Subtarea> subtareas2 = new ArrayList<Subtarea>();
				{ // Subtareas
					Subtarea subtarea11= new Subtarea("Diseño", "Se establece como será la app desde un punta de vista genera");
					Subtarea subtarea12= new Subtarea("Implementación", "Picar codigo");
					Subtarea subtarea13= new Subtarea("Documentar", "describir todo lo que se ha hecho hasta ahora");
					subtareas2.add(subtarea11);
					subtareas2.add(subtarea12);
					subtareas2.add(subtarea13);
				}
				Tarea t1= new Tarea("App del servidor", "25/04/2017", "02/01/2018", 2, "Crear el servidor del proyecto", subtareas2);
				listaTareas2.add(t1);
			}
			{	//Tarea 2.2
				ArrayList <Subtarea> subtareas2 = new ArrayList<Subtarea>();
				{	//Subtareas
					Subtarea subtarea21= new Subtarea("Diseño movil Android", "Diseñar la interfaz del movil");
					Subtarea subtarea22= new Subtarea("Implementación movil Android", "Picar codigo de la app movil");
					Subtarea subtarea23= new Subtarea("Documentación movil Android", "Documentar la app movil");
					Subtarea subtarea24= new Subtarea("Lanzamiento", "Subir la app a google play");
					subtareas2.add(subtarea21);
					subtareas2.add(subtarea22);
					subtareas2.add(subtarea23);
					subtareas2.add(subtarea24);
				}
				Tarea t2= new Tarea("App movil Android", "08/01/2018", "26/03/2018", 3, "Crear la app cliente para movil android", subtareas2);
				listaTareas2.add(t2);
			}
			{	//Tarea 2.3
				ArrayList <Subtarea> subtareas3 = new ArrayList<Subtarea>();
				{	//Subtareas
					Subtarea subtarea31= new Subtarea("Diseño movil iOS", "Diseñar la app con arquitectura iOS");
					Subtarea subtarea32= new Subtarea("Implementación movil iOS", "Picar codigo de la app para arquitectura iOS");
					Subtarea subtarea33= new Subtarea("Documentación movil iOS", "Documentar la app para arquitectura iOS");
					Subtarea subtarea34= new Subtarea("Lanzamiento iOS", "Subir la app a AppStore de Apple");
					subtareas3.add(subtarea31);
					subtareas3.add(subtarea32);
					subtareas3.add(subtarea33);
					subtareas3.add(subtarea34);
				}
				Tarea t2= new Tarea("App movil iOS", "08/01/2018", "26/03/2018", 1, "Crear la app cliente para movil iOS", subtareas3);
				listaTareas2.add(t2);
			}
			ArrayList<Usuario> miembrosp2 = new ArrayList<Usuario>();
			miembrosp2.add(u3);
			miembrosp2.add(u1);
			Proyecto p2= new Proyecto("That thing", "11/03/2017", "05/05/2018", 5,"Proyecto donde se ven muchas cosas nuevas sobre el ingles", u2, miembrosp2, listaTareas2, 2);
			listaProyectos.add(p2);
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		{	// Proyecto 3
			ArrayList<Tarea> listaTareas3 = new ArrayList<Tarea>();
			{	// Tarea 3.1
				ArrayList <Subtarea> subtareas2 = new ArrayList<Subtarea>();
				{ // Subtareas
					Subtarea subtarea11= new Subtarea("Conceptos básicos", "Teoria basica de programacion");
					Subtarea subtarea12= new Subtarea("Nivel avanzado", "Introduccion a las estructuras de datos");
					subtareas2.add(subtarea11);
					subtareas2.add(subtarea12);
				}
				Tarea t1= new Tarea("Teoria de programacion", "21/10/2017", "12/12/2018", 3, "Teorias y conceptos basicos de programacion y estructuras de datos", subtareas2);
				listaTareas3.add(t1);
			}
			{	//Tarea 3.2
				ArrayList <Subtarea> subtareas2 = new ArrayList<Subtarea>();
				{	//Subtareas
					Subtarea subtarea21= new Subtarea("Interfaces graficas", "Conceptos sobre interfaces graficas");
					subtareas2.add(subtarea21);
				}
				Tarea t2= new Tarea("Teoria de IPO", "08/01/2018", "26/03/2018", 0, "Crear la app cliente para movil android", subtareas2);
				listaTareas3.add(t2);
			}
			ArrayList<Usuario> miembrosp3 = new ArrayList<Usuario>();
			miembrosp3.add(u1);
			miembrosp3.add(u2);
			Proyecto p3= new Proyecto("Wow", "06/07/2017", "24/06/2018", 9,"Un proyecto grande que sirve de ejemplo para otras muchas teorias", u3, miembrosp3, listaTareas3, 1);
			listaProyectos.add(p3);
		}
	
	}

	public ArrayList<Proyecto> getListaProyectos() {
		return listaProyectos;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
}
