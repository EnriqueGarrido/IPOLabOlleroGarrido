package dominio;

import java.sql.SQLException;

public class Usuario {
	private String DNI;
	private String nombre;
	private String rol;
	private String conocimientos;
	private String contacto;
	private String foto;
	private String password;
	private DAOUsuario daoUsuario;
	
	public Usuario(String dni) {
		DNI = dni;
		daoUsuario = new DAOUsuario();
	}
	
	
	public Usuario() {
		daoUsuario = new DAOUsuario();
	}

	public void readName() throws SQLException {
		daoUsuario.readName(this);
	}
	
	public void readAll() throws SQLException {
		daoUsuario.readAll();
	}
	
	public void logIn() throws SQLException {
		daoUsuario.logIn(this);
	}
	
	
	/////////////////// getters y setters /////////////////////////
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getConocimientos() {
		return conocimientos;
	}
	public void setConocimientos(String conocimientos) {
		this.conocimientos = conocimientos;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DAOUsuario getDaoUsuario() {
		return daoUsuario;
	}
	
	public String toString() {
		return nombre;
	}

	
	
}
