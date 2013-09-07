package prepos.classification;

import prepos.database.Database;
import weka.classifiers.trees.J48;

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
