import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//Generar un ArrayList de Strings para paserselo al main cuand se habra la aplicacion

public class LecturaXML {
	public LecturaXML(){
		
	}
	
	//Intentar ver si se puede poner private
	public void lecturaConfigXML() throws ParserConfigurationException, SAXException {
		try {
	         File file = new File("."+File.separator+"XML"+File.separator+"config.xml");
	         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	         DocumentBuilder db = dbf.newDocumentBuilder();
	         Document document = db.parse(file);
	         document.getDocumentElement().normalize();
	         System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
	         NodeList nList = document.getElementsByTagName("configuration");
	         System.out.println("----------------------------");
	         
	                 
            System.out.println("Idioma : " + ((Element) nList.item(0)).getElementsByTagName("idioma").item(0).getTextContent());
            System.out.println("Tipus de Preguntes : " +((Element) nList.item(0)).getElementsByTagName("tipus_preguntes").item(0).getTextContent());
            System.out.println("Time out entre pregunta : " + ((Element) nList.item(0)).getElementsByTagName("timeout").item(0).getTextContent());
            System.out.println("NumMax preguntes : " + ((Element) nList.item(0)).getElementsByTagName("num_max_preguntes").item(0).getTextContent());
            System.out.println("Ruta XML de creacio de Kahoot : " + ((Element) nList.item(0)).getElementsByTagName("rutaXML").item(0).getTextContent());
	     }
	     catch(IOException e) {
	         System.out.println(e);
	     } 
	}
	 
}


