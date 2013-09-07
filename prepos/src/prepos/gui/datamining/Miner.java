package prepos.gui.datamining;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import prepos.association.Association;
import prepos.association.AssociationAprioriBorgelt;
import prepos.association.AssociationAprioriWeka;
import prepos.association.parser.ParserAssociationAprioriBorgelt;
import prepos.association.parser.ParserAssociationAprioriWeka;
import prepos.classification.Classification;
import prepos.classification.ClassificationC45;
import prepos.classification.ClassificationJ48;
import prepos.core.FileSaver;
import prepos.core.Shared;
import prepos.core.SystemInfo;

public class Miner extends javax.swing.JPanel {

    private JTree tAlgorithms;
    private ResourceBundle messages;

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

    private void initResources() {
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
        pAlgorithms.setViewportView(tAlgorithms);
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        chSave = new javax.swing.JFileChooser();
        pParameters = new javax.swing.JPanel();
        pOutput = new javax.swing.JPanel();
        bSave = new javax.swing.JButton();
        bSaveRules = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tOutput = new javax.swing.JTextArea();
        bStart = new javax.swing.JButton();
        pAlgorithms = new javax.swing.JScrollPane();

        jScrollPane2.setViewportView(jEditorPane1);

        chSave.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 500));

        pParameters.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameters"));
        pParameters.setMaximumSize(new java.awt.Dimension(192, 296));
        pParameters.setMinimumSize(new java.awt.Dimension(192, 296));
        pParameters.setPreferredSize(new java.awt.Dimension(192, 296));

        javax.swing.GroupLayout pParametersLayout = new javax.swing.GroupLayout(pParameters);
        pParameters.setLayout(pParametersLayout);
        pParametersLayout.setHorizontalGroup(
            pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pParametersLayout.setVerticalGroup(
            pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pOutput.setBorder(javax.swing.BorderFactory.createTitledBorder("Algorithm Output"));
        pOutput.setMaximumSize(new java.awt.Dimension(582, 478));
        pOutput.setMinimumSize(new java.awt.Dimension(582, 478));
        pOutput.setPreferredSize(new java.awt.Dimension(582, 478));

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

        tOutput.setColumns(20);
        tOutput.setRows(5);
        jScrollPane1.setViewportView(tOutput);

        javax.swing.GroupLayout pOutputLayout = new javax.swing.GroupLayout(pOutput);
        pOutput.setLayout(pOutputLayout);
        pOutputLayout.setHorizontalGroup(
            pOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pOutputLayout.createSequentialGroup()
                .addGap(0, 294, Short.MAX_VALUE)
                .addComponent(bSaveRules, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );
        pOutputLayout.setVerticalGroup(
            pOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pOutputLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSaveRules, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bStart.setText("Start");
        bStart.setMaximumSize(new java.awt.Dimension(192, 23));
        bStart.setMinimumSize(new java.awt.Dimension(192, 23));
        bStart.setPreferredSize(new java.awt.Dimension(192, 23));
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        pAlgorithms.setBorder(javax.swing.BorderFactory.createTitledBorder("Algorithms"));
        pAlgorithms.setMaximumSize(new java.awt.Dimension(192, 147));
        pAlgorithms.setMinimumSize(new java.awt.Dimension(192, 147));
        pAlgorithms.setPreferredSize(new java.awt.Dimension(192, 147));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pParameters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pAlgorithms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pAlgorithms, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pParameters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
        try {
            if (tAlgorithms.getSelectionPath().toString().contains("Apriori (Weka)")) {
                Association association = new AssociationAprioriWeka();
                tOutput.setText(association.getAssociations(Shared.getInstance().getDatabase(), "-N 2000 -T 0 -C 0.1 -D 0.05 -U 1.0 -M 0.01 -S -1.0 -c -1"));
                bSave.setEnabled(true);
                bSaveRules.setEnabled(true);
            } else if (tAlgorithms.getSelectionPath().toString().contains("Apriori (Borgelt)")) {
                Association association = new AssociationAprioriBorgelt();
                tOutput.setText(association.getAssociations(Shared.getInstance().getDatabase(), "-tr -s1 -m2 -n3"));
                bSave.setEnabled(true);
                bSaveRules.setEnabled(true);
            } else if (tAlgorithms.getSelectionPath().toString().contains("J48")) {
                Classification classification = new ClassificationJ48();
                tOutput.setText(classification.getClassification(Shared.getInstance().getDatabase(), ""));
                bSave.setEnabled(true);
                bSaveRules.setEnabled(true);
            } else if (tAlgorithms.getSelectionPath().toString().contains("C4.5")) {
                Classification classification = new ClassificationC45();
                tOutput.setText(classification.getClassification(Shared.getInstance().getDatabase(), "-f"));
                bSave.setEnabled(true);
                bSaveRules.setEnabled(true);
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
                ParserAssociationAprioriWeka parser = new ParserAssociationAprioriWeka(tOutput.getText());
                parser.buildAssociationRules();
                fileSaver = new FileSaver(chSave.getSelectedFile().getName(), chSave.getSelectedFile().getPath(), parser.toString());
            } else if (tAlgorithms.getSelectionPath().toString().contains("Apriori (Borgelt)")) {
                ParserAssociationAprioriBorgelt parser = new ParserAssociationAprioriBorgelt(tOutput.getText());
                parser.buildAssociationRules();
                fileSaver = new FileSaver(chSave.getSelectedFile().getName(), chSave.getSelectedFile().getPath(), parser.toString());
            }

            try {
                fileSaver.save();
            } catch (IOException ex) {
                SystemInfo.getLog().log(Level.SEVERE, ex.getLocalizedMessage());
            }
        }

    }//GEN-LAST:event_bSaveRulesActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSave;
    private javax.swing.JButton bSaveRules;
    private javax.swing.JButton bStart;
    private javax.swing.JFileChooser chSave;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane pAlgorithms;
    private javax.swing.JPanel pOutput;
    private javax.swing.JPanel pParameters;
    private javax.swing.JTextArea tOutput;
    // End of variables declaration//GEN-END:variables
}
