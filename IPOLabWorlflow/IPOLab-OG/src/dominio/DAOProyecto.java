package dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.DBBroker;

public class DAOProyecto {
	
	private ArrayList<Proyecto> proyectList;
	
	public void update(Proyecto p) {
		
	}
	
	public void delete(Proyecto p) {
		
	}
	
	public void insert(Proyecto p) {
		
	}
	
	public void read(Proyecto p) {
		
	}
	
	public void readTareas(Proyecto p) {
		
	}
	
	public void readMiembros(Proyecto p) {
		
	}
	
	public void readIcon(Proyecto p) throws SQLException {
		ResultSet rs = DBBroker.getInstancia().read("SELECT * FROM proyecto WHERE nombre = '"+p.getNombre()+"'");
		while(rs.next())	
			p.setIcono(rs.getString("icono"));
	}
	
	public void readAll() throws SQLException {
		ResultSet rs = DBBroker.getInstancia().read("SELECT * FROM proyecto");
		proyectList = new ArrayList<Proyecto>();
		while(rs.next()) {
			proyectList.add(new Proyecto(rs.getString("Nombre")));
		}
	}

	public ArrayList<Proyecto> getProyectList() {
		return proyectList;
	}
	
}
