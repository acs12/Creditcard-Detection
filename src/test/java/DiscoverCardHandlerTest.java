import static org.junit.Assert.*;

import org.junit.Test;

public class DiscoverCardHandlerTest {
	
	DiscoverCardHandler discoverCard = new DiscoverCardHandler();
	
	@Test
	public void test() {
		
		String result = discoverCard.handleRequest("6011000000000000");
		assertEquals("DiscoverCard",result);
		
	}
	
	@Test
	public void invalidTest() {
		String result = discoverCard.handleRequest("60110000000000");
		assertEquals("Invalid",result);
	}
	
	@Test
	public void invalidCardNumber() {
		String result = discoverCard.handleRequest("601100000abc0000");
		assertEquals("Invalid",result);
	}

}
