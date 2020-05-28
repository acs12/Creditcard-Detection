import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Xml implements Strategy {
	public void readWrite(String input, String outputFile) {
		ChainOfResponsibiltyClient cor = new ChainOfResponsibiltyClient();
		try {
			File file = new File(input);
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			Document output = db.newDocument();

			Element root = output.createElement("root");
            output.appendChild(root);
			doc.getDocumentElement().normalize();
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("row");

			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				System.out.println("\nNode Name :" + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					String data = eElement.getElementsByTagName("CardNumber").item(0).getTextContent();

					String result = cor.runTest(data);
					System.out.println("result " + result);
			                  
		            Element row = output.createElement("row");          
		            root.appendChild(row);
		            
		            Element CardNumber = output.createElement("CardNumber");
		            CardNumber.appendChild(output.createTextNode(data));
		            row.appendChild(CardNumber);
		            if(result.contentEquals("Invalid")) {
		            	// CardType element
			            Element CardType = output.createElement("CardType");
			            CardType.appendChild(output.createTextNode("Null"));
			            row.appendChild(CardType);
			 
			            // Error element
			            Element Error = output.createElement("Error");
			            Error.appendChild(output.createTextNode(result));
			            row.appendChild(Error);
		            }
		            else {
		            	// CardType element
			            Element CardType = output.createElement("CardType");
			            CardType.appendChild(output.createTextNode(result));
			            row.appendChild(CardType);
			 
			            // Error element
			            Element Error = output.createElement("Error");
			            Error.appendChild(output.createTextNode("Null"));
			            row.appendChild(Error);
		            }
		            
				}
			}
			
			// create the xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(output);
            StreamResult streamResult = new StreamResult(new File(outputFile));
            transformer.transform(domSource, streamResult);
            System.out.println("XML File Created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}