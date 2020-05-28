
public class CC_Invalid extends CCState {


	 public CC_Invalid( CreditCardState ccs)
	    {
	        super( ccs ) ;
	    }

	    public void doValid() {
	        cc_state.setState( "Valid" );
	    }
	    
	    public void doReset() {
	        cc_state.setState( "Checking" );
	    }
	 
}
