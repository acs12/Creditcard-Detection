
public interface State {
		public abstract void doValid();
		public abstract void doInvalid();
		public abstract void doChecking();
		public abstract void doReset();
}
