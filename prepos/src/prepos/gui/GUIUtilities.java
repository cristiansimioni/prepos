package prepos.gui;

import prepos.gui.datamining.SelectDatabase;
import prepos.gui.datamining.Postprocessing;
import prepos.gui.datamining.Miner;
import prepos.gui.datamining.Preprocessing;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.swing.JProgressBar;
import prepos.core.Shared;
import prepos.core.SystemInfo;
import prepos.gui.utilities.MySQLPreparator;

public class GUIUtilities extends javax.swing.JFrame {

    private ResourceBundle messages;

    public GUIUtilities() {
        try {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", Locale.getDefault());
        } catch (Exception e) {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", new Locale("en", "US"));
            SystemInfo.getLog().log(Level.WARNING, e.getLocalizedMessage());
        }
        initComponents();
        initResources();
        initLayout();
    }

    private void initLayout() {
        // Location
        pack();
        setLocation(100, 100);

        // Visual Windows 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName()) || "Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            SystemInfo.getLog().log(Level.WARNING, ex.getLocalizedMessage());
        }
    }

    private void initResources() {
        // Set icon
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/prepos/resources/icons/icon.png")));

        // Set title
        setTitle(messages.getString("UTILITIES"));

        // Insert panels on Tabbed Pan
        // MySQL Preparator
        MySQLPreparator sqlPreparator = new MySQLPreparator();
        this.tbOptions.add(sqlPreparator);
        this.tbOptions.setTitleAt(0, messages.getString("MYSQL_PREPARATOR"));

        this.pbProgressStatus.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbOptions = new javax.swing.JTabbedPane();
        pStatus = new javax.swing.JPanel();
        lStatusMessage = new javax.swing.JLabel();
        pbProgressStatus = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tbOptions.setMaximumSize(new java.awt.Dimension(516, 800));
        tbOptions.setMinimumSize(new java.awt.Dimension(516, 800));
        tbOptions.setPreferredSize(new java.awt.Dimension(516, 800));

        pStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        lStatusMessage.setName(""); // NOI18N

        javax.swing.GroupLayout pStatusLayout = new javax.swing.GroupLayout(pStatus);
        pStatus.setLayout(pStatusLayout);
        pStatusLayout.setHorizontalGroup(
            pStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pStatusLayout.createSequentialGroup()
                .addComponent(lStatusMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pbProgressStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pStatusLayout.setVerticalGroup(
            pStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lStatusMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(pbProgressStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tbOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lStatusMessage;
    private javax.swing.JPanel pStatus;
    private javax.swing.JProgressBar pbProgressStatus;
    private javax.swing.JTabbedPane tbOptions;
    // End of variables declaration//GEN-END:variables
}
