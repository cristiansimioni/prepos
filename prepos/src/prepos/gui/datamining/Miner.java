package prepos.gui.datamining;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import prepos.association.Association;
import prepos.association.AssociationAprioriBorgelt;
import prepos.association.AssociationAprioriWeka;
import prepos.association.parser.ParserAssociationAprioriBorgelt;
import prepos.association.parser.ParserAssociationAprioriWeka;
import prepos.classification.Classification;
import prepos.classification.ClassificationC45;
import prepos.classification.ClassificationJ48;
import prepos.classification.parser.ParserClassifierJ48;
import prepos.core.FileSaver;
import prepos.core.Shared;
import prepos.core.SystemInfo;

public class Miner extends javax.swing.JPanel {

    private JTree tAlgorithms;
    private ResourceBundle messages;
    private int selectedAlgorithm;
    private int lastExecutedAlgorithm;
    private String parameters;

    private enum algorithms {

        APRIORIBORGELT, APRIORIWEKA, J48, C45;
    }

    public Miner() {
        try {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", Locale.getDefault());
        } catch (Exception e) {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", new Locale("en", "US"));
            SystemInfo.getLog().log(Level.WARNING, e.getLocalizedMessage());
        }

        initComponents();
        createTree();
        initResources();
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getParameters() {
        return parameters;
    }

    private void initResources() {
        bStart.setEnabled(false);
        bParameters.setEnabled(false);
        bSave.setEnabled(false);
        bSaveRules.setEnabled(false);
    }

    private void createTree() {
        // Root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("prepos");

        // Tarefas de mineração de dados
        DefaultMutableTreeNode association = new DefaultMutableTreeNode("Association");
        DefaultMutableTreeNode classification = new DefaultMutableTreeNode("Classification");

        // Algoritmos de associação
        association.add(new DefaultMutableTreeNode("Apriori (Weka)"));
        association.add(new DefaultMutableTreeNode("Apriori (Borgelt)"));

        // Algoritmos de classicação
        classification.add(new DefaultMutableTreeNode("C4.5"));
        classification.add(new DefaultMutableTreeNode("J48"));

        // Adiciona as tarefas na árvore
        root.add(association);
        root.add(classification);

        tAlgorithms = new JTree(root);

        // Change event
        tAlgorithms.addTreeSelectionListener(
                new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath treePath = tAlgorithms.getSelectionPath();
                if (treePath.getPathCount() == 3) {
                    // Set default parameters
                    // Apriori (Borgelt)
                    if (treePath.toString().contains("Apriori (Borgelt)")) {
                        selectedAlgorithm = algorithms.APRIORIBORGELT.ordinal();
                        parameters = "-tr -c80 -s10 -S100 -m2 -n3";
                        bStart.setEnabled(true);
                        bParameters.setEnabled(true);
                    } // Apriori (Weka)
                    else if (treePath.toString().contains("Apriori (Weka)")) {
                        selectedAlgorithm = algorithms.APRIORIWEKA.ordinal();
                        parameters = "-N 5000 -T 0 -C 0.1 -D 0.05 -U 1.0 -M 0.01 -S -1.0 -c -1";
                        bStart.setEnabled(true);
                        bParameters.setEnabled(true);
                    } else if (treePath.toString().contains("J48")) {
                        selectedAlgorithm = algorithms.J48.ordinal();
                        parameters = "";
                        bStart.setEnabled(true);
                        bParameters.setEnabled(true);
                    } else if (treePath.toString().contains("C4.5")) {
                        selectedAlgorithm = algorithms.C45.ordinal();
                        parameters = "-f";
                        bStart.setEnabled(true);
                        bParameters.setEnabled(false);
                    }
                    tSelectedAlgorithm.setText(tAlgorithms.getSelectionPath().getLastPathComponent().toString() + " | " + parameters);
                }
            }
        });


