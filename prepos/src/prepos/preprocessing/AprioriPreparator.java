package prepos.preprocessing;

import prepos.database.Database;

public class AprioriPreparator {

    private Database database;

    public AprioriPreparator(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public String prepareDatabase() {
        StringBuilder msg = new StringBuilder();
        String line;
        for (int i = 0; i < database.numInstances(); i++) {
            line = "";
            for (int j = 0; j < database.numAttributes(); j++) {
                if (!database.getInstances().instance(i).toString(j).equals("?")) {
                    line += database.getAttribute(j).name().replace(" ", "");
                    line += "_";
                    line += database.getInstances().instance(i).toString(j).replace(" ", "");
                    line += " ";
                }
            }
            line = line.trim();
            line += "\n";
            msg.append(line);
        }
        return msg.toString();
    }
}