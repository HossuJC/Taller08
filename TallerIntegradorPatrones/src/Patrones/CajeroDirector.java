package Patrones;

public class CajeroDirector {
	private CajeroBuilder builder;
	
	public CajeroDirector(CajeroBuilder builder) {
		this.builder = builder;
	}
	
	public void ConstruirCajero() {
		builder.DefinirCajero();
		builder.IngresarDinero();
		builder.CalcularMonto();
	}
	
	public AtmUK getCajero() {
		return builder.getCajero();
	}
}