        pAlgorithms.setViewportView(tAlgorithms);
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        chSave = new javax.swing.JFileChooser();
        pOutput = new javax.swing.JPanel();
        bSave = new javax.swing.JButton();
        bSaveRules = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tOutput = new javax.swing.JTextArea();
        pAlgorithms = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        bStart = new javax.swing.JButton();
        bParameters = new javax.swing.JButton();
        tSelectedAlgorithm = new javax.swing.JTextField();

        jScrollPane2.setViewportView(jEditorPane1);

        chSave.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 500));

        pOutput.setBorder(javax.swing.BorderFactory.createTitledBorder("Algorithm Output"));
        pOutput.setMaximumSize(new java.awt.Dimension(582, 426));
        pOutput.setMinimumSize(new java.awt.Dimension(582, 426));
        pOutput.setPreferredSize(new java.awt.Dimension(582, 426));

        bSave.setText("Save Result");
        bSave.setMaximumSize(new java.awt.Dimension(135, 23));
        bSave.setMinimumSize(new java.awt.Dimension(135, 23));
        bSave.setPreferredSize(new java.awt.Dimension(135, 23));
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bSaveRules.setText("Save Rules");
        bSaveRules.setMaximumSize(new java.awt.Dimension(135, 23));
        bSaveRules.setMinimumSize(new java.awt.Dimension(135, 23));
        bSaveRules.setPreferredSize(new java.awt.Dimension(135, 23));
        bSaveRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveRulesActionPerformed(evt);
            }
        });

        tOutput.setEditable(false);
        tOutput.setColumns(20);
        tOutput.setRows(5);
        jScrollPane1.setViewportView(tOutput);

        javax.swing.GroupLayout pOutputLayout = new javax.swing.GroupLayout(pOutput);
        pOutput.setLayout(pOutputLayout);
        pOutputLayout.setHorizontalGroup(
            pOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
            .addGroup(pOutputLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSaveRules, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pOutputLayout.setVerticalGroup(
            pOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pOutputLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSaveRules, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pAlgorithms.setBorder(javax.swing.BorderFactory.createTitledBorder("Algorithms"));
        pAlgorithms.setMaximumSize(new java.awt.Dimension(192, 426));
        pAlgorithms.setMinimumSize(new java.awt.Dimension(192, 426));
        pAlgorithms.setPreferredSize(new java.awt.Dimension(192, 426));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected Algorithm"));

        bStart.setText("Start");
        bStart.setMaximumSize(new java.awt.Dimension(192, 23));
        bStart.setMinimumSize(new java.awt.Dimension(192, 23));
        bStart.setPreferredSize(new java.awt.Dimension(192, 23));
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        bParameters.setText("Parameters");
        bParameters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bParametersActionPerformed(evt);
            }
        });

        tSelectedAlgorithm.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(tSelectedAlgorithm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bStart, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bParameters)
                    .addComponent(tSelectedAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pAlgorithms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pAlgorithms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
        try {
            if (selectedAlgorithm == algorithms.APRIORIWEKA.ordinal()) {
                Association association = new AssociationAprioriWeka();
                tOutput.setText(association.getAssociations(Shared.getInstance().getDatabase(), this.parameters));
                bSave.setEnabled(true);
                bSaveRules.setEnabled(true);
                lastExecutedAlgorithm = selectedAlgorithm;
            } else if (selectedAlgorithm == algorithms.APRIORIBORGELT.ordinal()) {
                Association association = new AssociationAprioriBorgelt();
                tOutput.setText(association.getAssociations(Shared.getInstance().getDatabase(), this.parameters));
                bSave.setEnabled(true);
                bSaveRules.setEnabled(true);
                lastExecutedAlgorithm = selectedAlgorithm;
            } else if (selectedAlgorithm == algorithms.J48.ordinal()) {
                Classification classification = new ClassificationJ48();
                tOutput.setText(classification.getClassification(Shared.getInstance().getDatabase(), this.parameters));
                bSave.setEnabled(true);
                bSaveRules.setEnabled(true);
                lastExecutedAlgorithm = selectedAlgorithm;
            } else if (selectedAlgorithm == algorithms.C45.ordinal()) {
                Classification classification = new ClassificationC45();
                tOutput.setText(classification.getClassification(Shared.getInstance().getDatabase(), this.parameters));
                bSave.setEnabled(true);
                bSaveRules.setEnabled(true);
                lastExecutedAlgorithm = selectedAlgorithm;
            }
        } catch (Exception ex) {
            Shared.getInstance().changeStatus("Error: " + ex.getLocalizedMessage());
            SystemInfo.getLog().log(Level.SEVERE, ex.getLocalizedMessage());
        }

    }//GEN-LAST:event_bStartActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        int option = chSave.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            FileSaver fileSaver = new FileSaver(chSave.getSelectedFile().getName(), chSave.getSelectedFile().getPath(), tOutput.getText());
            try {
                fileSaver.save();
            } catch (IOException ex) {
                SystemInfo.getLog().log(Level.SEVERE, ex.getLocalizedMessage());
            }
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void bSaveRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveRulesActionPerformed
        int option = chSave.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            FileSaver fileSaver = null;
            if (tAlgorithms.getSelectionPath().toString().contains("Apriori (Weka)")) {
                ParserAssociationAprioriWeka parser = new ParserAssociationAprioriWeka(tOutput.getText(), Shared.getInstance().getDatabase().numInstances());
                parser.buildAssociationRules();
                fileSaver = new FileSaver(chSave.getSelectedFile().getName(), chSave.getSelectedFile().getPath(), parser.toString());
            } else if (tAlgorithms.getSelectionPath().toString().contains("Apriori (Borgelt)")) {
                ParserAssociationAprioriBorgelt parser = new ParserAssociationAprioriBorgelt(tOutput.getText());
                parser.buildAssociationRules();
                fileSaver = new FileSaver(chSave.getSelectedFile().getName(), chSave.getSelectedFile().getPath(), parser.toString());
            } else if (tAlgorithms.getSelectionPath().toString().contains("J48")) {
                ParserClassifierJ48 parser = new ParserClassifierJ48(tOutput.getText());
                parser.buidProductionRules();
                fileSaver = new FileSaver(chSave.getSelectedFile().getName(), chSave.getSelectedFile().getPath(), parser.toString());
            }

            try {
                fileSaver.save();
            } catch (IOException ex) {
                SystemInfo.getLog().log(Level.SEVERE, ex.getLocalizedMessage());
            }
        }

    }//GEN-LAST:event_bSaveRulesActionPerformed

    private void bParametersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bParametersActionPerformed
        if (selectedAlgorithm == algorithms.APRIORIWEKA.ordinal()) {
            ParametersAprioriWeka pAprioriWeka = new ParametersAprioriWeka(this);
            pAprioriWeka.setVisible(true);
        } else if (selectedAlgorithm == algorithms.APRIORIBORGELT.ordinal()) {
            ParametersAprioriBorgelt pBorgelt = new ParametersAprioriBorgelt(this);
            pBorgelt.setVisible(true);
        } else if (selectedAlgorithm == algorithms.J48.ordinal()) {
            ParametersJ48 pJ48 = new ParametersJ48(Shared.getInstance().getDatabase());
            pJ48.setVisible(true);
        } else if (selectedAlgorithm == algorithms.C45.ordinal()) {
        }
    }//GEN-LAST:event_bParametersActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bParameters;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bSaveRules;
    private javax.swing.JButton bStart;
    private javax.swing.JFileChooser chSave;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane pAlgorithms;
    private javax.swing.JPanel pOutput;
    private javax.swing.JTextArea tOutput;
    private javax.swing.JTextField tSelectedAlgorithm;
    // End of variables declaration//GEN-END:variables
}
