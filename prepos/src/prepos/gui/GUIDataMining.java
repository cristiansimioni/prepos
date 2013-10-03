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

public class GUIDataMining extends javax.swing.JFrame {

    private ResourceBundle messages;

    public GUIDataMining() {
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
        setTitle(messages.getString("DATA_MINING"));

        // Share itens
        Shared.getInstance().setTbOptions(tbOptions);
        Shared.getInstance().setlStatus(lStatusMessage);
        Shared.getInstance().setJbProgressStatus(pbProgressStatus);

        // Insert panels on Tabbed Pan
        // Select Database
        SelectDatabase selectedDatabase = new SelectDatabase();
        this.tbOptions.add(selectedDatabase);
        this.tbOptions.setTitleAt(0, messages.getString("DATABASE"));

        // Preprocessing
        Preprocessing preProcessing = new Preprocessing();
        this.tbOptions.add(preProcessing);
        this.tbOptions.setTitleAt(1, messages.getString("PREPROCESSING"));

        // Data Mining
        Miner dataMining = new Miner();
        this.tbOptions.add(dataMining);
        this.tbOptions.setTitleAt(2, messages.getString("DATA_MINING"));

        // Post-processing
        Postprocessing postProcessing = new Postprocessing();
        this.tbOptions.add(postProcessing);
        this.tbOptions.setTitleAt(3, messages.getString("POST_PROCESSING"));

        // Disable tabs
        this.tbOptions.setEnabledAt(1, false);
        this.tbOptions.setEnabledAt(2, false);
        this.tbOptions.setEnabledAt(3, false);
        
        this.pbProgressStatus.setVisible(false);

        this.pack();
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

        pStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        lStatusMessage.setName(""); // NOI18N

        javax.swing.GroupLayout pStatusLayout = new javax.swing.GroupLayout(pStatus);
        pStatus.setLayout(pStatusLayout);
        pStatusLayout.setHorizontalGroup(
            pStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pStatusLayout.createSequentialGroup()
                .addComponent(lStatusMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pbProgressStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );
        pStatusLayout.setVerticalGroup(
            pStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lStatusMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(pbProgressStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tbOptions, javax.swing.GroupLayout.Alignment.TRAILING)
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