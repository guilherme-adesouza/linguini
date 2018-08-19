package main;

import view.jfLogin;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;
import javax.swing.UIManager;


/**
 *
 * @author VitinNote
 */
public class Linguini {

    public static void main(String[] args) {
 
        try 
        {
          UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
        }
        new jfLogin().setVisible(true);
    }
}
