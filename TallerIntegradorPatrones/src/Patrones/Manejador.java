/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

public class Manejador
{
    protected int monto;
    protected float denominacion;

    public Manejador(int monto, float denominacion){
        this.monto = monto; // Total de billetes
        this.denominacion = denominacion; // Valor de cada billete
    }

    public int getMonto(){ return monto; }
    public float getDenominacion(){ return denominacion; }
    public void setMonto(int monto){ this.monto = monto; }

    public boolean retirar(int monto){
        if(this.monto < monto)
        	return false;
        this.monto -= monto;
        return true;
    }
    public boolean depositar(int monto, float denominacion){
        if (this.denominacion == denominacion)
        	return false;
        this.monto += monto;
        return true;
    }
}