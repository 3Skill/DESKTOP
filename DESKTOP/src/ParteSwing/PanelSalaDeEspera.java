package ParteSwing;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



import java.awt.Font;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import javax.swing.JTextField;
import java.awt.SystemColor;

import javax.swing.ListSelectionModel;


public class PanelSalaDeEspera extends JPanel {

	//Atributos
	private JLabel tituloSalaDeEspera,txtEsperant,ipServer,txtTitol,txtIp;
	private JButton btnComencar;
	private JList list;
	private JTextField countdown;
	
	private String nickname;
	private boolean paramNickName = true;
	private DefaultListModel  modelo = new DefaultListModel(); 

	//Constructor
	@SuppressWarnings("unchecked")
	public PanelSalaDeEspera(String titolKahoot) {
		startCountdown();
		setLayout(new BorderLayout(0, 0));
		
		tituloSalaDeEspera = new JLabel("Sala d'espera");
		tituloSalaDeEspera.setBackground(Color.YELLOW);
		tituloSalaDeEspera.setFont(new Font("Tahoma", Font.BOLD, 19));
		tituloSalaDeEspera.setHorizontalAlignment(SwingConstants.CENTER);
		add(tituloSalaDeEspera, BorderLayout.NORTH);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		txtEsperant = new JLabel("Esperant jugadors...");
		txtEsperant.setHorizontalAlignment(SwingConstants.CENTER);
		txtEsperant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEsperant.setBounds(164, 126, 197, 13);
		panelPrincipal.add(txtEsperant);
		
		JScrollPane scrollPaneConcursantes = new JScrollPane();
		scrollPaneConcursantes.setBounds(185, 161, 157, 183);
		panelPrincipal.add(scrollPaneConcursantes);
		
		
		list = new JList(modelo);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneConcursantes.setViewportView(list);
		
		btnComencar = new JButton("COMENCAR CONCURS");
		btnComencar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnComencar.setBounds(156, 354, 220, 50);
		panelPrincipal.add(btnComencar);
		
		JPanel panel_Kahoot_Ip = new JPanel();
		panel_Kahoot_Ip.setBackground(Color.LIGHT_GRAY);
		panel_Kahoot_Ip.setBounds(109, 10, 315, 106);
		panelPrincipal.add(panel_Kahoot_Ip);
		panel_Kahoot_Ip.setLayout(null);
		
		txtIp = new JLabel("IP:");
		txtIp.setBounds(67, 79, 30, 13);
		panel_Kahoot_Ip.add(txtIp);
		txtIp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		ipServer = new JLabel("New label");
		ipServer.setHorizontalAlignment(SwingConstants.CENTER);
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ipServer.setText(address.getHostAddress());
		ipServer.setBounds(91, 79, 135, 13);
		panel_Kahoot_Ip.add(ipServer);
		ipServer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		txtTitol = new JLabel(titolKahoot);
		txtTitol.setForeground(Color.RED);
		txtTitol.setBounds(10, 23, 297, 31);
		panel_Kahoot_Ip.add(txtTitol);
		txtTitol.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitol.setFont(new Font("Tahoma", Font.BOLD, 19));
		

		// Countdown Sala de espera (Timeout XML)  al comenzar kahoot
		countdown = new JTextField();
		countdown.setBackground(Color.WHITE);
		countdown.setForeground(new Color(0, 0, 139));
		countdown.setFont(new Font("Tahoma", Font.PLAIN, 80));
		countdown.setBounds(374, 171, 140, 144);
		countdown.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelPrincipal.add(countdown);
		countdown.setColumns(10);


		
			
		

	}
	
	private void startCountdown() {
		
		Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
        	int i = 3;

            public void run() {
                i--;
                if (i < 0) {
                    timer.cancel();
                    if(nickname != null) {
                    	addElementList(nickname);
                    	nickname = null;
                    }
                    
                    if(paramNickName) {
                    	startCountdown();
                    }
                    
                    
                }
                System.out.println(i);
            }

			
        }, 0, 1000);
        
	}
	
	
	//Getters and Setters
	public JLabel getTxtTituloPanel() {
		return tituloSalaDeEspera;
	}
	public void setTxtTituloPanel(JLabel txtTituloPanel) {
		this.tituloSalaDeEspera = txtTituloPanel;
	}
	public JLabel getTxtEsperant() {
		return txtEsperant;
	}
	public void setTxtEsperant(JLabel txtEsperant) {
		this.txtEsperant = txtEsperant;
	}
	public JLabel getIpServer() {
		return ipServer;
	}
	public void setIpServer(JLabel ipServer) {
		this.ipServer = ipServer;
	}
	public JLabel getTxtTitol() {
		return txtTitol;
	}
	public void setTxtTitol(JLabel txtTitol) {
		this.txtTitol = txtTitol;
	}
	public JLabel getTxtIp() {
		return txtIp;
	}
	public void setTxtIp(JLabel txtIp) {
		this.txtIp = txtIp;
	}
	public JButton getBtnComencar() {
		return btnComencar;
	}
	public void setBtnComencar(JButton btnComencar) {
		this.btnComencar = btnComencar;
	}
	public JList getList() {
		return list;
	}
	public void setList(JList list) {
		this.list = list;
	}


	public JTextField getCountdown() {
		return countdown;
	}

	public void setCountdown(JTextField countdown) {
		this.countdown = countdown;
	}
	
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public boolean isParamNickName() {
		return paramNickName;
	}

	public void setParamNickName() {
		this.paramNickName = false;
	}

	//
	public void addElementList(String name) {
		modelo.addElement(name);
		
	}
	

	
}
