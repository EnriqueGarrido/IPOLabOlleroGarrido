package dominio;

@SuppressWarnings("serial")
public class AuthenticationException extends Exception {
	
	public String getMessage() {
		return "Error the autenticacion. Usuario y contrase�a no encontrados en la base de datos";
		
	}
}
