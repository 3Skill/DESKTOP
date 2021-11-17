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

public class CreacionKahoots extends JPanel {
	
	//Atributs
	private JTextField tfTitol;
	private JLabel txtTitol, txtLlistaPreguntes,txtNovaPregunta, txtTemesAso, txtRespostes, txtResCorrecta;
	private JButton btnAfegirPregunta, btnGuardarKahoot;
	private JCheckBox cb1,cb2,cb3,cb4;
	private JList listPreguntas,listTemesAso;
	private JTextArea txtAreaRespostes, txtAreaPregunta;
	private PreguntesDao pd = new PreguntesDao();
	private RespostesDao rd = new RespostesDao();
	
	
	//Constructor
	public CreacionKahoots() {
		
		//Confg general del panel
		setLayout(new BorderLayout(0, 0));
		JLabel lblNewLabel = new JLabel("Crear Kahoot");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//Titol
		txtTitol = new JLabel("T\u00EDtol");
		txtTitol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTitol.setBounds(62, 48, 46, 13);
		panel.add(txtTitol);
		
		tfTitol = new JTextField();
		tfTitol.setBounds(118, 47, 344, 19);
		panel.add(tfTitol);
		tfTitol.setColumns(10);
		
		txtLlistaPreguntes = new JLabel("Llista de preguntes");
		txtLlistaPreguntes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLlistaPreguntes.setBounds(62, 116, 201, 13);
		panel.add(txtLlistaPreguntes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 157, 400, 127);
		panel.add(scrollPane);
		
		String[] listaPreguntas = {"Text nova pregunta 1","Text nova pregunta 2","..."};
		String[] llistaNovaPregunta = {"Text de la nova pregunta"};
		String[] llistaTemesAssociats = {"Tema 1","Tema 2","Tema 3","Tema n","..."};
		String[] llistaRespostes = {"Resposta 1","Resposta 2","Resposta 3","Resposta 4"};
		
		listPreguntas = new JList(listaPreguntas) ;
		listPreguntas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(listPreguntas);
		
		txtNovaPregunta = new JLabel("Nova Pregunta");
		txtNovaPregunta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNovaPregunta.setBounds(62, 321, 201, 13);
		panel.add(txtNovaPregunta);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(62, 362, 400, 94);
		panel.add(scrollPane_1);
		
		txtAreaPregunta = new JTextArea();
		scrollPane_1.setViewportView(txtAreaPregunta);
		
		txtTemesAso = new JLabel("Temes associats");
		txtTemesAso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTemesAso.setBounds(514, 118, 151, 13);
		panel.add(txtTemesAso);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(514, 157, 161, 115);
		panel.add(scrollPane_2);
		
		listTemesAso = new JList(llistaTemesAssociats);
		listTemesAso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_2.setViewportView(listTemesAso);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(516, 360, 161, 96);
		panel.add(scrollPane_3);
		
		txtAreaRespostes = new JTextArea();
		scrollPane_3.setViewportView(txtAreaRespostes);
		
		txtRespostes = new JLabel("Respostes");
		txtRespostes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRespostes.setBounds(514, 323, 106, 13);
		panel.add(txtRespostes);
		
		//Botones
		btnAfegirPregunta = new JButton("Afegir pregunta");
		btnAfegirPregunta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAfegirPregunta.setBounds(155, 542, 181, 70);
		panel.add(btnAfegirPregunta);
		
		btnAfegirPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Objectes de test
				Preguntes pregunta1 = new Preguntes("Es correcte la pregunta?", 4);
				ArrayList<Respostes> respostes = new ArrayList<Respostes>();
				Respostes resposta1 = new Respostes("Es correcte", true, 19);
				Respostes resposta2 = new Respostes("Es incorrecte", false, 19);
				respostes.add(resposta1);
				respostes.add(resposta2);
				checkNewPregunta(pregunta1, respostes);
				saveNewPregunta(pregunta1, respostes);
				
			}
		});
		
		btnGuardarKahoot = new JButton("Guardar nou Kahoot");
		btnGuardarKahoot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGuardarKahoot.setBounds(370, 542, 181, 70);
		panel.add(btnGuardarKahoot);
		
		
		//Parte de Respuestas posibles
		txtResCorrecta = new JLabel("Correcta");
		txtResCorrecta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtResCorrecta.setBounds(702, 323, 70, 13);
		panel.add(txtResCorrecta);
		
		cb1 = new JCheckBox("");
		cb1.setBounds(718, 362, 21, 21);
		panel.add(cb1);
		
		cb2 = new JCheckBox("");
		cb2.setBounds(718, 385, 21, 21);
		panel.add(cb2);
		
		cb3 = new JCheckBox("");
		cb3.setBounds(718, 408, 21, 21);
		panel.add(cb3);
		
		cb4 = new JCheckBox("");
		cb4.setBounds(718, 431, 21, 21);
		panel.add(cb4);
		
		
		
		
		

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
		return cb1;
	}

	public void setCb1(JCheckBox cb1) {
		this.cb1 = cb1;
	}

	public JCheckBox getCb2() {
		return cb2;
	}

	public void setCb2(JCheckBox cb2) {
		this.cb2 = cb2;
	}

	public JCheckBox getCb3() {
		return cb3;
	}

	public void setCb3(JCheckBox cb3) {
		this.cb3 = cb3;
	}

	public JCheckBox getCb4() {
		return cb4;
	}

	public void setCb4(JCheckBox cb4) {
		this.cb4 = cb4;
	}

	public JList getListPreguntas() {
		return listPreguntas;
	}

	public void setListPreguntas(JList listPreguntas) {
		this.listPreguntas = listPreguntas;
	}

	public JList getListTemesAso() {
		return listTemesAso;
	}

	public void setListTemesAso(JList listTemesAso) {
		this.listTemesAso = listTemesAso;
	}

	public JTextArea getTxtAreaRespostes() {
		return txtAreaRespostes;
	}

	public void setTxtAreaRespostes(JTextArea txtAreaRespostes) {
		this.txtAreaRespostes = txtAreaRespostes;
	}

	public JTextArea getTxtAreaPregunta() {
		return txtAreaPregunta;
	}

	public void setTxtAreaPregunta(JTextArea txtAreaPregunta) {
		this.txtAreaPregunta = txtAreaPregunta;
	}
	
	// Funcionalitats de la pantalla
	
	
	
	
	// Logica per guardar la pregunta
	
	public boolean checkNewPregunta(Preguntes pregunta1, ArrayList<Respostes> respostes) {
//		if(txtAreaRespostes.getLineCount()>1) {
		if(respostes.size()>1) {
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
//		long idPregunta = pregunta.getIdPreguntes();
		rd.saveResposta(respostes.get(0));
		rd.saveResposta(respostes.get(1));
		
	}
	
	
	
	
}
