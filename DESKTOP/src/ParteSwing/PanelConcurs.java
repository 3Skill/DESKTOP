package ParteSwing;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import kadamm.hibernate.dao.PreguntesDao;
import kadamm.hibernate.dao.RespostesDao;
import kadamm.hibernate.model.Preguntes;
import kadamm.hibernate.model.Respostes;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class PanelConcurs extends JPanel {
	//Atributos
	private JLabel txtPregunta;
	private JLabel txtResposta;
	private JButton btnNextQuest;
	private JLabel txtTemps;
	ArrayList<Respostes> respostes;
	ArrayList<JPanel> llistaPanelRespostes;
	RespostesDao rd = new RespostesDao();
	

	PreguntesDao pd = new PreguntesDao();
	//Constructor
	public PanelConcurs(Preguntes preguntes, boolean isUltimaPregunta) {
		setLayout(new BorderLayout(0, 0));
		respostes  = (ArrayList<Respostes>) rd.getRespostesByPreguntaId(preguntes.getIdPreguntes()); // Aqui tienes las respuestas
		txtPregunta = new JLabel(preguntes.getDescripcio());
		txtPregunta.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtPregunta, BorderLayout.NORTH);
		
		
		JPanel panelRespuestas = new JPanel();
		add(panelRespuestas, BorderLayout.CENTER);
		panelRespuestas.setLayout(new GridLayout(2, 2, 13, 13));
		
		for(int i = 0; i< respostes.size() ;i++) {
			JPanel panelRespuesta = new JPanel();
			panelRespuesta.setLayout(new BorderLayout());
			txtResposta = new JLabel(respostes.get(i).getDescripcio());
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
			llistaPanelRespostes.add(panelRespuesta);
		}
		
		JPanel panelBtnNextQuest = new JPanel();
		add(panelBtnNextQuest, BorderLayout.SOUTH);
		panelBtnNextQuest.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtTemps = new JLabel("temps");
		txtTemps.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelBtnNextQuest.add(txtTemps);
		
		if(isUltimaPregunta) {
			btnNextQuest = new JButton("Finalitzar");
		}else {
			btnNextQuest = new JButton("Seguent Pregunta");
		}
		btnNextQuest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNextQuest.setEnabled(false);
		
		panelBtnNextQuest.add(btnNextQuest);
		
		
	}
	
	public JLabel getTxtResposta() {
		return txtResposta;
	}

	public void setTxtResposta(JLabel txtResposta) {
		this.txtResposta = txtResposta;
	}

	public ArrayList<JPanel> getLlistaPanelRespostes() {
		return llistaPanelRespostes;
	}

	public void setLlistaPanelRespostes(ArrayList<JPanel> llistaPanelRespostes) {
		this.llistaPanelRespostes = llistaPanelRespostes;
	}
	public ArrayList<Respostes> getRespostes() {
		return respostes;
	}

	public void setRespostes(ArrayList<Respostes> respostes) {
		this.respostes = respostes;
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
