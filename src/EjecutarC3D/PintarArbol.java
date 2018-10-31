/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjecutarC3D;

import Estructuras.Nodo;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author anton
 */
public class PintarArbol {
    String contenido="digraph structs {\n node [shape=record];\n";
    String apuntar="";
    public void Pintar(String nombre) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        PrintWriter archivo=new PrintWriter("C:\\Users\\anton\\Desktop\\dibujos\\"+nombre+".txt","UTF-8");
        archivo.println(contenido);
        archivo.close();
        String dotPath="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
        String fileInput="C:\\Users\\anton\\Desktop\\dibujos\\"+nombre+".txt";
        String fileOutput="C:\\Users\\anton\\Desktop\\dibujos\\"+nombre+".jpg";
        String tParam="-Tjpg";
        String tOParam="-o";
        String cmd[]=new String[5];
        cmd[0]=dotPath;
        cmd[1]=tParam;
        cmd[2]=fileInput;
        cmd[3]=tOParam;
        cmd[4]=fileOutput;
        Runtime rt=Runtime.getRuntime();
        rt.exec(cmd);
        File file=new File(fileOutput);
        Desktop desk=Desktop.getDesktop();
        desk.open(file);
    }
    public void Generar_Arbol(Nodo inicio,String nombre) throws UnsupportedEncodingException, IOException{
        Armar_Arbol(inicio);
        Armar_Relaciones(inicio);
        contenido=contenido+"\n";
        contenido=contenido+apuntar+"}";
        Pintar(nombre);
    }
    
    public void Armar_Arbol(Nodo inicio) throws IOException{
        contenido=contenido+"struct"+inicio.getIndex()+" [label=\""+inicio.getNombre()+"|"+inicio.getValor()+"\"];\n";
        for(int i=0;i<inicio.getHijos().size();i++){
           Armar_Arbol(inicio.getHijos().get(i));
        }
    }
    public void Armar_Relaciones(Nodo inicio){
        for(int i=0;i<inicio.getHijos().size();i++){
            apuntar=apuntar+"struct"+inicio.getIndex()+"->struct"+inicio.getHijos().get(i).getIndex()+";\n";
            if(inicio.getHijos().get(i).getHijos().size()!=0){
                Armar_Relaciones(inicio.getHijos().get(i));
            }
        } 
    }
}
