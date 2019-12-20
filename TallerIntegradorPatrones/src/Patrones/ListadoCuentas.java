package Patrones;

import java.util.ArrayList;

public final class ListadoCuentas {
	
	private static ListadoCuentas instance;
	private ArrayList<Account> cuentas;
	
	private ListadoCuentas() {
		cuentas = new ArrayList<>();
	}
	
	public static ListadoCuentas getInstance() {
		if(instance == null) 
			instance = new ListadoCuentas();
		return instance;
	}
	
	public void loadDefaultAccounts() {
		for(int i=0; i<10;i++) 
			cuentas.add(new Account(i,(i+1)*100));
		
	}
	
	public String printCuentas() {
		StringBuilder retorno = new StringBuilder();
		for(Account account: cuentas) {
			retorno.append(account.getId()+") Cuenta "+account.getId()+": "+account.getAmount()+"\n");
		}
		return retorno.toString();
	}
	
	public Account getAccountById(int id) {
		return cuentas.get(id);
	}
}
