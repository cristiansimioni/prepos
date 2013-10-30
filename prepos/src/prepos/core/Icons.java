package prepos.core;

import java.awt.Component;
import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class Icons extends JLabel implements ListCellRenderer {

    // Attributes
    private ResourceBundle messages;
    private Hashtable<Object, ImageIcon> languages = null;

    // Constructor
    public Icons() {
        try {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", Locale.getDefault());
        } catch (Exception e) {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", new Locale("en", "US"));
            SystemInfo.getLog().log(Level.WARNING, e.getLocalizedMessage());
        }
        languages = new Hashtable<Object, ImageIcon>();
        languages.put(messages.getString("ENGLISH"), new ImageIcon(getClass().getResource("/prepos/resources/icons/usa.png")));
        languages.put(messages.getString("PORTUGUESE"), new ImageIcon(getClass().getResource("/prepos/resources/icons/brazil.png")));
    }

    // Override
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (languages.get(value) != null) {
            setIcon(languages.get(value));
            setText(value.toString());
            return this;
        } else {
            return null;
        }
    }
}
