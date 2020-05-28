import java.util.Scanner;
public class Main {

	public static void main(String[] args){
		Data data = new Data();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter File Location Path:---> \n");
		String location = sc.nextLine();
		System.out.println("Enter Input File Name With Extension(.csv , .json , .xml) :---> \n");
		String input = sc.nextLine();
		String ext = input.substring(input.lastIndexOf("."));
		System.out.println("Enter Output File Name :---> \n");
		String out = sc.nextLine();
		out = location + "\\" + out + ext;
		String s = location + "\\" + input;
		System.out.println("out"+ out);
		switch (ext) {
		case ".csv":
			data.ChangeStrategy(new Csv());
			data.SetFile(s,out);
			data.Execute();
			break;
		case ".json":
			data.ChangeStrategy(new Json());
			data.SetFile(s,out);
			data.Execute();
			break;
		case ".xml":
			data.ChangeStrategy(new Xml());
			data.SetFile(s,out);
			data.Execute();
			break;
		default :
			System.out.println("Invalid Extension");
		}
	}

}
