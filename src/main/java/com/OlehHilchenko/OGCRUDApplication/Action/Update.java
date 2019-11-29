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


        Scanner scanner = new Scanner(System.in);
        System.out.println("Past ID");
        id = scanner.next();
        ID = Long.parseLong(id);

        Developer developer = val.get(ID);
        ViewByID viewByID = new ViewByID();
        viewByID.viewByID(developer);

        System.out.println("To update First Name entry it: ");
        System.out.println("leave unchanged, entry -1 ");
        temp = scanner.next();
        if (!temp.equals("-1"))
            firstName = temp;
        else
            firstName = developer.firstName;
        System.out.println("To update Last Name entry it: ");
        System.out.println("leave unchanged, entry -1 ");
        temp = scanner.next();
        if (!temp.equals("-1"))
            lastName = temp;
        else
            lastName = developer.lastName;
        System.out.println("To update account status:");
        System.out.println("1 to ACTIVE");
        System.out.println("2 to BANNED");
        System.out.println("3 to DELETED");
        accountStatusC.accountStatus = scanner.next();
        switch (accountStatusC.accountStatus) {
            case "1":
                accountStatusC.accountStatus = ACTIVE;
                break;
            case "2":
                accountStatusC.accountStatus = BANNED;
                break;
            case "3":
                accountStatusC.accountStatus = DELETED;
                break;
            default:
                break;
        }
        System.out.println("Update skills set? y/n");
        temp = "";
        temp = scanner.next();
        if (temp.equals("y")) {
            boolean exitEntry = true;
            String skill;
            while (exitEntry) {
                skill = scanner.next();
                if (skill.equals("-1")) {
                    exitEntry = false;
                } else {
                    skills.add(skill);
                }
                System.out.println("Entry -1 to stop entry skills");
            }
            scanner.close();
        } else
            skills = developer.skillSet.skills;

        return new Developer(ID, firstName, lastName, skills, accountStatusC.accountStatus);
    }
}
