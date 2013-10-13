package prepos.database;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class DatabaseCSVLoader implements DatabaseLoader {

    @Override
    public Instances loadDatabase(String path) throws IOException {
        CSVLoader csv = new CSVLoader();
        csv.setFile(new File(path));
        return csv.getDataSet();
    }
}
