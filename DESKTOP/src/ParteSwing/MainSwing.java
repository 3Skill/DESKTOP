package ParteSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

	private static JPanel panelLogin,gk,sde,ck,concurs;
	private LecturaXML lxml;
	private ErrorHandlerComponent ehc = new ErrorHandlerComponent();
	private UsuariDao ud = new UsuariDao();
	
	//Metodo main
	public static void main(String[] args) {
		new MainSwing();
	}
	
	public boolean login(String nom, String pass) {
		
		// comentat a la espera de establir connexio entre repos
		
		try {
			Usuari usuari = ud.getUsuariByName(nom);
			
			System.out.println(usuari.getPassword());
			
			
			if (usuari.getPassword().equals(pass)) {
				return true;
			} else {
				ehc.actualitzaErrors("Contrasenya incorrecta");
			}
		} catch (IllegalStateException ise) {
			ehc.actualitzaErrors("Aquest usuari no existeix");
			ise.printStackTrace();
		} catch (Exception e) {
			ehc.actualitzaErrors("Error no controlat");
			e.printStackTrace();
		}
		return false;
		
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
		private String titolKahoot;

		public void actionPerformed(ActionEvent e) {
			
			//Boton 'Accedir' de Panel Login
			if ((e.getActionCommand().equals("Accedir"))){
				// Capturem els valors de usuari i password
				String nom = ((Login) panelLogin).gettfUsuari().getText().toString();
				String pass = ((Login) panelLogin).getPasswordField().getText();
				
				//Comprobaciones de que el login sea correct
				
				if(login(nom, pass) == true) {
					remove(panelLogin);
					remove(ehc);
					setTitle("Explorador de Kadamm");
					setSize(800, 600);
					setLocationRelativeTo(null);
					gk = new GestorKahoots();
					//Anyadimos el listener de crear kahoots
					JButton botonCrearKahoots = ((GestorKahoots) gk).getBtnCrearKahoot();
					JButton botonJugar = ((GestorKahoots) gk).getBtnJugar();
					
					botonCrearKahoots.addActionListener(new activeBotons());
					botonJugar.addActionListener(new activeBotons());
					add(gk);
					
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
				remove(ehc);
				repaint();
				setTitle("Creador de Kadamm");
				setSize(800, 690);
				setLocationRelativeTo(null);
				ck = new CreacionKahoots();
				JButton btnCearKahoot = ((CreacionKahoots) ck).getBtnAfegirPregunta();
				JButton btnEnrere = ((CreacionKahoots) ck).getBtnEnrere();
				btnEnrere.addActionListener(new activeBotons());
				btnCearKahoot.addActionListener(new activeBotons());
				add(ck);
			}
			else if((e.getActionCommand().equals("Enrere"))) {
				remove(ck);
				remove(ehc);
				setTitle("Explorador de Kadamm");
				setSize(800, 600);
				setLocationRelativeTo(null);
				gk = new GestorKahoots();
				//Anyadimos el listener de crear kahoots
				JButton botonCrearKahoots = ((GestorKahoots) gk).getBtnCrearKahoot();
				JButton botonJugar = ((GestorKahoots) gk).getBtnJugar();
				
				botonCrearKahoots.addActionListener(new activeBotons());
				botonJugar.addActionListener(new activeBotons());
				add(gk);
			}
			//Si le damos al boton jugar del panel 'CreacionKahoot' accedemos al panel de 'SalaDeEspera'
			else if ((e.getActionCommand().equals("JUGAR"))) {
				titolKahoot = ((GestorKahoots) gk).getListKahoots();
				
				if (titolKahoot != null) {
					ServerRMI server = new ServerRMI();
					remove(gk);
					remove(ehc);
					setTitle("Sala de Espera");
					setSize(550, 550);
					setLocationRelativeTo(null);
					sde = new SalaDeEspera(titolKahoot);
					JButton btnComencar = ((SalaDeEspera) sde).getBtnComencar();
					btnComencar.addActionListener(new activeBotons());
					add(sde);
					JList listaConcursantes = ((SalaDeEspera) sde).getList();
					//sde.addElementList(new JLabel("Hola"));
					server.setSalaEspera((SalaDeEspera) sde);
				}else {
					setSize(800, 650);
					setLocationRelativeTo(null);
					ehc.actualitzaErrors("Selecciona un Kahoot para jugar");
					add(ehc,BorderLayout.SOUTH);
				}
				
			}
			
			//Si le damos al boton comenzar Kahoot de la Sala de espera comienza la cuenta atras
			else if ((e.getActionCommand().equals("COMENCAR CONCURS"))) {
		
				int countdown = Integer.valueOf(lxml.getCountdown()); 
				JTextField jtextfieldCountdown = ((SalaDeEspera) sde).getCountdown();
				concurs = new Concurs();
				JButton botonNextQuest = ((Concurs) concurs).getBtnNextQuest();
				botonNextQuest.addActionListener(new activeBotons());
				String txtTemps = ((Concurs) concurs).getTxtTemps().getText();
				startCountdown(jtextfieldCountdown, countdown);
				
				
				
			}
			

			
			
			
			else if ((e.getActionCommand().equals("Afegir pregunta"))) {
				
				Respostes resposta1 = null;
				Respostes resposta2 = null;
				
				System.out.println("Entra");
				Preguntes pregunta1 = new Preguntes(((CreacionKahoots) ck).getTxtAreaPregunta().getText(), 4);
				ArrayList<Respostes> respostes = new ArrayList<Respostes>();
				ArrayList<JCheckBox> checkboxes= new ArrayList<JCheckBox>();
				checkboxes.add(((CreacionKahoots) ck).getCb1());
				checkboxes.add(((CreacionKahoots) ck).getCb2());
				checkboxes.add(((CreacionKahoots) ck).getCb3());
				checkboxes.add(((CreacionKahoots) ck).getCb4());
				
				respostes.add(resposta1);
				respostes.add(resposta2);
				String[] AreaRespostes = ((CreacionKahoots) ck).getTxtAreaRespostes().getText().split("\n");
//				Respostes resposta1 = new Respostes(((CreacionKahoots) ck).getTxtAreaRespostes().getText(), ((CreacionKahoots) ck).getCb1().isSelected(), 19);
				for (int i = 0; i < AreaRespostes.length; i++) {
					Respostes resposta = new Respostes(AreaRespostes[i], checkboxes.get(i).isSelected(), 19);
					respostes.set(i, resposta);
					
				}
//				Respostes resposta1 = new Respostes(AreaRespostes[0], ((CreacionKahoots) ck).getCb1().isSelected(), 19);
//				Respostes resposta2 = new Respostes(AreaRespostes[1], ((CreacionKahoots) ck).getCb1().isSelected(), 19);
//				respostes.add(resposta1);
//				respostes.add(resposta2);
				((CreacionKahoots) ck).checkNewPregunta(pregunta1, respostes);

				
			
			}
			

			//Si le damos a seguent pregunta es creara una altre presentacio
			else if ((e.getActionCommand().equals("Seguent Pregunta"))) {
				
				
				
				
				remove(concurs);
				concurs = new Concurs();
				JButton botonNextQuest = ((Concurs) concurs).getBtnNextQuest();
				botonNextQuest.addActionListener(new activeBotons());
				setTitle("Concurs");
				setResizable(true);
				setSize(800, 750);
				setLocationRelativeTo(null);
				add(concurs);
				repaint();
				startCountdownConcurs(((Concurs) concurs).getTxtTemps(),Integer.valueOf(lxml.getTimeout()));
				
			}

		
	}
	
		
		//Funcion para iniciar una cuentra atras en un JTextField
		private void startCountdown(JTextField jTextField, int timeout) {
				
			Timer timer = new Timer();
	        timer.scheduleAtFixedRate(new TimerTask() {
	        	int i = timeout;
	
	            public void run() {
	
	                jTextField.setText(String.valueOf(i));
	                i--;
	                if (i < 0) {
	                    timer.cancel();
	                    
	                    remove(sde);
	    				remove(ehc);
	    				setTitle("Concurs");
	    				setResizable(true);
	    				setSize(800, 750);
	    				setLocationRelativeTo(null);
	    				add(concurs);
	    				repaint();
	    				startCountdownConcurs(((Concurs) concurs).getTxtTemps(),Integer.valueOf(lxml.getTimeout()));
	                }
	            }
	
				
	        }, 0, 1000);
			
		}
	
		//Funcion para iniciar una cuentra atras en el Concurso para poder activar el boton
		private void startCountdownConcurs(JLabel txt,int timeout) {
				
			Timer timer = new Timer();
	        timer.scheduleAtFixedRate(new TimerTask() {
	        	int i = timeout;

	            public void run() {

	                txt.setText(String.valueOf(i));
	                i--;
	                if (i < 0) {
	                    timer.cancel();
	                    ((Concurs) concurs).setEnabledButton();
	                    
	                }
	            }

				
	        }, 0, 1000);
			
		}
	


	}
}
