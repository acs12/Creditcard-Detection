
public class CC_Valid extends CCState {

	 public CC_Valid( CreditCardState ccs)
	    {
	        super( ccs ) ;
	    }

	    public void doInvalid() {
	        cc_state.setState( "Invalid" );
	    }
	    
	    public void doReset() {
	        cc_state.setState( "Checking" );
	    }

}
