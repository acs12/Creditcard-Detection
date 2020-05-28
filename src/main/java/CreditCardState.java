
public class CreditCardState {

	State ValidState;
    State InvalidState;
    State CheckingState;
    State currentState;
    
    public CreditCardState()
    {
        ValidState = new CC_Valid(this);
        InvalidState = new CC_Invalid(this);
        CheckingState = new CC_Checking(this);
        currentState = CheckingState;
    }
	 
	public void valid() {
        System.out.println( "Valid...");
	    currentState.doValid();
	}
	 
	public void invalid() {
        System.out.println( "Invalid...");
	    currentState.doInvalid();
	}
	 
	public void checking() {
        System.out.println( "Checking...");
	    currentState.doChecking();
	}
	 
	public void reset() {
        System.out.println( "Reset...");
	    currentState.doReset();
	}
	 
	void setState(String nextState) {
        switch( nextState ) {
            case "Valid" : currentState = ValidState ; 
            break ;
            
            case "Invalid" : currentState =  InvalidState; 
            break ;
            
            case "Checking" : currentState = CheckingState ; 
            break ;
        }

	}
    
    public void showState()
    {
        System.out.println( "Current State: " + currentState.getClass().getName());
    }
}
