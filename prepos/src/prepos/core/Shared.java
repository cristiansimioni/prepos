package prepos.core;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import prepos.database.Database;

public class Shared {

    private static Shared instance;
    private Database database;
    private JLabel lStatus;
    private JTabbedPane tbOptions;
    private JProgressBar jbProgressStatus;

    private Shared() {
    }

    // Change status text
    public void changeStatus(String status) {
        lStatus.setText(status);
    }

    public static Shared getInstance() {
        if (instance == null) {
            instance = new Shared();
        }
        return instance;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public JTabbedPane getTbOptions() {
        return tbOptions;
    }

    public void setlStatus(JLabel lStatus) {
        this.lStatus = lStatus;
    }

    public void setTbOptions(JTabbedPane tbOptions) {
        this.tbOptions = tbOptions;
    }

    public JProgressBar getJbProgressStatus() {
        return jbProgressStatus;
    }

    public void setJbProgressStatus(JProgressBar jbProgressStatus) {
        this.jbProgressStatus = jbProgressStatus;
    }

}

