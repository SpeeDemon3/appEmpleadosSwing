package actividad06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
/**
 * 
 * @author Antonio Ruiz Benito -> DAW
 * 
 * Clase principal del programa
 *
 */
public class VentanaPrincipal {

	public static void main (String[] args) throws ErrorLeerArchivo {
		
		// Creo varios objetos de la clase Empleado	
		Empleado emp1 = new Empleado("Antonio", "r", 5000);
		Empleado emp2 = new Empleado("arya", "r", 2000.50);
		Empleado emp3 = new Empleado("Patricia", "Luengo", 4000.5);
		Empleado emp4 = new Empleado("Chula", "Ruiz", 1000);
		
		// Creo un HashMap empleados al que le paso como clave el obejto empleado y como valor el objeto Integer
		HashMap <String, Empleado> empleados = new HashMap<String, Empleado>();
		
		// Añado los objetos en el HashMap empleados
		// Como clase asigno el nombre de cada objeto, utilizando el metodo getNombre() de la clase Empleado
		// Como valor paso el objeto de tipo Empleado
		empleados.put("Antonio", emp1);
		empleados.put("arya", emp2);
		empleados.put("Patricia", emp3);
		empleados.put("Chula", emp4);
		
		// Compruebo cuantos elementos contiene el HashMap empleados
		System.out.println(empleados.size());
	
		// Recorro el HashMap empleados 
		Iterator<String> it = empleados.keySet().iterator(); // Creo un objeto Iterator que recorrera elementos de tipo <String>
										// Con el metodo keySet() obtengo los elementos del HashMap
										// Con el metodo iterator() recorro los elementos de las claves
		
		while(it.hasNext()) { // Con un bucle while recorro el HashMap empleados
			String clave = (String) it.next(); // Con el metodo next() obtengo cada elemento
			// Imprimo por consola la clave y valor, obteniendo el valor de la clave con el metodo get()
			System.out.println("Clave: " + clave + " - Valor: " + empleados.get(clave));
		}
		
		// Creo un objeto File al que le paso el nombre del archivo
		File archivo = new File("archivoHash");
		
		// Escribo en el archivo
		// Creo un objeto ObjectOutputStream para guardar el objeto en el archivo
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivo));
			// Paso por parametro al metodo writeObject el HashMap empleados para guardar los datos
			oos.writeObject(empleados);								
			// Cierro la conexion con el archivo
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (IOException e) {
			throw new ErrorLeerArchivo("La operación no se pudo realizar.");
		}
		
		// Inicializo una VentanaBienvenida
		VentanaBienvenida vent = new VentanaBienvenida();
		vent.setVisible(true); // Hago visible la ventana
		
		VentanaBienvenida.leerArchivo(); // Leo el archivo
		
		
	}
	

		
}
	
	

