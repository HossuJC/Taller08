package Patrones;

public abstract class WithdrawProcess {
	private WithdrawProcess next;
	
	public WithdrawProcess linkWith(WithdrawProcess next) {
		this.next = next;
		return next;
	}
	
	public abstract boolean execute(float amount, Account cuenta, AtmUK cajero);
	
	public boolean executeNext(float amount, Account cuenta, AtmUK cajero) {
		if (next == null){
			return true;
		}
		return execute(amount, cuenta, cajero);
	}
}
