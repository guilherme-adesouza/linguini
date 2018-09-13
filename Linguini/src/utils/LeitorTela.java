package utils;

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
        return getBotoes(tela.getRootPane().getComponents());
    }
    
    public static ArrayList<JButton> leitorBotoes(JDialog tela){
        return getBotoes(tela.getRootPane().getComponents());
    }
    
     public static ArrayList<JButton> leitorBotoes(JPanel tela){
        return getBotoes(tela.getComponents());
    }
    
    private static ArrayList<JButton>  getBotoes(Component[] components){
        ArrayList<JButton> buttons = new ArrayList();
        for(Component c : components){
            if(c instanceof JButton){
                buttons.add((JButton) c);
            }
        }
        return buttons;
    }    
}
