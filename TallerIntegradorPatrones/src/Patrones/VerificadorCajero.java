package Patrones;

public class VerificadorCajero extends Process{

	@Override
	public boolean execute(float amount, Account cuenta, AtmUK cajero) {
		if(amount > cajero.getDinero()) {
			System.out.println("ATM have insufficient funds\n\n");
			return false;
		}
		return executeNext(amount,cuenta,cajero);
		
	}

}
