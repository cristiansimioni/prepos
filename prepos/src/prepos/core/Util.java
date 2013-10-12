package prepos.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util {
    
    public static boolean isAssociationFile(String pathFile) throws FileNotFoundException  {
        String [] lines = new Scanner(new File(pathFile)).useDelimiter("\\Z").next().split("\n");
        for (String line : lines) {
            if (!line.contains("sup:") && !line.contains("conf:")) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isClassificationFile(String pathFile) throws FileNotFoundException  {
        String [] lines = new Scanner(new File(pathFile)).useDelimiter("\\Z").next().split("\n");
        for (String line : lines) {
            if (!line.contains("miss:") && !line.contains("hit:")) {
                return false;
            }
        }
        return true;
    }
}
