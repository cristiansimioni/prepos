/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prepos.database;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 *
 * @author Cristian
 */
public class DatabaseArffLoader implements DatabaseLoader {

    @Override
    public Instances loadDatabase(String path) throws IOException {
        ArffLoader arff = new ArffLoader();
        arff.setFile(new File(path));
        return arff.getDataSet();
    }
}
