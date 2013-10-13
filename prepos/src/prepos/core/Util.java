package prepos.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class Util {

    // Clean temporary folder
    public static void cleanTemporaryFolder() {
        File[] files = new File(System.getProperty("user.dir") + "//temp").listFiles();
        for (File f : files) {
            f.delete();
        }
    }

    // Verify if the file contains association rules
    public static boolean isAssociationFile(String pathFile) throws FileNotFoundException {
        String[] lines = new Scanner(new File(pathFile)).useDelimiter("\\Z").next().split("\n");
        for (String line : lines) {
            if (!line.contains("sup:") && !line.contains("conf:")) {
                return false;
            }
        }
        return true;
    }

    // Verify if the file contains production rules
    public static boolean isClassificationFile(String pathFile) throws FileNotFoundException {
        String[] lines = new Scanner(new File(pathFile)).useDelimiter("\\Z").next().split("\n");
        for (String line : lines) {
            if (!line.contains("miss:") && !line.contains("hit:")) {
                return false;
            }
        }
        return true;
    }
}
