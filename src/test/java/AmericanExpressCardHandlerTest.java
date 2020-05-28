import static org.junit.Assert.*;

import org.junit.Test;

public class AmericanExpressCardHandlerTest {
	
	AmericanExpressCardHandler amExCard = new AmericanExpressCardHandler();
	
	@Test
	public void test() {
		
		String result = amExCard.handleRequest("341000000000000");
		assertEquals("AmericanExpressCard",result);
		
	}
	
	@Test
	public void invalidTest() {
		String result = amExCard.handleRequest("341000000000000000");
		assertEquals("Invalid",result);
	}
	
	@Test
	public void invalidCardNumber() {
		String result = amExCard.handleRequest("341000000x#0000");
		assertEquals("Invalid",result);
	}

}
