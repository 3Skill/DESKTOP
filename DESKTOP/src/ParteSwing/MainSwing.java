package ParteSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funciones.Idioma;
import clasesXML.LecturaXML;
public class MainSwing extends JFrame {
	
	private JPanel contentPane;
	private static JFrame frame;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Acedemos a la configuracion inical del config.xml
					LecturaXML lxml = new LecturaXML();
					String[] arrayConf = lxml.lecturaConfigXML();
					System.out.println("Idioma : " + arrayConf[0]);
			        System.out.println("Tipus de Preguntes : " + arrayConf[1]);
			        System.out.println("Time out entre pregunta : " + arrayConf[2]);
			        System.out.println("NumMax preguntes : " + arrayConf[3]);
			        System.out.println("Ruta XML de creacio de Kahoot : " + arrayConf[4]);
			        
			        //cambiarIdioma(arrayConf[0]);
					//Configuracio basica
					MainSwing frame = new MainSwing();
					frame.setTitle("Benvingut!");
					frame.setSize(400, 450);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					//Anyadim el panel de Login a aquest
					JPanel panelLogin = new Login();
					frame.add(panelLogin);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public static void cambiarIdioma(String nombreIdioma){
		 
        Idioma idioma=new Idioma(nombreIdioma);
 
        //btnCambio.setText(idioma.getProperty("cambio"));
        frame.setTitle(idioma.getProperty("titulo"));
        //lblHola.setText(idioma.getProperty("saludo"));
 
        String idiomas[]={
                          idioma.getProperty("espanol"),
                          idioma.getProperty("catala")
                          };
    }

}
