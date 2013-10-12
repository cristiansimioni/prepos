package prepos.preprocessing;

import prepos.database.Database;

public class DenormalizeDatabase {
    
    private Database database;
    private int indexOfId;
    private int indexOfItem;

    public DenormalizeDatabase(Database database, int indexOfId, int indexOfItem) {
        this.database = database;
        this.indexOfId = indexOfId;
        this.indexOfItem = indexOfItem;
    }
    
    public String denormalize() {
        StringBuilder msg = new StringBuilder();
        
        return msg.toString();
    }
}
