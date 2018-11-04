package Estructuras;
import java.util.LinkedList;
public class Stack_Generico extends LinkedList<Object>{
    public int referencia;
    public Stack_Generico(){
        this.referencia=0;
    }
    public void push(Object objeto){
        this.addFirst(objeto);
    }
    public Object pop(){
        Object respuesta="vacio";
        if(this.size()>0){
            respuesta=this.getFirst();
            this.removeFirst();
        }
        return respuesta;
    }
    public Object popReferencia(int referencia){
        Object respuesta="vacio";
        if(this.size()>0){
            respuesta=this.get(referencia);
            this.remove(referencia);
        }
        return respuesta;
    }
    public void pushReferencia(int referencia,Object objecto){
        this.set(referencia, objecto);
    }
    public int getReferencia(){
        return this.referencia;
    }
    public void setReferencia(int referencia){
        this.referencia=referencia;
    }
}
