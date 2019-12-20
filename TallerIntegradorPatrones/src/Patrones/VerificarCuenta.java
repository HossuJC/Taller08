package Patrones;

public class VerificarCuenta extends WithdrawProcess {

	@Override
	public boolean execute(float amount, Account cuenta, AtmUK cajero) {
		if(amount > cuenta.getAmount() || amount == 0){
            System.out.println("You have insufficient funds\n\n");
            return false;
		}
		return executeNext(amount,cuenta,cajero);
	}
	
	
}
