package Patrones;

public class ActualizadorCuenta extends WithdrawProcess{

	@Override
	public boolean execute(float amount, Account cuenta, AtmUK cajero) {
		cuenta.withdraw(amount);
		cajero.sacarDinero(amount);
		return executeNext(amount,cuenta,cajero);
	}

}
