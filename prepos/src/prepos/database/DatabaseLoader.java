package prepos.database;

import java.io.IOException;
import weka.core.Instances;

public interface DatabaseLoader {

    public Instances loadDatabase(String path) throws IOException;
}