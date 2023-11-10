package com.mycompany.practica4;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class MyList <E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private Node<E> actualNode;
    private int contador = 0;
    
    public MyList(){
        this.firstNode = null;
        this.lastNode = null;
        this.actualNode = null;
        
    }
    
    public void showMyList(){
        Node<E> temporary = this.firstNode;
        while (temporary != null){
         //   System.out.println(temporary.getMain());
            System.out.println(temporary.getMain().toString());
            temporary=temporary.getNextNode();
        }
    }
    
    public void add(E p,int numEmp){
        
        this.contador++;
        Node<E> newNode = new Node(p,numEmp);
        
        //creas empleado 1 y lo añades
        
        if(firstNode == null){
            this.firstNode = newNode;
            this.lastNode = newNode;
    
        }else{
            
            lastNode.setNextNode(newNode);
            newNode.setPreviousNode(lastNode);
            lastNode = newNode;
        }
        this.actualNode = lastNode;
    }
    
    
    public void removeElement(){

        //no se ni como lo he hecho
        
        if(actualNode == firstNode){
            firstNode = actualNode.nextNode;
        }else if(actualNode == lastNode){
            lastNode = actualNode.previousNode;
        }else{
            actualNode.previousNode.setNextNode(actualNode.nextNode);
            actualNode.nextNode.setPreviousNode(actualNode.previousNode);
        }
           
        
    }
    
    public void nextNode(){
        this.actualNode = actualNode.previousNode;
    }
    
    public void previousNode(){
        this.actualNode = actualNode.nextNode;
    }
    
    
    public boolean isFirst(){
        return (actualNode == firstNode);
    }
    
    public boolean isLast(){
        return (actualNode == lastNode);
    }

    
    public Node<E> getFirstNode() {
        return firstNode;
    }
    
    public void goFirstNode(){
        
        this.actualNode=this.lastNode;
        
    }

    public void setFirstNode(Node<E> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<E> getLastNode() {
        return lastNode;
    }
    
    public void goLastNode(){
        this.actualNode=this.firstNode;
    }

    public void setLastNode(Node<E> lastNode) {
        this.lastNode = lastNode;
    }

    public Node<E> getActualNode() {
        return actualNode;
    }

    public void setActualNode(Node<E> actualNode) {
        this.actualNode = actualNode;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public boolean exist(int numEmp){
        
        Node Temporary = this.firstNode;
        
        do{
        if(Temporary.index==numEmp){
            return true;
        }
        else 
           Temporary= Temporary.getNextNode();
        }while(Temporary!=null);
        return false;
        
    }
    
   
    
    public void interCambiar(int num1,int num2){
        
        int con=0;
        Node recorre = this.firstNode;
        
        Node aux = null;
        Node aux2 = null;
        int indice;

        if(exist(num1) && exist(num2)){
     
            while(recorre != null){
                
                if(recorre.index==num1){
                   aux=recorre;
                }
                if(recorre.index==num2){
                    aux2=recorre;
                }
                recorre=recorre.getNextNode();
            }
            
           E intercambio = (E) aux.getMain();
           int indi =aux.index;
           aux.setMain(aux2.getMain());
           aux.setIndex(aux2.getIndex());
           
           aux2.setMain(intercambio);
           aux2.setIndex(indi);
           
        }
        else{
            System.out.println("Uno de los dos no existe");
        }

    }
    
    public void sortAndres(){
        
         boolean swapped = false;
        int listSize = this.contador-1;
        do{
            swapped= false;
            Node<E> node1 = this.firstNode;
            Node<E> node2  = node1.getNextNode();
            for(int i=0;i<listSize;i++){
                if(node1.getIndex()>node2.getIndex()){
                    intercambiarMain(node1,node2);
                    swapped = true;
                }
                node1 = node1.getNextNode();
                node2 = node2.getNextNode();
            }
            System.out.println("QUEDAN "+listSize+" LINEAS");
            listSize--;
        }while(swapped);
        
    }
    public void intercambiarMain(Node n1, Node n2){
        Node<E> node1 = n1;
        Node<E> node2 = n2;

        int indexAux = node1.getIndex();
        node1.setIndex(node2.getIndex());
        node2.setIndex(indexAux);

        E tempMain= node1.getMain();
        node1.setMain(node2.getMain());
        node2.setMain(tempMain);
        //System.out.println("Intercamio realizado");
    }
    
    public Boolean Sort(){
  
    Node aux=this.firstNode;
    int size=0;
    Boolean yaOrdenado=true;
    
    while(aux!=null){
        size++;
        aux=aux.getNextNode();
    }
        System.out.println(size);
    int numero=100000;
   int nuevoContador=0;
        for(int i=0;i<size;i++){
         aux=this.firstNode;
         numero-=1;
          System.out.println("Quedan "+(numero));
        for(int j=0;j<size;j++){
       
            if(aux!=null){
                if(aux.getNextNode()!=null){
                        if(aux.getIndex()<aux.getNextNode().getIndex()){
                          //  interCambiar(aux.getIndex(),aux.getNextNode().getIndex());
                             Node aux2 = aux.getNextNode();
                            
                            E intercambio = (E) aux.getMain();
                            int indi =aux.index;
                            aux.setMain(aux2.getMain());
                            aux.setIndex(aux2.getIndex());

                            aux2.setMain(intercambio);
                            aux2.setIndex(indi);
                            aux=aux.getNextNode();
                }
                else{
                   // System.out.println("Hola "+nuevoContador++);
                        
                }
                } 
            }
            if(aux!=null)
        aux=aux.getNextNode();
        yaOrdenado=false;
    }
       
    }
    
    
    /*
        aux=this.firstNode;
        while(aux.getNextNode()!=null){
            
            if(aux.index>aux.getNextNode().index){
            Node aux2 = aux.getNextNode();
                            
            E intercambio = (E) aux.getMain();
            int indi =aux.index;
            aux.setMain(aux2.getMain());
            aux.setIndex(aux2.getIndex());

            aux2.setMain(intercambio);
            aux2.setIndex(indi);
            aux=aux.getNextNode();
            }
        }
    */
    
    return yaOrdenado;
}

    


    
  public void saveData(String ruta) throws IOException {
    String filePath = ruta;
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
        Node aux = this.firstNode;
        while (aux != null) {
            out.writeObject(aux.main);
            aux = aux.getNextNode();
        }
    }
}

    
public ArrayList loadData(String ruta) throws IOException, ClassNotFoundException {
    String filePath = ruta;
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
        ArrayList<E> array = new ArrayList();
        while (true) {
            
            try {
                E lectura =  (E)  in.readObject();
                //aux.setMain(lectura);
                array.add(lectura);
               // add(lectura,aux.getIndex());
            } catch (EOFException e) {
                break; 
            }
        }
        return array;
    }
    
}
    
    
 public void Modify(E p){
     
    this.getActualNode().setMain(p);
     
 }   
    
// Inner class

    public class Node<E> {
        private Node<E> nextNode;
        private Node<E> previousNode;
        E main;
        int index = 0;
        
        public Node(E p, int numEmp){
            this.nextNode = null;
            this.main = p;
            this.index = numEmp;
        }
        
        public Node<E> getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public E getMain() {
            return main;
        }

        public void setMain(E p) {
            this.main = p;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Node<E> getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node<E> previousNode) {
            this.previousNode = previousNode;
        }
        
        
        
        
    }
}