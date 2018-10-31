/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author anton
 */
public class Nodo {
     private String nombre;
    private String valor;
    private int linea;
    private int columna;
    private int index;
    private ArrayList<Nodo> hijos;
    
    public Nodo() {
        this.nombre="";
        this.valor="";
        this.linea=0;
        this.columna=0;
        this.hijos=new ArrayList<>();
    }

    public Nodo(String nombre, String valor, int linea, int columna,int index) {
        this.nombre = nombre;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
        this.index=index;
        this.hijos=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }
    public void agregarHijos(ArrayList<Nodo> hijos){
        for(int i=0;i<hijos.size();i++){
            if(hijos.get(i)!=null){
                this.hijos.add(hijos.get(i));
            }
        }
    }
    
}
