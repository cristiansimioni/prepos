package prepos.gui.datamining;

import java.io.File;
import java.io.IOException;
import prepos.core.Shared;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import weka.core.Attribute;
import java.util.logging.Level;
import java.util.logging.Logger;
import prepos.core.SystemInfo;
import prepos.database.Database;
import weka.core.converters.ArffSaver;
import weka.core.converters.C45Saver;
import weka.core.converters.CSVSaver;

public class SelectDatabase extends javax.swing.JPanel {

    private ResourceBundle messages;

    public SelectDatabase() {
        try {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", Locale.getDefault());
        } catch (Exception e) {
            messages = ResourceBundle.getBundle("prepos.core.languages.language", new Locale("en", "US"));
            SystemInfo.getLog().log(Level.WARNING, e.getLocalizedMessage());
        }
        initComponents();
        initResources();
        initLabels();
    }

    private void initLabels() {
        bSelectDatabase.setText(messages.getString("CHOOSE_DATABASE"));
        bSaveDatabase.setText(messages.getString("SAVE_DATABASE"));
        bRemove.setText(messages.getString("REMOVE"));
        lAttributes.setText(messages.getString("ATTRIBUTES") + ":");
        lDistinct.setText(messages.getString("DISTINCT") + ":");
        lInstances.setText(messages.getString("INSTANCES") + ":");
        lMissing.setText(messages.getString("MISSING") + ":");
        lName.setText(messages.getString("NAME") + ":");
        lRelation.setText(messages.getString("NAME") + ":");
        lType.setText(messages.getString("TYPE") + ":");
        pCurrentRelation.setBorder(javax.swing.BorderFactory.createTitledBorder(messages.getString("CURRENT_RELATION")));
        pAttributes.setBorder(javax.swing.BorderFactory.createTitledBorder(messages.getString("ATTRIBUTES")));
        pSelectedAttribute.setBorder(javax.swing.BorderFactory.createTitledBorder(messages.getString("SELECTED_ATTRIBUTE")));
        pCurrentRelation.setName(messages.getString("CURRENT_RELATION"));
        // Welcome message
        Shared.getInstance().changeStatus(messages.getString("MSG_WELCOME") + " " + SystemInfo.getName());
    }

    private void initResources() {
        // File filters
        FileNameExtensionFilter arffFilter = new FileNameExtensionFilter("ARFF data files (*.arff)", "arff");
        FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("CSV data files (*.csv)", "csv");
        FileNameExtensionFilter c45DataFilter = new FileNameExtensionFilter("C4.5 data files (*.data)", "data");
        FileNameExtensionFilter c45NamesFilter = new FileNameExtensionFilter("C4.5 data files (*.names)", "names");

        // Add all file filters
        chSelectDatabase.addChoosableFileFilter(arffFilter);
        chSelectDatabase.addChoosableFileFilter(csvFilter);
        chSelectDatabase.addChoosableFileFilter(c45DataFilter);
        chSelectDatabase.addChoosableFileFilter(c45NamesFilter);

        // Set main file filter
        chSelectDatabase.setFileFilter(arffFilter);

        // Disable buttons
        bRemove.setEnabled(false);
        bSaveDatabase.setEnabled(false);

        // Event when selected attribute on list
        tAttributes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                DefaultTableModel model = (DefaultTableModel) tSelectedAtrribute.getModel();
                model.setNumRows(0);
                int selected = tAttributes.getSelectedRow();
                if (selected >= 0) {
                    Attribute attr = Shared.getInstance().getDatabase().getAttribute(selected);
                    for (int i = 0; i < attr.numValues(); i++) {
                        model.addRow(new Object[]{i + 1, attr.value(i), Shared.getInstance().getDatabase().getInstances().attributeStats(selected).nominalCounts[i]});
                    }

                    lName.setText(messages.getString("NAME") + ": " + attr.name());
                    lMissing.setText(messages.getString("MISSING") + ": " + Shared.getInstance().getDatabase().getInstances().attributeStats(selected).missingCount + " (" + Math.round((((float) Shared.getInstance().getDatabase().getInstances().attributeStats(selected).missingCount / (float) Shared.getInstance().getDatabase().getInstances().numInstances()) * 100)) + "%)");
                    lDistinct.setText(messages.getString("DISTINCT") + ": " + Shared.getInstance().getDatabase().getInstances().numDistinctValues(selected));
                    lType.setText(messages.getString("TYPE") + ": " + Attribute.typeToString(Shared.getInstance().getDatabase().getInstances().attribute(selected).type()));
                } else {
                    lName.setText(messages.getString("NAME") + ": ");
                    lMissing.setText(messages.getString("MISSING") + ": ");
                    lDistinct.setText(messages.getString("DISTINCT") + ": ");
                    lType.setText(messages.getString("TYPE") + ": ");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chSelectDatabase = new javax.swing.JFileChooser();
        pCurrentRelation = new javax.swing.JPanel();
        lRelation = new javax.swing.JLabel();
        lInstances = new javax.swing.JLabel();
        lAttributes = new javax.swing.JLabel();
        pAttributes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAttributes = new javax.swing.JTable();
        bRemove = new javax.swing.JButton();
        pSelectedAttribute = new javax.swing.JPanel();
        lMissing = new javax.swing.JLabel();
        lType = new javax.swing.JLabel();
        lDistinct = new javax.swing.JLabel();
        lName = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tSelectedAtrribute = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        bSelectDatabase = new javax.swing.JToggleButton();
        bSaveDatabase = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));

