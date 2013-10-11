package prepos.gui;

import prepos.core.SystemInfo;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GUIChooser extends javax.swing.JFrame {

    private ResourceBundle messages;

    public GUIChooser() {
        try {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", Locale.getDefault());
        } catch (Exception e) {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", new Locale("en", "US"));
            SystemInfo.getLog().log(Level.WARNING, e.getLocalizedMessage());
        }
        initLayout();
        initComponents();
        initResources();
        initLabels();
    }

    private void initLabels() {
        setTitle(SystemInfo.getName());
        btDataMining.setText(messages.getString("DATA_MINING"));
        btUtilities.setText(messages.getString("UTILITIES"));
        mAbout.setText(messages.getString("ABOUT"));
        mContact.setText(messages.getString("CONTACT"));
        mExit.setText(messages.getString("EXIT"));
        mTools.setText(messages.getString("TOOLS"));
        mHelp.setText(messages.getString("HELP"));
        mProgram.setText(messages.getString("PROGRAM"));
        mUserManual.setText(messages.getString("USER_MANUAL"));
        lbInfo.setText(messages.getString("AUTHOR") + ": " + SystemInfo.getAuthor() + " | "
                + messages.getString("VERSION") + ": " + SystemInfo.getVersion() + " | "
                + messages.getString("BUILD") + ": " + SystemInfo.getBuildDate() + " | "
                + "© " + SystemInfo.getYear());
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
        lbLogo.setFocusable(true);
        // Set logo
        ImageIcon myLogo = new ImageIcon(getClass().getResource("/prepos/resources/images/logo.png"));
        myLogo = new ImageIcon(myLogo.getImage().getScaledInstance(348, -1, Image.SCALE_SMOOTH));
        lbLogo.setIcon(myLogo);
        // Set icon
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/prepos/resources/icons/icon.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btDataMining = new javax.swing.JButton();
        btUtilities = new javax.swing.JButton();
        lbLogo = new javax.swing.JLabel();
        lbInfo = new javax.swing.JLabel();
        mMenu = new javax.swing.JMenuBar();
        mProgram = new javax.swing.JMenu();
        mConfiguration = new javax.swing.JMenuItem();
        mAbout = new javax.swing.JMenuItem();
        mExit = new javax.swing.JMenuItem();
        mTools = new javax.swing.JMenu();
        mWeka = new javax.swing.JMenuItem();
        mHelp = new javax.swing.JMenu();
        mContact = new javax.swing.JMenuItem();
        mUserManual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btDataMining.setText("Data Mining");
        btDataMining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDataMiningActionPerformed(evt);
            }
        });

        btUtilities.setText("Utilities");
        btUtilities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUtilitiesActionPerformed(evt);
            }
        });

        lbLogo.setToolTipText("");

        lbInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInfo.setText("Author: Cristian Simioni  |  Version: 1.0  |  Build: 04/04/2013  |  © 2013");

        mProgram.setText("Program");

        mConfiguration.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mConfiguration.setText("Configuration");
        mConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConfigurationActionPerformed(evt);
            }
        });
        mProgram.add(mConfiguration);

        mAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prepos/resources/icons/info.png"))); // NOI18N
        mAbout.setText("About");
        mAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAboutActionPerformed(evt);
            }
        });
        mProgram.add(mAbout);

        mExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prepos/resources/icons/exit.png"))); // NOI18N
        mExit.setText("Exit");
        mExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mExitActionPerformed(evt);
            }
        });
        mProgram.add(mExit);

        mMenu.add(mProgram);

        mTools.setText("Tools");

        mWeka.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        mWeka.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prepos/resources/icons/tool.png"))); // NOI18N
        mWeka.setText("Weka");
        mWeka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mWekaActionPerformed(evt);
            }
        });
        mTools.add(mWeka);

        mMenu.add(mTools);

        mHelp.setText("Help");

        mContact.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prepos/resources/icons/mail.png"))); // NOI18N
        mContact.setText("Contact");
        mContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mContactActionPerformed(evt);
            }
        });
        mHelp.add(mContact);

        mUserManual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        mUserManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prepos/resources/icons/manual.png"))); // NOI18N
        mUserManual.setText("User Manual");
        mUserManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUserManualActionPerformed(evt);
            }
        });
        mHelp.add(mUserManual);

        mMenu.add(mHelp);

        setJMenuBar(mMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btDataMining, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDataMining, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbInfo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Program > Exit
    private void mExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mExitActionPerformed

    // Program > About
    private void mAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAboutActionPerformed
        String msg;
        msg = messages.getString("AUTHOR") + ": " + SystemInfo.getAuthor() + "\n"
                + messages.getString("VERSION") + ": " + SystemInfo.getVersion() + "\n"
                + messages.getString("BUILD") + ": " + SystemInfo.getBuildDate() + "\n";
        JOptionPane.showMessageDialog(null, msg, messages.getString("ABOUT"), JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_mAboutActionPerformed

    // Program > Contact
    private void mContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mContactActionPerformed
        String msg;
        msg = SystemInfo.getAuthor() + "\n"
                + messages.getString("EMAIL") + ": " + SystemInfo.getAuthorEmail() + "\n\n"
                + SystemInfo.getProfessor() + "\n"
                + messages.getString("EMAIL") + ": " + SystemInfo.getProfessorEmail();
        JOptionPane.showMessageDialog(null, msg, messages.getString("CONTACT"), JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_mContactActionPerformed

    // Help > User Manual
    private void mUserManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUserManualActionPerformed
        File pdf = new File("user manual.pdf");
        try {
            Desktop.getDesktop().open(pdf);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), messages.getString("ERROR"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mUserManualActionPerformed

    // Button > Data Mining
    private void btDataMiningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDataMiningActionPerformed
        btDataMining.setEnabled(false);
        final GUIDataMining dataMining = new GUIDataMining();
        dataMining.setVisible(true);
        dataMining.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent w) {
                dataMining.dispose();
                btDataMining.setEnabled(true);
            }
        });
    }//GEN-LAST:event_btDataMiningActionPerformed

    // Button > Utilities
    private void btUtilitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUtilitiesActionPerformed
        btUtilities.setEnabled(false);
        final GUIUtilities utilities = new GUIUtilities();
        utilities.setVisible(true);
        utilities.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent w) {
                utilities.dispose();
                btUtilities.setEnabled(true);
            }
        });
        
    }//GEN-LAST:event_btUtilitiesActionPerformed

    // Tools > Weka
    // Erro: Quando fecha, a aplicação toda é fechada.
    private void mWekaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mWekaActionPerformed
        mWeka.setEnabled(false);
        final  weka.gui.GUIChooser weka = new weka.gui.GUIChooser();
        weka.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        weka.setVisible(true);
        weka.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent w) {
                weka.dispose();
                mWeka.setEnabled(true);
            }
        });
    }//GEN-LAST:event_mWekaActionPerformed

    // Program > Configuration
    // to do
    private void mConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConfigurationActionPerformed
        
    }//GEN-LAST:event_mConfigurationActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDataMining;
    private javax.swing.JButton btUtilities;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JMenuItem mAbout;
    private javax.swing.JMenuItem mConfiguration;
    private javax.swing.JMenuItem mContact;
    private javax.swing.JMenuItem mExit;
    private javax.swing.JMenu mHelp;
    private javax.swing.JMenuBar mMenu;
    private javax.swing.JMenu mProgram;
    private javax.swing.JMenu mTools;
    private javax.swing.JMenuItem mUserManual;
    private javax.swing.JMenuItem mWeka;
    // End of variables declaration//GEN-END:variables
}
