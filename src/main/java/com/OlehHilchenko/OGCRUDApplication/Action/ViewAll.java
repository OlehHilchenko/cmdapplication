package main.java.com.OlehHilchenko.OGCRUDApplication.Action;

import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.Developer;

import java.util.HashMap;

public class ViewAll {

    public void viewAll(HashMap<Long, Developer> val) {
        for (Long l : val.keySet()) {
            Developer dev = val.get(l);
            System.out.print("Developer: (" + l + ") " + dev.firstName + " " + dev.lastName + " ," );
            System.out.print("Skills: ");
            for (String s : dev.skillSet.skills)
                System.out.print(s + " ");
            System.out.print(",");
            System.out.print("AccountStatus: " + dev.accountStatusC.accountStatus);
            System.out.println();
        }
    }
}
