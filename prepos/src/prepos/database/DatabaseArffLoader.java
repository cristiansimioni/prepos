package prepos.database;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class DatabaseArffLoader implements DatabaseLoader {

    @Override
    public Instances loadDatabase(String path) throws IOException {
        ArffLoader arff = new ArffLoader();
        arff.setFile(new File(path));
        return arff.getDataSet();
    }
}
