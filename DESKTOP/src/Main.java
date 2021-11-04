import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
//PENDIENTE:
//-Al iniciar el programa se tienen que alamcenar las etiquetas de la configuracion en variables
public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub
		LecturaXML lxml = new LecturaXML();
		lxml.lecturaConfigXML();
	}

}
