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
    private String statusText;
    private boolean textChanged;

    // Constructor
    private Shared() {
        textChanged = false;
        Thread statusThread = new Thread(new StatusRunnable(), "Status thread");
        statusThread.start();
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

    private synchronized void verifyTextChanges() throws InterruptedException {
        while (!textChanged) {
            wait();
        }
    }

    public void setTextChanged(boolean textChanged) {
        this.textChanged = textChanged;
    }

    private class StatusRunnable implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    verifyTextChanges();
                    status.setText(statusText);
                }
            } catch (Exception e) {
            }
        }
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
    public synchronized void changeStatus(String status) {
        this.statusText = status;
        this.textChanged = true;
        if (this.textChanged) {
            notifyAll();
        }
    }
}
