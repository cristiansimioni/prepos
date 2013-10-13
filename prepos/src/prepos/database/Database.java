package prepos.database;

import java.io.IOException;
import weka.core.Attribute;
import weka.core.Instances;

public class Database {

    private Instances instances;
    private String path;
    private String type;

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

    public String relationName() {
        return instances.relationName();
    }

    public int numInstances() {
        return instances.numInstances();
    }

    public int numAttributes() {
        return instances.numAttributes();
    }

    public Attribute getAttribute(int index) {
        return instances.attribute(index);
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }
}
