import static org.junit.Assert.*;

import org.junit.Test;

public class VisaCardHandlerTest {
	
	VisaCardHandler visaCard = new VisaCardHandler();
	
	@Test
	public void test() {
		
		String result = visaCard.handleRequest("4120000000000");
		assertEquals("VisaCard",result);
		
	}
	
	@Test
	public void invalidTest() {
		String result = visaCard.handleRequest("41200000000");
		assertEquals("Invalid",result);
	}
	
	@Test
	public void invalidCardNumber() {
		String result = visaCard.handleRequest("4120000a@0000");
		assertEquals("Invalid",result);
	}

}
