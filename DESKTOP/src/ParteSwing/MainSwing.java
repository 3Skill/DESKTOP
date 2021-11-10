package ParteSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import ConnRMILipe.ServerRMI;
import funciones.Idioma;
import clasesXML.LecturaXML;
public class MainSwing extends JFrame {
	
	private static JPanel contentPane,panelLogin;
	private static String[] arrayConf = new String[5];
	/**
	 * Launch the application.
	 */
	public MainSwing(){
		//Empieza la conexion con el server
		new ServerRMI();
		//Acedemos a la configuracion inical del config.xml
		LecturaXML lxml = new LecturaXML();
	
		try {
			arrayConf = lxml.lecturaConfigXML();
//			System.out.println("Idioma : " + arrayConf[0]);
//	        System.out.println("Tipus de Preguntes : " + arrayConf[1]);
//	        System.out.println("Time out entre pregunta : " + arrayConf[2]);
//	        System.out.println("NumMax preguntes : " + arrayConf[3]);
//	        System.out.println("Ruta XML de creacio de Kahoot : " + arrayConf[4]);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
		//Configuracio basica
		
		
	
		
		setBackground(Color.gray);
		setTitle("Benvingut a Kadamm!");
		setSize(650, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		//Anyadim el panel de Login a aquest
		panelLogin = new Login();
		JButton botonLogin = ((Login) panelLogin).getBtnNewButton();
		botonLogin.addActionListener(new activeBotons());
		
		
		add(panelLogin);
		//
		
		setVisible(true);
	}
	
	//Clase para gestionar las acciones de los Botones
	class activeBotons implements ActionListener {
		

		public void actionPerformed(ActionEvent e) {
			
			if ((e.getActionCommand().equals("Accedir"))){
				
				remove(panelLogin);
				setTitle("Explorador de Kadamm");
				setSize(800, 600);
				setLocationRelativeTo(null);
				add(new GestorKahoots());
			}
			
		}
		
	}
	public static void main(String[] args) {
		new MainSwing();
		
		
	}

	/**
	 * Create the frame.
	 */
	
		
	
	
//	public static void cambiarIdioma(String nombreIdioma){
//		 
//        Idioma idioma=new Idioma(nombreIdioma);
// 
//        //btnCambio.setText(idioma.getProperty("cambio"));
//        setTitle(idioma.getProperty("titulo"));
//        //lblHola.setText(idioma.getProperty("saludo"));
// 
//        String idiomas[]={
//                          idioma.getProperty("espanol"),
//                          idioma.getProperty("catala")
//                          };
//    }

}
