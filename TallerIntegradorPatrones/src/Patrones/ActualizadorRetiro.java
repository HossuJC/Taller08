package Patrones;

public class ActualizadorRetiro extends Process{

	@Override
	public boolean execute(float amount, Account cuenta, AtmUK cajero) {
		cuenta.withdraw(amount);
		cajero.sacarDinero(amount);
		return executeNext(amount,cuenta,cajero);
	}

}
