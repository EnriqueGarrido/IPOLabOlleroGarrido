package dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.*;

public class DAOUsuario {
	private ArrayList<Usuario> userList;
	
	public void update(Usuario u) {
		
	}
	
	public void delete(Usuario u) {
		
	}
	
	public void insert(Usuario u) {
		
	}
	
	public void read(Usuario u) {
		
	}
	
	public void logIn(Usuario u) throws SQLException {
		ResultSet rs = DBBroker.getInstancia().read("SELECT * FROM usuario WHERE dni='" + u.getDNI()+"'");
		///////	
		//System.out.println(rs.getCursorName());
		while(rs.next()) {
			u.setPassword(rs.getString("password")); 
		}
	}
	
	public void readAll() throws SQLException {
		ResultSet rs = DBBroker.getInstancia().read("SELECT * FROM usuario");
		userList = new ArrayList<Usuario>();
		while(rs.next()) {
			userList.add(new Usuario(rs.getString("DNI")));
		}
	}

	public ArrayList<Usuario> getUserList() {
		return userList;
	}
}
