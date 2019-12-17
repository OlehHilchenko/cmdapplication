package main.java.view.uniqueid;

import java.util.Random;
import java.util.*;
import java.io.*;

public class RandomLongID {

    private static final String IDTXT = "main\\java\\view\\uniqueid\\ID.txt";

    private long randomId() {
        Random rnd = new Random();
        return (long) rnd.nextLong();
    }

    private ArrayList<String> readId(String file) {
        ArrayList<String> temp = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new FileInputStream(file));
            while (scan.hasNextLine())
                temp.add(scan.nextLine());
            scan.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return temp;
    }

    private void writeId(ArrayList<String> id, String file) {
        try {
            boolean firstWrite = false;
            for (String s : id) {
                FileWriter fw = new FileWriter(file, firstWrite);
                fw.write(s);
                fw.write(System.getProperty("line.separator"));
                fw.close();
                firstWrite = true;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Long checkedID() {
        Long id = randomId();
        ArrayList<String> list = readId(IDTXT);

        for (int i = 0; i < list.size(); i++) {
            if (id.equals(Long.parseLong(list.get(i)))) {
                id = randomId();
                i = 0;
            }
        }

        list.add("" + id);
        writeId(list, IDTXT);

        return id;
    }
}
