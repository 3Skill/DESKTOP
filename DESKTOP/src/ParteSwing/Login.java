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
	private JTextField username;
	private JTextField tx1;
	private JPasswordField tx2;
	private JButton button;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	
	/**
	 * Create the panel.
	 */
	
	//Falta poner el check box de recordar contrasenya
	public Login() {
		setLayout(new BorderLayout());
		
		
		
		
		
		setBackground(Color.white);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 30, 587, 114);
		lblNewLabel.setIcon(new ImageIcon("."+File.separator+"img"+File.separator+"fotoLogin.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Inici de Sessi\u00F3");
		lblNewLabel_1.setBounds(243, 154, 153, 38);
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 26));
		
		JLabel lblNewLabel_2 = new JLabel("Contrasenya:");
		lblNewLabel_2.setBounds(167, 242, 82, 18);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(259, 212, 130, 19);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Usuari:");
		lblNewLabel_2_1.setBounds(204, 213, 45, 13);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("   Recordar la contrasenya");
		chckbxNewCheckBox.setBounds(231, 277, 206, 21);
		chckbxNewCheckBox.setBackground(Color.white);
		
		btnNewButton = new JButton("Accedir");
		btnNewButton.setBackground(SystemColor.menu);
		
		btnNewButton.setBounds(251, 326, 138, 38);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(259, 241, 130, 19);
		setLayout(null);
		add(lblNewLabel);
		add(lblNewLabel_1);
		add(lblNewLabel_2_1);
		add(textField);
		add(lblNewLabel_2);
		add(passwordField);
		add(chckbxNewCheckBox);
		add(btnNewButton);
	
		
		
		
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JTextField getTx1() {
		return tx1;
	}

	public void setTx1(JTextField tx1) {
		this.tx1 = tx1;
	}

	public JPasswordField getTx2() {
		return tx2;
	}

	public void setTx2(JPasswordField tx2) {
		this.tx2 = tx2;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
	
}
