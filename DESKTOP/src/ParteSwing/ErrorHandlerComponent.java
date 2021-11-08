package ParteSwing;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ErrorHandlerComponent extends JPanel{
	private JLabel errorLabel;
	private JTextArea display;

	
	// Crea el component.
	 
	public ErrorHandlerComponent() {
		this.errorLabel = new JLabel("");
		this.setBorder ( new TitledBorder ( new EtchedBorder (), "Error Log" ) );
		
		// Crea els components d'area de text i el component Scroll

	    display = new JTextArea ( 2, 58 );
	    display.setEditable ( false ); 				// Estableix el textArea no-editable
	    display.setLineWrap(true);    				// Estableix el textArea per que salti de linia si ocupa tot l'espai
	    JScrollPane scroll = new JScrollPane ( display );
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

	    // Afegeix el component 
	    this.add ( scroll );
	}
	
	
	
	// Actualitza els missatges d'error
	public void actualitzaErrors(String errorMessage) {
        display.setText(display.getText() + "\n" + errorMessage);
    }
	
	// Recupera els missatges d'error
	public String getDisplay() {
		return this.display.getText();
	}

}