        pCurrentRelation.setBorder(javax.swing.BorderFactory.createTitledBorder("Current Relation"));
        pCurrentRelation.setMaximumSize(new java.awt.Dimension(374, 64));
        pCurrentRelation.setMinimumSize(new java.awt.Dimension(374, 64));
        pCurrentRelation.setPreferredSize(new java.awt.Dimension(374, 64));

        lRelation.setText("Relation: None");
        lRelation.setMaximumSize(new java.awt.Dimension(352, 14));
        lRelation.setMinimumSize(new java.awt.Dimension(352, 14));
        lRelation.setPreferredSize(new java.awt.Dimension(352, 14));

        lInstances.setText("Instances: None");
        lInstances.setMaximumSize(new java.awt.Dimension(218, 14));
        lInstances.setMinimumSize(new java.awt.Dimension(218, 14));
        lInstances.setPreferredSize(new java.awt.Dimension(218, 14));

        lAttributes.setText("Attributes: None");

        javax.swing.GroupLayout pCurrentRelationLayout = new javax.swing.GroupLayout(pCurrentRelation);
        pCurrentRelation.setLayout(pCurrentRelationLayout);
        pCurrentRelationLayout.setHorizontalGroup(
            pCurrentRelationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCurrentRelationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCurrentRelationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lRelation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pCurrentRelationLayout.createSequentialGroup()
                        .addComponent(lInstances, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lAttributes, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pCurrentRelationLayout.setVerticalGroup(
            pCurrentRelationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCurrentRelationLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lRelation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCurrentRelationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInstances, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lAttributes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pAttributes.setBorder(javax.swing.BorderFactory.createTitledBorder("Attributes"));
        pAttributes.setMaximumSize(new java.awt.Dimension(374, 355));
        pAttributes.setMinimumSize(new java.awt.Dimension(374, 355));
        pAttributes.setPreferredSize(new java.awt.Dimension(374, 355));

        tAttributes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tAttributes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tAttributes);
        tAttributes.getColumnModel().getColumn(0).setMinWidth(30);
        tAttributes.getColumnModel().getColumn(0).setMaxWidth(50);
        tAttributes.getColumnModel().getColumn(1).setResizable(false);

        bRemove.setText("Remove");
        bRemove.setMaximumSize(new java.awt.Dimension(362, 23));
        bRemove.setMinimumSize(new java.awt.Dimension(362, 23));
        bRemove.setPreferredSize(new java.awt.Dimension(362, 23));
        bRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pAttributesLayout = new javax.swing.GroupLayout(pAttributes);
        pAttributes.setLayout(pAttributesLayout);
        pAttributesLayout.setHorizontalGroup(
            pAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(bRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pAttributesLayout.setVerticalGroup(
            pAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAttributesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pSelectedAttribute.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected Attribute"));
        pSelectedAttribute.setMaximumSize(new java.awt.Dimension(401, 426));
        pSelectedAttribute.setMinimumSize(new java.awt.Dimension(401, 426));
        pSelectedAttribute.setPreferredSize(new java.awt.Dimension(401, 426));

        lMissing.setText("Missing: None");
        lMissing.setMaximumSize(new java.awt.Dimension(235, 14));
        lMissing.setMinimumSize(new java.awt.Dimension(235, 14));
        lMissing.setPreferredSize(new java.awt.Dimension(235, 14));

        lType.setText("Type: None");
        lType.setMaximumSize(new java.awt.Dimension(133, 14));
        lType.setMinimumSize(new java.awt.Dimension(133, 14));
        lType.setPreferredSize(new java.awt.Dimension(133, 14));

        lDistinct.setText("Distinct: None");

        lName.setText("Name: None");
        lName.setMaximumSize(new java.awt.Dimension(235, 14));
        lName.setMinimumSize(new java.awt.Dimension(235, 14));
        lName.setPreferredSize(new java.awt.Dimension(235, 14));

        tSelectedAtrribute.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Label", "Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tSelectedAtrribute.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tSelectedAtrribute);
        tSelectedAtrribute.getColumnModel().getColumn(0).setMinWidth(30);
        tSelectedAtrribute.getColumnModel().getColumn(0).setMaxWidth(50);
        tSelectedAtrribute.getColumnModel().getColumn(1).setResizable(false);
        tSelectedAtrribute.getColumnModel().getColumn(2).setResizable(false);

        javax.swing.GroupLayout pSelectedAttributeLayout = new javax.swing.GroupLayout(pSelectedAttribute);
        pSelectedAttribute.setLayout(pSelectedAttributeLayout);
        pSelectedAttributeLayout.setHorizontalGroup(
            pSelectedAttributeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSelectedAttributeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSelectedAttributeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lMissing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pSelectedAttributeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lDistinct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSelectedAttributeLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pSelectedAttributeLayout.setVerticalGroup(
            pSelectedAttributeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSelectedAttributeLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pSelectedAttributeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pSelectedAttributeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMissing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lDistinct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Database options"));
        jPanel1.setMaximumSize(new java.awt.Dimension(780, 46));
        jPanel1.setMinimumSize(new java.awt.Dimension(780, 46));
        jPanel1.setPreferredSize(new java.awt.Dimension(780, 46));

        bSelectDatabase.setText("Choose Database");
        bSelectDatabase.setMaximumSize(new java.awt.Dimension(180, 23));
        bSelectDatabase.setMinimumSize(new java.awt.Dimension(180, 23));
        bSelectDatabase.setPreferredSize(new java.awt.Dimension(180, 23));
        bSelectDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectDatabaseActionPerformed(evt);
            }
        });

        bSaveDatabase.setText("Save Database");
        bSaveDatabase.setMaximumSize(new java.awt.Dimension(180, 23));
        bSaveDatabase.setMinimumSize(new java.awt.Dimension(180, 23));
        bSaveDatabase.setPreferredSize(new java.awt.Dimension(180, 23));
        bSaveDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveDatabaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(bSelectDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSaveDatabase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(394, 394, 394))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bSelectDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bSaveDatabase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pAttributes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pCurrentRelation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pSelectedAttribute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pCurrentRelation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pAttributes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pSelectedAttribute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pAttributes.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    // Button > Select database
    private void bSelectDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectDatabaseActionPerformed
        int option = chSelectDatabase.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            String pathFile = chSelectDatabase.getSelectedFile().getAbsolutePath();

            try {
                Shared.getInstance().changeStatus(messages.getString("MSG_LOADING_DATABASE") + " " + chSelectDatabase.getSelectedFile().getName());

                Database database = new Database(pathFile);
                Shared.getInstance().setDatabase(database);

                // Update labels
                lRelation.setText(messages.getString("NAME") + ": " + Shared.getInstance().getDatabase().relationName());
                lInstances.setText(messages.getString("INSTANCES") + ": " + Shared.getInstance().getDatabase().numInstances());
                lAttributes.setText(messages.getString("ATTRIBUTES") + ": " + Shared.getInstance().getDatabase().numAttributes());

                // Enable tabs
                Shared.getInstance().getOptions().setEnabledAt(1, true);
                Shared.getInstance().getOptions().setEnabledAt(2, true);
                Shared.getInstance().getOptions().setEnabledAt(3, true);

                // Add Attributes on table
                DefaultTableModel model = (DefaultTableModel) tAttributes.getModel();
                model.setNumRows(0);
                for (int i = 0; i < Shared.getInstance().getDatabase().numAttributes(); i++) {
                    model.addRow(new Object[]{i + 1, Shared.getInstance().getDatabase().getInstances().attribute(i).name()});
                }

                Shared.getInstance().changeStatus(messages.getString("MSG_LOAD_SUCCESSFUL"));

                bRemove.setEnabled(true);
                bSaveDatabase.setEnabled(true);


            } catch (Exception e) {
                Shared.getInstance().changeStatus(messages.getString("MSG_LOAD_FAILURE"));
                JOptionPane.showMessageDialog(null, e.getMessage(), messages.getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_bSelectDatabaseActionPerformed

    private void bRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveActionPerformed
        if (Shared.getInstance().getDatabase().numAttributes() > 1) {
            int selected = tAttributes.getSelectedRow();
            // Verify if selected attribute is the class
            if (Shared.getInstance().getDatabase().getInstances().classIndex() == selected) {
                Shared.getInstance().getDatabase().getInstances().setClassIndex(selected - 1);
            }

            Shared.getInstance().changeStatus("Attribute removed.");
            // Remove attribute
            Shared.getInstance().getDatabase().getInstances().deleteAttributeAt(selected);

            // Update attributes on table
            DefaultTableModel model = (DefaultTableModel) tAttributes.getModel();
            model.setNumRows(0);
            for (int i = 0; i < Shared.getInstance().getDatabase().numAttributes(); i++) {
                model.addRow(new Object[]{i + 1, Shared.getInstance().getDatabase().getInstances().attribute(i).name()});
            }


        }
    }//GEN-LAST:event_bRemoveActionPerformed

    private void bSaveDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveDatabaseActionPerformed
        int option = chSelectDatabase.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            String pathFile = chSelectDatabase.getSelectedFile().getAbsolutePath();
            String type = chSelectDatabase.getFileFilter().getDescription();

            if (pathFile.contains(".")) {
                pathFile = pathFile.substring(0, pathFile.lastIndexOf("."));
            }

            if (type.equals("ARFF data files (*.arff)") || type.equals("Todos os Arquivos")) {
                ArffSaver saver = new ArffSaver();
                try {
                    pathFile += ".arff";
                    saver.setInstances(Shared.getInstance().getDatabase().getInstances());
                    saver.setFile(new File(pathFile));
                    saver.writeBatch();
                } catch (IOException ex) {
                    Logger.getLogger(SelectDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (type.equals("CSV data files (*.csv)")) {
                CSVSaver saver = new CSVSaver();
                try {
                    pathFile += ".csv";
                    saver.setInstances(Shared.getInstance().getDatabase().getInstances());
                    //saver.setFieldSeparator(";");
                    saver.setFile(new File(pathFile));
                    saver.writeBatch();
                } catch (IOException ex) {
                    Logger.getLogger(SelectDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (type.equals("C4.5 data files (*.data)") || type.equals("C4.5 data files (*.names)")) {
                C45Saver saver = new C45Saver();
                try {
                    if (!pathFile.endsWith(".names")) {
                        pathFile += ".names";
                    }
                    saver.setInstances(Shared.getInstance().getDatabase().getInstances());
                    saver.setFile(new File(pathFile));
                    saver.writeBatch();
                } catch (IOException ex) {
                    Logger.getLogger(SelectDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_bSaveDatabaseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRemove;
    private javax.swing.JButton bSaveDatabase;
    private javax.swing.JToggleButton bSelectDatabase;
    private javax.swing.JFileChooser chSelectDatabase;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lAttributes;
    private javax.swing.JLabel lDistinct;
    private javax.swing.JLabel lInstances;
    private javax.swing.JLabel lMissing;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lRelation;
    private javax.swing.JLabel lType;
    private javax.swing.JPanel pAttributes;
    private javax.swing.JPanel pCurrentRelation;
    private javax.swing.JPanel pSelectedAttribute;
    private javax.swing.JTable tAttributes;
    private javax.swing.JTable tSelectedAtrribute;
    // End of variables declaration//GEN-END:variables
}
