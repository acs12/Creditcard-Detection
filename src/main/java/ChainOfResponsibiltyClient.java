
public class ChainOfResponsibiltyClient {

	public String runTest(String s) {
		
		CreditCardCompanyHandler h1 = new MasterCardHandler();
		CreditCardCompanyHandler h2 = new VisaCardHandler();
		CreditCardCompanyHandler h3 = new DiscoverCardHandler();
		CreditCardCompanyHandler h4 = new AmericanExpressCardHandler();

		h1.setSuccessor(h2);
		h2.setSuccessor(h3);
		h3.setSuccessor(h4);

		System.out.println("Sending Card Number to MasterCardHandler...");
		return h1.handleRequest(s);
		
	}

}
