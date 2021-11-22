package ParteSwing;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

import kadamm.hibernate.dao.KahootDao;
import kadamm.hibernate.model.Kahoot;

import javax.swing.JScrollPane;

public class PanelGestorKahoots extends JPanel {
	
	//Atributs
	private JButton btnJugar,btnCrearKahoot, btnVeureDetall, btnFiltarTema, btnEditarTemes;
	private JLabel tituloGestorKahoots, txtKahoots, txtTemes, txtTemesSeleccionats;
	private JList listaKahoots;
	private KahootDao kd = new KahootDao();
	//Constructor
	public PanelGestorKahoots() {
		
		//Configuracion Basica
		setLayout(new BorderLayout(0, 0));
		JPanel panelTitulo = new JPanel();
		add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setBackground(Color.gray);
		JPanel panelGestorKahoots = new JPanel();
		add(panelGestorKahoots, BorderLayout.CENTER);
		panelGestorKahoots.setLayout(null);
		panelGestorKahoots.setBackground(Color.white);
		
		//Annadimos todos los componentes
		tituloGestorKahoots = new JLabel("Explorador de Kahoots");
		tituloGestorKahoots.setFont(new Font("Tahoma", Font.BOLD, 19));
		panelTitulo.add(tituloGestorKahoots);
		
		txtKahoots = new JLabel("Kahoots");
		txtKahoots.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtKahoots.setBounds(74, 40, 120, 13);
		panelGestorKahoots.add(txtKahoots);
		
		txtTemes = new JLabel("Temes");
		txtTemes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTemes.setBounds(543, 40, 58, 13);
		panelGestorKahoots.add(txtTemes);
		
		txtTemesSeleccionats = new JLabel("Temes selecionats");
		txtTemesSeleccionats.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTemesSeleccionats.setBounds(543, 264, 149, 13);
		panelGestorKahoots.add(txtTemesSeleccionats);
		
		btnVeureDetall = new JButton("Veure Detall");
		btnVeureDetall.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVeureDetall.setBounds(36, 328, 184, 51);
		panelGestorKahoots.add(btnVeureDetall);
		
		btnJugar = new JButton("JUGAR");
		btnJugar.setForeground(Color.RED);
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnJugar.setBounds(160, 390, 189, 82);
		panelGestorKahoots.add(btnJugar);
		
		btnCrearKahoot = new JButton("Crear Kahoot");
		btnCrearKahoot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCrearKahoot.setBounds(261, 328, 184, 51);
		panelGestorKahoots.add(btnCrearKahoot);
		
		btnFiltarTema = new JButton("Filtrar per Tema");
		btnFiltarTema.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFiltarTema.setBounds(543, 404, 149, 29);
		panelGestorKahoots.add(btnFiltarTema);
		
		btnEditarTemes = new JButton("Editar Temes");
		btnEditarTemes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarTemes.setBounds(553, 443, 128, 29);
		panelGestorKahoots.add(btnEditarTemes);
		
//		String[] datos = {"nom Kahoot1", "nom Kahoot 2", "nom Kahoot 3", "nom Kahoot n"};       // Sustituido abajo por AL
		String[] datos1 = {"Tema 1", "Tema 2", "Tema 3", "Tema 4","Tema n"};
		String[] datos11 = {"Tema selcc 1", "Tema selecc 2", "Tema selecc 3", "Tema selecc n"};
		
		JScrollPane scrollPanelTemes = new JScrollPane();
		scrollPanelTemes.setBounds(543, 75, 149, 93);
		panelGestorKahoots.add(scrollPanelTemes);
		
		JList listaTemas = new JList(datos1);
		listaTemas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPanelTemes.setViewportView(listaTemas);
		
		JScrollPane scrollPanelKahoots = new JScrollPane();
		scrollPanelKahoots.setBounds(74, 75, 327, 222);
		panelGestorKahoots.add(scrollPanelKahoots);
		
		// Se ha sustituido el array estatico por uno dinamico que recoge los kahoots de BD con hibernate - Iwo
		ArrayList<Kahoot>kahoots = (ArrayList<Kahoot>) kd.getAllKahoots();
		String[] nomKahoots = new String[kahoots.size()];
		for (int i = 0; i < kahoots.size(); i++) {
			nomKahoots[i] = kahoots.get(i).getNom();
		}
		listaKahoots = new JList(nomKahoots);
		listaKahoots.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPanelKahoots.setViewportView(listaKahoots);
		listaKahoots.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPanelTemasSeleccionados = new JScrollPane();
		scrollPanelTemasSeleccionados.setBounds(543, 301, 149, 93);
		panelGestorKahoots.add(scrollPanelTemasSeleccionados);
		
		JList listaTemasSeleccionados = new JList(datos11);
		listaTemasSeleccionados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPanelTemasSeleccionados.setViewportView(listaTemasSeleccionados);
		
		JLabel lblFlechaKahoot = new JLabel("");
		lblFlechaKahoot.setBounds(584, 187, 74, 67);
		String sCarpAct = System.getProperty("user.dir");
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		
		Image miicono = mipantalla
				.getImage(sCarpAct + File.separator + "img" + File.separator +"images.jpg");

		Image dimg = miicono.getScaledInstance(70, 60, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblFlechaKahoot.setIcon(imageIcon);
		panelGestorKahoots.add(lblFlechaKahoot);
		
		
		
		
		
		

	}
	
	
	//Getters and Setters
	public JButton getBtnJugar() {
		return btnJugar;
	}
	public void setBtnJugar(JButton btnJugar) {
		this.btnJugar = btnJugar;
	}
	public JButton getBtnCrearKahoot() {
		return btnCrearKahoot;
	}
	public void setBtnCrearKahoot(JButton btnCrearKahoot) {
		this.btnCrearKahoot = btnCrearKahoot;
	}
	public JButton getBtnVeureDetall() {
		return btnVeureDetall;
	}
	public void setBtnVeureDetall(JButton btnVeureDetall) {
		this.btnVeureDetall = btnVeureDetall;
	}
	public JButton getBtnFiltarTema() {
		return btnFiltarTema;
	}
	public void setBtnFiltarTema(JButton btnFiltarTema) {
		this.btnFiltarTema = btnFiltarTema;
	}
	public JButton getBtnEditarTemes() {
		return btnEditarTemes;
	}
	public void setBtnEditarTemes(JButton btnEditarTemes) {
		this.btnEditarTemes = btnEditarTemes;
	}
	public JLabel getTxtTitulo() {
		return tituloGestorKahoots;
	}
	public void setTxtTitulo(JLabel txtTitulo) {
		this.tituloGestorKahoots = txtTitulo;
	}
	public JLabel getTxtKahoots() {
		return txtKahoots;
	}
	public void setTxtKahoots(JLabel txtKahoots) {
		this.txtKahoots = txtKahoots;
	}
	public JLabel getTxtTemes() {
		return txtTemes;
	}
	public void setTxtTemes(JLabel txtTemes) {
		this.txtTemes = txtTemes;
	}
	public JLabel getTxtTemesSeleccionats() {
		return txtTemesSeleccionats;
	}
	public void setTxtTemesSeleccionats(JLabel txtTemesSeleccionats) {
		this.txtTemesSeleccionats = txtTemesSeleccionats;
	}

	public String getListKahoots() {
		return (String) listaKahoots.getSelectedValue();
	}

	public void setListKahoots(JList listKahoots) {
		this.listaKahoots = listKahoots;
	}
	
	
}