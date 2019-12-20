/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Crear un único cajero Automático de dólares con 100 billetes de 20, 100 de 10, 
        // 10 monedas de 0.50, 10 de 0.25 y 1000 de 0.05
    	CajeroDirector c = new CajeroDirector(new AtmUSBuilder());
    	c.ConstruirCajero();
    	AtmUK cajero = c.getCajero();
    	
        // Crear 10 cuentas nuevas en dólares locale.US con un saldo inicial entre 100.00 y 1000.00 USD cada una.
        ListadoCuentas cuentas = ListadoCuentas.getInstance();
        cuentas.loadDefaultAccounts();
        Scanner sc = new Scanner(System.in);
    	
        // Menú principal para seleccionar una de las 10 cuentas solo con el id
        System.out.println("Se muestran las siguientes cuentas predefinidas: ");
        System.out.println(cuentas.printCuentas());
        System.out.print("Escoja una de ellas para continuar con la ejecucion: ");
        int opt = sc.nextInt();
        // Mostrar el menú para realizar transacciones en el cajero automático
        Account cuentaElegida = cuentas.getAccountById(opt);
        SistemaCajero.transaction(cuentaElegida, cajero);
    }

    
}
