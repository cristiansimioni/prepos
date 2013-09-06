package prepos.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {

    private String name;
    private String path;
    private String text;

    public FileSaver(String name, String path, String text) {
        this.name = name;
        this.path = path;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void save() throws IOException {
        FileWriter fw;
        fw = new FileWriter(new File(path));
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            String[] lines = text.split("\n");
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
        
        fw.close();
    }
}