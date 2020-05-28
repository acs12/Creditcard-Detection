import static org.junit.Assert.*;

import org.junit.Test;

public class MasterCardHandlerTest {
	
	MasterCardHandler masterCard = new MasterCardHandler();
	CreditCardState cc = new CreditCardState();

	@Test
	public void test() {
		
		String result = masterCard.handleRequest("5410000000000000");
		assertEquals("MasterCard",result);		
	
	}
	
	@Test
	public void invalidTest() {
		String result = masterCard.handleRequest("54100000000000");
		assertEquals("Invalid",result);
	}

	@Test
	public void invalidCardNumber() {
		String result = masterCard.handleRequest("5410000ab0000000");
		assertEquals("Invalid",result);
	}
}
