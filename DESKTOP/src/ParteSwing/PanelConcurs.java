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

public class PanelConcurs extends JPanel {
	//Atributos
	private JLabel txtPregunta;
	private JLabel txtResposta;
	private JButton btnNextQuest;
	private JLabel txtTemps;

	//Constructor
	public PanelConcurs() {
		setLayout(new BorderLayout(0, 0));
		
		txtPregunta = new JLabel("Pregunta de exemple");
		txtPregunta.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtPregunta, BorderLayout.NORTH);
		
		
		JPanel panelRespuestas = new JPanel();
		add(panelRespuestas, BorderLayout.CENTER);
		panelRespuestas.setLayout(new GridLayout(2, 2, 13, 13));
		
		for(int i = 0; i< 4 ;i++) {
			JPanel panelRespuesta = new JPanel();
			panelRespuesta.setLayout(new BorderLayout());
			txtResposta = new JLabel("Resposta "+(i+1));
			txtResposta.setFont(new Font("Tahoma", Font.BOLD, 15));
			txtResposta.setHorizontalAlignment(SwingConstants.CENTER);
			switch(i) {
				case 0:
					panelRespuesta.setBackground(Color.CYAN);
					break;
				case 1:
					panelRespuesta.setBackground(Color.RED);
					break;
				case 2:
					panelRespuesta.setBackground(Color.ORANGE);
					break;
				case 3:
					panelRespuesta.setBackground(Color.GREEN);
					break;
				
			}
			
			
			panelRespuesta.add(txtResposta);
			panelRespuestas.add(panelRespuesta);
		}
		
		JPanel panelBtnNextQuest = new JPanel();
		add(panelBtnNextQuest, BorderLayout.SOUTH);
		panelBtnNextQuest.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtTemps = new JLabel("temps");
		txtTemps.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelBtnNextQuest.add(txtTemps);
		
		btnNextQuest = new JButton("Seguent Pregunta");
		btnNextQuest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNextQuest.setEnabled(false);
		
		panelBtnNextQuest.add(btnNextQuest);
		
		
	}
	
	//Getters and Setters
	public JLabel getTxtPregunta() {
		return txtPregunta;
	}

	public void setTxtPregunta(JLabel txtPregunta) {
		this.txtPregunta = txtPregunta;
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
