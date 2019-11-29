package main.java.com.OlehHilchenko.OGCRUDApplication.Action;

import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.AccountStatus;
import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.AccountStatusC;
import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.Developer;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Create implements AccountStatus {

    public Developer createNewDev(long ID) {
        String firstName;
        String lastName;
        AccountStatusC accountStatus = new AccountStatusC();
        LinkedHashSet<String> skills = new LinkedHashSet<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name.");
        firstName = scanner.next();
        System.out.println("Enter last name.");
        lastName = scanner.next();

        System.out.println("Enter account status:");
        System.out.println("1 to ACTIVE");
        System.out.println("2 to BANNED");
        System.out.println("3 to DELETED");
        accountStatus.accountStatus = scanner.next();
        switch (accountStatus.accountStatus) {
            case "1":
                accountStatus.accountStatus = ACTIVE;
                break;
            case "2":
                accountStatus.accountStatus = BANNED;
                break;
            case "3":
                accountStatus.accountStatus = DELETED;
                break;
            default:
                break;
        }

        System.out.println("Entry skills set: ");
        boolean exitEntry = true;
        String skill;
        while (exitEntry) {
            skill = scanner.next();
            if (skill.equals("-1"))
                exitEntry = false;
            else
                skills.add(skill);
            System.out.println("Entry -1 to stop entry skills");
        }
        scanner.close();
        return new Developer((long) ID, firstName, lastName, skills, accountStatus.accountStatus);
    }
}
