
public class MasterCardHandler implements CreditCardCompanyHandler {
	CreditCardState cc = new CreditCardState();

	private CreditCardCompanyHandler successor = null;

	public String handleRequest(String request) {
		System.out.println("MasterCardHandler got the request...");
		
		int result = Integer.parseInt(String.valueOf(request.charAt(1)));
		if (request.charAt(0) == '5' && result >= 1 && result <= 5 && request.matches("-?\\d+")) {
			System.out.println(this.getClass().getName() + " => This one is mine!");
			cc.checking();
			if (request.length() == 16) {
				System.out.println("Master Card length is 16, hence it is a valid card.");
				cc.valid();
				cc.reset();
				return ("MasterCard");

			} else {
				System.out.println("Master Card length is not 16, hence it is a valid card.");
				cc.invalid();
				cc.reset();
				return ("Invalid");
			}
		} else {
			if (successor != null)
				return successor.handleRequest(request);
			else {
				System.out.println("CardNumber is not of number type.");
				return "Invalid";
			}
		}
		
	}

	public void setSuccessor(CreditCardCompanyHandler next) {
		this.successor = next;
	}
}
