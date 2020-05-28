
public class CCState implements State {

	CreditCardState cc_state;
	 
	public CCState(CreditCardState ccs) {
        cc_state = ccs;
	}

	public void doValid() {
        System.out.println( "Valid is not valid in " + this.getClass().getName() + " state." );
	}

	public void doInvalid() {
        System.out.println( "Valid is not valid in " + this.getClass().getName() + " state." );
	}

	public void doChecking() {
        System.out.println(this.getClass().getName() + " state." );
	}
	
	public void doReset() {
        System.out.println("Reset is not valid in " + this.getClass().getName() + " state." );
	}
}
