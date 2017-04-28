package learningTool;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HelperBuilder {
    
    private Node root;
    
    public HelperBuilder(){
        
        try {
            File fXmlFile = new File("src/learningTool/requirements.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            root = doc.getDocumentElement();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public Node getRoot() {
		return root;
	}
	
    public PatternHelper parse(Node n) {
		
		Element elem = (Element) n;
		PatternHelper ph;
		//if root
		if (elem.isSameNode(root)) {
			ph = new PatternComposite("I need help in choosing patterns"); // This is just because the constructor needs a question
		} else {
			ph = new PatternComposite(elem.getElementsByTagName("requirement").item(0).getTextContent());
		}
		
        NodeList nList = n.getChildNodes();
		for (int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				elem = (Element) node;
				if (node.getNodeName() == "composite") {
					ph.add(parse(node));
				} else if (node.getNodeName() == "leaf") {
					ph.add(new PatternNode(elem.getElementsByTagName("pattern").item(0).getTextContent()));
				}
			}
		}
		return ph;
    }
	
}
