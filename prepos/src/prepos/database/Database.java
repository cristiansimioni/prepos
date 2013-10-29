package prepos.database;

import java.io.IOException;
import prepos.rules.AttributeValue;
import weka.core.Attribute;
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
public class Database {

    // Attributes
    private Instances instances;
    private String path;
    private String type;

    // Constructor
    public Database(String path) throws IOException {
        this.path = path;
        if (path.endsWith(".arff")) {
            instances = new DatabaseArffLoader().loadDatabase(path);
            setType("arff");
        } else if (path.endsWith(".csv")) {
            instances = new DatabaseCSVLoader().loadDatabase(path);
            setType("csv");
        } else if (path.endsWith(".data") || path.endsWith(".names")) {
            instances = new DatabaseC45Loader().loadDatabase(path);
            setType("c45");
        }
        instances.setClassIndex(instances.numAttributes() - 1);
    }

    // Getter & setter
    public Instances getInstances() {
        return instances;
    }

    public void setInstances(Instances instances) {
        this.instances = instances;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    // Methods
    // Get the relation name
    public String relationName() {
        return instances.relationName();
    }

    // Number of instances on database
    public int numInstances() {
        return instances.numInstances();
    }

    // Number of attributes on database
    public int numAttributes() {
        return instances.numAttributes();
    }

    // Get attribute by index
    public Attribute getAttribute(int index) {
        return instances.attribute(index);
    }

    // Verify if the value exists on instance
    public boolean existsOnInstance(AttributeValue attribute, int index) {
        String value;
        if (instances.attribute(attribute.getAttribute()).isNominal()) {
            value = instances.get(index).stringValue(instances.attribute(attribute.getAttribute()));
        } else {
            value = Double.toString(instances.get(index).value(instances.attribute(attribute.getAttribute())));
        }
        if (value.equals(attribute.getValue())) {
            return true;
        }
        return false;
    }
}
