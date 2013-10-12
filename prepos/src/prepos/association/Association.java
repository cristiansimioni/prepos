package prepos.association;

import prepos.database.Database;

/*
 * Author: Cristian Simioni
 * Last update: 09/03/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public interface Association {

    // Get all associations from database
    public String getAssociations(Database database, String parameters) throws Exception;
}
