package dominio;

import java.sql.SQLException;
import java.util.ArrayList;

public class Proyecto {
	
	private int id;
	private String nombre;
	private String fechaInicio;
	private String fechaFinal;
	private String icono;
	private String descripcion;
	private Usuario responsable;
	private ArrayList<Usuario> miembros;
	private ArrayList<Tarea> tareas;
	
	private DAOProyecto daoProyecto;

	public Proyecto(String nombre) {
		this.nombre = nombre;
		daoProyecto =  new DAOProyecto();
	}

	public Proyecto() {
		daoProyecto = new DAOProyecto();
	}


	public void update() {
		
	}
	
	public void delete() {
		
	}
	
	public void insert() {
		
	}
	
	public void read() throws SQLException {
		daoProyecto.read(this);
	}
	

	public void readAll() throws SQLException {
		daoProyecto.readAll();
	}
	
	public void readTareas() {
		
	}
	
	public void readMiembros() {
		
	}
	
	public void readIcon() throws SQLException {
		daoProyecto.readIcon(this);
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

	public DAOProyecto getDaoProyecto() {
		return daoProyecto;
	}

	public void setDaoProyecto(DAOProyecto daoProyecto) {
		this.daoProyecto = daoProyecto;
	}

	public int getId() {
		return id;
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
