package Patrones;

public class ActualizadorDeposito extends Process{

	@Override
	public boolean execute(float amount, Account cuenta, AtmUK cajero) {
		cuenta.deposit(amount);
		float array[] = {20.0f, 10.0f,5.0f,1.0f,0.5f,0.25f,0.05f,0.01f};
		int temporal;
		for(int i =0; i<array.length; i++) {
			temporal = (int) (amount/array[i]);
			if(temporal > 0) {
				cajero.ingresarDinero(temporal*array[i], array[i]);
				amount -= temporal*array[i];
			}
		}
		return true;
	}

}
