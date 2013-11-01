package prepos.gui.postprocessing;

import java.util.logging.Level;
import prepos.core.SystemInfo;
import prepos.rules.AssociationRule;

public class GUIMeasuresInformation extends javax.swing.JDialog {

    private AssociationRule rule;

    public GUIMeasuresInformation(AssociationRule rule) {
        this.rule = rule;
        initLayout();
        initComponents();
        initLabels();
    }

    private void initLabels() {
        lConfidence.setText("Confidence: " + rule.getConfidence());
        lSupport.setText("Support: " + rule.getSupport());
        lCountPremisses.setText("Count of Premises: " + rule.getPremises().size());
        lCountConsequents.setText("Count of Consequents: "+ rule.getConsequents().size());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lConfidence = new javax.swing.JLabel();
        lSupport = new javax.swing.JLabel();
        lCountPremisses = new javax.swing.JLabel();
        lCountConsequents = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rule Information");
        setModal(true);
        setResizable(false);

        lConfidence.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lConfidence.setText("Confidence of rule:");

        lSupport.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSupport.setText("Support of rule:");
        lSupport.setToolTipText("");

        lCountPremisses.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lCountPremisses.setText("Count of premises:");
        lCountPremisses.setToolTipText("");

        lCountConsequents.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lCountConsequents.setText("Count of consequents:");
        lCountConsequents.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lCountConsequents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lCountPremisses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lSupport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lConfidence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lConfidence)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lSupport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCountPremisses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCountConsequents)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lConfidence;
    private javax.swing.JLabel lCountConsequents;
    private javax.swing.JLabel lCountPremisses;
    private javax.swing.JLabel lSupport;
    // End of variables declaration//GEN-END:variables
}
