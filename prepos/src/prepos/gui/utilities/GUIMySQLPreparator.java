package prepos.gui.utilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import prepos.core.ButtonFile;
import prepos.utilities.MySQLPreparator;
import prepos.utilities.MySQLTable;
import prepos.utilities.ParserDictionary;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class GUIMySQLPreparator extends javax.swing.JPanel {

    // Attributes
    private MySQLPreparator mysql;

    public GUIMySQLPreparator() {
        initComponents();
        initResources();
    }

    private void initResources() {
        bTables.setEnabled(false);
        bScript.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chFile = new javax.swing.JFileChooser();
        pDicOfVariables = new javax.swing.JPanel();
        tDicOfVariables = new javax.swing.JTextField();
        bDicOfVariable = new javax.swing.JButton();
        pInformation = new javax.swing.JPanel();
        lDataName = new javax.swing.JLabel();
        tDataName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTables = new javax.swing.JTable();
        pExecutar = new javax.swing.JPanel();
        bTables = new javax.swing.JButton();
        bScript = new javax.swing.JButton();
        bClean = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 500));

        pDicOfVariables.setBorder(javax.swing.BorderFactory.createTitledBorder("Dictionary of Variables"));

        tDicOfVariables.setEditable(false);

        bDicOfVariable.setText("Select the Dictionary of Variables");
        bDicOfVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDicOfVariableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pDicOfVariablesLayout = new javax.swing.GroupLayout(pDicOfVariables);
        pDicOfVariables.setLayout(pDicOfVariablesLayout);
        pDicOfVariablesLayout.setHorizontalGroup(
            pDicOfVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDicOfVariablesLayout.createSequentialGroup()
                .addComponent(tDicOfVariables)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bDicOfVariable))
        );
        pDicOfVariablesLayout.setVerticalGroup(
            pDicOfVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDicOfVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tDicOfVariables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bDicOfVariable))
        );

        pInformation.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        lDataName.setText("Database Name:");

        tDataName.setEditable(false);

        tTables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tabela", "Arquivo", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tTables.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tTables);
        tTables.getColumnModel().getColumn(0).setResizable(false);
        tTables.getColumnModel().getColumn(1).setResizable(false);
        tTables.getColumnModel().getColumn(2).setMinWidth(60);
        tTables.getColumnModel().getColumn(2).setPreferredWidth(60);
        tTables.getColumnModel().getColumn(2).setMaxWidth(60);

        javax.swing.GroupLayout pInformationLayout = new javax.swing.GroupLayout(pInformation);
        pInformation.setLayout(pInformationLayout);
        pInformationLayout.setHorizontalGroup(
            pInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pInformationLayout.createSequentialGroup()
                        .addComponent(lDataName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tDataName))
                    .addGroup(pInformationLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pInformationLayout.setVerticalGroup(
            pInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInformationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDataName)
                    .addComponent(tDataName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pExecutar.setBorder(javax.swing.BorderFactory.createTitledBorder("Execution"));

        bTables.setText("Generate Files");
        bTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTablesActionPerformed(evt);
            }
        });

        bScript.setText("Generate Script");
        bScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bScriptActionPerformed(evt);
            }
        });

        bClean.setText("Clean");
        bClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pExecutarLayout = new javax.swing.GroupLayout(pExecutar);
        pExecutar.setLayout(pExecutarLayout);
        pExecutarLayout.setHorizontalGroup(
            pExecutarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pExecutarLayout.createSequentialGroup()
                .addComponent(bTables, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bScript, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bClean, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pExecutarLayout.setVerticalGroup(
            pExecutarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pExecutarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bTables)
                .addComponent(bScript)
                .addComponent(bClean))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pExecutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDicOfVariables, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pInformation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pDicOfVariables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pExecutar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bDicOfVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDicOfVariableActionPerformed
        int option = chFile.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            String pathFile = chFile.getSelectedFile().getAbsolutePath();
            tDicOfVariables.setText(pathFile);
            ParserDictionary dictionary = new ParserDictionary(new File(pathFile));
            mysql = dictionary.parser();

            tDataName.setText(mysql.getName());
            DefaultTableModel model = (DefaultTableModel) tTables.getModel();
            int i = 0;
            for (MySQLTable table : mysql.getTables()) {
                ButtonFile button = new ButtonFile(tTables, 2);
                model.addRow(new Object[]{table.getName(), "", button});
                i++;
            }

            bTables.setEnabled(true);
            bScript.setEnabled(true);
        }
    }//GEN-LAST:event_bDicOfVariableActionPerformed

    private void bCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCleanActionPerformed
        tDicOfVariables.setText("");
        tDataName.setText("");
        DefaultTableModel model = (DefaultTableModel) tTables.getModel();
        model.setNumRows(0);
        bTables.setEnabled(false);
        bScript.setEnabled(false);
    }//GEN-LAST:event_bCleanActionPerformed

    private void bTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTablesActionPerformed
        DefaultTableModel model = (DefaultTableModel) tTables.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            mysql.getTables().get(i).setPathFile((String) model.getValueAt(i, 1));
        }

        JFileChooser folder = new JFileChooser();
        folder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = folder.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            String pathFile = folder.getSelectedFile().getAbsolutePath();
            try {
                mysql.buildFiles(pathFile);
            } catch (IOException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }//GEN-LAST:event_bTablesActionPerformed

    private void bScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bScriptActionPerformed
        int option = chFile.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            String pathFile = chFile.getSelectedFile().getAbsolutePath();
            try {
                mysql.buildScript(chFile.getSelectedFile().getName(), pathFile);
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_bScriptActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClean;
    private javax.swing.JButton bDicOfVariable;
    private javax.swing.JButton bScript;
    private javax.swing.JButton bTables;
    private javax.swing.JFileChooser chFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lDataName;
    private javax.swing.JPanel pDicOfVariables;
    private javax.swing.JPanel pExecutar;
    private javax.swing.JPanel pInformation;
    private javax.swing.JTextField tDataName;
    private javax.swing.JTextField tDicOfVariables;
    private javax.swing.JTable tTables;
    // End of variables declaration//GEN-END:variables
}
