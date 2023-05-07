package actividad06;
/**
 * 
 * @author Antonio Ruiz Benito -> DAW
 *
 */
public class ErrorLeerArchivo extends Exception {
	/**
	 * Error personalizado
	 * 
	 * @param mensaje -> mensaje que recibe la funcion para indicar el error
	 */
	public ErrorLeerArchivo(String mensaje) {
		super(mensaje);
	}
	
}
