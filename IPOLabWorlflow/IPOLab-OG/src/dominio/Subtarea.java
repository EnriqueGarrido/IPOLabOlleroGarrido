package dominio;

public class Subtarea {
	
	private String nombre;
	private String descripcion;
	
	
	public Subtarea(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String toString() {
		return nombre;
	}
	

}
