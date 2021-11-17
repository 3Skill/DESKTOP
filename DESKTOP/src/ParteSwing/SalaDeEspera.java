package ParteSwing;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



import java.awt.Font;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
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


public class SalaDeEspera extends JPanel {

	//Atributos
	private JLabel txtTituloPanel,txtEsperant,ipServer,txtTitol,txtIp;
	private JButton btnComencar;
	private JList list;

	private JTextField countdown;

	private DefaultListModel  modelo = new DefaultListModel(); 

	//Constructor
	@SuppressWarnings("unchecked")
	public SalaDeEspera(String titolKahoot) {
		setLayout(new BorderLayout(0, 0));
		
		txtTituloPanel = new JLabel("Sala d'espera");
		txtTituloPanel.setBackground(Color.YELLOW);
		txtTituloPanel.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtTituloPanel.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtTituloPanel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtEsperant = new JLabel("Esperant jugadors...");
		txtEsperant.setHorizontalAlignment(SwingConstants.CENTER);
		txtEsperant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEsperant.setBounds(164, 126, 197, 13);
		panel.add(txtEsperant);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(185, 161, 157, 183);
		panel.add(scrollPane);
		
		
		list = new JList(modelo);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		btnComencar = new JButton("COMEN�AR CONCURS");
		btnComencar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnComencar.setBounds(156, 354, 220, 50);
		panel.add(btnComencar);
		
		JPanel panel_Kahoot_Ip = new JPanel();
		panel_Kahoot_Ip.setBackground(Color.LIGHT_GRAY);
		panel_Kahoot_Ip.setBounds(109, 10, 315, 102);
		panel.add(panel_Kahoot_Ip);
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
		panel.add(countdown);
		countdown.setColumns(10);


		

	}
	
	
	
	
	//Getters and Setters
	public JLabel getTxtTituloPanel() {
		return txtTituloPanel;
	}
	public void setTxtTituloPanel(JLabel txtTituloPanel) {
		this.txtTituloPanel = txtTituloPanel;
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

	public void addElementList(String name) {
		modelo.addElement(name);
		
	}
	

	
}
