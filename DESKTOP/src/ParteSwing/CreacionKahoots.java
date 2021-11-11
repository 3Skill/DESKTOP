package ParteSwing;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
//ATTENTION:
//PUEDE SER QUE LOS JLIST ALFINAL SEAN JTEXTAREA
public class CreacionKahoots extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CreacionKahoots() {
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
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtol");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(62, 48, 46, 13);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(118, 47, 344, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Llista de preguntes");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(62, 116, 201, 13);
		panel.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 157, 400, 127);
		panel.add(scrollPane);
		
		String[] listaPreguntas = {"Text nova pregunta 1","Text nova pregunta 2","..."};
		String[] llistaNovaPregunta = {"Text de la nova pregunta"};
		String[] llistaTemesAssociats = {"Tema 1","Tema 2","Tema 3","Tema n","..."};
		String[] llistaRespostes = {"Resposta 1","Resposta 2","Resposta 3","Resposta 4"};
		
		JList list = new JList(listaPreguntas) ;
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nova Pregunta");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(62, 321, 201, 13);
		panel.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(62, 362, 400, 94);
		panel.add(scrollPane_1);
		
		JList list_1 = new JList(llistaNovaPregunta);
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblNewLabel_3 = new JLabel("Temes associats");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(514, 118, 151, 13);
		panel.add(lblNewLabel_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(514, 157, 161, 115);
		panel.add(scrollPane_2);
		
		JList list_2 = new JList(llistaTemesAssociats);
		list_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_2.setViewportView(list_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(516, 360, 161, 96);
		panel.add(scrollPane_3);
		
		JList list_3 = new JList(llistaRespostes);
		list_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_3.setViewportView(list_3);
		
		JLabel lblNewLabel_4 = new JLabel("Respostes");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(514, 323, 106, 13);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Afegir pregunta");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(155, 542, 181, 70);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guardar nou Kahoot");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(370, 542, 181, 70);
		panel.add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(718, 362, 21, 21);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_5 = new JLabel("Correcta");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(702, 323, 70, 13);
		panel.add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(718, 385, 21, 21);
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("");
		chckbxNewCheckBox_1_1.setBounds(718, 408, 21, 21);
		panel.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("");
		chckbxNewCheckBox_1_2.setBounds(718, 431, 21, 21);
		panel.add(chckbxNewCheckBox_1_2);

	}
}
