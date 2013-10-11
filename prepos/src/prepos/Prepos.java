package prepos;

import prepos.core.SystemInfo;
import prepos.gui.GUIChooser;
import prepos.gui.GUIDataMining;

/*
 * Author: Cristian Simioni
 * Last update: 09/03/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 09/03/2013 | Cristian Simioni  | -                 | - 
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