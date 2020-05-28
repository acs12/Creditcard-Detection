import java.io.*;

public class Csv implements Strategy {
	public void readWrite(String csvFile, String outputFile) throws Exception {
		BufferedReader csvReader = new BufferedReader(new FileReader(csvFile));
		String row;
		FileWriter csvWriter = new FileWriter(outputFile);
		ChainOfResponsibiltyClient cor = new ChainOfResponsibiltyClient();
		csvWriter.append("Card Number");
		csvWriter.append(",");
		csvWriter.append("Card Type");
		csvWriter.append(",");
		csvWriter.append("Error");
		csvWriter.append("\n");
		for (int i = 0; (row = csvReader.readLine()) != null; i++) {
			if (i != 0) {
				String[] data = row.split(",");
				System.out.println(data[0] + " " + data[1] + " " + data[2]);
				String result = cor.runTest(data[0]);
				System.out.println("result " + result);
				csvWriter.append(data[0]);
				csvWriter.append(",");
				if(result.contentEquals("Invalid")) {
					csvWriter.append("Null");
					csvWriter.append(",");
					csvWriter.append(result);
				}
				else {
					csvWriter.append(result);
					csvWriter.append(",");
					csvWriter.append("Null");
				}
				csvWriter.append("\n");
			}
		}
		csvReader.close();
		csvWriter.flush();
		csvWriter.close();
	}
}
