/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjecutarC3D;

/**
 *
 * @author anton
 */
public class Resultado {
    public String tipo;
    public String simbolo;
    public Object valor;
    public int indice;

    public Resultado() {
        this.tipo="";
        this.simbolo="";
        this.valor="";
        this.indice=-1;
    }

    public Resultado(String tipo, String simbolo, Object valor, int indice) {
        this.tipo = tipo;
        this.simbolo = simbolo;
        this.valor = valor;
        this.indice = indice;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
}
