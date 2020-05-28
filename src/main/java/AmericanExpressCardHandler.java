
public class AmericanExpressCardHandler implements CreditCardCompanyHandler {

	private CreditCardCompanyHandler successor = null;
	CreditCardState cc = new CreditCardState();
	public String handleRequest( String request ) {
        System.out.println( "AmericanExpressCardhandler got the request...");
        if ( request.charAt(0) == '3' && (request.charAt(1) == '4' || request.charAt(1) == '7') && request.matches("-?\\d+"))
        {
            System.out.println( this.getClass().getName() + " => This one is mine!");
            cc.checking();
            if(request.length() == 15) {
            	System.out.println("AmEx Card length is 15, hence it is a valid card.");
            	cc.valid();
            	cc.reset();
            	return ("AmericanExpressCard");
            }
            else {
            	System.out.println("AmEx Card length is not equal to 15, hence it is invalid card.");
            	cc.invalid();
            	cc.reset();
            	return("Invalid");
            }
        }
        else
        {
            if ( successor != null )
                return successor.handleRequest(request);
            else {
            	System.out.println("Card Number is Invalid.");
            	cc.invalid();
            	cc.reset();
            	return ("Invalid");
            }
        }

	}

	public void setSuccessor(CreditCardCompanyHandler next) {
        this.successor = next ;
	}
}
