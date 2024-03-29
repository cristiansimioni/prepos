package prepos.gui.datamining;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import prepos.core.Shared;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import prepos.core.FileSaver;
import prepos.core.SystemInfo;
import prepos.gui.parameters.GUIParametersDatabaseDenormalizer;
import prepos.preprocessing.AprioriPreparator;
import prepos.preprocessing.DatabaseDenormalizer;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class Preprocessing extends javax.swing.JPanel {

    // Attributes
    private JTree tAlgorithms;
    private ResourceBundle messages;
    private int selectedAlgorithm;
    private String parameters;

    // Algorithms
    private enum algorithms {

        ASSOCIATION_APRIORI_PREPARATOR, ASSOCIATION_DATABASE_DENORMALIZER;
    }

    // Constructor
    public Preprocessing() {
        try {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", Locale.getDefault());
        } catch (Exception e) {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", new Locale("en", "US"));
            SystemInfo.getLog().log(Level.WARNING, e.getLocalizedMessage());
        }
        initComponents();
        initResources();
        createTree();
        initLabels();
    }

    // Methods
    // Initialize labels
    private void initLabels() {
        pSelectedAlgorithm.setBorder(javax.swing.BorderFactory.createTitledBorder(messages.getString("SELECTED_ALGORITHM")));
        pAlgorithms.setBorder(javax.swing.BorderFactory.createTitledBorder(messages.getString("ALGORITHMS")));
        pAlgorithmOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(messages.getString("ALGORITHM_OUTPUT")));
        bParameters.setText(messages.getString("PARAMETERS"));
        bStart.setText(messages.getString("START"));
        bSaveResult.setText(messages.getString("SAVE_RESULT"));
    }

    // Initialize resources
    private void initResources() {
        bSaveResult.setEnabled(false);
        bStart.setEnabled(false);
        bParameters.setEnabled(false);
    }

    // Create a tree
    private void createTree() {
        // Root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("prepos");

        // Data mining tasks
        DefaultMutableTreeNode association = new DefaultMutableTreeNode("Association");

        // Algorithms
        association.add(new DefaultMutableTreeNode("Apriori Preparator"));
        association.add(new DefaultMutableTreeNode("Denormalize Database"));

        // Add on the tree
        root.add(association);
        tAlgorithms = new JTree(root);

        // Value changed event
        tAlgorithms.addTreeSelectionListener(
                new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath treePath = tAlgorithms.getSelectionPath();
                if (treePath.getPathCount() == 3) {
                    // Apriori Preparator
                    if (treePath.toString().contains("Apriori Preparator")) {
                        selectedAlgorithm = algorithms.ASSOCIATION_APRIORI_PREPARATOR.ordinal();
                        bStart.setEnabled(true);
                        bParameters.setEnabled(false);
                    } // Denormalize Database
                    else if (treePath.toString().contains("Denormalize Database")) {
                        selectedAlgorithm = algorithms.ASSOCIATION_DATABASE_DENORMALIZER.ordinal();
                        bStart.setEnabled(true);
                        bParameters.setEnabled(true);
                        parameters = "-d0 -i0";
                    }
                    tSelectedAlgorithm.setText(tAlgorithms.getSelectionPath().getLastPathComponent().toString());
                }
            }
        });

        pAlgorithms.setViewportView(tAlgorithms);
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chSaveResult = new javax.swing.JFileChooser();
        pAlgorithmOutput = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tOutput = new javax.swing.JTextArea();
        bSaveResult = new javax.swing.JButton();
        pAlgorithms = new javax.swing.JScrollPane();
        pSelectedAlgorithm = new javax.swing.JPanel();
        bStart = new javax.swing.JButton();
        tSelectedAlgorithm = new javax.swing.JTextField();
        bParameters = new javax.swing.JButton();

        chSaveResult.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 500));

        pAlgorithmOutput.setBorder(javax.swing.BorderFactory.createTitledBorder("Algorithm Output"));
        pAlgorithmOutput.setMaximumSize(new java.awt.Dimension(582, 426));
        pAlgorithmOutput.setMinimumSize(new java.awt.Dimension(582, 426));
        pAlgorithmOutput.setPreferredSize(new java.awt.Dimension(582, 426));

        tOutput.setEditable(false);
        tOutput.setColumns(20);
        tOutput.setRows(5);
        jScrollPane1.setViewportView(tOutput);

        bSaveResult.setText("Save Result");
        bSaveResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveResultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pAlgorithmOutputLayout = new javax.swing.GroupLayout(pAlgorithmOutput);
        pAlgorithmOutput.setLayout(pAlgorithmOutputLayout);
        pAlgorithmOutputLayout.setHorizontalGroup(
            pAlgorithmOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAlgorithmOutputLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bSaveResult, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pAlgorithmOutputLayout.setVerticalGroup(
            pAlgorithmOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAlgorithmOutputLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSaveResult))
        );

        pAlgorithms.setBorder(javax.swing.BorderFactory.createTitledBorder("Algorithms"));
        pAlgorithms.setMaximumSize(new java.awt.Dimension(192, 426));
        pAlgorithms.setMinimumSize(new java.awt.Dimension(192, 426));
        pAlgorithms.setPreferredSize(new java.awt.Dimension(192, 426));

        pSelectedAlgorithm.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected Algorithm"));

        bStart.setText("Start");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        tSelectedAlgorithm.setEditable(false);

        bParameters.setText("Parameters");
        bParameters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bParametersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pSelectedAlgorithmLayout = new javax.swing.GroupLayout(pSelectedAlgorithm);
        pSelectedAlgorithm.setLayout(pSelectedAlgorithmLayout);
        pSelectedAlgorithmLayout.setHorizontalGroup(
            pSelectedAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSelectedAlgorithmLayout.createSequentialGroup()
                .addComponent(tSelectedAlgorithm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bStart, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pSelectedAlgorithmLayout.setVerticalGroup(
            pSelectedAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSelectedAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bStart)
                .addComponent(tSelectedAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bParameters))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pSelectedAlgorithm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pAlgorithms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pAlgorithmOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pSelectedAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pAlgorithms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pAlgorithmOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
        if (selectedAlgorithm == algorithms.ASSOCIATION_APRIORI_PREPARATOR.ordinal()) {
            AprioriPreparator apriori = new AprioriPreparator(Shared.getInstance().getDatabase());
            tOutput.setText(apriori.prepareDatabase());
            bSaveResult.setEnabled(true);
            Shared.getInstance().changeStatus("Database prepared.");
        } else if (selectedAlgorithm == algorithms.ASSOCIATION_DATABASE_DENORMALIZER.ordinal()) {
            DatabaseDenormalizer denormalizer = new DatabaseDenormalizer(Shared.getInstance().getDatabase(), parameters);
            tOutput.setText(denormalizer.denormalize());
            bSaveResult.setEnabled(true);
        }

    }//GEN-LAST:event_bStartActionPerformed

    private void bSaveResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveResultActionPerformed
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
    }//GEN-LAST:event_bSaveResultActionPerformed

    private void bParametersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bParametersActionPerformed
        if (selectedAlgorithm == algorithms.ASSOCIATION_DATABASE_DENORMALIZER.ordinal()) {
            GUIParametersDatabaseDenormalizer databaseDenormalizer = new GUIParametersDatabaseDenormalizer(Shared.getInstance().getDatabase(), parameters);
            databaseDenormalizer.setVisible(true);
            parameters = databaseDenormalizer.getParameters();
        }
    }//GEN-LAST:event_bParametersActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bParameters;
    private javax.swing.JButton bSaveResult;
    private javax.swing.JButton bStart;
    private javax.swing.JFileChooser chSaveResult;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pAlgorithmOutput;
    private javax.swing.JScrollPane pAlgorithms;
    private javax.swing.JPanel pSelectedAlgorithm;
    private javax.swing.JTextArea tOutput;
    private javax.swing.JTextField tSelectedAlgorithm;
    // End of variables declaration//GEN-END:variables
}
