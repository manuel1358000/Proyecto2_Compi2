/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjecutarC3D;

import Estructuras.Nodo;
import Gramatica_DASM.sintactico_DASM;
import proyecto2_compi2.Principal;

/**
 *
 * @author anton
 */
public class EjecutarC3D {
    public int calc=0;
    public Resultado Hacer(Nodo nodo) {
        return Accion(nodo);
    }
    public Resultado Accion(Nodo nodo) {
        Resultado resultado=new Resultado();
        switch(nodo.getNombre().toLowerCase()){
            case "inicio":{
                resultado=Hacer(nodo.getHijos().get(0));
                break;
            }
            case "funcion":{
                if(nodo.getHijos().size()==1){
                    resultado=Hacer(nodo.getHijos().get(0));
                    //solo realiza una operacion
                }else if(nodo.getHijos().size()==2){
                    Hacer(nodo.getHijos().get(0));
                    resultado=Hacer(nodo.getHijos().get(1));
                    //puede realizar dos operaciones
                }else{
                    System.out.println("Ocurrion un error");
                }
                break;
            }
            case "operacion":{
                if(nodo.getHijos().size()==1){
                    //puede ser numero, add, mult
                    Hacer(nodo.getHijos().get(0));
                }else if(nodo.getHijos().size()==2){
                    resultado=Hacer(nodo.getHijos().get(0));
                    resultado=Hacer(nodo.getHijos().get(1));
                }else if(nodo.getHijos().size()==3){
                }
                break;
            }
            case "get_local":{
                //busco el valor de la variable que tiene
                if(nodo.getHijos().get(0).getNombre().equals("numero")){
                    System.out.println("Solo tengo que mover el valor---------------------------->>>>>>>>>>>>>>>>>>>>>>");
                }else{
                    System.out.println("Tengo que ir a buscar el valor de la variable que venga o si es un tipo de funcion en especifico");
                }
                break;
            }
            case "get_global":{
                //busco el valor de la variable que tiene
                if(nodo.getHijos().get(0).getNombre().equals("numero")){
                    System.out.println("Solo tengo que mover el valor---------------------------->>>>>>>>>>>>>>>>>>>>>>");
                }else{
                    System.out.println("Tengo que ir a buscar el valor de la variable que venga o si es un tipo de funcion en especifico");
                }
                break;
            }
            case "set_local":{
                //busco el valor de la variable que tiene
                if(nodo.getHijos().get(0).getNombre().equals("numero")){
                    System.out.println("Solo tengo que mover el valor---------------------------->>>>>>>>>>>>>>>>>>>>>>");
                }else{
                    System.out.println("Tengo que ir a buscar el valor de la variable que venga o si es un tipo de funcion en especifico");
                }
                break;
            }
            case "set_global":{
                //busco el valor de la variable que tiene
                if(nodo.getHijos().get(0).getNombre().equals("numero")){
                    System.out.println("Solo tengo que mover el valor---------------------------->>>>>>>>>>>>>>>>>>>>>>");
                }else{
                    System.out.println("Tengo que ir a buscar el valor de la variable que venga o si es un tipo de funcion en especifico");
                }
                break;
            }
            case "tee_local":{
                //busco el valor de la variable que tiene
                if(nodo.getHijos().get(0).getNombre().equals("numero")){
                    System.out.println("Solo tengo que mover el valor---------------------------->>>>>>>>>>>>>>>>>>>>>>");
                }else{
                    System.out.println("Tengo que ir a buscar el valor de la variable que venga o si es un tipo de funcion en especifico");
                }
                break;
            }
            case "tee_global":{
                //busco el valor de la variable que tiene
                if(nodo.getHijos().get(0).getNombre().equals("numero")){
                    System.out.println("Solo tengo que mover el valor---------------------------->>>>>>>>>>>>>>>>>>>>>>");
                }else{
                    System.out.println("Tengo que ir a buscar el valor de la variable que venga o si es un tipo de funcion en especifico");
                }
                break;
            }
            case "br_if":{
                //busco el valor de la variable que tiene
                if(nodo.getHijos().get(0).getNombre().equals("v_m")){
                    System.out.println("Solo tengo que buscar la etiqueta---------------------------->>>>>>>>>>>>>>>>>>>>>>");
                }else{
                    System.out.println("Tengo que ir a buscar el valor de la variable que venga o si es un tipo de funcion en especifico");
                }
                break;
            }
            case "br":{
                //En esta parte solo pueden venir etiquetas
                if(nodo.getHijos().get(0).getNombre().equals("v_m")){
                    System.out.println("Solo tengo que buscar la etiqueta---------------------------->>>>>>>>>>>>>>>>>>>>>>");
                }else{
                    System.out.println("Tengo que ir a buscar el valor de la variable que venga o si es un tipo de funcion en especifico");
                }
                break;
            }
            case "tipo":{
                resultado.tipo=nodo.getValor();
                resultado.valor=nodo.getValor();
                break;
            }
            case "add":{
                if(Principal.pila_auxiliar.size()>=2){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double valor2=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=valor1+valor2;
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "diff":{
                if(Principal.pila_auxiliar.size()>=2){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double valor2=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=valor1-valor2;
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "mult":{
                if(Principal.pila_auxiliar.size()>=2){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double valor2=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=valor1*valor2;
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "div":{
                if(Principal.pila_auxiliar.size()>=2){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double valor2=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=valor1/valor2;
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "mod":{
                if(Principal.pila_auxiliar.size()>=2){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double valor2=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=valor1%valor2;
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "lt":{
                if(Principal.pila_auxiliar.size()>=2){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double valor0=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=0;
                    if(valor0<valor1){
                        respuesta=1;
                    }else{
                        respuesta=0;
                    }
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "gt":{
                if(Principal.pila_auxiliar.size()>=2){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double valor0=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=0;
                    if(valor0>valor1){
                        respuesta=1;
                    }else{
                        respuesta=0;
                    }
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "lte":{
                if(Principal.pila_auxiliar.size()>=2){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double valor0=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=0;
                    if(valor0<=valor1){
                        respuesta=1;
                    }else{
                        respuesta=0;
                    }
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "gte":{
                if(Principal.pila_auxiliar.size()>=2){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double valor0=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=0;
                    if(valor0>=valor1){
                        respuesta=1;
                    }else{
                        respuesta=0;
                    }
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "eqz":{
                if(Principal.pila_auxiliar.size()>=1){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=0;
                    if(valor1==0){
                        respuesta=1;
                    }else{
                        respuesta=0;
                    }
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "and":{
                if(Principal.pila_auxiliar.size()>=2){
                    int valor1=(int)Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    int valor0=(int)Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=valor1&valor0;
                    Principal.pila_auxiliar.push(respuesta);
                }
                
                break;
            }
            case "or":{
                if(Principal.pila_auxiliar.size()>=2){
                    int valor1=(int)Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    int valor0=(int)Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=valor1|valor0;
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "not":{
                if(Principal.pila_auxiliar.size()>=1){
                    int valor1=(int)Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=~valor1;
                    System.out.println(respuesta);
                    System.out.println("---------------------");
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "i_caracter":{
                System.out.println("Pendiente de realizar");
                break;
            }
            case "i_entero":{
                System.out.println("Pendiente de realizar");
                break;
            }
            case "i_flotante":{
                System.out.println("Pendiente de realizar");
                break;
            }
            case "print":{
                System.out.println("Pendiente de realizar");
                break;
            }
            
            case "numero":{
                //agregar el numero a la pila auxiliar
                Principal.pila_auxiliar.push(Double.parseDouble(nodo.getValor()));
                break;
            }
            default:{
                System.out.println("Elemento por default");
                break;
            }
        }
        return resultado;
    }
    public Nodo buscarNodo(String nombre){
        Nodo respuesta=new Nodo();
        respuesta=busqueda(nombre,sintactico_DASM.inicio);
        return respuesta;
    }
    public Nodo busqueda(String nombre,Nodo inicio){
        Nodo respuesta=null;
        if(inicio.getValor().toLowerCase().equals(nombre.toLowerCase())){
            respuesta=inicio;
        }else{
            for(int i=0;i<inicio.getHijos().size();i++){
                respuesta=busqueda(nombre,inicio.getHijos().get(i));
            }
        }   
        return respuesta;
    }
}
