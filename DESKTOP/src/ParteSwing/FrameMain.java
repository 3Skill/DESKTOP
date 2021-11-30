package ParteSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
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

import com.example.kadamm.ui.connexio.ServerRMI;

import funciones.Idioma;

import kadamm.hibernate.model.*;
import kadamm.hibernate.dao.*;
import kadamm.hibernate.util.*;
import kadamm.hibernate.test.*;


import clasesXML.LecturaXML;
public class FrameMain extends JFrame {
	
	//Atributos

	private static JPanel panelLogin,PanelGestorKahoots,PanelSalaDeEspera,PanelCreacionKahoots,PanelConcurs;
	private LecturaXML lxml;
	private PanelErrorHandlerComponent ehc = new PanelErrorHandlerComponent();
	private UsuariDao ud = new UsuariDao();
	private KahootDao kd = new KahootDao();
	private PreguntesDao pd = new PreguntesDao();
	private static Usuari usuariActual;
	private Kahoot kahootActual;
	private int iteradorConcurs = 0;
	private ArrayList<Preguntes> llistaPreguntes;
	private ArrayList<JPanel> llistaPanelPreguntes;
	private boolean isUltimaPregunta = false;
	private ServerRMI server;
	
	public static Usuari getUsuariActual() {
		return usuariActual;
	}

	public void setUsuariActual(Usuari usuari) {
		this.usuariActual = usuari;
	}

	//Metodo main
	public static void main(String[] args) {
		new FrameMain();
	}
	
