package main.resources.repository;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NewSkills implements StoragePath {

    ArrayList<String> read(String file) {
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

    boolean checkID(String ID, ArrayList<String> content) {
        boolean exists = false;
        for (String s : content) {
            String checkedID = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ':')
                    checkedID += s.charAt(i);
                else if (s.charAt(i) == ':') {
                    if (ID.equals(checkedID))
                        return true;
                    else
                        break;
                }
            }
        }
        return exists;
    }

    public boolean addNewSkill(Long ID, String name) {
        if (!checkID("" + ID, read(SKILLS))) {
            writeSkills(read(SKILLS), "" + ID, name);
            return true;
        } else
            return false;

    }

    void writeSkills(ArrayList<String> content, String ID, String name) {
        try {
            if (!ID.equals("") && !name.equals(""))
                content.add(ID + ":" + name);

            FileWriter fwD = new FileWriter(SKILLS);
            for (String s : content) {
                fwD.write(s);
                fwD.write(System.getProperty("line.separator"));
            }
            fwD.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
