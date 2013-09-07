package prepos.classification;

import prepos.database.Database;

public interface Classification {

    // Get the classification from database
    public String getClassification(Database database, String parameters) throws Exception;
}
