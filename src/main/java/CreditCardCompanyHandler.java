
public interface CreditCardCompanyHandler {
	String handleRequest( String request );
	void setSuccessor(CreditCardCompanyHandler next);
}
