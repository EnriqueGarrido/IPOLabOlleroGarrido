package dominio;

public class Subtarea {
	
	private String nombre;
	private String descripcion;
	
	private DAOSubtarea daoSubtarea;
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
	
	public void insert() {
		
	}
	
	public void read() {
		
	}
	
	
	///////////// getters y setters ///////////////

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public DAOSubtarea getDaoSubtarea() {
		return daoSubtarea;
	}

	public void setDaoSubtarea(DAOSubtarea daoSubtarea) {
		this.daoSubtarea = daoSubtarea;
	}
	
	

}
