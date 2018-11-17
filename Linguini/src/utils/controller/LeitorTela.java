package utils.controller;

import java.awt.Component;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author guilherme-souza
 */
public class LeitorTela {
    
    public static ArrayList<JButton> leitorBotoes(JFrame tela){
        return getBotoes(tela.getContentPane().getComponents());
    }
    
    public static ArrayList<JButton> leitorBotoes(JDialog tela){
        return getBotoes(tela.getContentPane().getComponents());
    }
    
     public static ArrayList<JButton> leitorBotoes(JPanel tela){
        return getBotoes(tela.getComponents());
    }
    
    private static ArrayList<JButton> getBotoes(Component[] components){
        ArrayList<JButton> buttons = new ArrayList();
        for(Component c : components){
            if(c instanceof JButton){
                buttons.add((JButton) c);
            }
            else if(c instanceof JPanel){
                buttons.addAll(getBotoes(((JPanel) c).getComponents()));
            }
                
        }
        return buttons;
    }    
}
