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

import kadamm.hibernate.model.*;
import kadamm.hibernate.dao.*;
import kadamm.hibernate.util.*;
import kadamm.hibernate.test.*;


import clasesXML.LecturaXML;
public class MainSwing extends JFrame {
	
	//Atributos
	private static JPanel panelLogin,gk;
	private LecturaXML lxml;
	private ErrorHandlerComponent ehc = new ErrorHandlerComponent();
	
	//Metodo main
	public static void main(String[] args) {
		new MainSwing();
		
		
	}
	
	//Constructor
	public MainSwing(){
		
		//Acedemos a la configuracion inical del config.xml
		try {
			lxml = new LecturaXML();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
        
		//Configuracio basica del JFrame
		
		setLayout(new BorderLayout());
		setBackground(Color.gray);
		setTitle("Benvingut a Kadamm!");
		setSize(650, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		//Anyadim el panel de Login a aquest
		
		panelLogin = new Login();
		JButton botonLogin = ((Login) panelLogin).getBotonAccedir();
		botonLogin.addActionListener(new activeBotons());
		
		add(panelLogin,BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	//Clase para gestionar las acciones de los Botones de los diferentes paneles
	class activeBotons implements ActionListener {
		

		public void actionPerformed(ActionEvent e) {
			
			//Boton 'Accedir' de Panel Login
			if ((e.getActionCommand().equals("Accedir"))){
				
				//Comprobaciones de que el login sea correct
				
				if(login(((Login) panelLogin).gettfUsuari().getText(), 
						((Login) panelLogin).getPasswordField().getText()) == true) {
					remove(panelLogin);
					remove(ehc);
					setTitle("Explorador de Kadamm");
					setSize(800, 600);
					setLocationRelativeTo(null);
					gk = new GestorKahoots();
					//Anyadimos el listener de crear kahoots
					JButton botonCrearKahoots = ((GestorKahoots) gk).getBtnCrearKahoot();
					botonCrearKahoots.addActionListener(new activeBotons());
					add(gk);
					new ServerRMI();
				} else {
					System.out.println("login incorrecte");
					setSize(650, 540);
					setResizable(true);
					setResizable(false);
					add(ehc,BorderLayout.SOUTH);
				}
			}
			//Boton 'Crear Kahoot' de Panel GestorKahoots 
			else if((e.getActionCommand().equals("Crear Kahoot"))) {
				remove(gk);
				repaint();
				setTitle("Explorador de Kadamm");
				setSize(800, 690);
				setLocationRelativeTo(null);
				add(new CreacionKahoots());
			}
			
			
		}
		
	}
	
	//Funcion para comprobar User/Pass del panel Login
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

}
