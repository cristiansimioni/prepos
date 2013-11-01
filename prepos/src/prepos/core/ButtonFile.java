package prepos.core;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import prepos.gui.postprocessing.GUIMeasuresInformation;
import prepos.rules.AssociationRule;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class ButtonFile extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

    JTable table;
    JButton renderButton;
    JButton editButton;
    String text;
    int row;

    public ButtonFile(JTable table, int column) {
        super();
        this.table = table;
        renderButton = new JButton();

        editButton = new JButton();
        editButton.setFocusPainted(false);
        editButton.addActionListener(this);

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer(this);
        columnModel.getColumn(column).setCellEditor(this);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (hasFocus) {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        } else if (isSelected) {
            renderButton.setForeground(table.getSelectionForeground());
            renderButton.setBackground(table.getSelectionBackground());
        } else {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        renderButton.setText("File");
        return renderButton;
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column) {
        text = "File";
        editButton.setText(text);
        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        return text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            String pathFile = chooser.getSelectedFile().getAbsolutePath();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setValueAt(pathFile, table.getSelectedRow(), 1);
        }
    }

    @Override
    protected void fireEditingStopped() {
    }
}
