package prepos.gui.parameters;

import java.util.logging.Level;
import prepos.core.SystemInfo;
import prepos.database.Database;

public class ParametersDatabaseDenormalizer extends javax.swing.JDialog {

    private String parameters;
    private Database database;
    private int indexOfId;
    private int indexOfItem;
    
    public ParametersDatabaseDenormalizer(Database database, String parameters) {
        this.database = database;
        this.parameters = parameters;
        initLayout();
        initComponents();
        initResources();
    }

    public String getParameters() {
        return parameters;
    }

    
    
    private void initResources() {
        if (!parameters.isEmpty()) {
            String [] allParamenters = parameters.split(" ");
            for (String parameter : allParamenters) {
                if (parameter.contains("-d")) {
                    indexOfId = Integer.parseInt(parameter.split("-d")[1]);
                } else if (parameter.contains("-i")) {
                    indexOfItem = Integer.parseInt(parameter.split("-i")[1]);
                }
            }
        }
        
        for (int i = 0; i < database.numAttributes(); i++) {
            lsIdAttribute.addItem(database.getAttribute(i).name());
            lsItemAttribute.addItem(database.getAttribute(i).name());
        }
        
        lsIdAttribute.setSelectedIndex(indexOfId);
        lsItemAttribute.setSelectedIndex(indexOfItem);
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

        lIdAttribute = new javax.swing.JLabel();
        bCancel = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        lsIdAttribute = new javax.swing.JComboBox();
        lItemAtrribute = new javax.swing.JLabel();
        lsItemAttribute = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parameters - Apriori (Borgelt)");
        setModal(true);
        setResizable(false);

        lIdAttribute.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lIdAttribute.setText("Select the id attribute:");

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        lItemAtrribute.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lItemAtrribute.setText("Select the item attribute:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lIdAttribute, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lsIdAttribute, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lsItemAttribute, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lItemAtrribute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lIdAttribute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lsIdAttribute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lItemAtrribute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lsItemAttribute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancel)
                    .addComponent(bSave))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        lIdAttribute.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        parameters = "-d" + lsIdAttribute.getSelectedIndex() + " -i" + lsItemAttribute.getSelectedIndex();
        this.dispose();
    }//GEN-LAST:event_bSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bSave;
    private javax.swing.JLabel lIdAttribute;
    private javax.swing.JLabel lItemAtrribute;
    private javax.swing.JComboBox lsIdAttribute;
    private javax.swing.JComboBox lsItemAttribute;
    // End of variables declaration//GEN-END:variables
}
