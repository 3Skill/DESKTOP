package ParteSwing;




import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	
	//Atributs
	private JTextField username;
	private JTextField tfUsuari;
	private JPasswordField passwordField;
	private JButton botonAccedir;
	private JLabel fotoLogin,txtIniciSessio,txtContra,txtUsuari;
	private JCheckBox cbRecordarContra;
	
	//Constructor
	public Login() {
		
		
		//Configuracion del panel
		setBackground(Color.white);
		setLayout(null);
		
		//JLabels
		fotoLogin = new JLabel("FotoLogin");
		fotoLogin.setBounds(10, 30, 587, 114);
		fotoLogin.setIcon(new ImageIcon("."+File.separator+"img"+File.separator+"fotoLogin.png"));
		
		txtIniciSessio = new JLabel("Inici de Sessi\u00F3");
		txtIniciSessio.setBounds(243, 154, 153, 38);
		txtIniciSessio.setForeground(SystemColor.desktop);
		txtIniciSessio.setFont(new Font("Calibri", Font.BOLD, 26));
		
		txtUsuari = new JLabel("Usuari:");
		txtUsuari.setBounds(204, 213, 45, 13);
		txtUsuari.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtContra = new JLabel("Contrasenya:");
		txtContra.setBounds(167, 242, 82, 18);
		txtContra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		
		//JtextFields
		tfUsuari = new JTextField();
		tfUsuari.setBounds(259, 212, 130, 19);
		tfUsuari.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setBounds(259, 241, 130, 19);
		
		//JCheckBox de recordar pass
		
		cbRecordarContra = new JCheckBox("   Recordar la contrasenya");
		cbRecordarContra.setBounds(231, 277, 206, 21);
		cbRecordarContra.setBackground(Color.white);
		
		//JButton para accedir
		botonAccedir = new JButton("Accedir");
		botonAccedir.setBackground(SystemColor.menu);
		
		botonAccedir.setBounds(251, 326, 138, 38);
		botonAccedir.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		//Anyadim tots els components al panel
		add(fotoLogin);
		add(txtIniciSessio);
		add(txtUsuari);
		add(tfUsuari);
		add(txtContra);
		add(passwordField);
		add(cbRecordarContra);
		add(botonAccedir);
		
		
	}
	
	//Getters and Setters del Panel
	public JTextField getUsername() {
		return username;
	}
	public void setUsername(JTextField username) {
		this.username = username;
	}
	
	public JTextField gettfUsuari() {
		return tfUsuari;
	}
	public void settfUsuari(JTextField tfUsuari) {
		this.tfUsuari = tfUsuari;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	public JButton getBotonAccedir() {
		return botonAccedir;
	}
	public void setBotonAccedir(JButton botonAccedir) {
		this.botonAccedir = botonAccedir;
	}
	public JLabel getFotoLogin() {
		return fotoLogin;
	}
	public void setFotoLogin(JLabel fotoLogin) {
		this.fotoLogin = fotoLogin;
	}
	public JLabel getTxtIniciSessio() {
		return txtIniciSessio;
	}
	public void setTxtIniciSessio(JLabel txtIniciSessio) {
		this.txtIniciSessio = txtIniciSessio;
	}
	public JLabel getTxtContra() {
		return txtContra;
	}
	public void setTxtContra(JLabel txtContra) {
		this.txtContra = txtContra;
	}
	public JLabel getTxtUsuari() {
		return txtUsuari;
	}
	public void setTxtUsuari(JLabel txtUsuari) {
		this.txtUsuari = txtUsuari;
	}
	public JCheckBox getCbRecordarContra() {
		return cbRecordarContra;
	}
	public void setCbRecordarContra(JCheckBox cbRecordarContra) {
		this.cbRecordarContra = cbRecordarContra;
	}
	
	

	
	
	
}