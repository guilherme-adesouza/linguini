package view;

import javax.swing.JOptionPane;

/**
 * @author guilherme-souza
 */
public class CustomJOption {
    
    public static int confirmacao(String title, String text, int messageType) {
        String[] options = {"Sim", "Não"};
        return JOptionPane.showOptionDialog(null, text, title, 0, messageType, null, options, null);
    }
}
