package prepos.association;

import java.io.File;
import java.util.Scanner;
import prepos.core.FileSaver;
import prepos.database.Database;
import prepos.preprocessing.AprioriPreparator;

/*
 * Author: Cristian Simioni
 * Last updated: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class AssociationAprioriBorgelt implements Association {

    @Override
    public String getAssociations(Database database, String parameters) throws Exception {
        String assoctiations;

        // Prepare database
        AprioriPreparator preparator = new AprioriPreparator(database);

        // Save base on temporary file
        String input = System.getProperty("user.dir") + "\\temp\\borgeltinput.txt";
        FileSaver saver = new FileSaver("borgeltinput.txt", input, preparator.prepareDatabase());
        saver.save();

        // Create output file
        String output = System.getProperty("user.dir") + "\\temp\\borgeltoutput.txt";

        // Build associations
        Process p;
        String programPath = System.getProperty("user.dir") + "\\lib\\apriori.exe";
        p = Runtime.getRuntime().exec(programPath + " " + parameters + " \"" + input + "\" \"" + output + "\"");
        p.waitFor();

        // Get the associations from file
        if (new File(output).length() != 0) {
            assoctiations = new Scanner(new File(output)).useDelimiter("\\Z").next();
        } else {
            assoctiations = "No rules found.";
        }

        return assoctiations;
    }
}
