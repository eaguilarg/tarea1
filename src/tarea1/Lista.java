
package tarea1;

import java.util.Stack;

/**
 *
 * @author EAGUILARG
 */
public class Lista<T> {
    //atributos
    Nodo <T> cabeza;
    int contador;
    
    //constructor
    public Lista(){
        cabeza=new Nodo();
        contador=0;
    }
    
    public void insertaInicio(Nodo <T> elem){
      Nodo<T> temporal=cabeza.getSiguiente();
      cabeza.setSiguiente(elem);
      elem.setSiguiente(temporal);
                       
    }
    
    //iterativo
    public void insertaFinal(T elem){
     Nodo<T> nuevo=new Nodo(elem);
     Nodo<T> aux = cabeza;
        while(aux.getSiguiente()!=null){
         aux=aux.getSiguiente();
     }
         aux.setSiguiente(nuevo);
         contador++;               
    }
    
    
    
    //invertir iterativo(pila)
    public void invertirI(){
        Nodo<T> actual=cabeza.getSiguiente();
        Stack<T> pila=new Stack();
        
        while(actual!=null){
            pila.push(actual.getElemento());
            actual=actual.getSiguiente();
        }
        actual=cabeza;
        while(!pila.isEmpty()){
            actual.setElemento(pila.pop());
            actual=actual.getSiguiente();
        }
        actual.setSiguiente(null);//actual.next=null;
    }
    
    //invertir recursivo
    public Nodo<T> invertirR(Nodo<T> actual){
         if(actual!=null){
          
            Nodo<T> temp=invertirR(actual.getSiguiente()); 
            temp.setSiguiente(actual);
            actual.setSiguiente(null);
      }
      else{
          cabeza.setSiguiente(actual);
      }
      return actual;
  }
    
    public int sumarElem( Nodo<T> elem,int n,int suma){
        if(n==0 && null==elem.getSiguiente())
            return suma;
        else
            return sumarElem( Nodo<T> elem.getSiguiente(),int n--,int suma+elem.getElemento())+ elem.getElemento() ;
    }
    
   
    public  String borrar(Nodo<T> elem) throws Unchecked {
        Nodo<T> aux = cabeza;
        while(aux.getSiguiente()!=elem ){
         aux=aux.getSiguiente();
         if(aux.getSiguiente()==null)
              new Unchecked("No existe el elemento");
        }
        contador--;
                      
        return elem.toString();
      }
    
    
    public String borrarR(Nodo<T> elem){
        
    }
    
        
    }
    
    
    
    
    
    

