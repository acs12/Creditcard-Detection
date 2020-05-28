
public class Data {
	private Strategy strategy;
	private String inputFile;
	private String outputFile;
	
	public void SetFile(String i,String o) {
		inputFile = i;
		outputFile = o;
	}
	
	
	public void Execute() {
		try {
			strategy.readWrite(inputFile,outputFile);
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void ChangeStrategy(Strategy R) {
		strategy = R;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
