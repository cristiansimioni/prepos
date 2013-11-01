package prepos.gui.postprocessing;

import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import prepos.core.SystemInfo;
import prepos.postprocessing.RulesFilter;
import prepos.rules.AssociationRule;
import prepos.rules.AttributeValue;

public class GUIUserDrivenQuestion extends javax.swing.JDialog {

    private ArrayList<AssociationRule> rules;
    private int index;

    public GUIUserDrivenQuestion(ArrayList<AssociationRule> rules, int index) {
        this.rules = rules;
        this.index = index;
        initLayout();
        initComponents();
        initLabels();
        initResources();
    }

    private void initLabels() {
    }

    private void initResources() {
        DefaultTableModel modelp = (DefaultTableModel) tSelectedPremises.getModel();
        DefaultTableModel modelc = (DefaultTableModel) tSelectedConsequents.getModel();

        AssociationRule rule = rules.get(this.index);

        for (AttributeValue attr : rule.getPremises()) {
            modelp.addRow(new Object[]{attr.getAttribute(), false});
        }

        for (AttributeValue attr : rule.getConsequents()) {
            modelc.addRow(new Object[]{attr.getAttribute(), false});
        }
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

    public ArrayList<AssociationRule> getRules() {
        return rules;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bSave = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        pPremise = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tSelectedPremises = new javax.swing.JTable();
        pConsequent = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tSelectedConsequents = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Question");
        setModal(true);
        setResizable(false);

        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        pPremise.setBorder(javax.swing.BorderFactory.createTitledBorder("What premise became the rule uninteresting?"));

        tSelectedPremises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Label", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tSelectedPremises);

        javax.swing.GroupLayout pPremiseLayout = new javax.swing.GroupLayout(pPremise);
        pPremise.setLayout(pPremiseLayout);
        pPremiseLayout.setHorizontalGroup(
            pPremiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
        );
        pPremiseLayout.setVerticalGroup(
            pPremiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pConsequent.setBorder(javax.swing.BorderFactory.createTitledBorder("What consequent became the rule uninteresting?"));

        tSelectedConsequents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Label", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tSelectedConsequents);

        javax.swing.GroupLayout pConsequentLayout = new javax.swing.GroupLayout(pConsequent);
        pConsequent.setLayout(pConsequentLayout);
        pConsequentLayout.setHorizontalGroup(
            pConsequentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pConsequentLayout.setVerticalGroup(
            pConsequentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 79, Short.MAX_VALUE)
                        .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pPremise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pConsequent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pPremise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pConsequent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSave)
                    .addComponent(bCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        ArrayList<String> selectedPremises = new ArrayList<>();
        ArrayList<String> selectedConsquents = new ArrayList<>();

        DefaultTableModel mPremises = (DefaultTableModel) tSelectedPremises.getModel();
        for (int i = 0; i < mPremises.getRowCount(); i++) {
            if ((boolean) mPremises.getValueAt(i, 1)) {
                selectedPremises.add((String) mPremises.getValueAt(i, 0));
            }
        }

        DefaultTableModel mConsequents = (DefaultTableModel) tSelectedConsequents.getModel();
        for (int i = 0; i < mConsequents.getRowCount(); i++) {
            if ((boolean) mConsequents.getValueAt(i, 1)) {
                selectedConsquents.add((String) mConsequents.getValueAt(i, 0));
            }
        }

        RulesFilter filter = new RulesFilter(rules);
        filter.setSelectedPremises(selectedPremises);
        filter.setSelectedConsequents(selectedConsquents);
        filter.setAnd(true);
        rules = filter.filter();
        this.dispose();
    }//GEN-LAST:event_bSaveActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pConsequent;
    private javax.swing.JPanel pPremise;
    private javax.swing.JTable tSelectedConsequents;
    private javax.swing.JTable tSelectedPremises;
    // End of variables declaration//GEN-END:variables
}
