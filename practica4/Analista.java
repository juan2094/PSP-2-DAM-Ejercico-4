/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica4;

import static com.mycompany.practica4.IFecha.AÑO;
import static com.mycompany.practica4.IFecha.DIA_DEL_MES;
import static com.mycompany.practica4.IFecha.MES_DEL_AÑO;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Cala
 */
public class Analista extends Empleado implements IFecha{
    
    private double plusAnual;
    private String sindicato;
    
    public Analista(int numero, String nombre, double sueldo, double sueldoMaximo, Fecha fecha,String sindicato,double plusAnual ) throws ESaldoNoValido {
        super(numero, nombre, sueldo, sueldoMaximo, fecha);
    this.plusAnual=plusAnual;
    this.sindicato=sindicato;
    }

    public double getPlusAnual() {
        return plusAnual;
    }

    public void setPlusAnual(double plusAnual) {
        this.plusAnual = plusAnual;
    }

    public String getSindicato() {
        return sindicato;
    }

    public void setSindicato(String sindicato) {
        this.sindicato = sindicato;
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

    @Override
    public String toString() {
        return super.toString()+"Analista{" + "plusAnual=" + plusAnual + ", sindicato=" + sindicato + '}';
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
