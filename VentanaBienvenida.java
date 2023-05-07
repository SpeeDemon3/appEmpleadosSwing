package actividad06;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 
 * @author Antonio Ruiz Benito -> DAW
 *
 */
public class VentanaBienvenida extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JPasswordField passwordField;

	// Atributo con el nombre del archivo
    private static String nombreArchivoEmpleados = "archivoHash";
    // Atributo HashMap de la clase
    private static HashMap<String, Empleado> datosEmpleados = new HashMap<>();


	/**
	 * Create the frame.
	 */
    // Constructor
	public VentanaBienvenida() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cuando se pulse 'x' se cerrara la ventana y el programa
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(203, 89, 114, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(70, 91, 70, 15);
		contentPane.add(lblNombre);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(70, 118, 70, 15);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(203, 116, 114, 19);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() { // Evento click raton
			@Override
			public void mouseClicked(MouseEvent e) {

				// Obtengo los valores de los campos textNombre y passwordField
				String nombre = textNombre.getText();
		        String password = new String(passwordField.getPassword());
		        
		        // Compruebo si los campos estan vacios con el metodo isEmpy() 
		        if (nombre.isEmpty() || password.isEmpty()) {
	        		mostrarMensajeError("Debes introducir tus datos de usuario.");
	        	// Compruebo con el metodo containsKey() contiene un elemento con la clave(nombre)
		        } else if (datosEmpleados.containsKey(nombre)) {
		        	Empleado empleadoLog = (Empleado) datosEmpleados.get(nombre);
		        	// De ser asi obtengo el apellido con el metodo getApellido de la clase Empleado
		        	if (empleadoLog.getApellido().equals(password)) { // y con el metodo equals compruebo si es igual al password introducido
		        		// Creo una nueva ventana
		        		VentanaBienvenida2 v = new VentanaBienvenida2(nombre, password);
		        		setVisible(false); // Oculto la actual
		        		v.setVisible(true); // Hago visible la nueva ventana
		        	} 
		        } else {
		        	// Informo si el usuario o el password no son correctos
		        	mostrarMensajeError("Paswword o Nombre incorrecto.");
		        }
		        
		        System.out.println("Ejercicio realizado por Antonio Ruiz Benito"); 
				
			}
		});
		btnLogin.setBounds(144, 166, 117, 25);
		contentPane.add(btnLogin);
	}

	/**
	 * Metodo para obtener el nombre del archivo
	 * @return -> Nombre del archivo
	 */
	public static String getNombreArchivoEmpleados() {
		return nombreArchivoEmpleados;
	}

	
	@SuppressWarnings("unchecked")
	public static void leerArchivo() throws ErrorLeerArchivo {
		// Creo un objeto File y le paso el nombre del archivo
		File archivo = new File("archivoHash");
		
		try {
			// Creo un objeto ObjectInputStream al que le paso el archivo para poder leerlo
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
	        datosEmpleados = (HashMap<String, Empleado>) ois.readObject(); // Hago una cast de lo que leo con el metodo readObject()
	        ois.close(); // Cierro la conexion
	        System.out.println("Archivos recuperados:");

	     // Recorro el HashMap empleados 
			Iterator<String> it = datosEmpleados.keySet().iterator(); // Creo un objeto Iterator que recorrera elementos de tipo <String>
																	// Con el metodo keySet() obtengo los elementos del HashMap
																	// Con el metodo iterator() recorro los elementos de las claves
				while(it.hasNext()) { // Con un bucle while recorro el HashMap empleados
					String clave = (String) it.next(); // Con el metodo next() obtengo cada elemento
					// Imprimo por consola la clave y valor, obteniendo el valor de la clave con el metodo get()
					System.out.println("Clave: " + clave + " - Valor: " + datosEmpleados.get(clave));
			}

	    } catch (IOException | ClassNotFoundException e) {
	        throw new ErrorLeerArchivo("No se pudo leer el archivo de empleados."); // Utilizo la excepcion personalizada para informar por consola
	    }
	}
	
	/**
	 *  Metodo para crear un componente y mostrar un mensaje de error
	 * @param mensaje -> Mensaje 
	 */
	public void mostrarMensajeError(String mensaje) {
	    JDialog dialogo = new JDialog(); // Inicio un componente JDialog
	    JLabel etiquetaMensaje = new JLabel(mensaje); // Inico un componente JLabel
	    etiquetaMensaje.setForeground(Color.RED); // Asigno el color rojo al texto de la etiqueta
	    etiquetaMensaje.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto horizontalmente
	    dialogo.add(etiquetaMensaje); // Añado la etiqueta al JDialog
	    dialogo.setSize(500, 150); // Medidas
	    dialogo.setLocationRelativeTo(null); // Centro la ventana en la pantalla del pc
	    dialogo.setVisible(true); // Hago visible el JDialog
	}

	
	



	

	
	
}
