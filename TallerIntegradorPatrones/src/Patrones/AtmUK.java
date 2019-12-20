/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class AtmUK {
    protected Currency currency;
    protected double dinero = 0;
    protected ArrayList <Manejador> manejadores; // Cada manejador puede entregar dinero de una sola denominación

    // -----------------
    public AtmUK() {
      manejadores = new ArrayList<Manejador>();
    }
    // -----------------
    public double getTotal() {
        return this.dinero;
    }

    // -----------------
    public void sacarDinero(double dinero) {
        this.dinero -= dinero;
        // Todo: realizar el proceso de sacar de cada manejador la cantidad requerida
    }

    // -----------------
    public void ingresarDinero(double dinero, float denominacion) {
        this.dinero += dinero;
        int temporal = (int) (dinero/denominacion);
        Manejador m;
        if((m = buscarManejador(denominacion)) != null) {
        	m.depositar(temporal, denominacion);
        } else {
        	m = new Manejador(temporal,denominacion);
        	addManejador(m);
        }
    }

    public void addManejador(Manejador m){
        manejadores.add(m);
    }
    public Manejador removeManejador(int i){
        return manejadores.remove(i);
    }
    
    public Manejador buscarManejador(float denominacion) {
    	for(Manejador manejador: this.manejadores) 
    		if(manejador.getDenominacion() == denominacion)
    			return manejador;
    	return null;
    }

    public ArrayList<Manejador> getManejadores() {
		return manejadores;
	}
	public void setManejadores(ArrayList<Manejador> manejadores) {
		this.manejadores = manejadores;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	

    
}
