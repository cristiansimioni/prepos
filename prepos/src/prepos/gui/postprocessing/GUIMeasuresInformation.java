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
        lMinSupport = new javax.swing.JLabel();
        lMaxSupport = new javax.swing.JLabel();
        lMinItems = new javax.swing.JLabel();
        lMaxItems = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rule Information");
        setModal(true);
        setResizable(false);

        lConfidence.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lConfidence.setText("Minimum confidence of a rule:");

        lMinSupport.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lMinSupport.setText("Minimum support of a rule:");
        lMinSupport.setToolTipText("");

        lMaxSupport.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lMaxSupport.setText("Maximum support of a rule:");
        lMaxSupport.setToolTipText("");

        lMinItems.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lMinItems.setText("Minimum number of items per rule:");
        lMinItems.setToolTipText("");

        lMaxItems.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lMaxItems.setText("Maximum number of items per rule:");
        lMaxItems.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lMaxItems, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lMinItems, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lMaxSupport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(lMinSupport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lConfidence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lConfidence)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lMinSupport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lMaxSupport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lMinItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lMaxItems)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lConfidence;
    private javax.swing.JLabel lMaxItems;
    private javax.swing.JLabel lMaxSupport;
    private javax.swing.JLabel lMinItems;
    private javax.swing.JLabel lMinSupport;
    // End of variables declaration//GEN-END:variables
}
