package prepos.gui.utilities;

import java.util.HashMap;
import java.util.Hashtable;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import prepos.utilities.MySQLAttribute;
import prepos.utilities.MySQLPreparator;
import prepos.utilities.MySQLTable;

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
    private DefaultListModel model;
    private MySQLPreparator sqlPreparator;
    private MySQLTable currentTable;
    private Hashtable files;

    public GUIMySQLPreparator() {
        initComponents();
        initResources();
    }

    private void initResources() {
        model = new DefaultListModel();

        // Event when the user changes the file
        lFiles.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                tTableName.setText((String) lFiles.getSelectedValue());
                MySQLTable current = (MySQLTable) files.get(lFiles.getSelectedValue());
                DefaultTableModel model = (DefaultTableModel) tbAttributes.getModel();

                model.setNumRows(0);
                for (MySQLAttribute attribute : current.getAttributes()) {
                    model.addRow(new Object[]{attribute.getName(), attribute.getType(), attribute.getStart(), attribute.getEnd()});
                }

            }
        });

        files = new Hashtable();
        sqlPreparator = new MySQLPreparator("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chFile = new javax.swing.JFileChooser();
        pFiles = new javax.swing.JPanel();
        bAddFile = new javax.swing.JButton();
        bRemoveFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lFiles = new javax.swing.JList();
        pRelation = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        pDictionary = new javax.swing.JPanel();
        pPreview = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lTableName = new javax.swing.JLabel();
        tTableName = new javax.swing.JTextField();
        pAttributes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAttributes = new javax.swing.JTable();
        bAddAttributes = new javax.swing.JButton();
        bRemoveAttributes = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 500));

        pFiles.setBorder(javax.swing.BorderFactory.createTitledBorder("List of Files"));

        bAddFile.setText("Add File");
        bAddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddFileActionPerformed(evt);
            }
        });

        bRemoveFile.setText("Remove File");
        bRemoveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveFileActionPerformed(evt);
            }
        });

        lFiles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lFiles);

        javax.swing.GroupLayout pFilesLayout = new javax.swing.GroupLayout(pFiles);
        pFiles.setLayout(pFilesLayout);
        pFilesLayout.setHorizontalGroup(
            pFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFilesLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(pFilesLayout.createSequentialGroup()
                        .addComponent(bAddFile, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bRemoveFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(2, 2, 2))
        );
        pFilesLayout.setVerticalGroup(
            pFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFilesLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAddFile)
                    .addComponent(bRemoveFile)))
        );

        pRelation.setBorder(javax.swing.BorderFactory.createTitledBorder("Relation"));

        jButton1.setText("jButton1");

        javax.swing.GroupLayout pRelationLayout = new javax.swing.GroupLayout(pRelation);
        pRelation.setLayout(pRelationLayout);
        pRelationLayout.setHorizontalGroup(
            pRelationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRelationLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        pRelationLayout.setVerticalGroup(
            pRelationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRelationLayout.createSequentialGroup()
                .addGap(0, 78, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pDictionary.setBorder(javax.swing.BorderFactory.createTitledBorder("Dictionary of Variables"));

        pPreview.setBorder(javax.swing.BorderFactory.createTitledBorder("Preview"));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout pPreviewLayout = new javax.swing.GroupLayout(pPreview);
        pPreview.setLayout(pPreviewLayout);
        pPreviewLayout.setHorizontalGroup(
            pPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        pPreviewLayout.setVerticalGroup(
            pPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
        );

        lTableName.setText("Table Name:");

        pAttributes.setBorder(javax.swing.BorderFactory.createTitledBorder("Attributes"));

        tbAttributes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Attribute", "Type", "Start", "End"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbAttributes);
        tbAttributes.getColumnModel().getColumn(0).setResizable(false);
        tbAttributes.getColumnModel().getColumn(1).setResizable(false);
        tbAttributes.getColumnModel().getColumn(2).setResizable(false);
        tbAttributes.getColumnModel().getColumn(3).setResizable(false);

        bAddAttributes.setText("Add Attribute");
        bAddAttributes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddAttributesActionPerformed(evt);
            }
        });

        bRemoveAttributes.setText("Remove Attribute");

        javax.swing.GroupLayout pAttributesLayout = new javax.swing.GroupLayout(pAttributes);
        pAttributes.setLayout(pAttributesLayout);
        pAttributesLayout.setHorizontalGroup(
            pAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
            .addGroup(pAttributesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAddAttributes, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemoveAttributes))
        );
        pAttributesLayout.setVerticalGroup(
            pAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAttributesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAddAttributes)
                    .addComponent(bRemoveAttributes)))
        );

        javax.swing.GroupLayout pDictionaryLayout = new javax.swing.GroupLayout(pDictionary);
        pDictionary.setLayout(pDictionaryLayout);
        pDictionaryLayout.setHorizontalGroup(
            pDictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDictionaryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pAttributes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pDictionaryLayout.createSequentialGroup()
                        .addComponent(lTableName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tTableName)))
                .addContainerGap())
        );
        pDictionaryLayout.setVerticalGroup(
            pDictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDictionaryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTableName)
                    .addComponent(tTableName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pAttributes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pRelation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pDictionary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pDictionary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pRelation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bAddFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddFileActionPerformed
        int option = chFile.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            String path = chFile.getSelectedFile().getAbsolutePath();

            model.addElement(path);
            lFiles.setModel(model);

            MySQLTable table = new MySQLTable(path);
            sqlPreparator.addTable(table);
            files.put(path, table);
        }
    }//GEN-LAST:event_bAddFileActionPerformed

    private void bRemoveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveFileActionPerformed
        int index = lFiles.getSelectedIndex();
        //files.remove(sqlPreparator.getTableByPath((String) lFiles.getSelectedValue()));
        model.remove(index);
    }//GEN-LAST:event_bRemoveFileActionPerformed

    private void bAddAttributesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddAttributesActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbAttributes.getModel();
        model.addRow(new Object[]{"", "", 0, 0});
        MySQLTable current = (MySQLTable) files.get(lFiles.getSelectedValue());
        current.addAttribute(new MySQLAttribute("", "", 0, 0));
        files.put(lFiles.getSelectedValue(), current);
    }//GEN-LAST:event_bAddAttributesActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddAttributes;
    private javax.swing.JButton bAddFile;
    private javax.swing.JButton bRemoveAttributes;
    private javax.swing.JButton bRemoveFile;
    private javax.swing.JFileChooser chFile;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JList lFiles;
    private javax.swing.JLabel lTableName;
    private javax.swing.JPanel pAttributes;
    private javax.swing.JPanel pDictionary;
    private javax.swing.JPanel pFiles;
    private javax.swing.JPanel pPreview;
    private javax.swing.JPanel pRelation;
    private javax.swing.JTextField tTableName;
    private javax.swing.JTable tbAttributes;
    // End of variables declaration//GEN-END:variables
}
