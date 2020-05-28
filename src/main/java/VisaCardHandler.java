
public class VisaCardHandler implements CreditCardCompanyHandler {

	CreditCardState cc = new CreditCardState();
	private CreditCardCompanyHandler successor = null;

	public String handleRequest(String request) {
		System.out.println("VisaCardHandler got the request...");
		if (request.charAt(0) == '4' && request.matches("-?\\d+")) {
			System.out.println(this.getClass().getName() + " => This one is mine!");
			cc.checking();
			if (request.length() == 13 || request.length() == 16) {
				System.out.println("Visa Card length matches the requirement, hence it is a valid card.");
				cc.valid();
				cc.reset();
				return ("VisaCard");
			} else {
				System.out.println("Visa card length do not match the requirement, hence it is invalid card");
				cc.invalid();
				cc.reset();
				return ("Invalid");
			}

		} else {
			if (successor != null)
				return successor.handleRequest(request);
			else
				System.out.println("CardNumber is not of number type.");
				return "Invalid";
		}
	}

	public void setSuccessor(CreditCardCompanyHandler next) {
		this.successor = next;
	}
}
