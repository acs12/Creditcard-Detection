import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class JsonTest {

	
	@Test
	public void test() throws IOException, ParseException {
		Json json = new Json();
		String jsonFile = "D:\\Coding\\Repo\\individual-project-acs12\\Sample.json";
		String outputFile = "D:\\Coding\\Repo\\individual-project-acs12\\Output.json";
		json.readWrite(jsonFile,outputFile);
		JSONParser parser = new JSONParser();
		FileReader read = new FileReader(outputFile);
		Object object = parser.parse(read);
		JSONArray listCard = (JSONArray) object;
		ArrayList<String> expectedOutput = new ArrayList<String>();
		for( Object card : listCard ) {
        	String particularCard= ((JSONObject) card).get("CardType").toString();
        	expectedOutput.add(particularCard);
        }
        assertEquals(new ArrayList<String>(Arrays.asList("MasterCard","VisaCard","AmericanExpressCard","Invalid")),expectedOutput);

	}

}
