/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_compi2;

import colores.colores_D;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.text.Caret;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;
/**
 *
 * @author anton
 */
public class Pesta extends JPanel implements ActionListener{
    public String path="";
    public static RSyntaxTextArea textArea= new RSyntaxTextArea();
    public  JTextField searchField;
    public JCheckBox regexCB;
    public JCheckBox matchCaseCB;
    public RTextScrollPane sp;
    public static RSyntaxTextArea getTextArea() {
        return textArea;
    }
    public static void setTextArea(RSyntaxTextArea textArea) {
        Pesta.textArea = textArea;
    }
    public Pesta(String path) {
        try{
            this.path=path;
            textArea= new RSyntaxTextArea(22,125);
            textArea.setLocation(200,200);
            AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory)TokenMakerFactory.getDefaultInstance();
            atmf.putMapping("text/mi_lenguaje", "colores.colores_D");
            textArea.setSyntaxEditingStyle("text/mi_lenguaje");
            textArea.setName("textArea");
            changeStyleProgrammatically();
            sp = new RTextScrollPane(textArea, true);
            sp.setIconRowHeaderEnabled(true);
            sp.setName("scroll");
            JToolBar toolBar = new JToolBar();
            searchField = new JTextField(50);
            toolBar.add(searchField);
            final JButton nextButton = new JButton("Find Next");
            nextButton.setActionCommand("FindNext");
            nextButton.addActionListener(this);
            toolBar.add(nextButton);
            searchField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    nextButton.doClick(0);
                }
            });
            JButton prevButton = new JButton("Find Previous");
            prevButton.setActionCommand("FindPrev");
            prevButton.addActionListener(this);
            toolBar.add(prevButton);
            regexCB = new JCheckBox("Regex");
            toolBar.add(regexCB);
            matchCaseCB = new JCheckBox("Match Case");
            toolBar.add(matchCaseCB);
            toolBar.setLocation(0,0);
            this.add(toolBar, BorderLayout.NORTH);
            this.add(sp);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +e.toString());
        }
        
    }
     private void changeStyleProgrammatically() {
      // Change a few things here and there.
        try{
            SyntaxScheme scheme = textArea.getSyntaxScheme();
            scheme.getStyle(Token.RESERVED_WORD).foreground = Color.BLUE;
            scheme.getStyle(Token.LITERAL_CHAR).foreground = Color.ORANGE;
            scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).foreground = Color.ORANGE;
            scheme.getStyle(Token.LITERAL_NUMBER_DECIMAL_INT).foreground = Color.MAGENTA;
            scheme.getStyle(Token.COMMENT_MULTILINE).foreground = Color.GRAY;
            scheme.getStyle(Token.COMMENT_EOL).foreground = Color.GRAY;
            textArea.revalidate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +e.toString());
        }
   }
    public void actionPerformed(ActionEvent e) {
        try{
            // "FindNext" => search forward, "FindPrev" => search backward
            String command = e.getActionCommand();
            boolean forward = "FindNext".equals(command);
            // Create an object defining our search parameters.
            SearchContext context = new SearchContext();
            String text = searchField.getText();
            if (text.length() == 0) {
                return;
            }
            context.setSearchFor(text);
            context.setMatchCase(matchCaseCB.isSelected());
            context.setRegularExpression(regexCB.isSelected());
            context.setSearchForward(forward);
            context.setWholeWord(false);
            boolean found = SearchEngine.find(textArea, context);
            if (!found) {
                JOptionPane.showMessageDialog(this, "Text not found");
            }
        }catch(HeadlessException h){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +h.toString());
        }
      

   }
   public static void setContenido(String contenido){
        try{
            textArea.setText(contenido);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +e.toString());
        }
   }
}