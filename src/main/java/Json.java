import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json implements Strategy  {

	
	@SuppressWarnings("unchecked")
	public void readWrite(String inputFileName, String outputFileName) throws IOException, ParseException{
		ChainOfResponsibiltyClient cor = new ChainOfResponsibiltyClient();
		JSONParser parser = new JSONParser();
		FileReader read = new FileReader(inputFileName);
		Object object = parser.parse(read);
		JSONArray listCard = (JSONArray) object;
		JSONArray cardOutputList = new JSONArray();
        for( Object card : listCard ) {
        	String particularCard= parseObject( (JSONObject) card);
        	String result = cor.runTest(particularCard);
        	System.out.println("result "+ result);
        	cardOutputList.add(writeJson(particularCard, result));
        }
       System.out.println("output- "+ cardOutputList);
       @SuppressWarnings("resource")
		FileWriter writer = new FileWriter(outputFileName);
       writer.write(cardOutputList.toJSONString());
       writer.flush();
	}

	private String parseObject(JSONObject card) {
		return card.get("CardNumber").toString();
	}

	@SuppressWarnings("unchecked")
	private JSONObject writeJson(String card, String cardType) throws IOException {
		
		JSONObject details = new JSONObject();
        details.put("CardNumber",card);
        details.put("CardType",cardType);
        if(cardType == "Invalid")
        	details.put("Error", "InvalidCardNumber");
        else
        	details.put("Error", "None");
        
       return details;
        
	}

}