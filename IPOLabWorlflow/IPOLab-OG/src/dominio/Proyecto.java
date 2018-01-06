package dominio;

import java.sql.SQLException;
import java.util.ArrayList;

public class Proyecto {
	
	private String nombre;
	private String fechaInicio;
	private String fechaFinal;
	private int icono;
	private String descripcion;
	private Usuario responsable;
	private int estado; //0-pendiente 1-en realizacion 2-realizado
	private ArrayList<Usuario> miembros;
	private ArrayList<Tarea> tareas;
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	
	

	public Proyecto(String nombre) {
		this.nombre = nombre;
	}

	public Proyecto() {
		miembros = new ArrayList<Usuario>();
	}
	
	public Proyecto(String nombre, String fechaInicio, String fechaFinal, int icono, String descripcion,
			Usuario responsable, ArrayList<Usuario> miembros, ArrayList<Tarea> tareas, int estado) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.icono = icono;
		this.descripcion = descripcion;
		this.responsable = responsable;
		this.miembros = miembros;
		this.tareas = tareas;
		this.estado = estado;
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

	public int getIcono() {
		return icono;
	}
	
	public String getIconoPath() {
		String pathIcon = "/presentation/Icons/proyecto";
		if (icono+1 <= 9)
			pathIcon += "0" + (icono+1);
		else
			pathIcon += icono+1;
		pathIcon += ".png";
		return pathIcon;
	}

	public void setIcono(int icono) {
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

	public void setMiembros(ArrayList<Usuario> miembros) {
		this.miembros = miembros;
	}
	
	
}
