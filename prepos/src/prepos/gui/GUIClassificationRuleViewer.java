package prepos.gui;

import prepos.core.SystemInfo;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import prepos.rules.ProductionRule;

public class GUIClassificationRuleViewer extends javax.swing.JFrame {

    private ResourceBundle messages;
    private ArrayList<ProductionRule> rules;

    public GUIClassificationRuleViewer(ArrayList<ProductionRule> rules) {
        this.rules = rules;
        try {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", Locale.getDefault());
        } catch (Exception e) {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", new Locale("en", "US"));
            SystemInfo.getLog().log(Level.WARNING, e.getLocalizedMessage());
        }

        initLayout();
        initComponents();
        initResources();
        initLabels();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tRules = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tRules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Premise", "Consequent", "Miss", "Hit", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tRules.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tRules);
        tRules.getColumnModel().getColumn(0).setMinWidth(70);
        tRules.getColumnModel().getColumn(0).setPreferredWidth(70);
        tRules.getColumnModel().getColumn(0).setMaxWidth(70);
        tRules.getColumnModel().getColumn(1).setResizable(false);
        tRules.getColumnModel().getColumn(2).setResizable(false);
        tRules.getColumnModel().getColumn(3).setMinWidth(75);
        tRules.getColumnModel().getColumn(3).setPreferredWidth(30);
        tRules.getColumnModel().getColumn(3).setMaxWidth(75);
        tRules.getColumnModel().getColumn(4).setMinWidth(75);
        tRules.getColumnModel().getColumn(4).setPreferredWidth(20);
        tRules.getColumnModel().getColumn(4).setMaxWidth(75);
        tRules.getColumnModel().getColumn(5).setMinWidth(15);
        tRules.getColumnModel().getColumn(5).setPreferredWidth(5);
        tRules.getColumnModel().getColumn(5).setMaxWidth(15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initLabels() {
    }

    private void initLayout() {
        // Localização
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
            java.util.logging.Logger.getLogger(GUIChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void initResources() {
        // Seta o ícone
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/prepos/resources/icons/icon.png")));
        // Initialize the table
        DefaultTableModel model = (DefaultTableModel) tRules.getModel();
        int i = 1;
        for (ProductionRule rule : this.rules) {
            model.addRow(new Object[]{i, rule.strPremise(), rule.strConsequent(), rule.getHit(), rule.getMiss(), false});
            i++;
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tRules;
    // End of variables declaration//GEN-END:variables
}
