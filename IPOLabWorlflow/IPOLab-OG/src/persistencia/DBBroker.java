package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBBroker {
	
	private static DBBroker instancia;
	
	private Connection conexion;
	private Statement sentenciaRead;
	private Statement sentenciaWrite;
	
	private final String driver;
	private final String nombreBD;
	private final String usuarioBD;
	private final String passwordBD;
	
	private DBBroker() {
		this.driver = "sun.jdbc.odbc.JdbcOdbcDriver";
		this.nombreBD = "ProyectOS.accdb";
		this.usuarioBD = "";
		this.passwordBD = "";
		
		try { 
			conexion = DriverManager.getConnection("jdbc:ucanaccess://"+this.nombreBD, this.usuarioBD, this.passwordBD);
		}catch(SQLException eSql) {
			JOptionPane.showMessageDialog(null, "Error al realizar la conexion con la Base de Datos: "+eSql.getErrorCode());
		}
		
		try {
			this.sentenciaRead = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			this.sentenciaWrite = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		}catch(SQLException eSql) {
			JOptionPane.showMessageDialog(null, "Error al crear el objeto de la sentencia: "+eSql.getErrorCode());
		}
	}
	
	//						//
	//	Patron Singleton	//
	//						//
	public static DBBroker getInstancia() {
		if(instancia == null)
			instancia = new DBBroker();
		return instancia;
	}
	
	public ResultSet read(String sql) throws SQLException {
		return this.sentenciaRead.executeQuery(sql);
	}
	
	//change method
	

}
