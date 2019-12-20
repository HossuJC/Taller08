package Patrones;

public abstract class CajeroBuilder {
	protected AtmUK cajero;
	
	public AtmUK getCajero() {
		return cajero;
	}
	
	public abstract void DefinirCajero();
	public abstract void IngresarDinero();
	public abstract void CalcularMonto();
}
