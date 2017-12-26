package dominio;

@SuppressWarnings("serial")
public class AuthenticationException extends Exception {
	
	public String getMessage() {
		return "Error the autenticacion. Usuario y contraseña no encontrados en la base de datos";
		
	}
}
