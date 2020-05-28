
public class CC_Checking extends CCState {

	 public CC_Checking( CreditCardState ccs)
	    {
	        super( ccs ) ;
	    }

	    public void doValid() {
	        cc_state.setState( "Valid" );
	    }
	    
	    public void doInvalid() {
	        cc_state.setState( "Invalid" );
	    }
	    
	    public void doReset() {
	        cc_state.setState( "Checking" );
	    }

}
