/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica4;

import java.util.GregorianCalendar;

/**
 *
 * @author Cala
 */
public class Programador extends Empleado implements IFecha {
    
    private double extraMensual;
    private int programasEscritos;
    
    public Programador(int numero, String nombre, double sueldo, double sueldoMaximo, Fecha fecha,double extraMensual, int programasEscritos) throws ESaldoNoValido {
        super(numero, nombre, sueldo, sueldoMaximo, fecha);
    this.extraMensual=extraMensual;
    this.programasEscritos=programasEscritos;
    }

    @Override
    public int dia() {
       GregorianCalendar fechaActual = new GregorianCalendar();
    return fechaActual.get(DIA_DEL_MES);
    }

    @Override
    public int mes() {
        GregorianCalendar fechaActual = new GregorianCalendar();
    return fechaActual.get(MES_DEL_AÑO)+1;
    }

    @Override
    public int año() {
        GregorianCalendar fechaActual = new GregorianCalendar();
    return fechaActual.get(AÑO);
    }
    
    @Override
    public boolean cumpleMes(){
       
        return this.dia()==this.getFecha().getDia();
    }
    
    @Override
    public boolean cumpleAños(){
 
        return this.dia()==this.getFecha().getDia() && this.mes()==this.getFecha().getMes();
    }

    public double getExtraMensual() {
        return extraMensual;
    }

    public void setExtraMensual(double extraMensual) {
        this.extraMensual = extraMensual;
    }

    public int getProgramasEscritos() {
        return programasEscritos;
    }

    public void setProgramasEscritos(int programasEscritos) {
        this.programasEscritos = programasEscritos;
    }

    @Override
    public String toString() {
        return super.toString()+"Programador{" + "extraMensual=" + extraMensual + ", programasEscritos=" + programasEscritos + '}';
    }

    @Override
    public int compareTo(Object o) {
        
        Empleado aux=(Empleado) o;
        
        if(this.getNumero()>aux.getNumero())
            return 1;
        else if(this.getNumero()==aux.getNumero())
            return 0;
        else
            return -1;
    }
    
}