	public boolean login(String nom, String pass) {
		
		// comentat a la espera de establir connexio entre repos
		
		try {
			Usuari usuari = ud.getUsuariByName(nom);
			setUsuariActual(usuari);
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
	public FrameMain(){
		
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
		
		panelLogin = new PanelLogin();
		JButton botonLogin = ((PanelLogin) panelLogin).getBotonAccedir();
		JTextField txtpass = ((PanelLogin) panelLogin).getPasswordField();
		JTextField txtuser = ((PanelLogin) panelLogin).gettfUsuari();
		botonLogin.addActionListener(new activeBotons());
		//Listener del teclado
		KeyListener keyListener =  new KeyListener(){
            public void keyTyped(KeyEvent e){
            	//System.out.println("Enter");
            }
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                	System.out.println("Enter");
    				// Capturem els valors de usuari i password
    				String nom = ((PanelLogin) panelLogin).gettfUsuari().getText().toString();
    				String pass = ((PanelLogin) panelLogin).getPasswordField().getText();
    				
    				//Comprobaciones de que el login sea correct
    				
    				if(login(nom, pass) == true) {
    					remove(panelLogin);
    					remove(ehc);
    					setTitle("Explorador de Kadamm");
    					setSize(800, 600);
    					setLocationRelativeTo(null);
    					PanelGestorKahoots = new PanelGestorKahoots();
    					//Anyadimos el listener de crear kahoots
    					JButton botonCrearKahoots = ((PanelGestorKahoots) PanelGestorKahoots).getBtnCrearKahoot();
    					JButton botonJugar = ((PanelGestorKahoots) PanelGestorKahoots).getBtnJugar();
    					
    					botonCrearKahoots.addActionListener(new activeBotons());
    					botonJugar.addActionListener(new activeBotons());
    					add(PanelGestorKahoots);
                } else {
					System.out.println("login incorrecte");
					setSize(650, 540);
					setResizable(true);
					setResizable(false);
					add(ehc,BorderLayout.SOUTH);
				}
                
            }
            }
            public void keyReleased(KeyEvent e){
            	//System.out.println("Enter");
            }
        };
        txtpass.addKeyListener(keyListener);
        txtuser.addKeyListener(keyListener);
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
				String nom = ((PanelLogin) panelLogin).gettfUsuari().getText().toString();
				String pass = ((PanelLogin) panelLogin).getPasswordField().getText();
				
				//Comprobaciones de que el login sea correct
				
				if(login(nom, pass) == true) {
					remove(panelLogin);
					remove(ehc);
					setTitle("Explorador de Kadamm");
					setSize(800, 600);
					setLocationRelativeTo(null);
					PanelGestorKahoots = new PanelGestorKahoots();
					//Anyadimos el listener de crear kahoots
					JButton botonCrearKahoots = ((PanelGestorKahoots) PanelGestorKahoots).getBtnCrearKahoot();
					JButton botonJugar = ((PanelGestorKahoots) PanelGestorKahoots).getBtnJugar();
					
					botonCrearKahoots.addActionListener(new activeBotons());
					botonJugar.addActionListener(new activeBotons());
					add(PanelGestorKahoots);
					
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
				remove(PanelGestorKahoots);
				remove(ehc);
				repaint();
				setTitle("Creador de Kadamm");
				setSize(800, 690);
				setResizable(true);
				setLocationRelativeTo(null);
				PanelCreacionKahoots = new PanelCreacionKahoots(ehc);
				JButton btnCearKahoot = ((PanelCreacionKahoots) PanelCreacionKahoots).getBtnAfegirPregunta();
				JButton btnGuardarKahoot = ((PanelCreacionKahoots) PanelCreacionKahoots).getBtnGuardarKahoot();
				JButton btnEnrere = ((PanelCreacionKahoots) PanelCreacionKahoots).getBtnEnrere();
				btnEnrere.addActionListener(new activeBotons());
				btnCearKahoot.addActionListener(new activeBotons());
				btnGuardarKahoot.addActionListener(new activeBotons());
				add(PanelCreacionKahoots);
			}
			else if((e.getActionCommand().equals("Enrere"))) {
				remove(PanelCreacionKahoots);
				
				remove(ehc);
				setTitle("Explorador de Kadamm");
				setSize(800, 600);
				setLocationRelativeTo(null);
				PanelGestorKahoots = new PanelGestorKahoots();
				//Anyadimos el listener de crear kahoots
				JButton botonCrearKahoots = ((PanelGestorKahoots) PanelGestorKahoots).getBtnCrearKahoot();
				JButton botonJugar = ((PanelGestorKahoots) PanelGestorKahoots).getBtnJugar();
				
				botonCrearKahoots.addActionListener(new activeBotons());
				botonJugar.addActionListener(new activeBotons());
				add(PanelGestorKahoots);
			}
			else if(e.getActionCommand().equals("Finalitzar")) {
				iteradorConcurs = 0;
				isUltimaPregunta = false;
				remove(PanelConcurs);
				remove(ehc);
				
				setTitle("Explorador de Kadamm");
				setSize(800, 600);
				setLocationRelativeTo(null);
				setResizable(false);
				PanelGestorKahoots = new PanelGestorKahoots();
				//Anyadimos el listener de crear kahoots
				JButton botonCrearKahoots = ((PanelGestorKahoots) PanelGestorKahoots).getBtnCrearKahoot();
				JButton botonJugar = ((PanelGestorKahoots) PanelGestorKahoots).getBtnJugar();
				
				botonCrearKahoots.addActionListener(new activeBotons());
				botonJugar.addActionListener(new activeBotons());
				add(PanelGestorKahoots);
			}
			//Si le damos al boton jugar del panel 'CreacionKahoot' accedemos al panel de 'SalaDeEspera'
			else if ((e.getActionCommand().equals("JUGAR"))) {
				titolKahoot = ((PanelGestorKahoots) PanelGestorKahoots).getListKahoots();
				
				if (titolKahoot != null) {
					//Coger las respuestas de cada pregunta 
					
					
					//Hashtable<String, String> infoPreguntas = getHashPreguntas(llistaPreguntes);
					ArrayList<String> infoKahoot = new ArrayList<String>();	
					infoKahoot.add(lxml.getCountdown());
					infoKahoot.add(lxml.getTimeout());
					
					
					kahootActual = kd.getKahootByName(titolKahoot);
					llistaPreguntes = (ArrayList<Preguntes>) pd.getAllPreguntesByKahoot(kahootActual.getIdKahoot());
					server = new ServerRMI(infoKahoot,llistaPreguntes);
					
					
					
					
					remove(PanelGestorKahoots);
					remove(ehc);
					setTitle("Sala de Espera");
					setSize(550, 550);
					setLocationRelativeTo(null);
					
					PanelSalaDeEspera = new PanelSalaDeEspera(kahootActual.getNom());
					JButton btnComencar = ((PanelSalaDeEspera) PanelSalaDeEspera).getBtnComencar();
					btnComencar.addActionListener(new activeBotons());
					add(PanelSalaDeEspera);
					JList listaConcursantes = ((PanelSalaDeEspera) PanelSalaDeEspera).getList();
					//sde.addElementList(new JLabel("Hola"));
					server.setSalaEspera((PanelSalaDeEspera) PanelSalaDeEspera);
				}else {
					setSize(800, 650);
					setLocationRelativeTo(null);
					ehc.actualitzaErrors("Selecciona un Kahoot para jugar");
					add(ehc,BorderLayout.SOUTH);
				}
				
			}
			
			//Si le damos al boton comenzar Kahoot de la Sala de espera comienza la cuenta atras
			else if ((e.getActionCommand().equals("COMENCAR CONCURS"))) {
				server.setWaitingRoom2Status(true);
				((ParteSwing.PanelSalaDeEspera) PanelSalaDeEspera).setParamNickName();
				int countdown = Integer.valueOf(lxml.getCountdown()); 
				JTextField jtextfieldCountdown = ((PanelSalaDeEspera) PanelSalaDeEspera).getCountdown();
				if(iteradorConcurs == llistaPreguntes.size()-1) {
					isUltimaPregunta = true;
				}
				//
				PanelConcurs = new PanelConcurs(llistaPreguntes.get(iteradorConcurs), isUltimaPregunta);
				iteradorConcurs++;
				JButton botonNextQuest = ((PanelConcurs) PanelConcurs).getBtnNextQuest();
				
				botonNextQuest.addActionListener(new activeBotons());
				String txtTemps = ((PanelConcurs) PanelConcurs).getTxtTemps().getText();
				
				llistaPanelPreguntes = ((ParteSwing.PanelConcurs) PanelConcurs).getLlistaPanelRespostes();
				startCountdown(jtextfieldCountdown, countdown);
				
				
				
			}
			//Si le damos a seguent pregunta es creara una altre presentacio
			else if ((e.getActionCommand().equals("Seguent Pregunta"))) {
				
				//La condicion esta es probisional, mas que nada esta para que no pete si no hay mas preguntas
				if(iteradorConcurs!=llistaPreguntes.size()) {
					remove(PanelConcurs);
					if(iteradorConcurs == llistaPreguntes.size()-1) {
						isUltimaPregunta = true;
						
					}
					PanelConcurs = new PanelConcurs(llistaPreguntes.get(iteradorConcurs), isUltimaPregunta);
					iteradorConcurs++;
					JButton botonNextQuest = ((PanelConcurs) PanelConcurs).getBtnNextQuest();
					botonNextQuest.addActionListener(new activeBotons());
					setTitle("Concurs");
					setResizable(true);
					setSize(800, 750);
					setLocationRelativeTo(null);
					add(PanelConcurs);
					repaint();
					
					llistaPanelPreguntes = ((ParteSwing.PanelConcurs) PanelConcurs).getLlistaPanelRespostes();
					startCountdownConcurs(((PanelConcurs) PanelConcurs).getTxtTemps(),Integer.valueOf(lxml.getTimeout()));
				}
				
				
			}
			
			else if ((e.getActionCommand().equals("Afegir pregunta"))) {
				

				
				Preguntes novaPregunta = new Preguntes(((PanelCreacionKahoots) PanelCreacionKahoots).getTxtAreaPregunta().getText());
				ArrayList<Respostes> respostes = new ArrayList<Respostes>();
				ArrayList<JCheckBox> checkboxes=  new ArrayList<JCheckBox>();
				checkboxes.add(((PanelCreacionKahoots) PanelCreacionKahoots).getCb1());
				checkboxes.add(((PanelCreacionKahoots) PanelCreacionKahoots).getCb2());
				checkboxes.add(((PanelCreacionKahoots) PanelCreacionKahoots).getCb3());
				checkboxes.add(((PanelCreacionKahoots) PanelCreacionKahoots).getCb4());
				

				String[] AreaRespostes = ((PanelCreacionKahoots) PanelCreacionKahoots).getTxtAreaRespostes().getText().split("\n");
				System.out.println("Respuestas: "+ AreaRespostes.length);

				
				for (int i = 0; i < AreaRespostes.length; i++) {
					if(!AreaRespostes[i].equals("")) {
						Respostes resposta = new Respostes(AreaRespostes[i], checkboxes.get(i).isSelected());
						respostes.add(resposta);
						System.out.println(AreaRespostes[i]);
					}
				}

				
				if (((PanelCreacionKahoots) PanelCreacionKahoots).checkNewPregunta(novaPregunta, respostes)) {
					for (JCheckBox cb : checkboxes) {
						remove(ehc);
						setSize(800, 690);
						setLocationRelativeTo(null);
						cb.setSelected(false);
					}
				}else {
					
					setSize(800, 710);
					setLocationRelativeTo(null);
					add(ehc,BorderLayout.SOUTH);
				}
				
				

				
			
			}
			
			// Comando para el boton de guardar un nuevo kahoot
			else if ((e.getActionCommand().equals("Guardar nou Kahoot"))) {
				String nomKahoot = ((PanelCreacionKahoots) PanelCreacionKahoots).getTfTitol().getText();
				if(nomKahoot.equals("")|| nomKahoot == null) {
					setSize(800, 710);
					setLocationRelativeTo(null);
					add(ehc,BorderLayout.SOUTH);
					ehc.actualitzaErrors("Error al guardar el Kahoot: El kahoot no té títol");
				}else {
					try {
						ArrayList<Preguntes> preguntes = (ArrayList<Preguntes>) pd.getAllPreguntesWithoutKahoot();
						Kahoot kahoot = new Kahoot(nomKahoot, usuariActual);
						kd.saveKahoot(kahoot);
						Kahoot idKahoot = kd.getKahootByName(nomKahoot);
						for (Preguntes pregunta : preguntes) {
							pregunta.setIdKahoot(idKahoot);
							pd.updatePregunta(pregunta);
						}
						setSize(800, 710);
						setLocationRelativeTo(null);
						add(ehc,BorderLayout.SOUTH);
						ehc.actualitzaErrors("Kahoot Guardat");
						// Si se ha guardado el kahoot sin problema, se vuelve a abrir la ventana de gestion de kahoots.
						remove(PanelCreacionKahoots);
						remove(ehc);
						setTitle("Explorador de Kadamm");
						setSize(800, 600);
						setLocationRelativeTo(null);
						PanelGestorKahoots = new PanelGestorKahoots();
						//Anyadimos el listener de crear kahoots
						JButton botonCrearKahoots = ((PanelGestorKahoots) PanelGestorKahoots).getBtnCrearKahoot();
						JButton botonJugar = ((PanelGestorKahoots) PanelGestorKahoots).getBtnJugar();
						
						botonCrearKahoots.addActionListener(new activeBotons());
						botonJugar.addActionListener(new activeBotons());
						add(PanelGestorKahoots);
						
					} catch (Exception e1) {
						setSize(800, 710);
						setLocationRelativeTo(null);
						add(ehc,BorderLayout.SOUTH);
						ehc.actualitzaErrors("Ha ocorregut un error a l'hora de guardar el Kahoot");
					}
				}
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
	                    
	                    remove(PanelSalaDeEspera);
	    				remove(ehc);
	    				setTitle("Concurs");
	    				setResizable(true);
	    				setSize(800, 750);
	    				setLocationRelativeTo(null);
	    				add(PanelConcurs);
	    				repaint();
	    				startCountdownConcurs(((PanelConcurs) PanelConcurs).getTxtTemps(),Integer.valueOf(lxml.getTimeout()));
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
	                    ((PanelConcurs) PanelConcurs).setEnabledButton();
	                    
	                	for(int i = 0;i<llistaPanelPreguntes.size();i++) {
	                		llistaPanelPreguntes.get(i).setBackground(Color.GRAY);
	                		
	                	}
	                }
	            }

				
	        }, 0, 1000);
			
		}


		
	


	}

	
}
