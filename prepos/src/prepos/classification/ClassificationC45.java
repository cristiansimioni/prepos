package prepos.classification;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import prepos.database.Database;
import weka.core.converters.C45Saver;

public class ClassificationC45 implements Classification {

    @Override
    public String getClassification(Database database, String parameters) throws Exception {
        StringBuilder classification = new StringBuilder();

        String input = System.getProperty("user.dir") + "\\temp\\c45input.names";

        // Save base on temporary file if database is not c45
        if (!database.getType().equals("c45")) {
            C45Saver saver = new C45Saver();

            saver.setInstances(database.getInstances());
            saver.setFile(new File(input));
            saver.writeBatch();
        }

        // Ajust database path
        input = input.substring(0, input.lastIndexOf("."));

        // Build classifier
        Process p;
        String programPath = System.getProperty("user.dir") + "\\lib\\c45.exe";
        String cmd = programPath + " " + parameters + " " + input;
        p = Runtime.getRuntime().exec(cmd);
        
        // Get the classication from stream
        InputStream stdin = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(stdin));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            classification.append(line);
            classification.append("\n");
        }

        p.waitFor();

        return classification.toString();
    }
}
