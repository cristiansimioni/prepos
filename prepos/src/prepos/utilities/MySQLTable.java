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
public class MySQLTable {

    // Attributes
    private String pathFile;
    private String name;
    private ArrayList<MySQLAttribute> attributes;

    // Constructor
    public MySQLTable(String name) {
        this.name = name;
        this.attributes = new ArrayList<>();
    }

    // Getter & setter
    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MySQLAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<MySQLAttribute> attributes) {
        this.attributes = attributes;
    }

    // Methods
    // Add attribute
    public void addAttribute(MySQLAttribute attribute) {
        attributes.add(attribute);
    }

    // Remove attribute by index
    public void removeAttribute(int index) {
        attributes.remove(index);
    }
}
