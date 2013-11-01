/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prepos.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class ParserDictionary {

    private File file;

    public ParserDictionary(File file) {
        this.file = file;
    }
    
    public MySQLPreparator parser() {
        MySQLPreparator preparator = new MySQLPreparator();
        MySQLTable current = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            preparator.setName(in.readLine());
            while (in.ready()) {
                str = in.readLine();
                if (!str.contains(";")) {
                    if (current != null) {
                        preparator.addTable(current);
                    }
                    current = new MySQLTable(str);
                } else {
                    String[] values = str.split(";");
                    MySQLAttribute attr = new MySQLAttribute(values[0], values[3], Integer.parseInt(values[1]), Integer.parseInt(values[2]));
                    current.addAttribute(attr);
                }
            }
            preparator.addTable(current);
            in.close();
        } catch (IOException e) {
        }

        System.out.println(preparator.getName());
        for (MySQLTable table : preparator.getTables()) {
            System.out.println(table.getName());
            for (MySQLAttribute attr : table.getAttributes()) {
                System.out.println(attr.getName() + ";" + attr.getStart() + ";" + attr.getEnd() + ";" + attr.getType());
            }
        }

        return preparator;
    }
}
