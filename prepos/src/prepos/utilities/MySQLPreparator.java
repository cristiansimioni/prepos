package prepos.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import prepos.core.FileSaver;

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
    public MySQLPreparator() {
        this.tables = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MySQLTable> getTables() {
        return tables;
    }

    public void setTables(ArrayList<MySQLTable> tables) {
        this.tables = tables;
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

    public void buildScript(String name, String path) throws IOException {
        StringBuilder msg = new StringBuilder();

        // Header
        msg.append("CREATE DATABASE " + getName().replace(" ", "") + ";\n");
        msg.append("USE DATABASE " + getName().replace(" ", "") + ";\n");
        msg.append("-- -- -- -- -- -- -- -- -- -- -- -- -- --\n\n\n");

        // Tables
        for (MySQLTable table : getTables()) {
            msg.append("CREATE TABLE " + table.getName().replace(" ", "") + " (\n");
            for (int i = 0; i < table.getAttributes().size(); i++) {
                if (i != table.getAttributes().size() - 1) {
                    msg.append("\t" + table.getAttributes().get(i).getName() + " " + table.getAttributes().get(i).getType() + ",\n");
                } else {
                    msg.append("\t" + table.getAttributes().get(i).getName() + " " + table.getAttributes().get(i).getType() + "\n");
                }
            }
            
            msg.append(");\n\n");
        }

        FileSaver saver = new FileSaver(name, path, msg.toString());
        saver.save();
    }
    
    public void buildFiles(String path) throws IOException {
        for (MySQLTable table : getTables()) {
            FileSaver file = new FileSaver(table.getName() + ".csv", path + "\\" + table.getName() + ".csv");
            StringBuilder msg = new StringBuilder();
            
            BufferedReader in = new BufferedReader(new FileReader(table.getPathFile()));
            String str;
            while (in.ready()) {
                str = in.readLine();
                for (MySQLAttribute attr : table.getAttributes()) {
                    String value = str.substring(attr.getStart(), attr.getEnd() + 1);
                    if (value.charAt(0) == ' ') {
                        msg.append("\\N;");
                    } else {
                        msg.append(value + ";");
                    }       
                }
                msg.append("\n");
            }
            
            in.close();
            file.setText(msg.toString());
            file.save();
        }
    }
}
