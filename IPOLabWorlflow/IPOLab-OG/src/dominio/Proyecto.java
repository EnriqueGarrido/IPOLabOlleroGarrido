package dominio;

import java.sql.SQLException;
import java.util.ArrayList;

public class Proyecto {
	
	private String nombre;
	private String fechaInicio;
	private String fechaFinal;
	private String icono;
	private String descripcion;
	private Usuario responsable;
	
	private ArrayList<Usuario> miembros;
	private ArrayList<Tarea> tareas;
	

	public Proyecto(String nombre) {
		this.nombre = nombre;
	}

	public Proyecto() {
		
	}
	
	public Proyecto(String nombre, String fechaInicio, String fechaFinal, String icono, String descripcion,
			Usuario responsable, ArrayList<Usuario> miembros, ArrayList<Tarea> tareas) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.icono = icono;
		this.descripcion = descripcion;
		this.responsable = responsable;
		this.miembros = miembros;
		this.tareas = tareas;
	}

	public void update() {
		
	}
	
	public void delete() {
		
	}
	
	public void insert() {
		
	}
	
	public void readTareas() {
		
	}
	
	public void readMiembros() {
		
	}
	
	//////////// Getters y setters //////////////
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public Usuario getResponsable() {
		return responsable;
	}

	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}

	public ArrayList<Usuario> getMiembros() {
		return miembros;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return nombre;
	}
	
	
}
