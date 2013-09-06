package prepos.database;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.C45Loader;

public class DatabaseC45Loader implements DatabaseLoader {

    @Override
    public Instances loadDatabase(String path) throws IOException {
        C45Loader c45 = new C45Loader();
        c45.setFile(new File(path));
        return c45.getDataSet();
    }
}
