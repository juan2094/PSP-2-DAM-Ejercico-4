/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica4;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Cala
 */
public abstract class Empleado implements Serializable,java.lang.Comparable {
    
    private int numero;
    private transient String nombre; 
    private double sueldo;
    private double sueldoMaximo;
    private Fecha fecha;
    
    public Empleado(int numero, String nombre, double sueldo, double sueldoMaximo,Fecha fecha)throws ESaldoNoValido{
        
        if(sueldo > sueldoMaximo){
            throw new ESaldoNoValido ("El sueldo sobrepasa el sueldo maximo");
        }
        else{
        this.numero=numero;
        this.nombre=nombre;
        this.sueldo=sueldo;
        this.sueldoMaximo=sueldoMaximo;
        this.fecha=fecha; 
        }
    };

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) throws ESaldoNoValido{
        if(sueldo > sueldoMaximo){
            throw new ESaldoNoValido ("El sueldo sobrepasa el sueldo maximo");
        }
        else
        this.sueldo = sueldo;
    }

    public double getSueldoMaximo() {
        return sueldoMaximo;
    }

    public void setSueldoMaximo(double sueldoMaximo)throws ESaldoNoValido {
        if(sueldoMaximo<sueldo){
            throw new ESaldoNoValido ("El sueldo sobrepasa el sueldo maximo");
        }
        else
        this.sueldoMaximo = sueldoMaximo;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Empleado{" + "numero=" + numero + ", nombre=" + nombre + ", sueldo=" + sueldo + ", sueldoMaximo=" + sueldoMaximo + ", fecha=" + fecha + '}';
    }
    
}
