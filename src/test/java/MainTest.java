import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class MainTest {

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void test() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter File Location Path:---> \n");
		String location = sc.nextLine();
		System.out.println("Enter Input File Name With Extension(.csv , .json , .xml) :---> \n");
		String input = sc.nextLine();
		String ext = input.substring(input.lastIndexOf("."));
		System.out.println("Enter Output File Name :---> \n");
		String out = sc.nextLine();
		out = location + out + ext;
		System.out.println("out" + out);
		switch (ext) {
		case ".csv":
			assertEquals(ext , ".csv");
			break;
		case ".json":
			assertEquals(ext , ".json");
			break;
		case ".xml":
			assertEquals(ext , ".xml");
			break;
		default:
			equals(ext != "!.xml" || ext != "!.csv" || ext != ".json");
			System.out.println("Invalid Extension");
		}
	}
}
