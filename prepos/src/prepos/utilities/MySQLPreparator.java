package prepos.utilities;

import java.util.ArrayList;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class MySQLPreparator {

    // Attributes
    private String name;
    private ArrayList<MySQLTable> tables;

    // Constructor
    public MySQLPreparator(String name) {
        this.name = name;
        this.tables = new ArrayList<>();
    }

    // Add new table
    public void addTable(MySQLTable table) {
        tables.add(table);
    }

    // Get the table by path
    public MySQLTable getTableByPath(String path) {
        for (MySQLTable table : tables) {
            if (table.getPathFile().equals(path)) {
                return table;
            }
        }
        return null;
    }
}
