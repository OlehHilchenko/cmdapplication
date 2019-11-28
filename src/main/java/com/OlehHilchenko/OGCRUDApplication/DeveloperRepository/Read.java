package main.java.com.OlehHilchenko.OGCRUDApplication.DeveloperRepository;

import main.java.com.OlehHilchenko.OGCRUDApplication.DataStore.DataWarehousePath;
import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.Developer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Read implements DataWarehousePath {

    ArrayList<String> develop;
    ArrayList<String> account;
    ArrayList<String> skill;

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

    public HashMap<Long, Developer> parse() {
        HashMap<Long, Developer> developersFromFiles = new HashMap<>();
        develop = read(DEVELOPERS);
        account = read(ACCOUNTS);
        skill = read(SKILLS);
        for (int i = 0; i < develop.size(); i++) {
            long ID;
            String firstName;
            String lastName;
            String accountStatus;
            LinkedHashSet<String> skills = new LinkedHashSet<>();
            String IDFirstNameLastName[] = new String[3];
            int count = 0;
            String temp = "";
            for (int j = 0; j < develop.get(i).length(); j++) {
                if (develop.get(i).charAt(j) != ' ') {
                    temp += develop.get(i).charAt(j);
                } else if (develop.get(i).charAt(j) == ' ') {
                    IDFirstNameLastName[count] = temp;
                    count++;
                    temp = "";
                }
            }
            IDFirstNameLastName[count] = temp;
            ID = Long.parseLong(IDFirstNameLastName[0]);
            firstName = IDFirstNameLastName[1];
            lastName = IDFirstNameLastName[2];
            developersFromFiles.put(ID, new Developer(ID, firstName, lastName));
            String IDAccount[] = new String[2];
            temp = "";
            count = 0;
            for (int l = 0; l < account.get(i).length(); l++) {
                if (account.get(i).charAt(l) != ' ') {
                    temp += account.get(i).charAt(l);
                } else if (account.get(i).charAt(l) == ' ') {
                    IDAccount[count] = temp;
                    count++;
                    temp = "";
                }
            }
            IDAccount[count] = temp;
            developersFromFiles.get(Long.parseLong(IDAccount[0])).accountStatusC.accountStatus = IDAccount[1];
            Long tempId = (long) 0;
            temp = "";
            count = 0;
            for (int k = 0; k < skill.get(i).length(); k++) {
                if (skill.get(i).charAt(k) != ' ') {
                    temp += skill.get(i).charAt(k);
                } else if (skill.get(i).charAt(k) == ' ' && count == 0) {
                    tempId = Long.parseLong(temp);
                    count++;
                    temp = "";
                } else if (skill.get(i).charAt(k) == ' ' && count != 0) {
                    skills.add(temp);
                    count++;
                    temp = "";
                }
            }
            skills.add(temp);
            developersFromFiles.get(tempId).skillSet.skills = skills;
        }

        return developersFromFiles;
    }

}
