/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Cala
 */
public class Practica4 {

    public static void main(String[] args) throws ESaldoNoValido, IOException, FileNotFoundException, ClassNotFoundException {
        MyList lista =new MyList();
        Programador p = new Programador(19,"Davilito",1200,2000,new Fecha(10,10,1994),200,19);
        lista.add(p,19);
        lista.add(new Programador(2,"Pablete",1200,2000,new Fecha(10,10,1994),200,2),2);
        lista.add(new Programador(8,"furrito",1200,2000,new Fecha(10,10,1994),200,8),8);
       lista.add(new Programador(7,"furrita",1200,2000,new Fecha(10,10,1994),200,8),7);
        lista.showMyList();
        System.out.println("\n");
        lista.Sort();
        
        lista.showMyList();
      System.out.println("\n");
        
      lista.Sort();
        
        lista.showMyList();
        
       // lista.saveData();
        
      
    }
    
    
    public static void deserializar() throws IOException, ClassNotFoundException{
        
        MyList nuevaLista = new MyList();
        
        ArrayList<Empleado> listita = nuevaLista.loadData("ruta");
       
        for(int i=0;i<listita.size();i++){
            nuevaLista.add(listita.get(i),listita.get(i).getNumero());
        }
       
        System.out.println("cargamos\n");
        nuevaLista.showMyList();
        
    }
    
}
