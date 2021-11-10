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


	private ErrorHandlerComponent ehc = new ErrorHandlerComponent();
	
	
//	comentada funcionaltat a la espera de connexi� entre repos
//	public boolean login(String nom, String pass) {
//		
//		// comentat a la espera de establir connexio entre repos
//		Usuari usuari = usuariDao.recuperarUsuariPerNom(nom);
//		
//		
//		if (usuari.getPassword() == pass) {
//			return true;
//		} else {
//			ehc.actualitzaErrors("Contrasenya incorrecta");
//		}
//		return false;
//		
//	}
//	
	public boolean login(String nom, String pass) {
		String usuariNom = nom;
		String usuariPass = pass;
		if (usuariPass.equals("1234")) {   // "1234" per poder testejar incorrecte
			return true;
		} else {
			
			ehc.actualitzaErrors("Login incorrecte");
			
			
			
		}
		return false;
	}
	

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
		
		
	
		setLayout(new BorderLayout());
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
		
		
		add(panelLogin,BorderLayout.CENTER);
		
		//
		
		setVisible(true);
	}
	
	//Clase para gestionar las acciones de los Botones
	class activeBotons implements ActionListener {
		

		public void actionPerformed(ActionEvent e) {
			
			if ((e.getActionCommand().equals("Accedir"))){
				
				if(login(((Login) panelLogin).getTextField().getText(), 
						((Login) panelLogin).getPasswordField().getText()) == true) {
					remove(panelLogin);
					remove(ehc);
					setTitle("Explorador de Kadamm");
					setSize(800, 600);
					setLocationRelativeTo(null);
					add(new GestorKahoots());
				} else {
					System.out.println("login incorrecte");
					setSize(650, 540);
					setResizable(true);
					setResizable(false);
					add(ehc,BorderLayout.SOUTH);
				}
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
