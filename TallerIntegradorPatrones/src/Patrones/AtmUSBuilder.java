package Patrones;

import java.util.Currency;
import java.util.Locale;

public class AtmUSBuilder extends CajeroBuilder {

	@Override
	public void DefinirCajero() {
		cajero = new AtmUK();
		cajero.setCurrency(Currency.getInstance(Locale.US));
	}

	@Override
	public void IngresarDinero() {
		Manejador m1 = new Manejador(100,20.0f);
		Manejador m2 = new Manejador(100,10.0f);
		Manejador m3 = new Manejador(10,0.5f);
		Manejador m4 = new Manejador(10,0.25f);
		Manejador m5 = new Manejador(1000,0.05f);
		cajero.addManejador(m1);
		cajero.addManejador(m2);
		cajero.addManejador(m3);
		cajero.addManejador(m4);
		cajero.addManejador(m5);
	}

	@Override
	public void CalcularMonto() {
		double monto = 0;
		for(Manejador manejador: cajero.getManejadores()) {
			monto += (double)(manejador.getMonto() * manejador.getDenominacion());
		}
		cajero.setDinero(monto);
		
	}

}
