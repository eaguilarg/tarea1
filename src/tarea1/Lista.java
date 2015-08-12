

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
    
      public void insertaInicio(T elem){
        Nodo<T> nuevo=new Nodo(elem);
        Nodo<T> temp=cabeza.getSiguiente();
        
        cabeza.setSiguiente(nuevo);
        nuevo.setSiguiente(temp);
        contador++;
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
    
     public void invertirLista2(){
      Nodo<T> aux=cabeza.getSiguiente();
      Stack<T> pila=new Stack();
      while(aux!=null){
          pila.push(aux.getElemento());
          aux=aux.getSiguiente();
      }
      
      aux=cabeza.getSiguiente();
      while(!pila.isEmpty()){
          aux.setElemento(pila.pop());
          aux=aux.getSiguiente();
      }
     
  }
    
    
    //invertir recursivo
    public Nodo<T> invertirR(Nodo<T> actual){
         if(actual.getSiguiente()!=null){
            Nodo<T> temp=invertirR(actual.getSiguiente()); 
            temp.setSiguiente(actual);
            actual.setSiguiente(null);
      }
      else{
          cabeza.setSiguiente(actual);
      }
      return actual;
  }
    
    
    
    /*
    public Nodo<T> invierte(Nodo<T> actual){
        if(actual.getSiguiente()==null){
            cabeza.getSiguiente()=actual;
        return actual;
        }
        else
             Nodo<T> temp= inviertes(actual.getSiguiente());
             temp.getSiguiente()=actual;
            return actual;
    } 
    private Nodo<T> inviertes(Nodo<T> actual){
        
        Stack pila = new Stack();
        while(actual!=null){
            pila.push(actual);
            actual=actual.getSiguiente();
        }
        actual=cabeza;
        while(!pila.isEmpty()){
           actual.getSiguiente()= (Nodo<T>)pila.pop();
            actual=actual.getSiguiente();
        }
        actual.getSiguiente()=null;
    }
    */
    
    public int sumarElem( Nodo<Integer> elem){
        if(elem.getSiguiente()==null)
            return elem.getElemento();
        else
            return elem.getElemento()+sumarElem( elem.getSiguiente());
    }
    
    public int sumar2(Nodo<Integer> elem, int suma){
        if(elem==null)
            return suma;
        return sumar2(elem.getSiguiente(),suma+elem.getElemento());
    }
    
      
    
   
    public  String borrar(T elem) throws Unchecked {
        Nodo<T> aux = cabeza;
        while(aux.getSiguiente().getElemento()!=elem && aux.getSiguiente()==null ){
         aux=aux.getSiguiente();
        }
         if(aux.getSiguiente()==null){
              new Unchecked("No existe el elemento");
        }
         else
             aux.setSiguiente(aux.getSiguiente().getSiguiente());
             contador--;
                      
        return elem.toString();
      }
    
       
    public T borrarR(T elem, Nodo<T> actual){
       
        if(actual.getSiguiente()==null)
            return null;
        if(actual.getSiguiente().getElemento().equals(elem)){
            actual.getSiguiente().setSiguiente(actual.getSiguiente().getSiguiente());
        return elem;
        }
        else
            return borrarR( elem, actual.getSiguiente());
        
    }
    
    
    //funcion bien profe
    public boolean remove(Nodo<T> n, T elem){
        boolean resp=false;
        if(n==null)
            return false;
        if(n.getElemento().equals(elem))
            return true;
        resp= remove(n.getSiguiente(), elem);
        if(resp)
            n.setSiguiente(n.getSiguiente().getSiguiente());
        return false;
    }
    
        
  public void imprimeLista(){
        Nodo<T> temp=cabeza.getSiguiente();
        
        while(temp!=null){
            System.out.print(""+temp.toString());
            System.out.print("↓"+"\n");
            temp=temp.getSiguiente();
        }
        System.out.println(""+"null");
    }
  
  
    public static void main(String args[]){
        Lista <Integer> lista=new Lista();
 
     lista.insertaInicio(3);
     lista.insertaInicio(2);
     lista.insertaInicio(1);
     lista.imprimeLista();
   
   
     //lista.invertirR(lista.cabeza.getSiguiente());
     //lista.imprimeLista();
    
     lista.remove(lista.cabeza.getSiguiente(), 3);
     lista.imprimeLista();
    
     
     System.out.println(lista.sumar2(lista.cabeza.getSiguiente(),0));
     
    }
    
        
    }

    
    
    
    
    
    

