package utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import apoio.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author fabricio
 */
public class ControlarEntradaNumero extends PlainDocument{
    private int tamanhoMax = 10;
         
    public ControlarEntradaNumero(int tamanhoMax){
        this.tamanhoMax = tamanhoMax;
    }
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
 
            if (str == null) return;  
                    
             String stringAntiga = getText (0, getLength() );  
             int tamanhoNovo = stringAntiga.length() + str.length(); 
                        
             if (tamanhoNovo <= tamanhoMax && Character.isDigit(str.charAt(0))) {  
                 super.insertString(offset, str.toUpperCase() , attr);  
             } else {    
                 super.insertString(offset, "", attr); 
             }  
    }
}
