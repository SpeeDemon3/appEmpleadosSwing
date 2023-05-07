package actividad06;

import java.io.Serializable;

/**
 * 
 * @author Antonio Ruiz Benito -> DAW
 *
 */
public class Empleado implements Serializable {

	// Atributos de la clase
	private String nombre;
	private String apellido;
	private double sueldo;
	// Con la palabra clave transient el atributo clave NO sera serializado
	private transient String clave = "patata"; // Este atributo por defecto tendra el valor -> 'patata'
	
	// Creo el constructor solo con los atributos nombre, apellido y sueldo, al crear un objeto con este constructor
	// el valor de la clave se le asignara por defecto
	public Empleado(String nombre, String apellido, double sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
	}
	
	// Creo el constructor con todos sus atributos
	public Empleado(String nombre, String apellido, double sueldo, String clave) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
		this.clave = clave;
	}
	
	// Setters y Getters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String apellido) {
		this.nombre = apellido;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public double getSueldo() {
		return sueldo;
	}
	
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	// Sobrescribo el metodo toString()
	@Override
	public String toString() {
		return "Nombre: " + nombre + " - Apellido: " + apellido + " - Sueldo: " + sueldo + " - Clave: " + clave;
	}
	
	// Sobrescribo el metodo hashCode
	@Override
	public int hashCode() { 
		int resultado = this.nombre.hashCode() + this.apellido.hashCode();
		return resultado;
	}
	
	// Sobrescribo el metodo equals
	@Override
	public boolean equals(Object emp) {
		if (this == emp) { // Comparo el objeto actual con el objeto 'emp'
			return true;
		}
		if (emp == null) {
			return false; // Compruebo si el objeto 'emp' es null
		}
		// Compruebo si las clases son diferentes obteniendo la informacion con el metodo getClass()
		if (getClass() != emp.getClass()) { 
			return false;
		}
		// Creo una variable Empleado y realizo un cast explicito del objeto 'emp'
		Empleado otro = (Empleado) emp; 
		if (apellido == null) { // Compruebo si el apellido es null
			if (otro.apellido != null) { // Compruebo si el apellido de 'otro' no es igual a null
				return false;
			} 
		// Compruebo si el valor del apellido NO es igual al valor del apellido del objeto 'otro'
		} else if (!apellido.equals(otro.apellido)) { 
			return false;
		}
		if (nombre == null) { // Compruebo si el nombre del objeto es igual a null
			if (otro.nombre != null) { // Compruebo si el nombre del objeto 'otro' No es igual a null
				return false;
			}
		// Compruebo si el nombre del objeto NO es igual al nombre del objeto 'otro'
		} else if (!nombre.equals(otro.nombre)) {
			return false;
		}
		// En caso de hacer todas estas comprobaciones y no entrar en ninguna retornara true porque el objeto sera igual
		return true; 
	}
	
	
}
