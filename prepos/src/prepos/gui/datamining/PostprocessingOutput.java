package prepos.gui.datamining;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import prepos.core.FileSaver;
import prepos.core.Shared;
import prepos.core.SystemInfo;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class PostprocessingOutput extends javax.swing.JPanel {

    // Attributes
    private ResourceBundle messages;

    // Constructor
    public PostprocessingOutput() {
        try {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", Locale.getDefault());
        } catch (Exception e) {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", new Locale("en", "US"));
            SystemInfo.getLog().log(Level.WARNING, e.getLocalizedMessage());
        }
        initComponents();
        initResources();
        initLabels();
    }

    private void initLabels() {
        bSave.setText(messages.getString("SAVE_RESULT"));
    }

    private void initResources() {
        bSave.setEnabled(true);
        //bSaveRules.setEnabled(false);
    }

    public JTextArea gettResult() {
        return tOutput;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chSaveResult = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tOutput = new javax.swing.JTextArea();
        bSave = new javax.swing.JButton();

        tOutput.setColumns(20);
        tOutput.setRows(5);
        jScrollPane1.setViewportView(tOutput);

        bSave.setText("Save Result");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSave)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        int option = chSaveResult.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            FileSaver fileSaver = new FileSaver(chSaveResult.getSelectedFile().getName(), chSaveResult.getSelectedFile().getPath(), tOutput.getText());
            try {
                fileSaver.save();
            } catch (IOException ex) {
                Shared.getInstance().changeStatus(messages.getString("ERROR") + ": " + ex.getLocalizedMessage());
                SystemInfo.getLog().log(Level.SEVERE, ex.getLocalizedMessage());
            }
        }
    }//GEN-LAST:event_bSaveActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSave;
    private javax.swing.JFileChooser chSaveResult;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tOutput;
    // End of variables declaration//GEN-END:variables
}
