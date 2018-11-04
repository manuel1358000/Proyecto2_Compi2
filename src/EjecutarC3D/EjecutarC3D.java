/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjecutarC3D;

import Estructuras.Nodo;
import Gramatica_DASM.sintactico_DASM;
import proyecto2_compi2.Principal;
import static proyecto2_compi2.Principal.pila;

/**
 *
 * @author anton
 */
public class EjecutarC3D {
    public static boolean bandera_etiqueta=true;
    public double calc=0.0;
    public Nodo auxiliar;
    public EjecutarC3D(){
        iniciarPila();
    }
    public static void iniciarPila(){
        
        for(int i=1;i<10000;i++){
            pila.push(0.0);
            Principal.heap.push(0.0);
        }
        Principal.heap.pushReferencia(0,1.0);
        pila.pushReferencia(0,1.0);
    }
    public Resultado Hacer(Nodo nodo) throws Throwable {
        return Accion(nodo);
    }
    public Resultado Accion(Nodo nodo) throws Throwable {
        Resultado resultado=new Resultado();
        switch(nodo.getNombre().toLowerCase()){
            case "inicio":{
                resultado=Hacer(nodo.getHijos().get(0));
                break;
            }
            case "asignacion":{
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
                    if(nodo.getHijos().size()>1){
                        resultado=Hacer(nodo.getHijos().get(1));
                        nodo=null;
                        System.out.println("Valor que tengo que revisar.");
                    }
                }else if(nodo.getHijos().size()==3){
                }
                break;
            }
            case "get_local":{
                //busco el valor de la variable que tiene
                if(bandera_etiqueta==true){
                    if(nodo.getHijos().get(0).getNombre().equals("numero")){
                        double valor=Double.parseDouble(Principal.pila.get(Integer.parseInt(nodo.getHijos().get(0).getValor())).toString());
                        Principal.pila_auxiliar.push(valor);
                    }else{
                    }
                }
                break;
            }
            case "get_global":{
                //busco el valor de la variable que tiene
                //busco el valor de la variable que tiene
                if(bandera_etiqueta==true){
                    if(nodo.getHijos().get(0).getNombre().equals("numero")){
                        double valor=Double.parseDouble(Principal.heap.get(Integer.parseInt(nodo.getHijos().get(0).getValor())).toString());
                        Principal.pila_auxiliar.push(valor);
                    }else{
                    }
                }
                break;
            }
            case "set_local":{
                //busco el valor de la variable que tiene
                if(bandera_etiqueta==true){
                    if(nodo.getHijos().get(0).getNombre().equals("numero")){
                        int posicion=Integer.parseInt(nodo.getHijos().get(0).getValor());
                        double valor=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                        Principal.pila.pushReferencia(posicion, valor);
                    }else if(nodo.getHijos().get(0).getNombre().equals("calc")){
                        this.calc=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                        double posicion=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                        int posicion1=(int)posicion;
                        Principal.pila.pushReferencia(posicion1,this.calc);
                    }
                }
                break;
            }
            case "set_global":{
                //busco el valor de la variable que tiene
                
                if(nodo.getHijos().get(0).getNombre().equals("numero")){
                    int posicion=Integer.parseInt(nodo.getHijos().get(0).getValor());
                    double valor=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    Principal.heap.pushReferencia(posicion, valor);
                }else if(nodo.getHijos().get(0).getNombre().equals("calc")){
                    this.calc=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double posicion=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    int posicion1=(int)posicion;
                    Principal.heap.pushReferencia(posicion1,this.calc);
                }
                break;
            }
            case "tee_local":{
                if(nodo.getHijos().get(0).getNombre().equals("numero")){
                    int posicion=Integer.parseInt(nodo.getHijos().get(0).getValor());
                    double valor=Double.parseDouble(Principal.pila_auxiliar.getLast().toString());
                    Principal.pila.pushReferencia(posicion, valor);
                }else if(nodo.getHijos().get(0).getNombre().equals("calc")){
                    this.calc=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double posicion=Double.parseDouble(Principal.pila_auxiliar.getLast().toString());
                    int posicion1=(int)posicion;
                    Principal.pila.pushReferencia(posicion1,this.calc);
                }
                break;
            }
            case "tee_global":{
                if(nodo.getHijos().get(0).getNombre().equals("numero")){
                    int posicion=Integer.parseInt(nodo.getHijos().get(0).getValor());
                    double valor=Double.parseDouble(Principal.pila_auxiliar.getLast().toString());
                    Principal.heap.pushReferencia(posicion, valor);
                }else if(nodo.getHijos().get(0).getNombre().equals("calc")){
                    this.calc=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double posicion=Double.parseDouble(Principal.pila_auxiliar.getLast().toString());
                    int posicion1=(int)posicion;
                    Principal.heap.pushReferencia(posicion1,this.calc);
                }
                break;
            }
            case "br_if":{
                //busco el valor de la variable que tiene
                if(nodo.getHijos().get(0).getNombre().equals("v_m")){
                    System.out.println("Solo tengo que buscar la etiqueta---------------------------->>>>>>>>>>>>>>>>>>>>>>");
                }else{
                    
                }
                break;
            }
            case "br":{
                //En esta parte solo pueden venir etiquetas
                if(nodo.getHijos().get(0).getNombre().equals("etiqueta")){
                    Nodo salto=sintactico_DASM.inicio;
                    System.out.println(nodo.getHijos().get(0).getValor());
                    Nodo respuesta1=busquedaEtiqueta(nodo.getHijos().get(0).getValor(),sintactico_DASM.inicio);
                    Hacer(sintactico_DASM.inicio);
                    bandera_etiqueta=false;
                }else{
                    
                }
                break;
            }
            case "v_m":{
                System.out.println("Etiqueta "+nodo.getNombre());
                System.out.println("----------------------->>>>>>>>>>>>>>>>>>?????????????????????????");
                bandera_etiqueta=true;
                break;
            }
            
            case "tipo":{
                resultado.tipo=nodo.getValor();
                resultado.valor=nodo.getValor();
                break;
            }
            case "add":{
                if(bandera_etiqueta==true){
                    if(Principal.pila_auxiliar.size()>=2){
                        double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                        double valor2=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                        double respuesta=valor1+valor2;
                        Principal.pila_auxiliar.push(respuesta);
                    }
                }
                break;
            }
            case "diff":{
                if(Principal.pila_auxiliar.size()>=2){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double valor2=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=valor2-valor1;
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
                    double respuesta=valor2/valor1;
                    Principal.pila_auxiliar.push(respuesta);
                }
                break;
            }
            case "mod":{
                if(Principal.pila_auxiliar.size()>=2){
                    double valor1=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double valor2=Double.parseDouble(Principal.pila_auxiliar.pop().toString());
                    double respuesta=valor2%valor1;
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
                if(bandera_etiqueta==true){
                    Principal.pila_auxiliar.push(Double.parseDouble(nodo.getValor()));
                }                
                break;
            }
            case "decimal":{
                //agregar el numero decimal a la pila auxiliar
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
                if(respuesta==null){
                }else{
                    break;
                }
            }
        }   
        return respuesta;
    }
    public Nodo busquedaEtiqueta(String nombre,Nodo inicio){
        Nodo respuesta=null;
        if(inicio.getValor().toLowerCase().equals(nombre.toLowerCase())&&inicio.getNombre().toLowerCase().equals("v_m")){
            respuesta=inicio;
            bandera_etiqueta=false;
        }else{
            for(int i=0;i<inicio.getHijos().size();i++){
                respuesta=busquedaEtiqueta(nombre,inicio.getHijos().get(i));
                if(respuesta!=null){
                    if(respuesta.getNombre()=="v_m"){
                        inicio.getHijos().clear();
                        inicio.getHijos().add(respuesta);
                        respuesta=inicio;
                    }
                }
            }
            System.out.println("Inicio "+inicio.getNombre());
        }   
        return respuesta;
    }
}
