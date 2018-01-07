package dominio;

import java.util.ArrayList;

public class Tarea {

	private String nombre;
	private String fechaInicial;
	private String fechaFinal;
	private int prioridad;
	private String descripcion;
	private ArrayList<Subtarea> subtareas;
	
	public Tarea(String nombre, String fechaInicial, String fechaFinal, int prioridad, String descripcion,
			ArrayList<Subtarea> subtareas) {
		super();
		this.nombre = nombre;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.prioridad = prioridad;
		this.descripcion = descripcion;
		this.subtareas = subtareas;
	}

	public Tarea(String string) {
		subtareas = new ArrayList<Subtarea>();
		this.nombre = string;
	}

	////////////Getters y setters //////////////
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<Subtarea> getSubtareas() {
		return subtareas;
	}
	
	public String toString() {
		return nombre;
	}

}
