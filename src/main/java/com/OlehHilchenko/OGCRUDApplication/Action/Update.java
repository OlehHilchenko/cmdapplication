package main.java.com.OlehHilchenko.OGCRUDApplication.Action;


import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.*;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Update implements AccountStatus {

    public Developer update(HashMap<Long, Developer> val) {
        long ID;
        String id;
        String firstName;
        String lastName;
        AccountStatusC accountStatusC = new AccountStatusC();
        LinkedHashSet<String> skills = new LinkedHashSet<>();
        String temp;


        Scanner scannerU = new Scanner(System.in);
        System.out.println("Past ID");
        id = scannerU.next();
        ID = Long.parseLong(id);

        Developer developer = val.get(ID);
        ViewByID viewByID = new ViewByID();
        viewByID.viewByID(developer);

        System.out.println("To update First Name entry it: ");
        System.out.println("leave unchanged, entry -1 ");
        temp = scannerU.next();
        if (!temp.equals("-1"))
            firstName = temp;
        else
            firstName = developer.firstName;
        System.out.println("To update Last Name entry it: ");
        System.out.println("leave unchanged, entry -1 ");
        temp = scannerU.next();
        if (!temp.equals("-1"))
            lastName = temp;
        else
            lastName = developer.lastName;
        System.out.println("To update account status:");
        System.out.println("1 to ACTIVE");
        System.out.println("2 to BANNED");
        System.out.println("3 to DELETED");
        accountStatusC.accountStatusValue = scannerU.next();
        switch (accountStatusC.accountStatusValue) {
            case "1":
                accountStatusC.accountStatusValue = ACTIVE;
                break;
            case "2":
                accountStatusC.accountStatusValue = BANNED;
                break;
            case "3":
                accountStatusC.accountStatusValue = DELETED;
                break;
            default:
                break;
        }
        System.out.println("Update skillsValues set? y/n");
        temp = "";
        temp = scannerU.next();
        if (temp.equals("y")) {
            boolean exitEntry = true;
            String skill;
            System.out.println("Entry skillsValues: ");
            while (exitEntry) {
                skill = scannerU.next();
                if (skill.equals("-1")) {
                    exitEntry = false;
                } else {
                    skills.add(skill);
                }
                System.out.println("Entry -1 to stop entry skillsValues");
            }
            //scannerU.close();
        } else
            skills = developer.skillSet.skillsValues;

        return new Developer(ID, firstName, lastName, skills, accountStatusC.accountStatusValue);
    }
}
