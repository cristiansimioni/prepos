package prepos.gui.datamining;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import prepos.association.parser.ParserAssociationPrepos;
import prepos.classification.parser.ParserClassifierPrepos;
import prepos.core.Util;
import prepos.gui.GUIAssociationRuleViewer;
import prepos.gui.GUIClassificationRuleViewer;
import prepos.postprocessing.ExceptionRuleSearcher;
import prepos.gui.postprocessing.GUIRulesFilter;
import prepos.postprocessing.RulesFilter;
import prepos.postprocessing.RedundancyElimination;
import prepos.rules.AssociationRule;
import prepos.rules.ProductionRule;

/*
 * Author: Cristian Simioni
 * Last update: 09/03/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class Postprocessing extends javax.swing.JPanel {

    private JTree tAlgorithms;
    private boolean isAssociationRules;
    private boolean isProductionRules;
    private PostprocessingOutput tResult;
    private PostprocessingStatistics tStatistics;
    int selectedAlgorithm;
    private ArrayList<AssociationRule> associationRules;
    private ArrayList<ProductionRule> productionRules;

    private enum algorithms {

        ASSOCIATION_FILTER, ASSOCIATION_EXCEPTIONRULES, ASSOCIATION_MEASURES,
        CLASSIFIER_FILTER, CLASSIFIER_REDUNDANCY, CLASSIFIER_MEASURES;
    }

    public PostprocessingOutput gettResult() {
        return tResult;
    }

    public PostprocessingStatistics gettStatistics() {
        return tStatistics;
    }

    public Postprocessing() {
        this.isAssociationRules = false;
        this.isProductionRules = false;
        initComponents();
        initResources();
        createTree();
    }

    private void createTree() {
        // Root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("prepos");

        // Data mining tasks
        DefaultMutableTreeNode association = new DefaultMutableTreeNode("Association");
        DefaultMutableTreeNode classification = new DefaultMutableTreeNode("Classification");

        // Association algorithms
        association.add(new DefaultMutableTreeNode("Filter Rules"));
        association.add(new DefaultMutableTreeNode("Exception Rules"));
        association.add(new DefaultMutableTreeNode("Interesting Measures"));

        // Classification algorithms
        classification.add(new DefaultMutableTreeNode("Eliminate Redundancy"));
        classification.add(new DefaultMutableTreeNode("Interesting Measures"));

        // Add all tasks on the tree
        root.add(association);
        root.add(classification);

        tAlgorithms = new JTree(root);

        tAlgorithms.addTreeSelectionListener(
                new TreeSelectionListener() {
                    @Override
                    public void valueChanged(TreeSelectionEvent e) {
                        TreePath treePath = tAlgorithms.getSelectionPath();
                        if (treePath.getPathCount() == 3) {
                            // Filter Association
                            if (treePath.toString().contains("Filter") && treePath.toString().contains("Association")) {
                                selectedAlgorithm = algorithms.ASSOCIATION_FILTER.ordinal();
                                bStart.setEnabled(true);
                            } // Apriori (Weka)
                            else if (treePath.toString().contains("Exception")) {
                                selectedAlgorithm = algorithms.ASSOCIATION_EXCEPTIONRULES.ordinal();
                                bStart.setEnabled(true);
                            } else if (treePath.toString().contains("Measures")) {
                                selectedAlgorithm = algorithms.ASSOCIATION_MEASURES.ordinal();
                                bStart.setEnabled(true);
                            }
                            tSelectedAlgorithm.setText(tAlgorithms.getSelectionPath().getLastPathComponent().toString());
                        }
                    }
                });

        pAlgorithms.setViewportView(tAlgorithms);

        repaint();
    }

    private void initResources() {
        // 
        tResult = new PostprocessingOutput();
        this.tbResults.add(tResult);
        this.tbResults.setTitleAt(0, "Result");

        tStatistics = new PostprocessingStatistics();
        this.tbResults.add(tStatistics);
        this.tbResults.setTitleAt(1, "Statistics");

        bStart.setEnabled(false);
        bRulesViewer.setEnabled(false);

        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chRulesFile = new javax.swing.JFileChooser();
        pAlgorithms = new javax.swing.JScrollPane();
        tbResults = new javax.swing.JTabbedPane();
        pSelectedRules = new javax.swing.JPanel();
        bSelectRulesFile = new javax.swing.JButton();
        bRulesViewer = new javax.swing.JButton();
        tSelectedRules = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        bStart = new javax.swing.JButton();
        tSelectedAlgorithm = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(800, 500));

        pAlgorithms.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Algorithms")));

        tbResults.setBorder(javax.swing.BorderFactory.createTitledBorder("Results"));

        pSelectedRules.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected Rules File"));

        bSelectRulesFile.setText("Select Rules File");
        bSelectRulesFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectRulesFileActionPerformed(evt);
            }
        });

        bRulesViewer.setText("View Rules");
        bRulesViewer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRulesViewerActionPerformed(evt);
            }
        });

        tSelectedRules.setEditable(false);

        javax.swing.GroupLayout pSelectedRulesLayout = new javax.swing.GroupLayout(pSelectedRules);
        pSelectedRules.setLayout(pSelectedRulesLayout);
        pSelectedRulesLayout.setHorizontalGroup(
            pSelectedRulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSelectedRulesLayout.createSequentialGroup()
                .addComponent(tSelectedRules, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSelectRulesFile, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRulesViewer, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pSelectedRulesLayout.setVerticalGroup(
            pSelectedRulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSelectedRulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bSelectRulesFile)
                .addComponent(bRulesViewer)
                .addComponent(tSelectedRules, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected Algorithm"));

        bStart.setText("Start");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tSelectedAlgorithm)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tSelectedAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bStart))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pSelectedRules, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pAlgorithms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbResults, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pSelectedRules, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pAlgorithms, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                    .addComponent(tbResults))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bSelectRulesFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectRulesFileActionPerformed
        int option = chRulesFile.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            String pathFile = chRulesFile.getSelectedFile().getAbsolutePath();
            try {
                if (Util.isAssociationFile(pathFile)) {
                    ParserAssociationPrepos parser = new ParserAssociationPrepos(new Scanner(new File(pathFile)).useDelimiter("\\Z").next());
                    parser.buildAssociationRules();
                    associationRules = parser.getRules();
                    isAssociationRules = true;
                    isProductionRules = false;
                } else if (Util.isClassificationFile(pathFile)) {
                    ParserClassifierPrepos parser = new ParserClassifierPrepos(new Scanner(new File(pathFile)).useDelimiter("\\Z").next());
                    parser.buildProductionRules();
                    productionRules = parser.getRules();
                    isAssociationRules = false;
                    isProductionRules = true;
                }
                tSelectedRules.setText(pathFile);
                bRulesViewer.setEnabled(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Postprocessing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        bStart.setEnabled(true);
    }//GEN-LAST:event_bSelectRulesFileActionPerformed

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
        if (tAlgorithms.getSelectionPath().toString().contains("Exception Rules")) {
            ExceptionRuleSearcher exceptions = new ExceptionRuleSearcher(associationRules);
            exceptions.find();
            tResult.gettResult().setText(exceptions.toString());
            tStatistics.gettStatistic().setText(exceptions.statistics());
        } else if (tAlgorithms.getSelectionPath().toString().contains("Filter")) {
            RulesFilter filter = new RulesFilter(associationRules);
            GUIRulesFilter GUIFilter = new GUIRulesFilter(filter, this);

            GUIFilter.setVisible(true);
        } else if (tAlgorithms.getSelectionPath().toString().contains("Redundancy")) {
            RedundancyElimination redundancyElimination = new RedundancyElimination(productionRules);
            redundancyElimination.eliminate();
            tResult.gettResult().setText(redundancyElimination.toString());
            tStatistics.gettStatistic().setText(redundancyElimination.statistics());
        }
    }//GEN-LAST:event_bStartActionPerformed

    private void bRulesViewerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRulesViewerActionPerformed
        if (this.isAssociationRules) {
            GUIAssociationRuleViewer viewer = new GUIAssociationRuleViewer(associationRules);
            viewer.setVisible(true);
        } else if (this.isProductionRules) {
            GUIClassificationRuleViewer viewer = new GUIClassificationRuleViewer(productionRules);
            viewer.setVisible(true);
        }
    }//GEN-LAST:event_bRulesViewerActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRulesViewer;
    private javax.swing.JButton bSelectRulesFile;
    private javax.swing.JButton bStart;
    private javax.swing.JFileChooser chRulesFile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane pAlgorithms;
    private javax.swing.JPanel pSelectedRules;
    private javax.swing.JTextField tSelectedAlgorithm;
    private javax.swing.JTextField tSelectedRules;
    private javax.swing.JTabbedPane tbResults;
    // End of variables declaration//GEN-END:variables
}