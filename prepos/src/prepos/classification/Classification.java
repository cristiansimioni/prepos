package prepos.classification;

import prepos.database.Database;

/*
 * Author: Cristian Simioni
 * Last updated: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public interface Classification {

    // Get the classification from database
    public String getClassification(Database database, String parameters) throws Exception;
}
