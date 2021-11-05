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

public class Login extends JPanel {
	private JTextField username;
	private JTextField tx1;
	private JPasswordField tx2;
	private JButton button;
	
	/**
	 * Create the panel.
	 */
	public Login() {
		
		setBackground(Color.white);
		JPanel panel1 = new JPanel();
		JPanel gridPanel = new JPanel();

		add(Box.createVerticalGlue());
		JLabel title = new JLabel();
		String sCarpAct = System.getProperty("user.dir");
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miicono = mipantalla
				.getImage(sCarpAct + File.separator + "img" + File.separator + "fotoLogin.png");

		Image dimg = miicono.getScaledInstance(300, 180, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		title.setIcon(imageIcon);
		title.setAlignmentX(CENTER_ALIGNMENT);
		add(title);

		gridPanel.add(new JLabel("Nom d'usuari:", JLabel.RIGHT));
		username = new JTextField("Iwo Prshvihfski", 10);
		gridPanel.add(username);
		gridPanel.add(new JLabel("Contrasenya:", JLabel.RIGHT));
		tx2 = new JPasswordField("metajets", 10);
		gridPanel.add(tx2);
		gridPanel.setLayout(new GridLayout(3, 2, 5, 5));
		panel1.add(gridPanel);
		panel1.add(Box.createRigidArea(new Dimension(20, 0)));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		gridPanel.setBackground(Color.white);
		panel1.setBackground(Color.white);
		add(panel1);

		button = new JButton("Accedir");   
		button.setAlignmentX(CENTER_ALIGNMENT);
		
		add(button);
		add(Box.createVerticalGlue());

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

}
