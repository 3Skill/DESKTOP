package ParteSwing;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import kadamm.hibernate.model.*;
import kadamm.hibernate.dao.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelCreacionKahoots extends JPanel {
	
	//Atributs
	private JTextField tfTitol;
	private JLabel txtTitol, txtLlistaPreguntes,txtNovaPregunta, txtTemesAso, txtRespostes, txtResCorrecta;
	private JButton btnAfegirPregunta, btnGuardarKahoot;
	private JCheckBox cbRespuesta1,cbRspuesta2,cbRespuesta3,cbRespuesta4;
	private JList listPreguntas,listaTemasAsociados;
	private JTextArea txtAreaRespostes, txtAreaNuevaPregunta;
	private PreguntesDao pd = new PreguntesDao();
	private RespostesDao rd = new RespostesDao();
	private JPanel panelTituloCreacionKahoot;
	private JLabel lbTituloCreacionKahoots;
	private JButton btnEnrere;
	
	
	//Constructor
	public PanelCreacionKahoots() {
		
		//Confg general del panel
		setLayout(new BorderLayout(0, 0));
		JPanel panelPrincipalCrearKahoot = new JPanel();
		panelPrincipalCrearKahoot.setBackground(Color.WHITE);
		add(panelPrincipalCrearKahoot, BorderLayout.CENTER);
		panelPrincipalCrearKahoot.setLayout(null);
		
		//Titol
		txtTitol = new JLabel("T\u00EDtol");
		txtTitol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTitol.setBounds(62, 48, 46, 13);
		panelPrincipalCrearKahoot.add(txtTitol);
		
		tfTitol = new JTextField();
		tfTitol.setBounds(118, 47, 344, 19);
		panelPrincipalCrearKahoot.add(tfTitol);
		tfTitol.setColumns(10);
		
		txtLlistaPreguntes = new JLabel("Llista de preguntes");
		txtLlistaPreguntes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLlistaPreguntes.setBounds(62, 116, 201, 13);
		panelPrincipalCrearKahoot.add(txtLlistaPreguntes);
		
		JScrollPane scrollPanelPreguntas = new JScrollPane();
		scrollPanelPreguntas.setBounds(62, 157, 400, 127);
		panelPrincipalCrearKahoot.add(scrollPanelPreguntas);
		
		String[] listaPreguntas = {"Text nova pregunta 1","Text nova pregunta 2","..."};
		String[] llistaNovaPregunta = {"Text de la nova pregunta"};
		String[] llistaTemesAssociats = {"Tema 1","Tema 2","Tema 3","Tema n","..."};
		String[] llistaRespostes = {"Resposta 1","Resposta 2","Resposta 3","Resposta 4"};
		
		listPreguntas = new JList(listaPreguntas) ;
		listPreguntas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPanelPreguntas.setViewportView(listPreguntas);
		
		txtNovaPregunta = new JLabel("Nova Pregunta");
		txtNovaPregunta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNovaPregunta.setBounds(62, 321, 201, 13);
		panelPrincipalCrearKahoot.add(txtNovaPregunta);
		
		JScrollPane scrollPanelNuevaPregunta = new JScrollPane();
		scrollPanelNuevaPregunta.setBounds(62, 362, 400, 94);
		panelPrincipalCrearKahoot.add(scrollPanelNuevaPregunta);
		
		txtAreaNuevaPregunta = new JTextArea();
		scrollPanelNuevaPregunta.setViewportView(txtAreaNuevaPregunta);
		
		txtTemesAso = new JLabel("Temes associats");
		txtTemesAso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTemesAso.setBounds(514, 118, 151, 13);
		panelPrincipalCrearKahoot.add(txtTemesAso);
		
		JScrollPane scrollPanelTemasAsociados = new JScrollPane();
		scrollPanelTemasAsociados.setBounds(514, 157, 161, 115);
		panelPrincipalCrearKahoot.add(scrollPanelTemasAsociados);
		
		listaTemasAsociados = new JList(llistaTemesAssociats);
		listaTemasAsociados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPanelTemasAsociados.setViewportView(listaTemasAsociados);
		
		JScrollPane scrollPanelRespostas = new JScrollPane();
		scrollPanelRespostas.setBounds(516, 360, 161, 96);
		panelPrincipalCrearKahoot.add(scrollPanelRespostas);
		
		txtAreaRespostes = new JTextArea();
		scrollPanelRespostas.setViewportView(txtAreaRespostes);
		
		txtRespostes = new JLabel("Respostes");
		txtRespostes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRespostes.setBounds(514, 323, 106, 13);
		panelPrincipalCrearKahoot.add(txtRespostes);
		
		//Botones
		btnAfegirPregunta = new JButton("Afegir pregunta");
		btnAfegirPregunta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAfegirPregunta.setBounds(216, 491, 181, 70);
		panelPrincipalCrearKahoot.add(btnAfegirPregunta);
		
		
		btnGuardarKahoot = new JButton("Guardar nou Kahoot");
		btnGuardarKahoot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGuardarKahoot.setBounds(431, 491, 181, 70);
		panelPrincipalCrearKahoot.add(btnGuardarKahoot);
		
		
		//Parte de Respuestas posibles
		txtResCorrecta = new JLabel("Correcta");
		txtResCorrecta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtResCorrecta.setBounds(702, 323, 70, 13);
		panelPrincipalCrearKahoot.add(txtResCorrecta);
		
		cbRespuesta1 = new JCheckBox("");
		cbRespuesta1.setBounds(718, 362, 21, 21);
		panelPrincipalCrearKahoot.add(cbRespuesta1);
		
		cbRspuesta2 = new JCheckBox("");
		cbRspuesta2.setBounds(718, 385, 21, 21);
		panelPrincipalCrearKahoot.add(cbRspuesta2);
		
		cbRespuesta3 = new JCheckBox("");
		cbRespuesta3.setBounds(718, 408, 21, 21);
		panelPrincipalCrearKahoot.add(cbRespuesta3);
		
		cbRespuesta4 = new JCheckBox("");
		cbRespuesta4.setBounds(718, 431, 21, 21);
		panelPrincipalCrearKahoot.add(cbRespuesta4);
		
		panelTituloCreacionKahoot = new JPanel();
		add(panelTituloCreacionKahoot, BorderLayout.NORTH);
		
		btnEnrere = new JButton("Enrere");
		btnEnrere.setForeground(Color.RED);
		btnEnrere.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lbTituloCreacionKahoots = new JLabel("Crear Kahoot");
		lbTituloCreacionKahoots.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTituloCreacionKahoots.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbTituloCreacionKahoots.setBackground(Color.GRAY);
		GroupLayout gl_panelTituloCreacionKahoot = new GroupLayout(panelTituloCreacionKahoot);
		gl_panelTituloCreacionKahoot.setHorizontalGroup(
			gl_panelTituloCreacionKahoot.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTituloCreacionKahoot.createSequentialGroup()
					.addGap(23)
					.addComponent(btnEnrere, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(193)
					.addComponent(lbTituloCreacionKahoots, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(381, Short.MAX_VALUE))
		);
		gl_panelTituloCreacionKahoot.setVerticalGroup(
			gl_panelTituloCreacionKahoot.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTituloCreacionKahoot.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTituloCreacionKahoot.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEnrere, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbTituloCreacionKahoots))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panelTituloCreacionKahoot.setLayout(gl_panelTituloCreacionKahoot);
		
		
		
		
		

	}
	
	//Getters and Setters

	public JTextField getTfTitol() {
		return tfTitol;
	}

	public void setTfTitol(JTextField tfTitol) {
		this.tfTitol = tfTitol;
	}

	public JLabel getTxtTitol() {
		return txtTitol;
	}

	public void setTxtTitol(JLabel txtTitol) {
		this.txtTitol = txtTitol;
	}

	public JLabel getTxtLlistaPreguntes() {
		return txtLlistaPreguntes;
	}

	public void setTxtLlistaPreguntes(JLabel txtLlistaPreguntes) {
		this.txtLlistaPreguntes = txtLlistaPreguntes;
	}

	public JLabel getTxtNovaPregunta() {
		return txtNovaPregunta;
	}

	public void setTxtNovaPregunta(JLabel txtNovaPregunta) {
		this.txtNovaPregunta = txtNovaPregunta;
	}

	public JLabel getTxtTemesAso() {
		return txtTemesAso;
	}

	public void setTxtTemesAso(JLabel txtTemesAso) {
		this.txtTemesAso = txtTemesAso;
	}

	public JLabel getTxtRespostes() {
		return txtRespostes;
	}

	public void setTxtRespostes(JLabel txtRespostes) {
		this.txtRespostes = txtRespostes;
	}

	public JLabel getTxtResCorrecta() {
		return txtResCorrecta;
	}

	public void setTxtResCorrecta(JLabel txtResCorrecta) {
		this.txtResCorrecta = txtResCorrecta;
	}

	public JButton getBtnAfegirPregunta() {
		return btnAfegirPregunta;
	}

	public void setBtnAfegirPregunta(JButton btnAfegirPregunta) {
		this.btnAfegirPregunta = btnAfegirPregunta;
	}

	public JButton getBtnGuardarKahoot() {
		return btnGuardarKahoot;
	}

	public void setBtnGuardarKahoot(JButton btnGuardarKahoot) {
		this.btnGuardarKahoot = btnGuardarKahoot;
	}

	public JCheckBox getCb1() {
		return cbRespuesta1;
	}

	public void setCb1(JCheckBox cb1) {
		this.cbRespuesta1 = cb1;
	}

	public JCheckBox getCb2() {
		return cbRspuesta2;
	}

	public void setCb2(JCheckBox cb2) {
		this.cbRspuesta2 = cb2;
	}

	public JCheckBox getCb3() {
		return cbRespuesta3;
	}

	public void setCb3(JCheckBox cb3) {
		this.cbRespuesta3 = cb3;
	}

	public JCheckBox getCb4() {
		return cbRespuesta4;
	}

	public void setCb4(JCheckBox cb4) {
		this.cbRespuesta4 = cb4;
	}

	public JList getListPreguntas() {
		return listPreguntas;
	}

	public void setListPreguntas(JList listPreguntas) {
		this.listPreguntas = listPreguntas;
	}

	public JList getListTemesAso() {
		return listaTemasAsociados;
	}

	public void setListTemesAso(JList listTemesAso) {
		this.listaTemasAsociados = listTemesAso;
	}

	public JTextArea getTxtAreaRespostes() {
		return txtAreaRespostes;
	}

	public void setTxtAreaRespostes(JTextArea txtAreaRespostes) {
		this.txtAreaRespostes = txtAreaRespostes;
	}

	public JTextArea getTxtAreaPregunta() {
		return txtAreaNuevaPregunta;
	}

	public void setTxtAreaPregunta(JTextArea txtAreaPregunta) {
		this.txtAreaNuevaPregunta = txtAreaPregunta;
	}
	public JButton getBtnEnrere() {
		return btnEnrere;
	}

	public void setBtnEnrere(JButton btnEnrere) {
		this.btnEnrere = btnEnrere;
	}
	
	// Funcionalitats de la pantalla
	
	
	
	
	// Logica per guardar la pregunta
	
	

	public boolean checkNewPregunta(Preguntes pregunta1, ArrayList<Respostes> respostes) {
//		if(txtAreaRespostes.getLineCount()>1) {
		if(respostes.get(1) != null) {
			if(respostes.get(0).isRespostaCorrecta() || respostes.get(1).isRespostaCorrecta()) {
				System.out.println("Guardem la pregunta");
				saveNewPregunta(pregunta1, respostes);
				return true;
			} else {
				System.out.println("La pregunta no conté cap reposta correcta");
			}
		} else {
			System.out.println("La pregunta no te 2 o més respostes");
		}
		return false;
	}
	
	public void saveNewPregunta(Preguntes pregunta, ArrayList<Respostes> respostes) {
		pd.savePregunta(pregunta);
		long idPregunta = pregunta.getIdPreguntes();
		System.out.println(idPregunta);
		respostes.get(0).setIdPregunta(idPregunta);
		rd.saveResposta(respostes.get(0));
		respostes.get(1).setIdPregunta(idPregunta);
		rd.saveResposta(respostes.get(1));
		
	}
}
