package prepos.database;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

public class DatabaseCSVLoader implements DatabaseLoader {
    
    @Override
    public Instances loadDatabase(String path) throws IOException {
        CSVLoader csv = new CSVLoader();
        csv.setFile(new File(path));
        return csv.getDataSet();
    }
}
