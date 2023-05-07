package actividad06;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
/**
 * 
 * @author Antonio Ruiz Benito -> DAW
 *
 */
public class VentanaBienvenida2 extends JFrame {

	// Atributos - Componentes
	private JPanel contentPane;
	// Atributos para mostrar
	private String nombre;
	private String apellido;


	/**
	 * Create the frame.
	 */
	// Constructor
	public VentanaBienvenida2(String nombre, String apellido) { // Paso los atributos para poder utilizarlos
		
		this.nombre = nombre;
		this.apellido = apellido;
		
		// Diseño de la ventana
		setName("Bienvenido"); // Titulo de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cuando se pulse 'x' se cerrara la ventana y el programa
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Añado los atributos nombre y apellido al texto del JLabel para poder mostrarlos
		JLabel lblBienvenido = new JLabel("Bienvenido:     " + nombre + " " + apellido + "!");
		lblBienvenido.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblBienvenido.setForeground(UIManager.getColor("Menu.acceleratorForeground"));
		lblBienvenido.setBounds(76, 116, 352, 15);
		contentPane.add(lblBienvenido);
	}


	// Setters y getters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
