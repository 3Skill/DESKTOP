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

	/**
	 * Create the panel.
	 */
	public GestorKahoots() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.gray);
		JLabel lblNewLabel = new JLabel("Explorador de Kahoots");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.white);
		JLabel lblNewLabel_1 = new JLabel("Kahoots");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(74, 40, 120, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Temes");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(543, 40, 58, 13);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Temes selecionats");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(543, 264, 149, 13);
		panel_1.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Veure Detall");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(36, 328, 184, 51);
		panel_1.add(btnNewButton);
		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.setForeground(Color.RED);
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnJugar.setBounds(160, 390, 189, 82);
		panel_1.add(btnJugar);
		
		JButton btnNewButton_1_1 = new JButton("Crear Kahoot");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_1.setBounds(261, 328, 184, 51);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Filtrar per Tema");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(543, 404, 149, 29);
		panel_1.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Editar Temes");
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1_1.setBounds(553, 443, 128, 29);
		panel_1.add(btnNewButton_1_1_1_1);
		
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
		JList list = new JList(datos);
		list.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane_1.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
}
