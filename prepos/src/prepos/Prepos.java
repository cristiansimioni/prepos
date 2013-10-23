package prepos;

import prepos.core.SystemInfo;
import prepos.gui.GUIChooser;

/*
 * Author: Cristian Simioni
 * Last updated: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class Prepos {

    public static void main(String[] args) {
        // Initialize system
        SystemInfo.initialize();

        // Open the graphic environment
        GUIChooser chooser = new GUIChooser();
        chooser.setVisible(true);
    }
}