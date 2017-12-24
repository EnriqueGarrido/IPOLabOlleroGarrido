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
		while(rs.next()) //System.out.println(rs.getString(7));
			u.setPassword(rs.getString(7)); 
	}
	
	public void readAll() {
		
	}
}
