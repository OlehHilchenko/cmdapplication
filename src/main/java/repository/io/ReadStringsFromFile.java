package main.java.repository.io;

import main.java.model.Account;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadStringsFromFile {

    public static List<String> readObjectFromFile(String filepath) {
        ArrayList<String> stringsFromFile = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new FileInputStream(filepath));
            while (scan.hasNextLine())
                stringsFromFile.add(scan.nextLine());
            scan.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return stringsFromFile;
    }
}
