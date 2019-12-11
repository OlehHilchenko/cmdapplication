package main.resources.view.uniqueid;

import java.util.Random;
import java.util.*;
import java.io.*;

public class RandomLongID {

    public static final String IDTXT = "main\\resources\\view\\uniqueid\\ID.txt";

    long randomId() {
        Random rnd = new Random();
        long id = (long) rnd.nextLong();
        return id;
    }

    ArrayList<String> readId(String file) {
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

    void writeId(ArrayList<String> id, String file) {
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
