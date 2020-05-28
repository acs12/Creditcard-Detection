import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlTest {


	@Test
	public void test() throws ParserConfigurationException, SAXException, IOException {
		Xml xml = new Xml();
		ChainOfResponsibiltyClient cor = new ChainOfResponsibiltyClient();
		String xmlFile = "D:\\Coding\\Repo\\individual-project-acs12\\Sample.xml";
		String outputFile = "D:\\Coding\\Repo\\individual-project-acs12\\Output.xml";
		xml.readWrite(xmlFile, outputFile);
		ArrayList<String> expectedResult = new ArrayList<String>();
		System.out.print("In Test");
		File file = new File(outputFile);
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
				System.out.println("result1" + result);
				expectedResult.add(result);
			}
		}
		
		assertEquals(new ArrayList<String>(Arrays.asList("MasterCard", "VisaCard", "AmericanExpressCard", "Invalid")),
				expectedResult);
	}

}
