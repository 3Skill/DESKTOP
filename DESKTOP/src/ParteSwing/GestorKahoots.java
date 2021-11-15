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
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class GestorKahoots extends JPanel {
	
	//Atributs
	private JButton btnJugar,btnCrearKahoot, btnVeureDetall, btnFiltarTema, btnEditarTemes;
	private JLabel txtTitulo, txtKahoots, txtTemes, txtTemesSeleccionats;
	private JList listKahoots;
	//Constructor
	public GestorKahoots() {
		
		//Configuracion Basica
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.gray);
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.white);
		
		//Annadimos todos los componentes
		txtTitulo = new JLabel("Explorador de Kahoots");
		txtTitulo.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel.add(txtTitulo);
		
		txtKahoots = new JLabel("Kahoots");
		txtKahoots.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtKahoots.setBounds(74, 40, 120, 13);
		panel_1.add(txtKahoots);
		
		txtTemes = new JLabel("Temes");
		txtTemes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTemes.setBounds(543, 40, 58, 13);
		panel_1.add(txtTemes);
		
		txtTemesSeleccionats = new JLabel("Temes selecionats");
		txtTemesSeleccionats.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTemesSeleccionats.setBounds(543, 264, 149, 13);
		panel_1.add(txtTemesSeleccionats);
		
		btnVeureDetall = new JButton("Veure Detall");
		btnVeureDetall.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVeureDetall.setBounds(36, 328, 184, 51);
		panel_1.add(btnVeureDetall);
		
		btnJugar = new JButton("JUGAR");
		btnJugar.setForeground(Color.RED);
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnJugar.setBounds(160, 390, 189, 82);
		panel_1.add(btnJugar);
		
		btnCrearKahoot = new JButton("Crear Kahoot");
		btnCrearKahoot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCrearKahoot.setBounds(261, 328, 184, 51);
		panel_1.add(btnCrearKahoot);
		
		btnFiltarTema = new JButton("Filtrar per Tema");
		btnFiltarTema.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFiltarTema.setBounds(543, 404, 149, 29);
		panel_1.add(btnFiltarTema);
		
		btnEditarTemes = new JButton("Editar Temes");
		btnEditarTemes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarTemes.setBounds(553, 443, 128, 29);
		panel_1.add(btnEditarTemes);
		
		String[] datos = {"nom Kahoot1", "nom Kahoot 2", "nom Kahoot 3", "nom Kahoot n"};
		String[] datos1 = {"Tema 1", "Tema 2", "Tema 3", "Tema 4","Tema n"};
		String[] datos11 = {"Tema selcc 1", "Tema selecc 2", "Tema selecc 3", "Tema selecc n"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(543, 75, 149, 93);
		panel_1.add(scrollPane);
		
		JList list_1 = new JList(datos1);
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(list_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(74, 75, 327, 222);
		panel_1.add(scrollPane_1);
		listKahoots = new JList(datos);
		listKahoots.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane_1.setViewportView(listKahoots);
		listKahoots.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(543, 301, 149, 93);
		panel_1.add(scrollPane_2);
		
		JList list_1_1 = new JList(datos11);
		list_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane_2.setViewportView(list_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(584, 187, 74, 67);
		String sCarpAct = System.getProperty("user.dir");
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		
		Image miicono = mipantalla
				.getImage(sCarpAct + File.separator + "img" + File.separator +"images.jpg");

		Image dimg = miicono.getScaledInstance(70, 60, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblNewLabel_2.setIcon(imageIcon);
		panel_1.add(lblNewLabel_2);
		
		
		
		
		
		

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
		return txtTitulo;
	}
	public void setTxtTitulo(JLabel txtTitulo) {
		this.txtTitulo = txtTitulo;
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
		return (String) listKahoots.getSelectedValue();
	}

	public void setListKahoots(JList listKahoots) {
		this.listKahoots = listKahoots;
	}
	
	
}