package prepos.preprocessing;

import prepos.database.Database;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class AprioriPreparator {

    // Attributes
    private Database database;

    // Constructor
    public AprioriPreparator(Database database) {
        this.database = database;
    }

    // Getter & setter
    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    // Methods
    // Prepare database to Apriori algorithm
    public String prepareDatabase() {
        StringBuilder msg = new StringBuilder();
        String line;
        for (int i = 0; i < database.numInstances(); i++) {
            line = "";
            for (int j = 0; j < database.numAttributes(); j++) {
                if (!database.getInstances().instance(i).toString(j).equals("?")) {
                    line += database.getAttribute(j).name().replace(" ", "");
                    line += "_";
                    line += database.getInstances().instance(i).toString(j).replace(" ", "");
                    line += " ";
                }
            }
            line = line.trim();
            line += "\n";
            msg.append(line);
        }
        return msg.toString();
    }
}