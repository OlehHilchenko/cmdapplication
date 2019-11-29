package main.java.com.OlehHilchenko.OGCRUDApplication.Action;

import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.Developer;

public class ViewByID {

    public void viewByID(Developer d){
        System.out.print("Developer: " + "(" + d.ID + ") " + d.firstName + " " + d.lastName + " ;");
        System.out.print("Skills: ");
            for(String s : d.skillSet.skills)
                System.out.print(s + " ,");

        System.out.print(";");
        System.out.print("Account status: " + d.accountStatusC.accountStatus);
        System.out.println();
    }
}
