package prepos.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * Author: Cristian Simioni
 * Last update: 09/03/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class SystemInfo {

    // Attributes
    // Tool info 
    private static String name = "PREPOS - Data Mining Environment";
    private static String version = "1.0";
    private static String buildDate = "15.10.2013";
    private static String year = "2013";
    // Authors info
    private static String author = "Cristian Simoni";
    private static String authorEmail = "cristian.milani@pucpr.br";
    private static String professor = "Deborah Ribeiro Carvalho";
    private static String professorEmail = "ribeiro.carvalho@pucpr.br";
    // Configuration default
    private static String language = "en";
    private static String country = "US";
    // Log
    private static Logger log;

    // Getter & setter
    public static String getName() {
        return name;
    }

    public static String getVersion() {
        return version;
    }

    public static String getBuildDate() {
        return buildDate;
    }

    public static String getYear() {
        return year;
    }

    public static String getAuthor() {
        return author;
    }

    public static String getAuthorEmail() {
        return authorEmail;
    }

    public static String getProfessor() {
        return professor;
    }

    public static String getProfessorEmail() {
        return professorEmail;
    }

    public static String getLanguage() {
        return language;
    }

    public static String getCountry() {
        return country;
    }

    public static Logger getLog() {
        return log;
    }

    // Methods
    // Initialize prepos
    public static void initialize() {
        // Create log file
        log = Logger.getLogger("log");
        FileHandler fh;
        try {
            fh = new FileHandler("log.txt", true);
            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
        } catch (IOException | SecurityException ex) {
            System.err.println(ex.getMessage());
        }

        // Verify if the configuration file exists
        try {
            Properties configuration = new Properties();
            configuration.load(new FileInputStream("./config.properties"));

            // Set language
            language = configuration.getProperty("language");
            country = configuration.getProperty("country");

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            log.log(Level.WARNING, "Configuration file had a problem.");
        }
        Locale.setDefault(new Locale(language, country));

        // Create temporary folder
        File temp = new File(System.getProperty("user.dir") + "//temp");
        temp.mkdir();

        // Clean temporary folder
        File[] files = temp.listFiles();
        for (File f : files) {
            f.delete();
        }
    }
}