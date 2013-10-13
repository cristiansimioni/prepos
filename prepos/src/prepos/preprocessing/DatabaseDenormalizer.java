package prepos.preprocessing;

import java.util.ArrayList;
import java.util.Hashtable;
import prepos.database.Database;
import weka.core.Instance;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class DatabaseDenormalizer {

    // Attributes
    private Database database;
    private String parameters;
    private int indexOfId;
    private int indexOfItem;

    // Constructor
    public DatabaseDenormalizer(Database database, String parametes) {
        this.database = database;
        this.parameters = parametes;
        this.indexOfId = 0;
        this.indexOfItem = 0;
    }

    // Getter & setter
    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public int getIndexOfId() {
        return indexOfId;
    }

    public void setIndexOfId(int indexOfId) {
        this.indexOfId = indexOfId;
    }

    public int getIndexOfItem() {
        return indexOfItem;
    }

    public void setIndexOfItem(int indexOfItem) {
        this.indexOfItem = indexOfItem;
    }

    // Methods
    // Parametes parser
    public void setParameters() {
        if (!parameters.isEmpty()) {
            String[] allParamenters = parameters.split(" ");
            for (String parameter : allParamenters) {
                if (parameter.contains("-d")) {
                    setIndexOfId(Integer.parseInt(parameter.split("-d")[1]));
                } else if (parameter.contains("-i")) {
                    setIndexOfItem(Integer.parseInt(parameter.split("-i")[1]));
                }
            }
        }
    }

    // Denormalize database
    public String denormalize() {
        StringBuilder msg = new StringBuilder();

        // Ajust the parameters
        setParameters();

        // Veridy if the attributes are nominal
        boolean idIsNominal = database.getInstances().attribute(indexOfId).isNominal();
        boolean itemIsNominal = database.getInstances().attribute(indexOfItem).isNominal();

        // Build a hash by distinct values of indexOfId
        Hashtable hash = new Hashtable();
        ArrayList<String> keyValues = new ArrayList<>();
        for (int i = 0; i < database.numInstances(); i++) {
            ArrayList<Instance> instancesById;
            String value = "";
            if (!idIsNominal) {
                value = Double.toString(database.getInstances().instance(i).value(indexOfId));

            } else {
                value = database.getInstances().instance(i).stringValue(indexOfId);
            }
            instancesById = (ArrayList<Instance>) hash.get(value);
            if (instancesById == null) {
                instancesById = new ArrayList<>();
                instancesById.add(database.getInstances().instance(i));
                keyValues.add(value);
            } else {
                instancesById.add(database.getInstances().instance(i));
            }
            hash.put(value, instancesById);

        }

        // Build denormalized database using the a keyValue per instance
        for (int i = 0; i < keyValues.size(); i++) {
            ArrayList<Instance> instances = (ArrayList<Instance>) hash.get(keyValues.get(i));
            String line = "";
            for (Instance instance : instances) {
                if (itemIsNominal) {
                    line += instance.stringValue(indexOfItem) + " ";
                } else {
                    line += Double.toString(instance.value(i)) + " ";
                }
            }
            msg.append(line.trim());
            msg.append("\n");
        }
        return msg.toString();
    }
}
