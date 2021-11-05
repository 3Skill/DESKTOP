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

public class Login extends JPanel {
	private JTextField username;
	private JTextField tx1;
	private JPasswordField tx2;
	private JButton button;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Create the panel.
	 */
	
	//Falta poner el check box de recordar contrasenya
	public Login() {
		
		setBackground(Color.white);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 30, 587, 114);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1vict\\Desktop\\Proyecte\\DESKTOP\\DESKTOP\\img\\fotoLogin.png"));
		
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
		
		JButton btnNewButton = new JButton("Accedir");
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
		
		JLabel lblNewLabel_3 = new JLabel("\u00A9 2021 3Skill Solutions ");
		lblNewLabel_3.setBounds(10, 385, 144, 13);
		add(lblNewLabel_3);
		
		
	}
}
