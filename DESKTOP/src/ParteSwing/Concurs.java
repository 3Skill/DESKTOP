package ParteSwing;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class Concurs extends JPanel {
	//Atributos
	private JLabel txtPregunta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNextQuest;
	private JLabel txtTemps;

	//Constructor
	public Concurs() {
		setLayout(new BorderLayout(0, 0));
		
		txtPregunta = new JLabel("Pregunta de exemple");
		txtPregunta.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtPregunta, BorderLayout.NORTH);
		
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 13, 13));
		
		textField = new JTextField("Resposta1");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(Color.GREEN);
		panel.add(textField);
		
		textField_1 = new JTextField("Resposta2");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBackground(Color.RED);
		panel.add(textField_1);
		
		textField_2 = new JTextField("Resposta3");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBackground(Color.CYAN);
		panel.add(textField_2);
		
		textField_3 = new JTextField("Resposta4");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBackground(Color.ORANGE);
		panel.add(textField_3);
		
		JPanel panel2 = new JPanel();
		add(panel2, BorderLayout.SOUTH);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtTemps = new JLabel("temps");
		txtTemps.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel2.add(txtTemps);
		
		btnNextQuest = new JButton("Seguent Pregunta");
		btnNextQuest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNextQuest.setEnabled(false);
		
		panel2.add(btnNextQuest);
		
		
	}
	
	//Getters and Setters
	public JLabel getTxtPregunta() {
		return txtPregunta;
	}

	public void setTxtPregunta(JLabel txtPregunta) {
		this.txtPregunta = txtPregunta;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JButton getBtnNextQuest() {
		return btnNextQuest;
	}

	public void setBtnNextQuest(JButton btnNextQuest) {
		this.btnNextQuest = btnNextQuest;
	}

	public JLabel getTxtTemps() {
		return txtTemps;
	}

	public void setTxtTemps(JLabel txtTemps) {
		this.txtTemps = txtTemps;
	}
	
	//Metodo para habilitar el boton
	public void setEnabledButton() {
		btnNextQuest.setEnabled(true);
	}
	
	

}
