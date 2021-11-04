import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub
		LecturaXML lxml = new LecturaXML();
		String[] arrayConf = lxml.lecturaConfigXML();
		System.out.println("Idioma : " + arrayConf[0]);
        System.out.println("Tipus de Preguntes : " + arrayConf[1]);
        System.out.println("Time out entre pregunta : " + arrayConf[2]);
        System.out.println("NumMax preguntes : " + arrayConf[3]);
        System.out.println("Ruta XML de creacio de Kahoot : " + arrayConf[4]);
	}

}
