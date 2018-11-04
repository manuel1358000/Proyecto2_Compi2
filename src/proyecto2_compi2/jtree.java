/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_compi2;

import java.io.File;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author anton
 */
public class jtree implements TreeExpansionListener{
    private JTree jTree1;
    private DefaultTreeModel modelo;
    public DefaultTreeModel getModelo() {
        return modelo;
    }
    public jtree() {
    }
    public jtree(JTree jTree1) {
        this.jTree1 = jTree1;
    }
    public void setJTree(JTree jTree1) {
        this.jTree1 = jTree1;
    }
    public void init() {
        File archivo=new File ("ruta");
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("ruta");
        modelo = new DefaultTreeModel(top);
        jTree1.setModel(modelo);
        jTree1.addTreeExpansionListener(this);
        for (File f : archivo.listFiles()) {
            DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(f);    
            top.add(raiz);
            actualizaNodo(raiz, f);    
        }
    }
    private boolean actualizaNodo(DefaultMutableTreeNode nodo, File f) {
        nodo.removeAllChildren();
        return actualizaNodo(nodo,f,2);
    }
 
    private boolean actualizaNodo(DefaultMutableTreeNode nodo, File f, int profundidad) {
        File[] files = f.listFiles(); // de el nodo que llega listamos todos sus archivos
        if(files!=null && profundidad>0){  
            for(File file: files){
                DefaultMutableTreeNode nuevo = new DefaultMutableTreeNode(file);
                actualizaNodo(nuevo, file,profundidad-1);
                nodo.add(nuevo); //crea el nodo
            }
        }
        return true;
    }
    @Override
    public void treeExpanded(TreeExpansionEvent event) {
        TreePath path = event.getPath(); // Se obtiene el path del nodo
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
        if(node==null || !(node.getUserObject() instanceof File) ) return;
        File f = (File) node.getUserObject();
        actualizaNodo(node, f);  //actualiza la estructura
        JTree tree = ( JTree) event.getSource();
        DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
        model.nodeStructureChanged(node);
    }
 
    @Override
    public void treeCollapsed(TreeExpansionEvent event) { } 
    }