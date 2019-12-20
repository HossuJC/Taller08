package Patrones;

import java.util.Scanner;

public class SistemaCajero {
	
	private SistemaCajero() {}
	
	//Dentro de las transacciones se debe llamar al ATM para hacer el retiro o deposito de la cuenta correspondiente
    public static void transaction(Account cuenta, AtmUK cajero){
        // here is where most of the work is
        int choice; 
        System.out.println("Please select an option"); 
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Balance ATM");
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        Process process;
        switch(choice){
            case 1:
                	float amount; 
                	System.out.println("Please enter amount to withdraw: "); 
                	amount = in.nextFloat();
                	process = new VerificarCuenta();
                	process.linkWith(new VerificadorCajero()).linkWith(new ActualizadorRetiro());
                	if(process.execute(amount, cuenta, cajero))
                	System.out.println("You have withdrawn " +amount+" and your new balance is "+cuenta.getAmount());
                	else
                		System.out.println("Error in transaction");
                	anotherTransaction(cuenta,cajero); 
                	break; 
            case 2:
                    // option number 2 is depositing 
                    float deposit; 
                    System.out.println("Please enter amount you would wish to deposit: "); 
                    deposit = in.nextFloat();
                    process = new ActualizadorDeposito();
                    if(process.execute(deposit, cuenta, cajero))
                    	System.out.println("You have deposit " +deposit+" and your new balance is "+cuenta.getAmount());
                    else
                        System.out.println("Error in transaction");
                    anotherTransaction(cuenta,cajero);
                    break; 
            case 3:
            		System.out.println("Your new balance is "+cuenta.getAmount());
                    anotherTransaction(cuenta,cajero); 
                    break;
            case 4:
            		System.out.println("ATM balance is: ");
            		for(Manejador manejador: cajero.getManejadores()) {
            			if(manejador.getMonto() > 0)
            			System.out.println("Numero de billetes de "+manejador.getDenominacion()+" es: "+manejador.getMonto());	
            		}
            		System.out.println("Total del cajero: "+cajero.getDinero());
                    anotherTransaction(cuenta,cajero); 
            break;
            default:
                    System.out.println("Invalid option:\n\n"); 
                    anotherTransaction(cuenta,cajero);
            break;
        }
    }
    public static void anotherTransaction(Account cuenta, AtmUK cajero){
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        Scanner in = new Scanner(System.in);	
        int anotherTransaction = in.nextInt();
        if(anotherTransaction == 1){
            transaction(cuenta,cajero); // call transaction method
        } else if(anotherTransaction == 2){
            System.out.println("Thanks for choosing us. Good Bye!");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction(cuenta, cajero);
        }
    }
}
