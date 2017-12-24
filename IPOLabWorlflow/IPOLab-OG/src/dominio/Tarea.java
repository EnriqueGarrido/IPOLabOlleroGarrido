package dominio;

import java.util.ArrayList;

public class Tarea {

	private String nombre;
	private String fechaInicial;
	private String fechaFinal;
	private int prioridad;
	private String descripcion;
	private ArrayList<Subtarea> subtareas;
	private ArrayList<Usuario> miembrosTarea;

	private DAOTarea daoTarea;

	public void update() {

	}

	public void delete() {

	}

	public void insert() {

	}

	public void read() {

	}

	public void readSubtareas() {
		
	}
	
	public void readMiembros() {
		
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

	public ArrayList<Usuario> getMiembrosTarea() {
		return miembrosTarea;
	}

	public DAOTarea getDaoTarea() {
		return daoTarea;
	}

}