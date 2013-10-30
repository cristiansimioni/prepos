package prepos.core;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import prepos.database.Database;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class Shared {

    // Attributes
    private static Shared instance;
    private Database database;
    private JLabel status;
    private JTabbedPane options;
    private JProgressBar progressBar;

    // Constructor
    private Shared() {
    }

    // Getter & setter
    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public JTabbedPane getOptions() {
        return options;
    }

    public void setStatus(JLabel status) {
        this.status = status;
    }

    public void setOptions(JTabbedPane options) {
        this.options = options;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    // Methods
    // Get a instance for Shared items
    public static Shared getInstance() {
        if (instance == null) {
            instance = new Shared();
        }
        return instance;
    }

    // Change status text
    public void changeStatus(String status) {
        this.status.setText(status);
    }
}
