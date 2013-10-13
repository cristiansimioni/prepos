package prepos.database;

import java.io.IOException;
import weka.core.Instances;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public interface DatabaseLoader {

    // Get all informations and instances from database
    public Instances loadDatabase(String path) throws IOException;
}