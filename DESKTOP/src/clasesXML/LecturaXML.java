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
	private String idioma,tipus_preguntes,timeout,num_max_preguntes,rutaXML;
	
	public LecturaXML() throws ParserConfigurationException, SAXException{
		try {
			 
	         File file = new File("."+File.separator+"XML"+File.separator+"config.xml");
	         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	         DocumentBuilder db = dbf.newDocumentBuilder();
	         Document document = db.parse(file);
	         document.getDocumentElement().normalize();
	         //System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
	         NodeList nList = document.getElementsByTagName("configuration");
	         //System.out.println("----------------------------");
	         
	         idioma = ((Element) nList.item(0)).getElementsByTagName("idioma").item(0).getTextContent();         
	         tipus_preguntes = ((Element) nList.item(0)).getElementsByTagName("tipus_preguntes").item(0).getTextContent(); 
	         timeout = ((Element) nList.item(0)).getElementsByTagName("timeout").item(0).getTextContent(); 
	         num_max_preguntes = ((Element) nList.item(0)).getElementsByTagName("num_max_preguntes").item(0).getTextContent(); 
	         rutaXML = ((Element) nList.item(0)).getElementsByTagName("rutaXML").item(0).getTextContent(); 
	         
	         
	     }
	     catch(IOException e) {
	         System.out.println(e);
	         
	     } 
		 
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getTipus_preguntes() {
		return tipus_preguntes;
	}

	public void setTipus_preguntes(String tipus_preguntes) {
		this.tipus_preguntes = tipus_preguntes;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getNum_max_preguntes() {
		return num_max_preguntes;
	}

	public void setNum_max_preguntes(String num_max_preguntes) {
		this.num_max_preguntes = num_max_preguntes;
	}

	public String getRutaXML() {
		return rutaXML;
	}

	public void setRutaXML(String rutaXML) {
		this.rutaXML = rutaXML;
	}
	
	
	 
}


