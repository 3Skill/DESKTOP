package clasesXML;
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


public class LecturaXML {
	public LecturaXML(){
		
	}
	
	//Preguntar si esta bien en public o protected
	public String[] lecturaConfigXML() throws ParserConfigurationException, SAXException {
		String[] array = new String[5];
		try {
			 
	         File file = new File("."+File.separator+"XML"+File.separator+"config.xml");
	         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	         DocumentBuilder db = dbf.newDocumentBuilder();
	         Document document = db.parse(file);
	         document.getDocumentElement().normalize();
	         //System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
	         NodeList nList = document.getElementsByTagName("configuration");
	         //System.out.println("----------------------------");
	         
	         array[0] = ((Element) nList.item(0)).getElementsByTagName("idioma").item(0).getTextContent();         
	         array[1] = ((Element) nList.item(0)).getElementsByTagName("tipus_preguntes").item(0).getTextContent(); 
	         array[2] = ((Element) nList.item(0)).getElementsByTagName("timeout").item(0).getTextContent(); 
	         array[3] = ((Element) nList.item(0)).getElementsByTagName("timeout").item(0).getTextContent(); 
	         array[4] = ((Element) nList.item(0)).getElementsByTagName("rutaXML").item(0).getTextContent(); 
	         
	         
	     }
	     catch(IOException e) {
	         System.out.println(e);
	         array = null;
	     } 
		 return array;
			
	}
	 
}


