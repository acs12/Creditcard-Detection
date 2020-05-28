
public class DiscoverCardHandler implements CreditCardCompanyHandler {
	
	CreditCardState cc = new CreditCardState();

	private CreditCardCompanyHandler successor = null;
	public String handleRequest( String request ) {
        System.out.println( "DiscoverCardHandler got the request...");
        if ( request.indexOf("6011") == 0 && request.matches("-?\\d+"))
        {
            System.out.println( this.getClass().getName() + " => This one is mine!");
            cc.checking();
            if(request.length() == 16){
            	System.out.println("Discover Card length is 16, hence it is valid card.");
            	cc.valid();
            	cc.reset();
            	return ("DiscoverCard");
            }
            else {
            	System.out.println("Discover Card length is not 16, hence it is invalid card.");
            	cc.invalid();
            	cc.reset();
            	return("Invalid");
            }
        }
        else
        {
            if ( successor != null )
                return successor.handleRequest(request);
            else
            	System.out.println("CardNumber is not of number type.");
				return "Invalid";
        }
	}

	public void setSuccessor(CreditCardCompanyHandler next) {
        this.successor = next ;
	}	
}
