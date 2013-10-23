package prepos.classification;

import prepos.database.Database;
import weka.classifiers.trees.J48;

/*
 * Author: Cristian Simioni
 * Last updated: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class ClassificationJ48 implements Classification {

    @Override
    public String getClassification(Database database, String parameters) throws Exception {

        J48 j48 = new J48();

        // Set paramenters
        j48.setOptions(parameters.split(" "));

        // Build classifier
        j48.buildClassifier(database.getInstances());

        return j48.toString();
    }
}
