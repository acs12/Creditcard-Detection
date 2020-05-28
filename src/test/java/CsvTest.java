import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class CsvTest {
	
	
	@Test
	public void test() throws Exception {
		Csv csv = new Csv();
		String csvFile = "D:\\Coding\\Repo\\individual-project-acs12\\Sample.csv";
		String outputFile = "D:\\Coding\\Repo\\individual-project-acs12\\Output.csv";
		csv.readWrite(csvFile,outputFile);
		
		BufferedReader csvReader = new BufferedReader(new FileReader(outputFile));
		ChainOfResponsibiltyClient cor = new ChainOfResponsibiltyClient();
		String row;
		ArrayList<String> expectedResult = new ArrayList<String>();
		for (int i = 0; (row = csvReader.readLine()) != null; i++) {
			if (i != 0) {
				String[] data = row.split(",");
				String result = cor.runTest(data[0]);
				System.out.println("Output is " + result);
				expectedResult.add(result);
			}
		}
		csvReader.close();
		assertEquals(new ArrayList<String>(Arrays.asList("MasterCard","VisaCard","AmericanExpressCard","Invalid")),expectedResult);
			
	}
}
