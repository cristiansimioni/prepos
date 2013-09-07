package prepos.classification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import prepos.database.Database;
import weka.core.converters.C45Saver;

public class ClassificationC45 implements Classification {

    @Override
    public String getClassification(Database database, String parameters) throws Exception {
        String classification;


        String input = System.getProperty("user.dir") + "\\temp\\c45input.names";
        
        // Save base on temporary file if database is not c45
        if (!database.getType().equals("c45")) {
            C45Saver saver = new C45Saver();

            saver.setInstances(database.getInstances());
            saver.setFile(new File(input));
            saver.writeBatch();
        }

        // Create output file
        String output = System.getProperty("user.dir") + "\\temp\\c45output.txt";

        // Ajust database path
        input = input.substring(0, input.lastIndexOf("."));
        
        // Build associations
        Process p;
        String programPath = System.getProperty("user.dir") + "\\lib\\c45.exe";
        String cmd = programPath + " " + parameters + " " + input + " > " + output;
        p = Runtime.getRuntime().exec(cmd);
        p.waitFor();

        // Get the associations from file
        Scanner sc = new Scanner(new File(output));
        classification = new Scanner(new File(output)).useDelimiter("\\Z").next();
        
        return classification;
    }
    
}
