package main.java.repository.io;

import main.java.model.Account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteStringsInFile {

    public static void writeStringsToFile(String filepath, List<String> stringsInFile) {
        try {
            boolean firstWrite = false;
            for (String str : stringsInFile) {
                FileWriter fw = new FileWriter(filepath, firstWrite);
                fw.write(str);
                fw.write(System.getProperty("line.separator"));
                fw.close();
                firstWrite = true;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
